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
package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * [Affirmation] is the data class to represent the Affirmation text and imageResourceId
 */
/**
 * [Affirmation] es una clase de datos que representa una afirmación con su texto y una imagen.
 */
data class Affirmation(
    @StringRes val stringResourceId: Int,// ID de recurso de string (texto de la afirmación)
    @DrawableRes val imageResourceId: Int// ID de recurso de imagen asociada a la afirmación
)
