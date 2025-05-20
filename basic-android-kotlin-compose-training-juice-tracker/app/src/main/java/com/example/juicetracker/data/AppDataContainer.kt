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
package com.example.juicetracker.data

import android.content.Context

/**
 * Implementación de [AppContainer] que proporciona una instancia de [RoomJuiceRepository].
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementación para [JuiceRepository].
     *
     * Utiliza 'by lazy' para inicializar el repositorio solo cuando se accede a él por primera vez.
     * Esto asegura que la base de datos se cree de forma diferida, lo que es eficiente.
     *
     * Obtiene la instancia de la base de datos de la aplicación a través de AppDatabase.getDatabase(context)
     * y luego obtiene el JuiceDao de esa base de datos para construir el RoomJuiceRepository.
     */
    override val juiceRepository: JuiceRepository by lazy {
        RoomJuiceRepository(AppDatabase.getDatabase(context).juiceDao())
    }
}
