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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Anota la clase como una base de datos Room.
// 'entities' especifica las clases de entidad que forman parte de esta base de datos (en este caso, Juice).
// 'version' es la versión de la base de datos; se incrementa cuando se cambia el esquema.
@Database(entities = [Juice::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // Declara un metodo abstracto que Room implementará para proporcionar el DAO (Data Access Object) para la tabla Juice.
    abstract fun juiceDao(): JuiceDao

    // Define un objeto compañero para métodos estáticos y propiedades, como la inicialización de la base de datos.
    companion object {
        // La anotación @Volatile asegura que todas las lecturas y escrituras de esta propiedad se realicen desde la memoria principal,
        // garantizando que el valor sea siempre el más actualizado en entornos multihilo.
        @Volatile
        private var INSTANCE: AppDatabase? = null // La instancia Singleton de la base de datos.

        // Metodo para obtener la instancia Singleton de la base de datos.
        // Si la instancia ya existe, la retorna; de lo contrario, la crea de forma segura en un bloque sincronizado.
        fun getDatabase(context: Context): AppDatabase {
            // Si INSTANCE no es nulo, entonces ya se ha inicializado, por lo que lo retornamos.
            // Si es nulo, entramos en el bloque 'synchronized'.
            return INSTANCE ?: synchronized(this) {
                // Construye la base de datos Room.
                Room.databaseBuilder(
                    context, // El contexto de la aplicación.
                    AppDatabase::class.java, // La clase de la base de datos.
                    "app_database" // El nombre del archivo de la base de datos.
                )
                    // Configurar esta opción en el constructor de la base de datos de tu aplicación significa que Room
                    // elimina permanentemente todos los datos de las tablas de tu base de datos cuando intenta
                    // realizar una migración sin una ruta de migración definida. Esto es útil para el desarrollo,
                    // pero no para la producción.
                    .fallbackToDestructiveMigration()
                    // Construye la instancia de la base de datos.
                    .build()
                    // Después de construir la instancia, la asigna a INSTANCE y la retorna.
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}
