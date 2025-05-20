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

package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.AppTheme

// La clase principal de la actividad de la aplicación.
class MainActivity : ComponentActivity() {

    // Se llama cuando la actividad se crea por primera vez.
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Habilita el dibujo de contenido de borde a borde.
        super.onCreate(savedInstanceState) // Llama a la implementación de la superclase.
        setContent {
            // Establece el contenido de la actividad usando Jetpack Compose.
            AppTheme {
                // Aplica el tema personalizado de la aplicación.
                LemonadeApp() // Renderiza la aplicación principal de Lemonade.
            }
        }
    }
}

// Anotación para indicar que se están utilizando APIs experimentales de Material 3.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {

    // Estado mutable para rastrear el paso actual de la aplicación. Se inicializa en 1.
    var currentStep by remember { mutableStateOf(1) }

    // Estado mutable para rastrear la cantidad de veces que se debe exprimir el limón. Se inicializa en 0.
    var squeezeCount by remember { mutableStateOf(0) }

    // Scaffold proporciona una estructura de diseño básica de Material Design.
    Scaffold(
        topBar = {
            // CenterAlignedTopAppBar para una barra superior con el título centrado.
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade", // Título de la aplicación.
                        fontWeight = FontWeight.Bold // Fuente en negrita para el título.
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer // Color de fondo de la barra superior.
                )
            )
        }
    ) { innerPadding -> // innerPadding se usa para aplicar el relleno de la barra superior al contenido.
        Surface(
            modifier = Modifier
                .fillMaxSize() // El Surface ocupa todo el espacio disponible.
                .padding(innerPadding) // Aplica el relleno para evitar que el contenido se superponga con la barra superior.
                .background(MaterialTheme.colorScheme.tertiaryContainer), // Color de fondo del Surface.
            color = MaterialTheme.colorScheme.background // Color de fondo general de la pantalla.
        ) {
            // Un 'when' para manejar los diferentes pasos de la aplicación.
            when (currentStep) {
                1 -> {
                    // Primer paso: Seleccionar el limón.
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_select, // Texto "Toca el limonero para empezar".
                        drawableResourceId = R.drawable.lemon_tree, // Imagen del limonero.
                        contentDescriptionResourceId = R.string.lemon_tree_content_description, // Descripción de contenido para accesibilidad.
                        onImageClick = {
                            currentStep = 2 // Pasa al siguiente paso.
                            squeezeCount = (2..4).random() // Genera un número aleatorio de veces que se debe exprimir.
                        }
                    )
                }
                2 -> {
                    // Segundo paso: Exprimir el limón.
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_squeeze, // Texto "Sigue tocando el limón para exprimirlo".
                        drawableResourceId = R.drawable.lemon_squeeze, // Imagen del limón siendo exprimido.
                        contentDescriptionResourceId = R.string.lemon_content_description, // Descripción de contenido.
                        onImageClick = {
                            squeezeCount-- // Decrementa el contador de exprimir.
                            if (squeezeCount == 0) {
                                currentStep = 3 // Si se exprime lo suficiente, pasa al siguiente paso.
                            }
                        }
                    )
                }

                3 -> {
                    // Tercer paso: Beber la limonada.
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_drink, // Texto "Toca la limonada para beberla".
                        drawableResourceId = R.drawable.lemon_drink, // Imagen del vaso de limonada.
                        contentDescriptionResourceId = R.string.lemonade_content_description, // Descripción de contenido.
                        onImageClick = {
                            currentStep = 4 // Pasa al siguiente paso.
                        }
                    )
                }
                4 -> {
                    // Cuarto paso: Vaso vacío, reiniciar.
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_empty_glass, // Texto "Toca el vaso vacío para volver a empezar".
                        drawableResourceId = R.drawable.lemon_restart, // Imagen del vaso vacío.
                        contentDescriptionResourceId = R.string.empty_glass_content_description, // Descripción de contenido.
                        onImageClick = {
                            currentStep = 1 // Regresa al primer paso.
                        }
                    )
                }
            }
        }
    }
}

// Composable que muestra un texto y una imagen interactiva.
@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int, // ID de recurso para el texto a mostrar.
    drawableResourceId: Int, // ID de recurso para la imagen a mostrar.
    contentDescriptionResourceId: Int, // ID de recurso para la descripción de contenido de la imagen.
    onImageClick: () -> Unit, // Función de lambda que se ejecuta al hacer clic en la imagen.
    modifier: Modifier = Modifier // Modificador opcional para el diseño.
) {
    Box(
        modifier = modifier // Aplica el modificador al Box.
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente los elementos hijos.
            verticalArrangement = Arrangement.Center, // Centra verticalmente los elementos hijos.
            modifier = Modifier.fillMaxSize() // La columna ocupa todo el espacio disponible.
        ) {
            Button(
                onClick = onImageClick, // Define la acción al hacer clic en el botón.
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)), // Forma del botón con esquinas redondeadas.
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer) // Colores del botón.
            ) {
                Image(
                    painter = painterResource(drawableResourceId), // Carga la imagen desde los recursos.
                    contentDescription = stringResource(contentDescriptionResourceId), // Descripción de contenido para accesibilidad.
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width)) // Ancho de la imagen.
                        .height(dimensionResource(R.dimen.button_image_height)) // Altura de la imagen.
                        .padding(dimensionResource(R.dimen.button_interior_padding)) // Relleno interno de la imagen.
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical))) // Espacio vertical entre la imagen y el texto.
            Text(
                text = stringResource(textLabelResourceId), // Muestra el texto desde los recursos.
                style = MaterialTheme.typography.bodyLarge // Estilo de texto.
            )
        }
    }
}

// Composable de previsualización para la aplicación Lemonade.
@Preview
@Composable
fun LemonPreview() {
    AppTheme() {
        LemonadeApp() // Previsualiza la aplicación Lemonade.
    }
}