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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.racetracker.R
import com.example.racetracker.ui.theme.RaceTrackerTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

// Composable principal de la aplicación RaceTracker.
@Composable
fun RaceTrackerApp() {
    /**
     * Nota: Para sobrevivir a los cambios de configuración como la rotación de pantalla, [rememberSaveable]
     * debería usarse con un objeto Saver personalizado. Pero para mantener el ejemplo simple y centrarse
     * en Coroutines, ese detalle de implementación se ha omitido.
     */
    // Crea y recuerda el objeto RaceParticipant para el jugador uno.
    val playerOne = remember {
        RaceParticipant(name = "Player 1", progressIncrement = 1)
    }
    // Crea y recuerda el objeto RaceParticipant para el jugador dos.
    val playerTwo = remember {
        RaceParticipant(name = "Player 2", progressIncrement = 2)
    }
    // Estado mutable para controlar si la carrera está en progreso.
    var raceInProgress by remember { mutableStateOf(false) }

    // Un LaunchedEffect se ejecuta cuando las claves (playerOne, playerTwo) cambian.
    // Aquí, se usa para iniciar las corrutinas de los jugadores cuando la carrera está en progreso.
    if (raceInProgress) {
        LaunchedEffect(playerOne, playerTwo) {
            // coroutineScope crea un nuevo ámbito de corrutinas.
            coroutineScope {
                // Lanza una corrutina para que el jugador uno "corra".
                launch { playerOne.run() }
                // Lanza una corrutina para que el jugador dos "corra".
                launch { playerTwo.run() }
            }
            // Una vez que ambas corrutinas de carrera terminan, la carrera ya no está en progreso.
            raceInProgress = false
        }
    }
    // Renderiza la pantalla principal de la aplicación RaceTracker.
    RaceTrackerScreen(
        playerOne = playerOne, // Pasa el objeto del jugador uno.
        playerTwo = playerTwo, // Pasa el objeto del jugador dos.
        isRunning = raceInProgress, // Indica si la carrera está activa.
        onRunStateChange = { raceInProgress = it }, // Callback para cambiar el estado de la carrera.
        modifier = Modifier // Modificadores aplicados a la pantalla.
            .statusBarsPadding() // Aplica padding para evitar la barra de estado.
            .fillMaxSize() // Ocupa todo el tamaño disponible.
            .verticalScroll(rememberScrollState()) // Hace que la pantalla sea verticalmente desplazable.
            .safeDrawingPadding() // Aplica padding para evitar áreas de dibujo seguras del sistema.
            .padding(horizontal = dimensionResource(R.dimen.padding_medium)), // Aplica padding horizontal.
    )
}

// Composable que representa la pantalla principal de seguimiento de la carrera.
@Composable
private fun RaceTrackerScreen(
    playerOne: RaceParticipant, // El objeto del jugador uno.
    playerTwo: RaceParticipant, // El objeto del jugador dos.
    isRunning: Boolean, // Indica si la carrera está activa.
    onRunStateChange: (Boolean) -> Unit, // Callback para cambiar el estado de ejecución.
    modifier: Modifier = Modifier // Modificador opcional para el diseño.
) {
    Column(
        modifier = modifier, // Aplica el modificador a la columna.
        verticalArrangement = Arrangement.Center, // Centra los elementos verticalmente.
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente.
    ) {
        Text(
            text = stringResource(R.string.run_a_race), // Texto del título de la pantalla.
            style = MaterialTheme.typography.headlineSmall, // Estilo de texto.
        )
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el tamaño disponible.
                .padding(dimensionResource(R.dimen.padding_medium)), // Aplica padding.
            verticalArrangement = Arrangement.Center, // Centra los elementos verticalmente.
            horizontalAlignment = Alignment.CenterHorizontally, // Centra los elementos horizontalmente.
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_walk), // Icono de una persona caminando.
                contentDescription = null, // Sin descripción de contenido para accesibilidad (es un icono decorativo).
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)), // Aplica padding al icono.
            )
            // Indicador de estado para el jugador uno.
            StatusIndicator(
                participantName = playerOne.name, // Nombre del jugador.
                currentProgress = playerOne.currentProgress, // Progreso actual.
                maxProgress = stringResource( // Progreso máximo formateado como porcentaje.
                    R.string.progress_percentage,
                    playerOne.maxProgress
                ),
                progressFactor = playerOne.progressFactor, // Factor de progreso para la barra.
                modifier = Modifier.fillMaxWidth() // Ocupa todo el ancho disponible.
            )
            Spacer(modifier = Modifier.size(dimensionResource(R.dimen.padding_large))) // Espacio grande entre indicadores.
            // Indicador de estado para el jugador dos.
            StatusIndicator(
                participantName = playerTwo.name, // Nombre del jugador.
                currentProgress = playerTwo.currentProgress, // Progreso actual.
                maxProgress = stringResource( // Progreso máximo formateado como porcentaje.
                    R.string.progress_percentage,
                    playerTwo.maxProgress
                ),
                progressFactor = playerTwo.progressFactor, // Factor de progreso para la barra.
                modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho disponible.
            )
            Spacer(modifier = Modifier.size(dimensionResource(R.dimen.padding_large))) // Espacio grande entre el último indicador y los controles.
            // Controles de la carrera (botones de inicio/pausa y reinicio).
            RaceControls(
                isRunning = isRunning, // Indica si la carrera está activa.
                onRunStateChange = onRunStateChange, // Callback para cambiar el estado de ejecución.
                onReset = { // Callback para reiniciar la carrera.
                    playerOne.reset() // Reinicia el progreso del jugador uno.
                    playerTwo.reset() // Reinicia el progreso del jugador dos.
                    onRunStateChange(false) // Establece el estado de la carrera como no en ejecución.
                },
                modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho disponible.
            )
        }
    }
}

// Composable para mostrar el indicador de estado de un participante.
@Composable
private fun StatusIndicator(
    participantName: String, // Nombre del participante.
    currentProgress: Int, // Progreso actual del participante.
    maxProgress: String, // Progreso máximo del participante (como cadena formateada).
    progressFactor: Float, // Factor de progreso para la barra de progreso (valor entre 0.0f y 1.0f).
    modifier: Modifier = Modifier // Modificador opcional para el diseño.
) {
    Row(
        modifier = modifier // Aplica el modificador a la fila.
    ) {
        Text(
            text = participantName, // Muestra el nombre del participante.
            modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_small)) // Relleno al final del texto.
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)) // Espacio entre los elementos de la columna.
        ) {
            LinearProgressIndicator(
                progress = progressFactor, // Progreso de la barra.
                modifier = Modifier
                    .fillMaxWidth() // Ocupa todo el ancho disponible.
                    .height(dimensionResource(R.dimen.progress_indicator_height)) // Altura de la barra de progreso.
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.progress_indicator_corner_radius))) // Recorta la barra con esquinas redondeadas.
            )
            Row(
                modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho disponible.
                horizontalArrangement = Arrangement.SpaceBetween // Distribuye el espacio uniformemente entre los elementos.
            ) {
                Text(
                    text = stringResource(R.string.progress_percentage, currentProgress), // Muestra el progreso actual como porcentaje.
                    textAlign = TextAlign.Start, // Alinea el texto al inicio.
                    modifier = Modifier.weight(1f) // Asigna un peso para que ocupe el espacio disponible.
                )
                Text(
                    text = maxProgress, // Muestra el progreso máximo.
                    textAlign = TextAlign.End, // Alinea el texto al final.
                    modifier = Modifier.weight(1f) // Asigna un peso para que ocupe el espacio disponible.
                )
            }
        }
    }
}

// Composable para los controles de la carrera (botones de inicio/pausa y reinicio).
@Composable
private fun RaceControls(
    onRunStateChange: (Boolean) -> Unit, // Callback para cambiar el estado de ejecución de la carrera.
    onReset: () -> Unit, // Callback para reiniciar la carrera.
    modifier: Modifier = Modifier, // Modificador opcional para el diseño.
    isRunning: Boolean = true, // Estado actual de la carrera (true si está corriendo, false si está pausada).
) {
    Column(
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium)), // Aplica padding superior.
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)) // Espacio entre los elementos de la columna.
    ) {
        Button(
            onClick = { onRunStateChange(!isRunning) }, // Al hacer clic, cambia el estado de ejecución (iniciar/pausar).
            modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho disponible.
        ) {
            Text(if (isRunning) stringResource(R.string.pause) else stringResource(R.string.start)) // Muestra "Pausar" o "Iniciar" según el estado.
        }
        OutlinedButton(
            onClick = onReset, // Al hacer clic, reinicia la carrera.
            modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho disponible.
        ) {
            Text(stringResource(R.string.reset)) // Muestra el texto "Reiniciar".
        }
    }
}

// Composable de previsualización para la aplicación RaceTracker.
@Preview(showBackground = true) // Muestra un fondo en la previsualización.
@Composable
fun RaceTrackerAppPreview() {
    RaceTrackerTheme { // Aplica el tema de la aplicación.
        RaceTrackerApp() // Previsualiza el composable principal de la aplicación.
    }
}
