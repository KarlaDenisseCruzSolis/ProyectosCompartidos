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
package com.example.marsphotos.data // Declara el paquete al que pertenece este archivo, útil para la organización del proyecto

import com.example.marsphotos.network.MarsApiService // Importa la interfaz del servicio de red para acceder a la API de fotos de Marte
import retrofit2.Retrofit // Importa la clase Retrofit que permite crear llamadas HTTP a servicios REST
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory // Importa el convertidor para usar kotlinx.serialization con Retrofit
import kotlinx.serialization.json.Json // Importa la clase Json para manejar objetos JSON en Kotlin
import okhttp3.MediaType.Companion.toMediaType // Importa la función para convertir una cadena a tipo MediaType (necesaria para el convertidor)

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer { // Define una interfaz para un contenedor de dependencias a nivel de aplicación
    val marsPhotosRepository: MarsPhotosRepository // Propiedad que representa el repositorio de fotos de Marte
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer { // Clase que implementa la interfaz AppContainer y proporciona las dependencias

    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/" // URL base del servidor donde se encuentra la API

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder() // Crea una instancia del cliente Retrofit usando el patrón Builder
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) // Añade un convertidor para transformar JSON a objetos Kotlin usando kotlinx.serialization
        .baseUrl(baseUrl) // Establece la URL base de la API para todas las llamadas HTTP
        .build() // Finaliza la construcción del objeto Retrofit

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: MarsApiService by lazy { // Crea una instancia del servicio Retrofit de forma perezosa (lazy), se inicializa sólo cuando se usa
        retrofit.create(MarsApiService::class.java) // Crea una implementación de la interfaz MarsApiService usando Retrofit
    }

    /**
     * DI implementation for Mars photos repository
     */
    override val marsPhotosRepository: MarsPhotosRepository by lazy { // Implementa la propiedad del repositorio usando una instancia que se crea perezosamente
        NetworkMarsPhotosRepository(retrofitService) // Crea una instancia del repositorio que usa el servicio Retrofit para obtener las fotos de Marte
    }
}