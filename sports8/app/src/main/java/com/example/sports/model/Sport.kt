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

package com.example.sports.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Modelo de datos para un Deporte.
 *
 * Esta clase de datos encapsula toda la información relevante para un deporte individual
 * que se mostrará en la aplicación. Utiliza anotaciones para asegurar que los IDs de los recursos
 * sean del tipo correcto (cadenas para textos y drawables para imágenes).
 *
 * @property id Un identificador único para el deporte.
 * @property titleResourceId El ID del recurso de cadena para el título del deporte.
 * @property subtitleResourceId El ID del recurso de cadena para el subtítulo o una breve descripción del deporte.
 * @property playerCount El número de jugadores que participan en el deporte.
 * @property olympic Un valor booleano que indica si el deporte es un deporte olímpico (true) o no (false).
 * @property imageResourceId El ID del recurso drawable para la imagen principal del deporte (usada en la lista).
 * @property sportsImageBanner El ID del recurso drawable para la imagen de banner del deporte (usada en la vista de detalles).
 * @property sportDetails El ID del recurso de cadena para los detalles o la descripción completa del deporte.
 */
data class Sport(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
    val playerCount: Int,
    val olympic: Boolean,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val sportsImageBanner: Int,
    @StringRes val sportDetails: Int
)
