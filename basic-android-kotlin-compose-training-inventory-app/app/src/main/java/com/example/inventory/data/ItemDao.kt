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

package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Database access object to access the Inventory database
 * (Interfaz de acceso a la base de datos para interactuar con los datos de inventario)
 */
@Dao // Indica que esta es una interfaz DAO que contiene operaciones de acceso a la base de datos
interface ItemDao { // Define la interfaz ItemDao para gestionar operaciones CRUD sobre la tabla 'items'

    @Query("SELECT * from items ORDER BY name ASC") // Consulta para obtener todos los items ordenados por nombre
    fun getAllItems(): Flow<List<Item>> // Devuelve una lista de 'items' como un flujo de datos (para actualizaciones en tiempo real)

    @Query("SELECT * from items WHERE id = :id")// Consulta para obtener un item específico por su id
    fun getItem(id: Int): Flow<Item>// Devuelve un solo item basado en el id, como un flujo de datos

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)// Inserta un item en la base de datos, ignorando si ya existe
    suspend fun insert(item: Item)// Operación suspensiva para insertar un item en la base de datos

    @Update // Anotación que indica que este metodo se usa para actualizar un item en la base de datos
    suspend fun update(item: Item)  // Operación suspensiva para actualizar un item en la base de datos

    @Delete // Anotación que indica que este metodo se usa para eliminar un item de la base de datos
    suspend fun delete(item: Item) // Operación suspensiva para eliminar un item de la base de datos
}
