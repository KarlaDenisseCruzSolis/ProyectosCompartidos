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

package com.example.sports

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
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import com.example.sports.ui.SportsApp
import com.example.sports.ui.theme.SportsTheme

/**
 * Actividad principal de la aplicación Sports.
 * Esta es la clase de punto de entrada para la aplicación.
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class) // Permite el uso de APIs experimentales de Material 3 para clases de tamaño de ventana.
class MainActivity : ComponentActivity() {
    /**
     * Se llama cuando la actividad se crea por primera vez.
     * Aquí se realiza la configuración inicial de la UI de la aplicación.
     *
     * @param savedInstanceState Si la actividad está siendo reinicializada después de
     * haber sido cerrada previamente, este Bundle contiene los datos que suministró
     * más recientemente en [onSaveInstanceState]. De lo contrario, es nulo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Habilita el modo de pantalla completa, permitiendo que el contenido se extienda hasta los bordes de la pantalla.
        super.onCreate(savedInstanceState) // Llama a la implementación de la superclase.
        setContent {
            // Aplica el tema definido para la aplicación Sports.
            SportsTheme {
                // Obtiene la dirección de diseño local (por ejemplo, LTR o RTL).
                val layoutDirection = LocalLayoutDirection.current
                // Superficie de Material Design para contener el contenido de la aplicación.
                Surface(
                    modifier = Modifier
                        // Aplica un padding al inicio y al final para evitar que el contenido
                        // se superponga con las barras del sistema (como la barra de estado o la barra de navegación).
                        .padding(
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection)
                        )
                ) {
                    // Calcula la clase de tamaño de ventana para determinar el diseño apropiado.
                    val windowSize = calculateWindowSizeClass(this)
                    // Llama al Composable principal de la aplicación Sports.
                    SportsApp(
                        windowSize = windowSize.widthSizeClass, // Pasa la clase de tamaño de ancho de la ventana.
                        onBackPressed = { finish() } // Define la acción al presionar el botón de retroceso: finaliza la actividad.
                    )
                }
            }
        }
    }
}