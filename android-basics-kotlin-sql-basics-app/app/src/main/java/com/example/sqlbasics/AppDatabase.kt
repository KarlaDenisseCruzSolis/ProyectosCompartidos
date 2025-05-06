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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Define una base de datos Room con una sola entidad: CaliforniaPark, y versión 1
@Database(entities = arrayOf(CaliforniaPark::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun californiaParkDao(): CaliforniaParkDao // Metodo abstracto que proporciona acceso al DAO

    companion object { // Objeto companion: permite crear una sola instancia de AppDatabase (singleton)
        @Volatile // Volatile garantiza que los cambios sean visibles entre hilos
        private var INSTANCE: AppDatabase? = null

        fun getDatabase( // Metodo para obtener la base de datos (singleton)
            context: Context
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) { // Si la instancia ya existe, se devuelve; si no, se crea sincronizadamente
                // Construye la base de datos usando un archivo preexistente en assets
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database" // Nombre de la base de datos interna en Android
                )
                    .createFromAsset("database/sql_basics.db")// Carga la base desde assets
                    .build()
                INSTANCE = instance // Asigna la instancia creada

                instance // Retorna la instancia
            }
        }
    }
}