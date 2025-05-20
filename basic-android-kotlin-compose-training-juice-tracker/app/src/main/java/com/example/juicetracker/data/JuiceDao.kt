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

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Objeto de Acceso a Datos (DAO) para Juice, que contiene métodos para acceder y modificar la tabla Juice en la base de datos Room.
 */
@Dao
interface JuiceDao {
    // Define una consulta SQL para obtener todos los registros de la tabla 'juice'.
    // Retorna un Flow que emitirá una lista de objetos Juice cada vez que los datos cambien.
    @Query("SELECT * FROM juice")
    fun getAll(): Flow<List<Juice>>

    // Anota la función para insertar un nuevo objeto Juice en la base de datos.
    // 'suspend' indica que esta es una función de suspensión y debe llamarse desde una coroutine.
    @Insert
    suspend fun insert(juice: Juice)

    // Anota la función para eliminar un objeto Juice existente de la base de datos.
    @Delete
    suspend fun delete(juice: Juice)

    // Anota la función para actualizar un objeto Juice existente en la base de datos.
    @Update
    suspend fun update(juice: Juice)
}