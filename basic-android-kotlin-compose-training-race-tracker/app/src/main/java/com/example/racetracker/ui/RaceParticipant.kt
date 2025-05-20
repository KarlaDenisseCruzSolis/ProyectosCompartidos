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
package com.example.racetracker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

/**
 * Esta clase representa un contenedor de estado para un participante de la carrera.
 */
class RaceParticipant(
    val name: String, // El nombre del participante.
    val maxProgress: Int = 100, // El progreso máximo que el participante puede alcanzar.
    val progressDelayMillis: Long = 500L, // El retraso en milisegundos entre cada incremento de progreso.
    private val progressIncrement: Int = 1, // La cantidad en la que el progreso se incrementa en cada paso.
    private val initialProgress: Int = 0 // El progreso inicial del participante.
) {
    // Bloque init para realizar validaciones al inicializar la clase.
    init {
        // Requiere que maxProgress sea mayor que 0. Lanza un IllegalArgumentException si no lo es.
        require(maxProgress > 0) { "maxProgress=$maxProgress; must be > 0" }
        // Requiere que progressIncrement sea mayor que 0. Lanza un IllegalArgumentException si no lo es.
        require(progressIncrement > 0) { "progressIncrement=$progressIncrement; must be > 0" }
    }

    /**
     * Indica el progreso actual del participante de la carrera.
     * La propiedad 'private set' significa que solo puede ser modificada dentro de esta clase.
     */
    var currentProgress by mutableStateOf(initialProgress)
        private set

    /**
     * Actualiza el valor de [currentProgress] en [progressIncrement] hasta que alcanza [maxProgress].
     * Hay un retraso de [progressDelayMillis] entre cada actualización.
     * Es una función suspendida, lo que significa que puede pausarse y reanudarse en una corrutina.
     */
    suspend fun run() {
        // Bucle que continúa mientras el progreso actual sea menor que el progreso máximo.
        while (currentProgress < maxProgress) {
            delay(progressDelayMillis) // Pausa la corrutina por el tiempo especificado.
            currentProgress += progressIncrement // Incrementa el progreso.
        }
    }

    /**
     * Independientemente del valor de [initialProgress], la función de reinicio establecerá
     * [currentProgress] en 0.
     */
    fun reset() {
        currentProgress = 0 // Establece el progreso actual a 0.
    }
}

/**
 * El indicador de progreso lineal espera un valor de progreso en el rango de 0-1. Esta propiedad
 * calcula el factor de progreso para satisfacer los requisitos del indicador.
 * Es una propiedad de extensión de la clase RaceParticipant.
 */
val RaceParticipant.progressFactor: Float
    get() = currentProgress / maxProgress.toFloat() // Calcula el progreso como un valor flotante entre 0 y 1.