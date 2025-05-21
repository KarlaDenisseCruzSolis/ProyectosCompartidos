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
package com.example.marsphotos.ui.screens // Declara el paquete en el que se encuentra este archivo

// Importa componentes y funciones necesarios para la UI y el sistema de imágenes
import androidx.compose.foundation.Image // Permite mostrar imágenes estáticas
import androidx.compose.foundation.layout.* // Importa varios layouts (Column, Row, etc.)
import androidx.compose.foundation.lazy.grid.* // Importa el grid perezoso (LazyVerticalGrid)
import androidx.compose.material3.* // Importa componentes de Material 3 (Button, Text, Card, etc.)
import androidx.compose.runtime.Composable // Marca funciones como composables para Jetpack Compose
import androidx.compose.ui.Alignment // Permite alinear elementos dentro de los layouts
import androidx.compose.ui.Modifier // Se usa para modificar apariencia y comportamiento de composables
import androidx.compose.ui.layout.ContentScale // Controla cómo se escala la imagen dentro del contenedor
import androidx.compose.ui.platform.LocalContext // Accede al contexto actual (requerido para cargar imágenes con Coil)
import androidx.compose.ui.res.painterResource // Carga imágenes desde los recursos
import androidx.compose.ui.res.stringResource // Carga cadenas desde archivos de recursos (strings.xml)
import androidx.compose.ui.tooling.preview.Preview // Permite previsualizar composables en tiempo de diseño
import androidx.compose.ui.unit.dp // Define dimensiones como padding, tamaño, etc., en dp (density pixels)
import coil.compose.AsyncImage // Composable de Coil para cargar imágenes desde internet
import coil.request.ImageRequest // Permite construir una petición de imagen con opciones como crossfade
import com.example.marsphotos.R // Accede a los recursos del proyecto (imágenes, strings, etc.)
import com.example.marsphotos.model.MarsPhoto // Importa el modelo de datos MarsPhoto
import com.example.marsphotos.ui.theme.MarsPhotosTheme // Importa el tema personalizado de la app

// Composable principal que representa la pantalla de inicio
@Composable
fun HomeScreen(
    marsUiState: MarsUiState, // Estado actual de la UI (cargando, éxito, error)
    retryAction: () -> Unit, // Función que se llama cuando se presiona el botón de reintento
    modifier: Modifier = Modifier, // Modificador opcional para personalizar el diseño
    contentPadding: PaddingValues = PaddingValues(0.dp), // Espaciado interno opcional
) {
    when (marsUiState) { // Según el estado de la UI se muestra una pantalla distinta
        is MarsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize()) // Muestra pantalla de carga
        is MarsUiState.Success -> PhotosGridScreen( // Muestra la cuadrícula de fotos si hubo éxito
            marsUiState.photos, contentPadding = contentPadding, modifier = modifier.fillMaxWidth()
        )
        is MarsUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize()) // Muestra pantalla de error
    }
}

// Composable que muestra una imagen de carga
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp), // Tamaño de la imagen
        painter = painterResource(R.drawable.loading_img), // Imagen de recurso usada mientras carga
        contentDescription = stringResource(R.string.loading) // Descripción accesible para lectores de pantalla
    )
}

// Composable que muestra un mensaje de error con un botón para reintentar
@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier, // Modificador recibido
        verticalArrangement = Arrangement.Center, // Centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = "" // Imagen de error
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp)) // Mensaje de error
        Button(onClick = retryAction) { // Botón para reintentar
            Text(stringResource(R.string.retry)) // Texto del botón
        }
    }
}

// Composable que muestra la cuadrícula de fotos de Marte
@Composable
fun PhotosGridScreen(
    photos: List<MarsPhoto>, // Lista de fotos a mostrar
    modifier: Modifier = Modifier, // Modificador para diseño
    contentPadding: PaddingValues = PaddingValues(0.dp), // Padding para el contenido
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp), // Distribuye columnas adaptándose al ancho disponible
        modifier = modifier.padding(horizontal = 4.dp), // Agrega un pequeño padding horizontal
        contentPadding = contentPadding, // Usa el padding recibido
    ) {
        items(items = photos, key = { photo -> photo.id }) { photo -> // Itera sobre cada foto y asigna una key por id
            MarsPhotoCard( // Muestra cada foto en una tarjeta
                photo,
                modifier = Modifier
                    .padding(4.dp) // Espaciado entre tarjetas
                    .fillMaxWidth() // Ocupa todo el ancho disponible
                    .aspectRatio(1.5f) // Proporción de aspecto de la tarjeta (ancho:alto)
            )
        }
    }
}

// Composable que representa una tarjeta con una imagen de Marte
@Composable
fun MarsPhotoCard(photo: MarsPhoto, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier, // Modificador recibido
        shape = MaterialTheme.shapes.medium, // Forma con esquinas redondeadas según el tema
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Elevación de la tarjeta (sombra)
    ) {
        AsyncImage( // Imagen cargada desde internet usando Coil
            model = ImageRequest.Builder(context = LocalContext.current).data(photo.imgSrc) // Construye la petición con la URL de la foto
                .crossfade(true).build(), // Aplica transición con fundido
            error = painterResource(R.drawable.ic_broken_image), // Imagen mostrada si falla la carga
            placeholder = painterResource(R.drawable.loading_img), // Imagen temporal mientras carga
            contentDescription = stringResource(R.string.mars_photo), // Descripción accesible
            contentScale = ContentScale.Crop, // Recorta la imagen para llenar el contenedor
            modifier = Modifier.fillMaxWidth() // La imagen ocupa todo el ancho
        )
    }
}

// Vista previa del composable LoadingScreen
@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    MarsPhotosTheme { // Aplica el tema de la app
        LoadingScreen() // Muestra la pantalla de carga
    }
}

// Vista previa del composable ErrorScreen
@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    MarsPhotosTheme {
        ErrorScreen({}) // Muestra la pantalla de error con una función vacía como retryAction
    }
}

// Vista previa del composable PhotosGridScreen con datos de prueba
@Preview(showBackground = true)
@Composable
fun PhotosGridScreenPreview() {
    MarsPhotosTheme {
        val mockData = List(10) { MarsPhoto("$it", "") } // Crea una lista simulada de 10 fotos con ids del 0 al 9
        PhotosGridScreen(mockData) // Muestra la cuadrícula de fotos con los datos simulados
    }
}