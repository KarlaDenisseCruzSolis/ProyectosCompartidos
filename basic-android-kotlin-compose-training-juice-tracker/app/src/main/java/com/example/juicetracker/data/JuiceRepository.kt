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

import kotlinx.coroutines.flow.Flow

/**
 * Interfaz para [JuiceRepository] que contiene métodos para acceder y modificar ítems de jugo.
 */
interface JuiceRepository {
    // Declara una propiedad de flujo que emitirá una lista de objetos Juice.
    // Esto permite observar los cambios en la lista de jugos de forma asíncrona.
    val juiceStream: Flow<List<Juice>>

    // Función suspendida para agregar un nuevo objeto Juice a la fuente de datos.
    // 'suspend' indica que esta función puede pausarse y reanudarse en un coroutine.
    suspend fun addJuice(juice: Juice)

    // Función suspendida para eliminar un objeto Juice de la fuente de datos.
    suspend fun deleteJuice(juice: Juice)

    // Función suspendida para actualizar un objeto Juice existente en la fuente de datos.
    suspend fun updateJuice(juice: Juice)
}