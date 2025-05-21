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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lunchtray.R

/**
 * Composable que representa la pantalla de inicio para comenzar un nuevo pedido.
 * Contiene un botón centralizado para iniciar el proceso de pedido.
 *
 * @param onStartOrderButtonClicked La acción a realizar cuando se hace clic en el botón "Start Order".
 * @param modifier Modificador para aplicar a este Composable.
 */
@Composable
fun StartOrderScreen(
    onStartOrderButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Columna que centra su contenido horizontal y verticalmente.
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally, // Alinea el contenido horizontalmente al centro.
        verticalArrangement = Arrangement.Center // Alinea el contenido verticalmente al centro.
    ) {
        // Botón para iniciar el pedido.
        Button(
            onClick = onStartOrderButtonClicked, // La acción a realizar al hacer clic en el botón.
            Modifier.widthIn(min = 250.dp) // Establece un ancho mínimo para el botón.
        ) {
            Text(stringResource(R.string.start_order)) // Texto del botón, obtenido de los recursos de cadena.
        }
    }
}

/**
 * Vista previa del `StartOrderScreen` en el panel de diseño.
 * Permite visualizar cómo se verá la pantalla de inicio.
 */
@Preview
@Composable
fun StartOrderPreview(){
    // Instancia de StartOrderScreen para la vista previa.
    StartOrderScreen(
        onStartOrderButtonClicked = {},// Define una acción vacía para el botón en la vista previa.
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize()
    )
}
