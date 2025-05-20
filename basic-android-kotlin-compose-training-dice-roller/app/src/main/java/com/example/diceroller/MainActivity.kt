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
package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

// La clase principal de la actividad. Hereda de ComponentActivity.
class MainActivity : ComponentActivity() {
    // Se llama cuando la actividad se crea por primera vez.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la UI para esta actividad usando Compose.
        setContent {
            // Aplica el tema DiceRollerTheme a la aplicación.
            DiceRollerTheme {
                // Una superficie que ocupa todo el tamaño disponible y usa el color de fondo del tema.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llama al composable principal de la aplicación.
                    DiceRollerApp()
                }
            }
        }
    }
}

// Composable de previsualización para la aplicación DiceRoller.
@Preview
@Composable
fun DiceRollerApp() {
    // Llama al composable que muestra el dado, el botón y la imagen.
    // El modificador centra el contenido en la pantalla.
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize() // Ocupa todo el tamaño disponible.
        .wrapContentSize(Alignment.Center) // Centra el contenido dentro del tamaño disponible.
    )
}

// Composable que combina la lógica del dado, el botón y la imagen.
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // Declara una variable de estado mutable para el resultado del dado.
    // remember asegura que el estado se mantenga entre recomposiciones.
    var result by remember { mutableStateOf( 1) }
    // Determina qué recurso de imagen de dado usar basándose en el valor de 'result'.
    val imageResource = when(result) {
        1 -> R.drawable.dice_1 // Si el resultado es 1, usa la imagen dice_1.
        2 -> R.drawable.dice_2 // Si el resultado es 2, usa la imagen dice_2.
        3 -> R.drawable.dice_3 // Si el resultado es 3, usa la imagen dice_3.
        4 -> R.drawable.dice_4 // Si el resultado es 4, usa la imagen dice_4.
        5 -> R.drawable.dice_5 // Si el resultado es 5, usa la imagen dice_5.
        else -> R.drawable.dice_6 // Para cualquier otro resultado (6), usa la imagen dice_6.
    }
    // Organiza los elementos verticalmente y los centra horizontalmente.
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        // Muestra la imagen del dado correspondiente al resultado actual.
        // painterResource carga la imagen desde los recursos.
        // contentDescription proporciona una descripción para accesibilidad.
        Image(painter = painterResource(imageResource), contentDescription = result.toString())

        // Crea un espacio vertical entre la imagen y el botón.
        Spacer(modifier = Modifier.height(16.dp)) // Espacio de 16 unidades dp.

        // Crea un botón.
        Button(
            onClick = { result = (1..6).random() }, // Cuando se hace clic, genera un número aleatorio entre 1 y 6.
        ) {
            // Muestra el texto del botón.
            // stringResource carga la cadena "roll" desde los recursos.
            // fontSize establece el tamaño de la fuente.
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}
