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

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unscramble.R
import com.example.unscramble.ui.theme.UnscrambleTheme

/**
 * Composable que representa la pantalla principal del juego Unscramble.
 * Gestiona el estado del juego y la interacción del usuario.
 * @param gameViewModel El ViewModel para gestionar la lógica y el estado del juego.
 */
@Composable
fun GameScreen(gameViewModel: GameViewModel = viewModel()) {
    // Recopila el estado de la UI del juego como un State.
    // Cuando el estado de la UI cambia en el ViewModel, este Composable se recompone.
    val gameUiState by gameViewModel.uiState.collectAsState()
    // Obtiene una dimensión de recurso para el padding mediano.
    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    // Columna que contiene todos los elementos de la UI del juego.
    Column(
        modifier = Modifier
            .statusBarsPadding() // Aplica padding para evitar la barra de estado.
            .verticalScroll(rememberScrollState()) // Permite el desplazamiento vertical.
            .safeDrawingPadding() // Aplica padding para áreas seguras de dibujo.
            .padding(mediumPadding), // Aplica padding general.
        verticalArrangement = Arrangement.Center, // Centra el contenido verticalmente.
        horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente.
    ) {

        // Texto que muestra el nombre de la aplicación.
        Text(
            text = stringResource(R.string.app_name), // Obtiene el texto del recurso de cadena.
            style = typography.titleLarge, // Aplica un estilo de tipografía grande para el título.
        )
        // Composable que muestra el diseño del juego (palabra codificada, campo de entrada).
        GameLayout(
            onUserGuessChanged = { gameViewModel.updateUserGuess(it) }, // Callback cuando la suposición del usuario cambia.
            wordCount = gameUiState.currentWordCount, // Número de palabras actuales.
            userGuess = gameViewModel.userGuess, // La suposición actual del usuario.
            onKeyboardDone = { gameViewModel.checkUserGuess() }, // Callback cuando se presiona la acción "Done" del teclado.
            currentScrambledWord = gameUiState.currentScrambledWord, // La palabra codificada actual.
            isGuessWrong = gameUiState.isGuessedWordWrong, // Indica si la suposición es incorrecta.
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho disponible.
                .wrapContentHeight() // Ajusta la altura al contenido.
                .padding(mediumPadding) // Aplica padding.
        )
        // Columna que contiene los botones de enviar y saltar.
        Column(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho disponible.
                .padding(mediumPadding), // Aplica padding.
            verticalArrangement = Arrangement.spacedBy(mediumPadding), // Espaciado entre elementos verticales.
            horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente.
        ) {

            // Botón para enviar la suposición del usuario.
            Button(
                modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho disponible.
                onClick = { gameViewModel.checkUserGuess() } // Llama a la función para verificar la suposición.
            ) {
                Text(
                    text = stringResource(R.string.submit), // Texto del botón.
                    fontSize = 16.sp // Tamaño de la fuente.
                )
            }

            // Botón para saltar a la siguiente palabra.
            OutlinedButton(
                onClick = { gameViewModel.skipWord() }, // Llama a la función para saltar la palabra.
                modifier = Modifier.fillMaxWidth() // Ocupa todo el ancho disponible.
            ) {
                Text(
                    text = stringResource(R.string.skip), // Texto del botón.
                    fontSize = 16.sp // Tamaño de la fuente.
                )
            }
        }

        // Muestra el estado actual del juego (puntuación).
        GameStatus(score = gameUiState.score, modifier = Modifier.padding(20.dp))

        // Muestra un diálogo de puntuación final si el juego ha terminado.
        if (gameUiState.isGameOver) {
            FinalScoreDialog(
                score = gameUiState.score, // Puntuación final.
                onPlayAgain = { gameViewModel.resetGame() } // Callback para reiniciar el juego.
            )
        }
    }
}

/**
 * Composable que muestra el estado actual del juego, específicamente la puntuación.
 * @param score La puntuación actual.
 * @param modifier Un Modifier para este componible.
 */
@Composable
fun GameStatus(score: Int, modifier: Modifier = Modifier) {
    // Tarjeta que contiene el texto de la puntuación.
    Card(
        modifier = modifier
    ) {
        // Texto que muestra la puntuación actual.
        Text(
            text = stringResource(R.string.score, score), // Obtiene el texto del recurso y formatea la puntuación.
            style = typography.headlineMedium, // Aplica un estilo de tipografía.
            modifier = Modifier.padding(8.dp) // Aplica padding al texto.
        )

    }
}

/**
 * Composable que define el diseño principal del juego, incluyendo la palabra codificada y el campo de entrada.
 * @param currentScrambledWord La palabra codificada actual.
 * @param wordCount El número de palabras actuales.
 * @param isGuessWrong Indica si la suposición del usuario es incorrecta.
 * @param userGuess La suposición actual del usuario.
 * @param onUserGuessChanged Callback cuando el valor del campo de suposición cambia.
 * @param onKeyboardDone Callback cuando la acción "Done" del teclado es activada.
 * @param modifier Un Modifier para este componible.
 */
@Composable
fun GameLayout(
    currentScrambledWord: String,
    wordCount: Int,
    isGuessWrong: Boolean,
    userGuess: String,
    onUserGuessChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Obtiene una dimensión de recurso para el padding mediano
    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    // Tarjeta que contiene la palabra codificada, instrucciones y campo de entrada.
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)// Aplica una elevación a la tarjeta.
    ) {
        Column(// Columna que organiza los elementos de la tarjeta verticalmente.
            verticalArrangement = Arrangement.spacedBy(mediumPadding),// Espaciado entre elementos verticales.
            horizontalAlignment = Alignment.CenterHorizontally,// Centra los elementos horizontalmente.
            modifier = Modifier.padding(mediumPadding)// Aplica padding a la columna.
        ) {
            Text(// Texto que muestra el contador de palabras.
                modifier = Modifier
                    .clip(shapes.medium)// Recorta con formas medianas.
                    .background(colorScheme.surfaceTint)// Color de fondo del tinte de la superficie.
                    .padding(horizontal = 10.dp, vertical = 4.dp)// Padding horizontal y vertical.
                    .align(alignment = Alignment.End),// Alinea el texto al final (derecha).
                text = stringResource(R.string.word_count, wordCount),// Texto del contador de palabras.
                style = typography.titleMedium,// Estilo de tipografía.
                color = colorScheme.onPrimary// Color del texto.
            )
            Text(// Texto que muestra la palabra codificada.
                text = currentScrambledWord,
                style = typography.displayMedium// Estilo de tipografía.
            )
            Text(// Texto de instrucciones para el juego.
                text = stringResource(R.string.instructions),// Texto de las instrucciones.
                textAlign = TextAlign.Center, // Alinea el texto al centro.
                style = typography.titleMedium// Estilo de tipografía.
            )
            OutlinedTextField(// Campo de texto con contorno para la suposición del usuario.
                value = userGuess,// Valor actual de la suposición.
                singleLine = true,// Permite una sola línea de texto.
                shape = shapes.large,// Forma del campo de texto.
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorScheme.surface,// Color del contenedor cuando está enfocado.
                    unfocusedContainerColor = colorScheme.surface,// Color del contenedor cuando no está enfocado.
                    disabledContainerColor = colorScheme.surface,// Color del contenedor cuando está deshabilitado.
                ),
                onValueChange = onUserGuessChanged,// Callback para cambios en el valor.
                label = {
                    if (isGuessWrong) {// Muestra diferentes etiquetas dependiendo de si la suposición es incorrecta.
                        Text(stringResource(R.string.wrong_guess))// Etiqueta para suposición incorrecta.
                    } else {
                        Text(stringResource(R.string.enter_your_word))// Etiqueta para ingresar la palabra.
                    }
                },
                isError = isGuessWrong, // Muestra el campo de texto en estado de error si la suposición es incorrecta.
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done// Acción "Done" para el teclado.
                ),
                keyboardActions = KeyboardActions(
                    onDone = { onKeyboardDone() }// Callback cuando se presiona "Done" en el teclado.
                )
            )
        }
    }
}

/*
 * Crea y muestra un AlertDialog con la puntuación final.
 * @param score La puntuación final del juego.
 * @param onPlayAgain El callback que se invoca cuando el usuario quiere jugar de nuevo.
 * @param modifier Un Modifier para este componible.
 */
@Composable
private fun FinalScoreDialog(
    score: Int,
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Obtiene el contexto local y lo convierte a una actividad para poder finalizarla.
    val activity = (LocalContext.current as Activity)

    // Diálogo de alerta que muestra la puntuación final.
    AlertDialog(
        onDismissRequest = {
            // Descarta el diálogo cuando el usuario hace clic fuera del diálogo o en el botón de retroceso.
            // Si quieres deshabilitar esa funcionalidad, simplemente usa un onCloseRequest vacío.
        },
        title = { Text(text = stringResource(R.string.congratulations)) },// Título del diálogo.
        text = { Text(text = stringResource(R.string.you_scored, score)) },// Texto que muestra la puntuación.
        modifier = modifier,
        dismissButton = {
            TextButton( // Botón para salir de la aplicación.
                onClick = {
                    activity.finish()// Finaliza la actividad actual.
                }
            ) {
                Text(text = stringResource(R.string.exit))// Texto del botón de salir.
            }
        },
        confirmButton = {
            TextButton(onClick = onPlayAgain) {// Botón para jugar de nuevo.
                Text(text = stringResource(R.string.play_again))// Texto del botón de jugar de nuevo.
            }
        }
    )
}

/**
 * Vista previa de la pantalla del juego.
 */
@Preview(showBackground = true) // Muestra un fondo en la vista previa.
@Composable
fun GameScreenPreview() {
    // Aplica el tema Unscramble a la vista previa.
    UnscrambleTheme {
        GameScreen() // Muestra el GameScreen para la vista previa.
    }
}