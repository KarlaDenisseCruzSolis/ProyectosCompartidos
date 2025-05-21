/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.lunchtray.R
import com.example.lunchtray.model.MenuItem

/**
 * Composable base para las pantallas de menú que muestran una lista de opciones.
 * Permite la selección de un único elemento y proporciona botones para cancelar o continuar.
 *
 * @param options La lista de elementos [MenuItem] a mostrar.
 * @param modifier Modificador para aplicar a este Composable.
 * @param onCancelButtonClicked La acción a realizar cuando se hace clic en el botón "Cancelar".
 * @param onNextButtonClicked La acción a realizar cuando se hace clic en el botón "Siguiente".
 * @param onSelectionChanged La acción a realizar cuando cambia la selección de un elemento.
 */
@Composable
fun BaseMenuScreen(
    options: List<MenuItem>,
    modifier: Modifier = Modifier,
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    onSelectionChanged: (MenuItem) -> Unit,
) {
    // Estado mutable para almacenar el nombre del elemento seleccionado.
    // 'rememberSaveable' asegura que el estado se conserve a través de cambios de configuración.

    var selectedItemName by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier) {// Columna principal que organiza los elementos del menú y los botones.
        // Itera sobre cada elemento en la lista de opciones para crear una fila para cada uno.
        options.forEach { item ->
            val onClick = {// Define la acción a realizar cuando se hace clic en un elemento del menú.
                selectedItemName = item.name// Actualiza el nombre del elemento seleccionado.
                onSelectionChanged(item)// Llama al callback para notificar el cambio de selección.
            }
            // Muestra una fila de elemento de menú individual.
            MenuItemRow(
                item = item, // El elemento del menú a mostrar.
                selectedItemName = selectedItemName, // El nombre del elemento actualmente seleccionado.
                onClick = onClick, // La acción a realizar al hacer clic en la fila o el radio button.
                modifier = Modifier.selectable( // Hace que la fila sea seleccionable.
                    selected = selectedItemName == item.name, // Indica si esta fila está seleccionada.
                    onClick = onClick // La acción de clic para la fila seleccionable.
                )
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),// Padding a la izquierda.
                        end = dimensionResource(R.dimen.padding_medium),// Padding a la derecha.
                    )
            )
        }

        // Grupo de botones para "Cancelar" y "Siguiente".
        MenuScreenButtonGroup(
            selectedItemName = selectedItemName, // Pasa el nombre del elemento seleccionado para habilitar/deshabilitar el botón "Siguiente".
            onCancelButtonClicked = onCancelButtonClicked, // Callback para el botón "Cancelar".
            onNextButtonClicked = {
                // Afirmación de que no es nulo porque el botón "Siguiente" no está habilitado a menos que el selectedItem no sea nulo.
                onNextButtonClicked() // Callback para el botón "Siguiente".
            },
            modifier = Modifier.fillMaxWidth().padding(dimensionResource(R.dimen.padding_medium))// Ocupa todo el ancho y aplica padding.
        )
    }
}

/**
 * Composable que representa una fila individual de un elemento de menú.
 * Incluye un RadioButton, el nombre del elemento, la descripción y el precio.
 *
 * @param item El [MenuItem] a mostrar en esta fila.
 * @param selectedItemName El nombre del elemento actualmente seleccionado (para controlar el estado del RadioButton).
 * @param onClick La acción a realizar cuando se hace clic en la fila o el RadioButton.
 * @param modifier Modificador para aplicar a este Composable.
 */
@Composable
fun MenuItemRow(
    item: MenuItem,
    selectedItemName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(// Fila que organiza el RadioButton y la información del elemento.
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically// Alinea los elementos verticalmente al centro.
    ) {
        RadioButton(// RadioButton para seleccionar el elemento.
            selected = selectedItemName == item.name,// El RadioButton está seleccionado si el nombre coincide.
            onClick = onClick// La acción de clic para el RadioButton.
        )
        Column(// Columna que contiene el nombre, descripción y precio del elemento.
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))// Espacio entre elementos verticales.
        ) {
            Text(// Texto para el nombre del elemento.
                text = item.name,
                style = MaterialTheme.typography.headlineSmall // Estilo de tipografía para el título pequeño.
            )
            Text( // Texto para la descripción del elemento.
                text = item.description,
                style = MaterialTheme.typography.bodyLarge// Estilo de tipografía para el cuerpo grande.
            )
            Text(// Texto para el precio formateado del elemento.
                text = item.getFormattedPrice(), // Obtiene el precio formateado.
                style = MaterialTheme.typography.bodyMedium// Estilo de tipografía para el cuerpo medio.
            )
            Divider(// Divisor visual para separar los elementos de la lista.
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

/**
 * Composable que agrupa los botones "Cancelar" y "Siguiente" en la parte inferior de una pantalla de menú.
 *
 * @param selectedItemName El nombre del elemento seleccionado, usado para habilitar el botón "Siguiente".
 * @param onCancelButtonClicked La acción a realizar cuando se hace clic en el botón "Cancelar".
 * @param onNextButtonClicked La acción a realizar cuando se hace clic en el botón "Siguiente".
 * @param modifier Modificador para aplicar a este Composable.
 */
@Composable
fun MenuScreenButtonGroup(
    selectedItemName: String,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(// Fila que organiza los botones horizontalmente.
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
    ){
        // Botón con contorno para "Cancelar".
        OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
            Text(stringResource(R.string.cancel).uppercase())// Texto del botón en mayúsculas.
        }
        Button(// Botón sólido para "Siguiente".
            modifier = Modifier.weight(1f),
            // el botón está habilitado cuando el usuario hace una selección
            enabled = selectedItemName.isNotEmpty(),// El botón está habilitado si se ha seleccionado un elemento.
            onClick = onNextButtonClicked// La acción de clic para el botón "Siguiente".
        ) {
            Text(stringResource(R.string.next).uppercase())// Texto del botón en mayúsculas.
        }
    }
}
