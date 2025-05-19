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
package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

// Clase principal de la actividad
class MainActivity : ComponentActivity() {

    // Metodo que se ejecuta al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // Contenedor Surface que usa el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa todo el tamaño disponible
                    color = MaterialTheme.colorScheme.background // Usa el color de fondo del tema
                ) {
                    AffirmationsApp() // Llama a la función principal de la app
                }
            }
        }
    }
}

// Función composable principal de la aplicación
@Composable
fun AffirmationsApp() {
    AffirmationList(
        affirmationList = Datasource().loadAffirmations(), // Carga las afirmaciones desde la fuente de datos
    )
}

// Muestra una lista de afirmaciones en forma de tarjetas usando LazyColumn
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        // Crea un ítem para cada afirmación en la lista
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp) // Aplica margen a cada tarjeta
            )
        }
    }
}

// Muestra una sola tarjeta de afirmación con imagen y texto
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            // Muestra la imagen de la afirmación
            Image(
                painter = painterResource(affirmation.imageResourceId), // Carga la imagen desde recursos
                contentDescription = stringResource(affirmation.stringResourceId), // Proporciona descripción accesible
                modifier = Modifier
                    .fillMaxWidth() // Imagen ocupa todo el ancho
                    .height(194.dp), // Altura fija de la imagen
                contentScale = ContentScale.Crop // Recorta y llena el contenedor
            )
            // Muestra el texto de la afirmación
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId), // Obtiene el texto desde recursos
                modifier = Modifier.padding(16.dp), // Aplica padding alrededor del texto
                style = MaterialTheme.typography.headlineSmall // Usa estilo de título pequeño del tema
            )
        }
    }
}

// Vista previa de una tarjeta de afirmación en el editor
@Preview
@Composable
private fun AffirmationCardPreview() {
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1)) // Muestra ejemplo con afirmación 1
}