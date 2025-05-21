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

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.EntreeItem

@Composable
fun EntreeMenuScreen(
    options: List<EntreeItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (EntreeItem) -> Unit,
    modifier: Modifier = Modifier
) {
    // Reutiliza el componente BaseMenuScreen para mostrar la interfaz de usuario del menú.
    // BaseMenuScreen es un Composable genérico que maneja la visualización de una lista de elementos
    // seleccionables, botones de cancelar y siguiente.
    BaseMenuScreen(
        options = options, // Le pasa la lista de opciones de EntreeItem.
        onCancelButtonClicked = onCancelButtonClicked, // Pasa el callback para el botón de cancelar.
        onNextButtonClicked = onNextButtonClicked, // Pasa el callback para el botón de siguiente.
        // Se realiza un casting seguro de la función `onSelectionChanged`.
        // Esto es necesario porque `BaseMenuScreen` espera un `(MenuItem) -> Unit`,
        // mientras que esta función recibe un `(EntreeItem) -> Unit`.
        // Dado que `EntreeItem` es una subclase de `MenuItem`, este casting es seguro.
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        modifier = modifier // Aplica el modificador recibido a BaseMenuScreen.
    )
}

@Preview
@Composable
fun EntreeMenuPreview(){
    // Esta función Composable es una vista previa para el EntreeMenuScreen.
    // Permite visualizar cómo se verá la pantalla del menú de platos principales en el panel de diseño de Android Studio
    // sin necesidad de ejecutar la aplicación completa.
    EntreeMenuScreen(
        options = DataSource.entreeMenuItems, // Proporciona una lista de elementos de plato principal de ejemplo desde DataSource.
        onCancelButtonClicked = {}, // Define una acción vacía para el botón "Cancelar" para la vista previa.
        onNextButtonClicked = {}, // Define una acción vacía para el botón "Siguiente" para la vista previa.
        onSelectionChanged = {}, // Define una acción vacía para el cambio de selección de elementos para la vista previa.
        modifier = Modifier
            // Aplica un padding mediano alrededor de la pantalla para una mejor visualización en la vista previa.
            .padding(dimensionResource(R.dimen.padding_medium))
            // Permite el desplazamiento vertical de la pantalla, simulando que hay más contenido del que cabe en pantalla.
            // Esto es útil para probar diseños con muchos elementos.
            .verticalScroll(rememberScrollState())
    )
}
