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
 * Implementación de la interfaz [JuiceRepository]
 * que permite el acceso y la modificación de los ítems de Juice a través de [JuiceDao].
 */
class RoomJuiceRepository(private val juiceDao: JuiceDao) : JuiceRepository {
    // Declara una propiedad de flujo que emite una lista de objetos Juice.
    // Obtiene todos los ítems de Juice de la base de datos a través de juiceDao.
    override val juiceStream: Flow<List<Juice>> = juiceDao.getAll()

    // Implementa la función para agregar un nuevo ítem de Juice a la base de datos.
    // La palabra clave 'suspend' indica que es una función de suspensión que puede ser pausada y reanudada.
    override suspend fun addJuice(juice: Juice) = juiceDao.insert(juice)

    // Implementa la función para eliminar un ítem de Juice de la base de datos.
    override suspend fun deleteJuice(juice: Juice) = juiceDao.delete(juice)

    // Implementa la función para actualizar un ítem de Juice existente en la base de datos.
    override suspend fun updateJuice(juice: Juice) = juiceDao.update(juice)
}
