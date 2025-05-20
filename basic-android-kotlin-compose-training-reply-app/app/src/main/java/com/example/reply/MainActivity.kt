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
package com.example.reply

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import com.example.reply.ui.ReplyApp
import com.example.reply.ui.theme.ReplyTheme

// La clase principal de la actividad de la aplicación.
class MainActivity : ComponentActivity() {

    // Anotación para indicar el uso de APIs experimentales.
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Habilita la visualización de borde a borde para que el contenido se extienda detrás de las barras del sistema.
        super.onCreate(savedInstanceState) // Llama al metodo onCreate de la superclase para la inicialización estándar.

        setContent {
            // Establece el contenido de la actividad usando Jetpack Compose.
            ReplyTheme {
                // Aplica el tema personalizado ReplyTheme a la interfaz de usuario.
                val layoutDirection = LocalLayoutDirection.current // Obtiene la dirección de diseño actual (izquierda a derecha o derecha a izquierda).
                Surface(
                    modifier = Modifier
                        .padding( // Aplica padding para que el contenido no se superponga con las barras de sistema.
                            start = WindowInsets.safeDrawing.asPaddingValues() // Calcula el padding inicial (izquierdo) desde los insets de dibujo seguros.
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing.asPaddingValues() // Calcula el padding final (derecho) desde los insets de dibujo seguros.
                                .calculateEndPadding(layoutDirection)
                        )
                ) {
                    val windowSize = calculateWindowSizeClass(this) // Calcula la clase de tamaño de la ventana actual de la actividad.

                    ReplyApp(
                        windowSize = windowSize.widthSizeClass, // Pasa la clase de tamaño del ancho de la ventana a ReplyApp.
                    )
                }
            }
        }
    }
}

// Composable de previsualización para la aplicación Reply en un tamaño compacto.
@Preview(showBackground = true) // Muestra un fondo en la previsualización.
@Composable
fun ReplyAppCompactPreview() {
    ReplyTheme { // Aplica el tema de la aplicación.
        Surface { // Envuelve el contenido en un Surface.
            ReplyApp(
                windowSize = WindowWidthSizeClass.Compact, // Establece la clase de ancho de ventana a Compact para la previsualización.
            )
        }
    }
}

// Composable de previsualización para la aplicación Reply en un tamaño mediano.
@Preview(showBackground = true, widthDp = 700) // Muestra un fondo y establece un ancho de 700dp para la previsualización.
@Composable
fun ReplyAppMediumPreview() {
    ReplyTheme { // Aplica el tema de la aplicación.
        Surface { // Envuelve el contenido en un Surface.
            ReplyApp(
                windowSize = WindowWidthSizeClass.Medium, // Establece la clase de ancho de ventana a Medium para la previsualización.
            )
        }
    }
}

// Composable de previsualización para la aplicación Reply en un tamaño expandido.
@Preview(showBackground = true, widthDp = 1000) // Muestra un fondo y establece un ancho de 1000dp para la previsualización.
@Composable
fun ReplyAppExpandedPreview() {
    ReplyTheme { // Aplica el tema de la aplicación.
        Surface { // Envuelve el contenido en un Surface.
            ReplyApp(
                windowSize = WindowWidthSizeClass.Expanded, // Establece la clase de ancho de ventana a Expanded para la previsualización.
            )
        }
    }
}
