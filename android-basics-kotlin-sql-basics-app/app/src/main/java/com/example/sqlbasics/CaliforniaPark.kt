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

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "park") // Anotación @Entity indica que esta clase representa una tabla de base de datos llamada "park"
data class CaliforniaPark(
    @PrimaryKey(autoGenerate = true) val id: Int, // Define el campo 'id' como clave primaria que se genera automáticamente
    @ColumnInfo(name = "name") val name: String, // Asocia el campo 'name' con la columna "name" de la tabla
    @ColumnInfo(name = "city") val city: String, // Asocia el campo 'city' con la columna "city"
    @ColumnInfo(name = "area_acres") val acres: Int, // Asocia 'acres' con "area_acres", indica el tamaño del parque en acres
    @ColumnInfo(name = "park_visitors") val visitors: Int?, // Asocia 'visitors' con "park_visitors", puede ser nulo (nullable)
    @ColumnInfo(name = "established") val established: Long, // Asocia 'established' con "established", fecha en milisegundos desde 1970
    @ColumnInfo(name = "type") val type: String   // Asocia 'type' con "type", indica el tipo de parque (por ejemplo, natural, estatal)
)
