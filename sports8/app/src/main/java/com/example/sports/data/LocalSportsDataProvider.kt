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

package com.example.sports.data

import com.example.sports.R
import com.example.sports.model.Sport

/**
 * Objeto singleton que proporciona datos de deportes de manera local.
 * Actúa como una fuente de datos estática para la aplicación, conteniendo
 * una lista predefinida de objetos [Sport].
 */
object LocalSportsDataProvider {
    /**
     * Define un deporte predeterminado, que es el primer elemento de la lista de deportes.
     * Esto puede ser útil para establecer una selección inicial o un valor por defecto.
     */
    val defaultSport = getSportsData()[0]

    /**
     * Retorna una lista inmutable de objetos [Sport] que representan los datos de los deportes disponibles.
     * Cada objeto [Sport] incluye detalles como el ID, los IDs de recursos para el título, subtítulo,
     * imágenes, el número de jugadores y si es un deporte olímpico.
     *
     * @return Una [List] de [Sport] que contiene los datos de los deportes.
     */
    fun getSportsData(): List<Sport> {
        return listOf(
            Sport(
                id = 1,
                titleResourceId = R.string.baseball,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 9 ,
                olympic = true,
                imageResourceId = R.drawable.ic_baseball_square,
                sportsImageBanner = R.drawable.ic_baseball_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 2,
                titleResourceId = R.string.badminton,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_badminton_square,
                sportsImageBanner = R.drawable.ic_badminton_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 3,
                titleResourceId = R.string.basketball,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 5,
                olympic = true,
                imageResourceId = R.drawable.ic_basketball_square,
                sportsImageBanner = R.drawable.ic_basketball_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 4,
                titleResourceId = R.string.bowling,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = false,
                imageResourceId = R.drawable.ic_bowling_square,
                sportsImageBanner = R.drawable.ic_bowling_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 5,
                titleResourceId = R.string.cycling,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_cycling_square,
                sportsImageBanner = R.drawable.ic_cycling_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 6,
                titleResourceId = R.string.golf,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = false,
                imageResourceId = R.drawable.ic_golf_square,
                sportsImageBanner = R.drawable.ic_golf_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 7,
                titleResourceId = R.string.running,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_running_square,
                sportsImageBanner = R.drawable.ic_running_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 8,
                titleResourceId = R.string.soccer,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 11,
                olympic = true,
                imageResourceId = R.drawable.ic_soccer_square,
                sportsImageBanner = R.drawable.ic_soccer_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 9,
                titleResourceId = R.string.swimming,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_swimming_square,
                sportsImageBanner = R.drawable.ic_swimming_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 10,
                titleResourceId = R.string.table_tennis,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_table_tennis_square,
                sportsImageBanner = R.drawable.ic_table_tennis_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 11,
                titleResourceId = R.string.tennis,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_tennis_square,
                sportsImageBanner = R.drawable.ic_tennis_banner,
                sportDetails = R.string.sport_detail_text
            )
        )
    }
}
