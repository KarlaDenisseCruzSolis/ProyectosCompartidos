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

package com.example.marsphotos // Define el paquete donde está este archivo Kotlin (app principal).

import android.os.Bundle // Importa la clase Bundle, usada para guardar el estado de la actividad.
import androidx.activity.ComponentActivity // Importa la clase base para actividades que usan Compose.
import androidx.activity.compose.setContent // Importa función para establecer el contenido Compose en la actividad.
import androidx.activity.enableEdgeToEdge // Importa función para habilitar contenido en modo edge-to-edge (pantalla completa sin barras).
import androidx.compose.foundation.layout.fillMaxSize // Importa modificador para llenar todo el espacio disponible.
import androidx.compose.material3.Surface // Importa un contenedor visual que aplica fondo y forma (Material3).
import androidx.compose.ui.Modifier // Importa el modificador que permite ajustar tamaño, forma y comportamiento de UI.
import com.example.marsphotos.ui.MarsPhotosApp // Importa la función composable que representa la app completa.
import com.example.marsphotos.ui.theme.MarsPhotosTheme // Importa el tema personalizado de la app.

class MainActivity : ComponentActivity() { // Declara la actividad principal heredando de ComponentActivity.
    override fun onCreate(savedInstanceState: Bundle?) { // Función que se ejecuta al crear la actividad.
        enableEdgeToEdge() // Habilita que la app use toda la pantalla, sin áreas restringidas por barras de sistema.
        super.onCreate(savedInstanceState) // Llama al método onCreate de la superclase para inicialización básica.
        setContent { // Establece el contenido UI usando Compose.
            MarsPhotosTheme { // Aplica el tema personalizado a toda la UI.
                Surface( // Contenedor visual que define el fondo y la forma del área visible.
                    modifier = Modifier.fillMaxSize(), // Hace que el Surface ocupe todo el tamaño disponible.
                ) {
                    MarsPhotosApp() // Llama a la función composable que define la estructura principal de la app.
                }
            }
        }
    }
}