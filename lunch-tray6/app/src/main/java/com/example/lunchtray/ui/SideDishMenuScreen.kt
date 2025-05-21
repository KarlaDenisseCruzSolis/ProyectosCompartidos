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
import com.example.lunchtray.model.MenuItem.SideDishItem

@Composable
fun SideDishMenuScreen(
    options: List<SideDishItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (SideDishItem) -> Unit,
    modifier: Modifier = Modifier
) {
    // Reutiliza el componente BaseMenuScreen para mostrar la interfaz de usuario del menú.
    // BaseMenuScreen es un Composable genérico que maneja la visualización de una lista de elementos
    // seleccionables, así como los botones de cancelar y siguiente.
    BaseMenuScreen(
        options = options, // Pasa la lista de opciones de guarniciones (SideDishItem).
        onCancelButtonClicked = onCancelButtonClicked, // Pasa el callback para cuando se haga clic en el botón de cancelar.
        onNextButtonClicked = onNextButtonClicked, // Pasa el callback para cuando se haga clic en el botón de siguiente.
        // Realiza un casting seguro de la función `onSelectionChanged`.
        // Esto es necesario porque `BaseMenuScreen` espera una función que reciba un `MenuItem`,
        // mientras que esta función recibe un `SideDishItem`.
        // Como `SideDishItem` es una subclase de `MenuItem`, este casting es seguro y permitido.
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        modifier = modifier // Aplica el modificador recibido a este Composable.
    )
}

@Preview
@Composable
fun SideDishMenuPreview(){
    // Esta función Composable es una vista previa para el SideDishMenuScreen.
    // Su propósito es permitir a los desarrolladores visualizar cómo se verá la pantalla
    // del menú de guarniciones directamente en el panel de diseño de Android Studio,
    // sin tener que ejecutar la aplicación completa en un emulador o dispositivo.
    SideDishMenuScreen(
        options = DataSource.sideDishMenuItems, // Proporciona una lista de elementos de guarnición de ejemplo desde DataSource.
        onNextButtonClicked = {}, // Define una acción vacía para el botón "Siguiente" en la vista previa.
        onCancelButtonClicked = {}, // Define una acción vacía para el botón "Cancelar" en la vista previa.
        onSelectionChanged = {}, // Define una acción vacía para el cambio de selección de elementos en la vista previa.
        modifier = Modifier
            // Aplica un padding mediano alrededor de la pantalla para mejorar la visualización en la vista previa.
            .padding(dimensionResource(R.dimen.padding_medium))
            // Hace que la pantalla sea desplazable verticalmente. Esto es útil para simular
            // que hay más contenido del que cabe en la pantalla, permitiendo probar cómo se ve
            // el diseño con scroll.
            .verticalScroll(rememberScrollState())
    )
}
