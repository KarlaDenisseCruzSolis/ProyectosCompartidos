/*
 * Copyright 2023 The Android Open Source Project
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

package com.example.sports.utils

/**
 * Enumeración que define los diferentes **tipos de contenido** que se pueden mostrar
 * en la aplicación Sports, dependiendo del tamaño y el estado del dispositivo.
 *
 * Esto es útil para implementar diseños adaptables que cambian la forma en que se presenta
 * la información según el espacio disponible en la pantalla (por ejemplo, en teléfonos vs. tabletas,
 * o en modo retrato vs. paisaje).
 */
enum class SportsContentType {
    /**
     * Indica que solo se debe mostrar la **lista de elementos**.
     * Esto es típico en pantallas más pequeñas donde no hay suficiente espacio
     * para mostrar la lista y los detalles simultáneamente.
     */
    ListOnly,

    /**
     * Indica que se deben mostrar tanto la **lista de elementos como los detalles**
     * del elemento seleccionado al mismo tiempo.
     * Esto es común en pantallas más grandes, como las de tabletas o dispositivos plegables
     * en modo extendido.
     */
    ListAndDetail
}
