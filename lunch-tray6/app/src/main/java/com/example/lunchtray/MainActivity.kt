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
package com.example.lunchtray

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lunchtray.ui.theme.LunchTrayTheme

/**
 * La actividad principal de la aplicación Lunch Tray.
 * Esta es la clase de punto de entrada para la aplicación.
 */
class MainActivity : ComponentActivity() {
    /**
     * Llamado cuando la actividad se crea por primera vez.
     * Aquí es donde se realiza la configuración inicial de la UI de la aplicación.
     *
     * @param savedInstanceState Si la actividad está siendo reinicializada después de
     * haber sido cerrada previamente, este Bundle contiene los datos que suministró
     * más recientemente en [onSaveInstanceState]. De lo contrario, es nulo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama a la implementación de la superclase.
        // Establece el contenido de la UI de la actividad utilizando Jetpack Compose.
        setContent {
            // Aplica el tema definido para la aplicación Lunch Tray.
            LunchTrayTheme {
                // Llama al Composable principal de la aplicación, que define la estructura de navegación.
                LunchTrayApp()
            }
        }
    }
}
