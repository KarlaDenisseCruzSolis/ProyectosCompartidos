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

package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.model.Amphibian
import com.example.amphibians.ui.theme.AmphibiansTheme

// Composable principal de la pantalla de inicio
@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState, // Estado de la UI que puede ser Loading, Success o Error
    retryAction: () -> Unit,              // Acción para reintentar en caso de error
    modifier: Modifier = Modifier,        // Modificador para la UI
    contentPadding: PaddingValues = PaddingValues(0.dp) // Padding adicional si es necesario
) {
    // Control de flujo según el estado de la UI
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier.size(200.dp)) // Mostrar pantalla de carga
        is AmphibiansUiState.Success -> // Mostrar lista de anfibios si la carga fue exitosa
            AmphibiansListScreen(
                amphibians = amphibiansUiState.amphibians,
                modifier = modifier
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    ),
                contentPadding = contentPadding
            )
        else -> ErrorScreen(retryAction, modifier) // Mostrar pantalla de error si ocurre una falla
    }
}

/**
 * Pantalla que se muestra mientras se cargan los datos.
 */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.loading_img), // Imagen mostrada durante la carga
        contentDescription = stringResource(R.string.loading), // Texto accesible para la imagen
        modifier = modifier // Aplicación del modificador recibido
    )
}

/**
 * Pantalla que se muestra si ocurre un error al cargar datos, incluye botón para reintentar.
 */
@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center, // Alinear elementos verticalmente al centro
        horizontalAlignment = Alignment.CenterHorizontally // Alinear horizontalmente al centro
    ) {
        Text(stringResource(R.string.loading_failed)) // Mostrar mensaje de error
        Button(onClick = retryAction) {               // Botón para reintentar
            Text(stringResource(R.string.retry))
        }
    }
}

// Composable que muestra una tarjeta individual con datos de un anfibio
@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,                         // Modificador para la tarjeta
        shape = RoundedCornerShape(8.dp)             // Bordes redondeados
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.amphibian_title, amphibian.name, amphibian.type),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium)),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),  // Imagen ocupa todo el ancho
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.imgSrc)          // URL de la imagen del anfibio
                    .crossfade(true)                 // Transición suave
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                error = painterResource(id = R.drawable.ic_broken_image), // Imagen de error
                placeholder = painterResource(id = R.drawable.loading_img) // Imagen de carga
            )
            Text(
                text = amphibian.description,        // Descripción del anfibio
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

// Composable que muestra la lista de anfibios en una columna perezosa (LazyColumn)
@Composable
private fun AmphibiansListScreen(
    amphibians: List<Amphibian>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(24.dp) // Espacio vertical entre elementos
    ) {
        items(
            items = amphibians,        // Lista de elementos
            key = { amphibian ->       // Clave única por nombre
                amphibian.name
            }
        ) { amphibian ->
            AmphibianCard(amphibian = amphibian, modifier = Modifier.fillMaxSize())
        }
    }
}

// Vista previa de la pantalla de carga para el editor
@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    AmphibiansTheme {
        LoadingScreen(
            Modifier
                .fillMaxSize()
                .size(200.dp)
        )
    }
}

// Vista previa de la pantalla de error para el editor
@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    AmphibiansTheme {
        ErrorScreen({}, Modifier.fillMaxSize())
    }
}

// Vista previa de la lista de anfibios con datos ficticios
@Preview(showBackground = true)
@Composable
fun AmphibiansListScreenPreview() {
    AmphibiansTheme {
        val mockData = List(10) {
            Amphibian(
                "Lorem Ipsum - $it",
                "$it",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                        " eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad" +
                        " minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip" +
                        " ex ea commodo consequat.",
                imgSrc = ""
            )
        }
        AmphibiansListScreen(mockData, Modifier.fillMaxSize())
    }
}