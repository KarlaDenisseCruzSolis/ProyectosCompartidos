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

import android.app.Application
import com.example.amphibians.data.AppContainer
import com.example.amphibians.data.DefaultAppContainer

// Clase principal de la aplicación, se ejecuta al iniciar la app
class AmphibiansApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    // Declaración de una propiedad lateinit para almacenar el contenedor de dependencias
    lateinit var container: AppContainer

    // Metodo que se ejecuta cuando se crea la aplicación
    override fun onCreate() {
        super.onCreate()
        // Inicializa el contenedor de dependencias con su implementación por defecto
        container = DefaultAppContainer()
    }
}
