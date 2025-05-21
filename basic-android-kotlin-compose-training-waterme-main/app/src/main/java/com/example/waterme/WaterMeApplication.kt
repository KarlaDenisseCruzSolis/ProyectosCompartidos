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

package com.example.waterme // Define el paquete de la aplicación

import android.app.Application // Importa la clase Application base de Android
import com.example.waterme.data.AppContainer // Importa la interfaz o clase contenedora de dependencias
import com.example.waterme.data.DefaultAppContainer // Importa la implementación por defecto del contenedor

class WaterMeApplication : Application() { // Clase que extiende Application para configuración global
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer // Variable para almacenar el contenedor de dependencias, inicializada luego
    override fun onCreate() { // Método llamado al crear la aplicación (antes que cualquier activity)
        super.onCreate() // Llama a la implementación base para inicialización estándar
        container = DefaultAppContainer(this) // Inicializa el contenedor con la implementación por defecto, pasando el contexto
    }
}