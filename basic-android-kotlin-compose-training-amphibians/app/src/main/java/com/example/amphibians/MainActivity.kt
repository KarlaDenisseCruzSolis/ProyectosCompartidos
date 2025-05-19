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

package com.example.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.amphibians.ui.AmphibiansApp
import com.example.amphibians.ui.theme.AmphibiansTheme

// Clase MainActivity que hereda de ComponentActivity y representa la entrada principal de la app
class MainActivity : ComponentActivity() {
    // Metodo que se llama cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad utilizando Jetpack Compose
        setContent {
            // Aplica el tema personalizado de la aplicación
            AmphibiansTheme {
                // Contenedor Surface que utiliza el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa todo el tamaño disponible
                    color = MaterialTheme.colorScheme.background // Usa el color de fondo del tema
                ) {
                    // Llama al componente principal de la app que contiene la UI
                    AmphibiansApp()
                }
            }
        }
    }
}