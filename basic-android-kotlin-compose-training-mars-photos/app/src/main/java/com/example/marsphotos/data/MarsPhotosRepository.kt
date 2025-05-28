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
package com.example.marsphotos.data // Declara el paquete al que pertenece el archivo, útil para la organización del código fuente

import com.example.marsphotos.model.MarsPhoto // Importa la clase MarsPhoto, que representa una foto de Marte
import com.example.marsphotos.network.MarsApiService // Importa la interfaz MarsApiService, que define las llamadas a la API

/**
 * Repository that fetch mars photos list from marsApi.
 */
interface MarsPhotosRepository { // Define una interfaz para un repositorio que obtiene fotos de Marte desde la API
    /** Fetches list of MarsPhoto from marsApi */
    suspend fun getMarsPhotos(): List<MarsPhoto> // Declara una función suspendida que devuelve una lista de objetos MarsPhoto
}

/**
 * Network Implementation of Repository that fetch mars photos list from marsApi.
 */
class NetworkMarsPhotosRepository( // Define una clase que implementa MarsPhotosRepository usando la red
    private val marsApiService: MarsApiService // Recibe como parámetro el servicio Retrofit para conectarse a la API
) : MarsPhotosRepository { // Implementa la interfaz MarsPhotosRepository
    /** Fetches list of MarsPhoto from marsApi */
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos() // Implementa la función getMarsPhotos usando el método getPhotos() del servicio de red
}