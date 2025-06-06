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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() { // Clase abstracta que hereda de RoomDatabase

    abstract fun itemDao(): ItemDao // Metodo abstracto para obtener una instancia del DAO (interfaz de acceso a datos)

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null // Instancia única de la base de datos

        fun getDatabase(context: Context): InventoryDatabase { // Función para obtener o crear la base de datos
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                // Crea un constructor para la base de datos
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    /**
                     * Setting this option in your app's database builder means that Room
                     * permanently deletes all data from the tables in your database when it
                     * attempts to perform a migration with no defined migration path.
                     */
                    .fallbackToDestructiveMigration() // Elimina todos los datos si no se encuentra una migración definida entre versiones
                    .build()// Construye la instancia de la base de datos
                    .also { Instance = it }// Asigna la instancia creada a 'Instance' y la devuelve
            }
        }
    }
}
