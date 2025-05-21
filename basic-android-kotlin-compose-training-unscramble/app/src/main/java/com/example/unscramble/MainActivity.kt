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

package com.example.unscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.unscramble.ui.GameScreen
import com.example.unscramble.ui.theme.UnscrambleTheme

/**
 * MainActivity es la actividad principal de la aplicación Unscramble.
 * Es el punto de entrada de la aplicación y gestiona la configuración inicial de la interfaz de usuario.
 */
class MainActivity : ComponentActivity() {
    /**
     * Llamado cuando la actividad se crea por primera vez.
     * Aquí se configura la interfaz de usuario de la aplicación.
     *
     * @param savedInstanceState Si la actividad está siendo re-inicializada después de haber sido
     * previamente cerrada, este Bundle contiene los datos que suministró más recientemente en
     * [onSaveInstanceState]. De lo contrario, es nulo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Habilita el modo de pantalla completa para que el contenido se extienda hasta los bordes del dispositivo.
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        // Establece el contenido de la interfaz de usuario de la actividad utilizando Jetpack Compose.
        setContent {
            // Aplica el tema definido para la aplicación Unscramble.
            UnscrambleTheme {
                // Una superficie que ocupa todo el tamaño disponible.
                // Sirve como el contenedor principal para el contenido de la interfaz de usuario.
                Surface(
                    modifier = Modifier.fillMaxSize(), // El modificador fillMaxSize() hace que la superficie ocupe todo el espacio disponible.
                ) {
                    // Llama a la función componible GameScreen, que contiene el diseño y la lógica del juego.
                    GameScreen()
                }
            }
        }
    }
}