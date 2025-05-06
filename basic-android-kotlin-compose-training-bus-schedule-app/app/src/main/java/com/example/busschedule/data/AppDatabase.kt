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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Definición de la clase AppDatabase, que es la base de datos de la aplicación.
// La anotación @Database indica las entidades que se gestionan en la base de datos y la versión actual.
@Database(entities = arrayOf(BusSchedule::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    // Metodo abstracto para acceder a la DAO (Data Access Object) de BusSchedule.
    abstract fun busScheduleDao(): BusScheduleDao

    // Compañero de objeto que mantiene la instancia única de la base de datos.
    companion object {
        // Volatile asegura que el valor de INSTANCE se actualice correctamente en varios hilos.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Metodo para obtener la instancia de la base de datos de manera segura en entornos concurrentes.
        fun getDatabase(context: Context): AppDatabase {
            // Si ya existe una instancia, se devuelve. Si no, se crea una nueva.
            return INSTANCE ?: synchronized(this) {
                // Construcción de la base de datos utilizando Room, especificando el contexto, la clase de la base de datos y el nombre del archivo.
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"  // Nombre del archivo de base de datos.
                )
                    // Crea la base de datos desde un archivo de activos preexistente.
                    .createFromAsset("database/bus_schedule.db")
                    // Si no hay una migración definida, la base de datos será eliminada y reconstruida.
                    // Este comportamiento puede evitar problemas si no se gestionan las migraciones.
                    .fallbackToDestructiveMigration()
                    .build()  // Construcción final de la base de datos.
                    .also {
                        // Se asigna la nueva instancia a la variable INSTANCE.
                        INSTANCE = it
                    }
            }
        }
    }
}