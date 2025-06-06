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

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Proporciona acceso a las operaciones de lectura/escritura sobre la tabla de horarios.
 * Usado por los view models para formatear los resultados de las consultas para su uso en la interfaz de usuario.
 */
@Dao // Define esta interfaz como un "DAO" (Data Access Object) de Room.
interface BusScheduleDao {

    // Define una consulta que obtiene todos los registros de la tabla "schedule",
    // ordenados por hora de llegada de manera ascendente.
    @Query(
        """
        SELECT * FROM schedule 
        ORDER BY arrival_time ASC    
        """
    )
    // Devuelve un Flow que emitirá una lista de objetos BusSchedule de manera asíncrona.
    // Flow permite a la UI observar los datos de manera reactiva.
    fun getAll(): Flow<List<BusSchedule>>

    // Define una consulta que obtiene todos los registros de la tabla "schedule"
    // donde el nombre de la parada coincide con el valor proporcionado,
    // ordenados por hora de llegada de manera ascendente.
    @Query(
        """
        SELECT * FROM schedule 
        WHERE stop_name = :stopName 
        ORDER BY arrival_time ASC 
        """
    )
    // Devuelve un Flow que emitirá una lista de objetos BusSchedule con el nombre de la parada especificado.
    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}