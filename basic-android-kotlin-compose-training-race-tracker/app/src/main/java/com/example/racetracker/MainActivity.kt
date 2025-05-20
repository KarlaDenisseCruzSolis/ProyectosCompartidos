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
package com.example.racetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.racetracker.ui.RaceTrackerApp
import com.example.racetracker.ui.theme.RaceTrackerTheme

// MainActivity es el punto de entrada de la aplicación Android.
class MainActivity : ComponentActivity() {
    // onCreate se llama cuando la actividad se crea por primera vez.
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Habilita la visualización de borde a borde para la actividad.
        super.onCreate(savedInstanceState) // Llama al metodo onCreate de la superclase.
        setContent {
            // Establece el contenido de la actividad usando Jetpack Compose.
            RaceTrackerTheme {
                // Un contenedor Surface que usa el color 'background' del tema.
                Surface(
                    modifier = Modifier.fillMaxSize(), // Hace que el Surface ocupe toda la pantalla.
                ) {
                    RaceTrackerApp() // Renderiza el composable principal de la aplicación RaceTracker.
                }
            }
        }
    }
}