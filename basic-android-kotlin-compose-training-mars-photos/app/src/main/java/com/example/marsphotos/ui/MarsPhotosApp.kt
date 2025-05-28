/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.marsphotos.ui // Define el paquete donde se encuentra este archivo Kotlin (código de la interfaz).

import androidx.compose.foundation.layout.fillMaxSize // Importa modificador para que un componente ocupe todo el tamaño disponible.
import androidx.compose.material3.CenterAlignedTopAppBar // Importa un componente de barra superior centrada (Material 3).
import androidx.compose.material3.ExperimentalMaterial3Api // Anotación para usar API experimental de Material 3.
import androidx.compose.material3.MaterialTheme // Permite acceder al tema de Material 3 (colores, tipografía, etc.).
import androidx.compose.material3.Scaffold // Componente base que estructura la UI en topBar, bottomBar, content, etc.
import androidx.compose.material3.Surface // Contenedor visual que aplica color y forma de fondo.
import androidx.compose.material3.Text // Componente de texto.
import androidx.compose.material3.TopAppBarDefaults // Proporciona comportamientos predeterminados para la AppBar.
import androidx.compose.material3.TopAppBarScrollBehavior // Tipo que define cómo reacciona la AppBar al hacer scroll.
import androidx.compose.runtime.Composable // Anotación que marca una función como una UI componible (Compose).
import androidx.compose.ui.Modifier // Permite modificar el diseño de los elementos (tamaño, relleno, scroll, etc.).
import androidx.compose.ui.input.nestedscroll.nestedScroll // Permite que un elemento reaccione al scroll anidado.
import androidx.compose.ui.res.stringResource // Permite acceder a recursos de texto definidos en strings.xml.
import androidx.lifecycle.viewmodel.compose.viewModel // Permite obtener una instancia de un ViewModel dentro de una función Compose.
import com.example.marsphotos.R // Accede a recursos como strings, drawables, etc.
import com.example.marsphotos.ui.screens.HomeScreen // Importa la pantalla principal.
import com.example.marsphotos.ui.screens.MarsViewModel // Importa el ViewModel que maneja los datos de la pantalla.

@Composable
fun MarsPhotosApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior() // Crea un comportamiento para que la AppBar desaparezca al hacer scroll hacia abajo y reaparezca al subir.

    Scaffold( // Estructura principal de la app con topBar y content.
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection), // Conecta el comportamiento de scroll a la interfaz para que la AppBar responda al desplazamiento.
        topBar = { MarsTopAppBar(scrollBehavior = scrollBehavior) } // Define la barra superior personalizada con el comportamiento de scroll.
    ) {
        Surface( // Contenedor visual que define el fondo de la pantalla.
            modifier = Modifier.fillMaxSize() // Hace que el Surface ocupe todo el tamaño disponible de la pantalla.
        ) {
            val marsViewModel: MarsViewModel =
                viewModel(factory = MarsViewModel.Factory) // Obtiene una instancia del ViewModel usando su fábrica personalizada.

            HomeScreen( // Llama a la pantalla principal, pasándole el estado de UI y acciones del ViewModel.
                marsUiState = marsViewModel.marsUiState, // Estado actual de la interfaz (cargando, error o éxito con datos).
                retryAction = marsViewModel::getMarsPhotos, // Acción a ejecutar cuando el usuario desea reintentar obtener datos.
                contentPadding = it // Padding que provee el Scaffold para respetar espacios seguros (topBar, bottomBar).
            )
        }
    }
}

@Composable
fun MarsTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar( // Crea una barra superior con el título centrado.
        scrollBehavior = scrollBehavior, // Aplica el comportamiento de scroll recibido como parámetro.
        title = {
            Text(
                text = stringResource(R.string.app_name), // Muestra el nombre de la app desde strings.xml.
                style = MaterialTheme.typography.headlineSmall, // Usa el estilo de título pequeño del tema actual.
            )
        },
        modifier = modifier // Permite aplicar modificadores desde fuera de la función si se desea.
    )
}