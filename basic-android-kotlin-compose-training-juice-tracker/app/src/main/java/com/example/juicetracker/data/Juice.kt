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

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.juicetracker.R
import com.example.juicetracker.ui.theme.Orange as OrangeColor

/**
 * Representa una sola tabla en la base de datos.
 *
 * Nota: El tipo de color es diferente al de la rama principal.
 * Por favor, elimina la aplicación y vuelve a instalarla si existe una aplicación de la rama principal
 * para evitar errores de base de datos.
 */
@Entity // La anotación @Entity indica que esta clase es una tabla de la base de datos Room.
data class Juice(
    @PrimaryKey(autoGenerate = true) // @PrimaryKey define 'id' como la clave primaria y autoGenerate = true permite que Room genere automáticamente valores para ella.
    val id: Long, // El ID único para cada entrada de jugo.
    val name: String, // El nombre del jugo.
    val description: String = "", // Una descripción opcional del jugo, con un valor predeterminado vacío.
    val color: String, // El color del jugo, almacenado como una cadena.
    val rating: Int // La calificación del jugo.
)

// Un enum (enumeración) para definir los colores de los jugos, asociando cada color con un objeto Color de Compose y un ID de recurso de cadena para su etiqueta.
enum class JuiceColor(val color: Color, @StringRes val label: Int) {
    Red(Color.Red, R.string.red),
    Blue(Color.Blue, R.string.blue),
    Green(Color.Green, R.string.green),
    Cyan(Color.Cyan, R.string.cyan),
    Yellow(Color.Yellow, R.string.yellow),
    Magenta(Color.Magenta, R.string.magenta),
    Orange(OrangeColor, R.string.orange)
}
