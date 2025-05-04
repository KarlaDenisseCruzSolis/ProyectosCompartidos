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

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 * (Esta clase representa una entidad de la base de datos. Cada instancia de Item será una fila en la tabla "items")
 */
@Entity(tableName = "items")// Anotación que indica que esta clase representa una tabla de base de datos llamada "items"
data class Item(// Define una clase de datos llamada Item
    @PrimaryKey(autoGenerate = true) // Especifica que 'id' es la clave primaria y se generará automáticamente
    val id: Int = 0,// Identificador único para cada item, por defecto es 0 (se sobreescribe automáticamente)
    val name: String,// Nombre del artículo
    val price: Double, // Precio del artículo
    val quantity: Int // Cantidad disponible del artículo en inventario
)
