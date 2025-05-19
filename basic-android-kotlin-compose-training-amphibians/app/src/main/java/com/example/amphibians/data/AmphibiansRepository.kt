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

package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibiansApiService

/**
 * Repository interface que define cómo obtener datos de anfibios desde la fuente de datos.
 */
interface AmphibiansRepository {
    /** Metodo que recupera una lista de anfibios desde la fuente de datos */
    suspend fun getAmphibians(): List<Amphibian>
}

/**
 * Implementación del repositorio que utiliza una fuente de datos de red (API).
 */
class DefaultAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService // Inyección del servicio de red como dependencia
) : AmphibiansRepository {
    /** Implementación del metodo que obtiene la lista de anfibios a través del servicio de red */
    override suspend fun getAmphibians(): List<Amphibian> = amphibiansApiService.getAmphibians()
}