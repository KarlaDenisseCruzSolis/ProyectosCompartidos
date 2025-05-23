/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.sqlbasics

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao // Anotación @Dao indica que esta interfaz es un objeto de acceso a datos (DAO)
interface CaliforniaParkDao {
    // Inserta una lista de objetos CaliforniaPark en la tabla 'park'
    // La función es suspendida (suspend), por lo tanto debe ejecutarse dentro de una corrutina
    @Insert
    suspend fun insertAll(parks: List<CaliforniaPark>)
    // Consulta todos los registros de la tabla 'park' y los devuelve como una lista
    @Query("SELECT * FROM park")
    suspend fun getAll(): List<CaliforniaPark>
}
