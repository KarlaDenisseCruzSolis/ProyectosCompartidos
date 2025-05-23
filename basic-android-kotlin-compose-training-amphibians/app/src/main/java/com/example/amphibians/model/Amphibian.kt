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

package com.example.amphibians.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class that defines an amphibian which includes a name, type, description, and image URL.
 */
@Serializable   // Anotación para que la clase pueda ser serializada y deserializada automáticamente
data class Amphibian(   // Clase de datos que representa un anfibio
    val name: String,   // Nombre del anfibio
    val type: String,   // Tipo o especie del anfibio
    val description: String,   // Descripción del anfibio
    @SerialName("img_src") val imgSrc: String  // URL de la imagen del anfibio, con nombre en JSON "img_src"
)