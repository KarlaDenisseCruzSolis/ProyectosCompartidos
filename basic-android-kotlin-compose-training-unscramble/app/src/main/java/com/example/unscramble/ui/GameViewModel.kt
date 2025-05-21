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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel que contiene los datos de la aplicación y los métodos para procesar los datos.
 * Esta clase hereda de [ViewModel], lo que le permite sobrevivir a cambios de configuración como la rotación de pantalla.
 */
class GameViewModel : ViewModel() {

    // Estado de la UI del juego, representado por un MutableStateFlow.
    // Los cambios en este StateFlow activarán recomposiciones en la UI.
    private val _uiState = MutableStateFlow(GameUiState())
    // Exposición inmutable del estado de la UI para que los Componibles solo puedan leerlo.
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    // La suposición del usuario, almacenada como un estado mutable para que la UI pueda interactuar con ella.
    // 'private set' asegura que solo el ViewModel pueda modificar directamente este valor.
    var userGuess by mutableStateOf("")
        private set

    // Conjunto de palabras que ya han sido utilizadas en el juego para evitar repeticiones.
    private var usedWords: MutableSet<String> = mutableSetOf()
    // La palabra correcta actual que el usuario debe adivinar.
    private lateinit var currentWord: String

    /**
     * Bloque de inicialización que se ejecuta cuando se crea una instancia de [GameViewModel].
     * Llama a [resetGame] para inicializar el estado del juego.
     */
    init {
        resetGame()
    }

    /*
     * Re-inicializa los datos del juego para reiniciar el juego.
     * Esto incluye limpiar las palabras usadas y restablecer el estado de la UI.
     */
    fun resetGame() {
        usedWords.clear() // Limpia el conjunto de palabras usadas.
        // Restablece el estado de la UI a un estado inicial, generando una nueva palabra codificada.
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    /*
     * Actualiza la suposición del usuario.
     * @param guessedWord La palabra ingresada por el usuario.
     */
    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord // Asigna la palabra ingresada por el usuario a la variable userGuess.
    }

    /*
     * Comprueba si la suposición del usuario es correcta.
     * Aumenta la puntuación en consecuencia.
     */
    fun checkUserGuess() {
        // Compara la suposición del usuario con la palabra correcta, ignorando mayúsculas y minúsculas.
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            // La suposición del usuario es correcta, aumenta la puntuación.
            // y llama a updateGameState() para preparar el juego para la siguiente ronda.
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE) // Incrementa la puntuación.
            updateGameState(updatedScore) // Actualiza el estado del juego con la nueva puntuación.
        } else {
            // La suposición del usuario es incorrecta, muestra un error.
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true) // Establece isGuessedWordWrong en true.
            }
        }
        // Reinicia la suposición del usuario después de la comprobación.
        updateUserGuess("")
    }

    /*
     * Salta a la siguiente palabra.
     */
    fun skipWord() {
        updateGameState(_uiState.value.score) // Actualiza el estado del juego manteniendo la misma puntuación.
        // Reinicia la suposición del usuario.
        updateUserGuess("")
    }

    /*
     * Elige una nueva currentWord y currentScrambledWord y actualiza UiState de acuerdo al
     * estado actual del juego.
     * @param updatedScore La puntuación actualizada después de la ronda.
     */
    private fun updateGameState(updatedScore: Int) {
        // Comprueba si se han utilizado todas las palabras disponibles.
        if (usedWords.size == MAX_NO_OF_WORDS){
            // Última ronda del juego, actualiza isGameOver a true, no elige una nueva palabra.
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false, // Reinicia el estado de suposición incorrecta.
                    score = updatedScore, // Actualiza la puntuación.
                    isGameOver = true // Establece isGameOver en true para finalizar el juego.
                )
            }
        } else{
            // Ronda normal del juego, elige una nueva palabra.
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false, // Reinicia el estado de suposición incorrecta.
                    currentScrambledWord = pickRandomWordAndShuffle(), // Obtiene una nueva palabra codificada.
                    currentWordCount = currentState.currentWordCount.inc(), // Incrementa el contador de palabras.
                    score = updatedScore // Actualiza la puntuación.
                )
            }
        }
    }

    /**
     * Desordena la palabra actual.
     * @param word La palabra a desordenar.
     * @return La palabra desordenada.
     */
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray() // Convierte la palabra en un array de caracteres.
        // Desordena la palabra.
        tempWord.shuffle()
        // Asegura que la palabra desordenada no sea la misma que la original.
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord) // Devuelve la palabra desordenada como una cadena.
    }

    /**
     * Elige una palabra aleatoria de la lista de palabras y la desordena.
     * Asegura que la palabra no haya sido usada antes.
     * @return La palabra codificada.
     */
    private fun pickRandomWordAndShuffle(): String {
        // Continúa eligiendo una nueva palabra aleatoria hasta que se obtenga una que no se haya usado antes.
        currentWord = allWords.random() // Elige una palabra aleatoria de la lista de todas las palabras.
        return if (usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle() // Si la palabra ya se usó, intenta de nuevo.
        } else {
            usedWords.add(currentWord) // Añade la palabra al conjunto de palabras usadas.
            shuffleCurrentWord(currentWord) // Desordena la palabra y la devuelve.
        }
    }
}
