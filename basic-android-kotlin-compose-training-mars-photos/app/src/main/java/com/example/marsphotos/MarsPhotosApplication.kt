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
package com.example.marsphotos // Define el paquete donde se encuentra esta clase.

import android.app.Application // Importa la clase base Application de Android.
import com.example.marsphotos.data.AppContainer // Importa la interfaz que representa el contenedor de dependencias.
import com.example.marsphotos.data.DefaultAppContainer // Importa la implementación por defecto del contenedor de dependencias.

class MarsPhotosApplication : Application() { // Declara la clase que extiende Application para inicialización global.
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer // Variable que almacenará el contenedor de dependencias, se inicializa después.
    override fun onCreate() { // Método llamado al iniciar la aplicación.
        super.onCreate() // Llama al método onCreate de la clase base Application.
        container = DefaultAppContainer() // Inicializa el contenedor con la implementación por defecto.
    }
}