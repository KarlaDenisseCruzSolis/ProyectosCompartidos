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
package com.example.busschedule.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representa una sola tabla en la base de datos. Cada fila es una instancia separada
 * de la clase BusSchedule. Cada propiedad corresponde a una columna.
 * Además, es necesario un ID como identificador único para cada fila en la base de datos.
 */
@Entity(tableName = "Schedule") // Define la tabla en la base de datos con el nombre "Schedule".
data class BusSchedule(
    // La propiedad 'id' se marca como la clave primaria para identificar de forma única cada fila.
    @PrimaryKey
    val id: Int, // Clave primaria que identificará de manera única cada registro.

    // La propiedad 'stopName' representa el nombre de la parada.
    // Se usa la anotación @NonNull para asegurarse de que no sea nulo.
    @NonNull
    @ColumnInfo(name = "stop_name") // El nombre de la columna en la base de datos será "stop_name".
    val stopName: String, // Nombre de la parada de autobús.

    // La propiedad 'arrivalTimeInMillis' representa el tiempo de llegada en milisegundos.
    // También se marca como @NonNull para que no sea nulo.
    @NonNull
    @ColumnInfo(name = "arrival_time") // El nombre de la columna en la base de datos será "arrival_time".
    val arrivalTimeInMillis: Int // Hora de llegada en milisegundos desde la medianoche.
)