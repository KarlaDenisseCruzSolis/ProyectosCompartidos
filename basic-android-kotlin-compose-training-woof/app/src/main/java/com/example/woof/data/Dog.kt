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
package com.example.woof.data // Define el paquete donde está esta clase y datos relacionados

import androidx.annotation.DrawableRes // Importa anotación para recursos gráficos (imágenes)
import androidx.annotation.StringRes   // Importa anotación para recursos de texto (strings)
import com.example.woof.R            // Importa recursos generados automáticamente (imágenes, strings, etc.)
/**
 * A data class to represent the information presented in the dog card
 * Clase de datos que representa la información que se muestra en la tarjeta de un perro
 */
data class Dog(
    @DrawableRes val imageResourceId: Int, // Id del recurso de imagen, anotado para indicar que es un drawable
    @StringRes val name: Int,              // Id del recurso de texto para el nombre del perro
    val age: Int,                          // Edad del perro en años
    @StringRes val hobbies: Int            // Id del recurso de texto que describe los hobbies del perro
)
// Lista de perros con sus datos, cada uno con imagen, nombre, edad y descripción (hobbies)
val dogs = listOf(
    Dog(R.drawable.koda, R.string.dog_name_1, 2, R.string.dog_description_1),   // Perro 1 con sus recursos y edad
    Dog(R.drawable.lola, R.string.dog_name_2, 16, R.string.dog_description_2),  // Perro 2
    Dog(R.drawable.frankie, R.string.dog_name_3, 2, R.string.dog_description_3),// Perro 3
    Dog(R.drawable.nox, R.string.dog_name_4, 8, R.string.dog_description_4),    // Perro 4
    Dog(R.drawable.faye, R.string.dog_name_5, 8, R.string.dog_description_5),   // Perro 5
    Dog(R.drawable.bella, R.string.dog_name_6, 14, R.string.dog_description_6), // Perro 6
    Dog(R.drawable.moana, R.string.dog_name_7, 2, R.string.dog_description_7),  // Perro 7
    Dog(R.drawable.tzeitel, R.string.dog_name_8, 7, R.string.dog_description_8),// Perro 8
    Dog(R.drawable.leroy, R.string.dog_name_9, 4, R.string.dog_description_9)   // Perro 9
)