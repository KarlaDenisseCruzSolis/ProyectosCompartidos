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
package com.example.juicetracker.data

/**
 * Contenedor de la aplicación para la inyección de dependencias.
 *
 * Esta interfaz define las dependencias que la aplicación necesita para funcionar,
 * en este caso, el repositorio de jugos. Al usar una interfaz, se promueve
 * la inversión de control y facilita las pruebas y la modularidad del código.
 */
interface AppContainer {
    // Propiedad que proporciona una instancia de JuiceRepository.
    // Las clases que implementen esta interfaz serán responsables de proporcionar
    // una implementación concreta de JuiceRepository.
    val juiceRepository: JuiceRepository
}