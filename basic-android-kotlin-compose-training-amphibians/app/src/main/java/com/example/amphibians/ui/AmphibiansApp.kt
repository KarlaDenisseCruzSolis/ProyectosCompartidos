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

package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.ui.screens.AmphibiansViewModel
import com.example.amphibians.ui.screens.HomeScreen


// Indica que se está utilizando una API experimental de Material3
@OptIn(ExperimentalMaterial3Api::class)
// Declaración de la función composable principal de la app
@Composable
fun AmphibiansApp() {
    // Estructura base de la UI con barra superior y cuerpo
    Scaffold(
        modifier = Modifier.fillMaxSize(), // Ocupa todo el tamaño de la pantalla
        topBar = {
            // Definición de la barra superior
            TopAppBar(
                title = {
                    // Texto del título de la barra superior, usando un recurso de string
                    Text(
                        stringResource(R.string.app_name), // Carga el nombre de la app desde strings.xml
                        style = MaterialTheme.typography.headlineMedium // Aplica un estilo de texto definido en el tema
                    )
                }
            )
        }
    ) {
        // Contenedor Surface que define el fondo y comportamiento del contenido principal
        Surface(
            modifier = Modifier.fillMaxSize(), // Ocupa todo el tamaño disponible
            color = MaterialTheme.colorScheme.background // Usa el color de fondo del esquema de color actual
        ) {
            // Obtiene una instancia del ViewModel con una fábrica personalizada
            val amphibiansViewModel: AmphibiansViewModel =
                viewModel(factory = AmphibiansViewModel.Factory)

            // Llama a la pantalla principal pasando el estado de la UI y acción para reintentar cargar datos
            HomeScreen(
                amphibiansUiState = amphibiansViewModel.amphibiansUiState, // Estado actual de la interfaz (cargando, error o datos)
                retryAction = amphibiansViewModel::getAmphibians, // Función para volver a cargar los datos si hubo error
                modifier = Modifier.fillMaxSize(), // Ocupa todo el espacio disponible
                contentPadding = it // Aplica el padding proporcionado por el Scaffold (para evitar que el contenido se superponga)
            )
        }
    }
}
