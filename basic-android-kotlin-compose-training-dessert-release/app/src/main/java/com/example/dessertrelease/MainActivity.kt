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
package com.example.dessertrelease

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dessertrelease.ui.DessertReleaseApp
import com.example.dessertrelease.ui.theme.DessertReleaseTheme

class MainActivity : ComponentActivity() { // Define la actividad principal.
    override fun onCreate(savedInstanceState: Bundle?) { // Sobrescribe el metodo onCreate para inicializar la actividad.
        super.onCreate(savedInstanceState) // Llama al metodo de la clase base.
        setContent { // Establece el contenido usando Jetpack Compose.
            DessertReleaseTheme { // Aplica el tema de la aplicación.
                DessertReleaseApp() // Llama a la función que lanza la interfaz de la aplicación.
            }
        }
    }
}