/*
 * Copyright (C) 2023 The Android Open Source Project
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

package com.example.dessertclicker.data

import com.example.dessertclicker.R
import com.example.dessertclicker.model.Dessert

/**
 * [Datasource] generates a list of [Dessert]
 * Objeto que contiene la lista de postres disponibles en la app
 */
object Datasource {
    val dessertList = listOf(  // Lista inmutable de objetos Dessert
        Dessert(R.drawable.cupcake, 5, 0),        // Postre cupcake, cuesta 5, disponible desde 0 vendidos
        Dessert(R.drawable.donut, 10, 5),          // Donut, cuesta 10, disponible desde 5 vendidos
        Dessert(R.drawable.eclair, 15, 20),        // Eclair, cuesta 15, desde 20 vendidos
        Dessert(R.drawable.froyo, 30, 50),         // Froyo, cuesta 30, desde 50 vendidos
        Dessert(R.drawable.gingerbread, 50, 100),  // Gingerbread, cuesta 50, desde 100 vendidos
        Dessert(R.drawable.honeycomb, 100, 200),   // Honeycomb, cuesta 100, desde 200 vendidos
        Dessert(R.drawable.icecreamsandwich, 500, 500), // Ice Cream Sandwich, cuesta 500, desde 500 vendidos
        Dessert(R.drawable.jellybean, 1000, 1000), // Jellybean, cuesta 1000, desde 1000 vendidos
        Dessert(R.drawable.kitkat, 2000, 2000),    // KitKat, cuesta 2000, desde 2000 vendidos
        Dessert(R.drawable.lollipop, 3000, 4000),  // Lollipop, cuesta 3000, desde 4000 vendidos
        Dessert(R.drawable.marshmallow, 4000, 8000), // Marshmallow, cuesta 4000, desde 8000 vendidos
        Dessert(R.drawable.nougat, 5000, 16000),   // Nougat, cuesta 5000, desde 16000 vendidos
        Dessert(R.drawable.oreo, 6000, 20000)      // Oreo, cuesta 6000, desde 20000 vendidos
    )
}