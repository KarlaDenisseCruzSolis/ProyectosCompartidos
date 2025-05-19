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
package com.example.cupcake.data

import com.example.cupcake.R

// Objeto singleton que provee datos estáticos para la app
object DataSource {
    // Lista de recursos de texto que representan los sabores disponibles de cupcake
    val flavors = listOf(
        R.string.vanilla,         // Vainilla
        R.string.chocolate,       // Chocolate
        R.string.red_velvet,      // Red Velvet
        R.string.salted_caramel,  // Caramelo Salado
        R.string.coffee           // Café
    )

    // Lista de pares que contienen la descripción del número de cupcakes y su cantidad numérica
    val quantityOptions = listOf(
        Pair(R.string.one_cupcake, 1),      // Una pieza
        Pair(R.string.six_cupcakes, 6),     // Seis piezas
        Pair(R.string.twelve_cupcakes, 12)  // Doce piezas
    )
}