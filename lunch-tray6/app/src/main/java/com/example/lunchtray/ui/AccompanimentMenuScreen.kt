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
import com.example.lunchtray.model.MenuItem.AccompanimentItem

/**
 * Composable que muestra la pantalla del menú de aderezos.
 * Reutiliza el `BaseMenuScreen` para mostrar las opciones de aderezos.
 *
 * @param options Una lista de [AccompanimentItem] que representa los aderezos disponibles.
 * @param onCancelButtonClicked La función a ejecutar cuando se hace clic en el botón "Cancelar".
 * @param onNextButtonClicked La función a ejecutar cuando se hace clic en el botón "Siguiente".
 * @param onSelectionChanged La función a ejecutar cuando cambia la selección de un aderezo.
 * @param modifier Modificador para aplicar a este componible.
 */
@Composable
fun AccompanimentMenuScreen(
    options: List<AccompanimentItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (AccompanimentItem) -> Unit,
    modifier: Modifier = Modifier
) {
    // Reutiliza BaseMenuScreen, que maneja la lógica de visualización de un menú genérico.
    // Se realiza un casting seguro de `onSelectionChanged` a `(MenuItem) -> Unit` porque
    // AccompanimentItem es una subclase de MenuItem, y BaseMenuScreen espera un callback de MenuItem.
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        modifier = modifier
    )
}

/**
 * Vista previa del `AccompanimentMenuScreen` en el panel de diseño.
 * Muestra cómo se verá el menú de aderezos con datos de ejemplo.
 */
@Preview
@Composable
fun AccompanimentMenuPreview(){
    // Crea una instancia de AccompanimentMenuScreen con datos de prueba del DataSource.
    AccompanimentMenuScreen(
        options = DataSource.accompanimentMenuItems,// Utiliza los datos de aderezos definidos en DataSource.
        onNextButtonClicked = {},// Función vacía para el botón "Siguiente" en la vista previa.
        onCancelButtonClicked = {}, // Función vacía para el botón "Cancelar" en la vista previa.
        onSelectionChanged = {},// Función vacía para el cambio de selección en la vista previa.
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())// Permite el desplazamiento vertical para simular contenido completo.
    )
}
