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
package com.example.cupcake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cupcake.ui.theme.CupcakeTheme

// Actividad principal de la app
class MainActivity : ComponentActivity() {
    // Metodo que se llama al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        // Habilita la visualización a pantalla completa sin barras de sistema (modo edge to edge)
        enableEdgeToEdge()
        // Llama al metodo onCreate de la clase padre para inicializar la actividad
        super.onCreate(savedInstanceState)
        // Define el contenido de la actividad usando Jetpack Compose
        setContent {
            // Aplica el tema personalizado de la app
            CupcakeTheme {
                // Llama al Composable principal que contiene la app
                CupcakeApp()
            }
        }
    }
}