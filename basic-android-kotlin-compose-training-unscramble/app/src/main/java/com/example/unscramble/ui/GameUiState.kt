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
package com.example.unscramble.ui

/**
 * Clase de datos que representa el estado de la interfaz de usuario del juego.
 *
 * Esta clase contiene todos los datos necesarios para renderizar la UI del juego en un momento dado.
 *
 * @param currentScrambledWord La palabra actual que está revuelta y que el usuario debe adivinar.
 * Se inicializa como una cadena vacía.
 * @param currentWordCount El número de palabras que el usuario ha intentado adivinar hasta el momento.
 * Se inicializa en 1.
 * @param score La puntuación actual del jugador.
 * Se inicializa en 0.
 * @param isGuessedWordWrong Un booleano que indica si la última palabra adivinada por el usuario fue incorrecta.
 * Esto se usa para mostrar retroalimentación visual al usuario.
 * Se inicializa en `false`.
 * @param isGameOver Un booleano que indica si el juego ha terminado.
 * Se inicializa en `false`.
 */
data class GameUiState(
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 1,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)
