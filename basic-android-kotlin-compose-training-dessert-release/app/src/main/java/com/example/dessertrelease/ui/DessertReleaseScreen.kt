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
package com.example.dessertrelease.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dessertrelease.R
import com.example.dessertrelease.data.local.LocalDessertReleaseData
import com.example.dessertrelease.ui.theme.DessertReleaseTheme

@Composable
fun DessertReleaseApp( // Composable principal que lanza la pantalla de la aplicación.
    dessertReleaseViewModel: DessertReleaseViewModel = viewModel(
        factory = DessertReleaseViewModel.Factory // Crea el ViewModel si no existe.
    )
) {
    DessertReleaseScreen( // Llama a la función que muestra la pantalla de postres.
        uiState = dessertReleaseViewModel.uiState.collectAsState().value, // Observa el estado de la UI.
        selectLayout = dessertReleaseViewModel::selectLayout // Proporciona la función para cambiar el layout.
    )
}

@OptIn(ExperimentalMaterial3Api::class) // Permite el uso de características experimentales.
@Composable
private fun DessertReleaseScreen( // Composable que maneja la UI de la pantalla de postres.
    uiState: DessertReleaseUiState, // Estado de la UI.
    selectLayout: (Boolean) -> Unit // Función que cambia el tipo de layout.
) {
    val isLinearLayout = uiState.isLinearLayout // Determina si se usa un layout lineal o de cuadrícula.
    Scaffold( // Componente que organiza la estructura básica de la pantalla.
        topBar = { // Define la barra superior.
            TopAppBar(
                title = { Text(stringResource(R.string.top_bar_name)) }, // Muestra el título de la barra.
                actions = { // Acción de la barra para cambiar el layout.
                    IconButton(
                        onClick = {
                            selectLayout(!isLinearLayout) // Cambia el layout al hacer clic.
                        }
                    ) {
                        Icon(
                            painter = painterResource(uiState.toggleIcon), // Muestra el ícono para cambiar el layout.
                            contentDescription = stringResource(uiState.toggleContentDescription),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.inversePrimary
                )
            )
        }
    ) { innerPadding -> // Define el padding interno del contenido.
        val modifier = Modifier
            .padding(
                top = dimensionResource(R.dimen.padding_medium), // Aplica el padding.
                start = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium),
            )
        if (isLinearLayout) { // Si el layout es lineal, usa un LazyColumn.
            DessertReleaseLinearLayout(
                modifier = modifier.fillMaxWidth(), // Aplica el modificador al layout.
                contentPadding = innerPadding
            )
        } else { // Si no es lineal, usa un LazyVerticalGrid.
            DessertReleaseGridLayout(
                modifier = modifier,
                contentPadding = innerPadding,
            )
        }
    }
}

@Composable
fun DessertReleaseLinearLayout( // Composable que muestra los postres en un layout lineal.
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn( // Usamos LazyColumn para una lista perezosa.
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)), // Espaciado entre los items.
    ) {
        items(
            items = LocalDessertReleaseData.dessertReleases, // Datos de los postres.
            key = { dessert -> dessert }
        ) { dessert -> // Muestra cada postre como un Card.
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary // Establece el color del fondo.
                ),
                shape = MaterialTheme.shapes.medium // Define la forma de la tarjeta.
            ) {
                Text(
                    text = dessert, // Muestra el nombre del postre.
                    modifier = Modifier
                        .fillMaxWidth() // La tarjeta ocupa todo el ancho.
                        .padding(dimensionResource(R.dimen.padding_medium)),
                    textAlign = TextAlign.Center // Centra el texto dentro de la tarjeta.
                )
            }
        }
    }
}

@Composable
fun DessertReleaseGridLayout( // Composable que muestra los postres en un layout de cuadrícula.
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid( // Usamos LazyVerticalGrid para una cuadrícula.
        modifier = modifier,
        columns = GridCells.Fixed(3), // Define 3 columnas fijas.
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)), // Espaciado entre filas.
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)) // Espaciado entre columnas.
    ) {
        items(
            items = LocalDessertReleaseData.dessertReleases,
            key = { dessert -> dessert }
        ) { dessert -> // Muestra cada postre en un Card dentro de la cuadrícula.
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.height(110.dp), // Establece la altura de la tarjeta.
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = dessert, // Muestra el nombre del postre.
                    maxLines = 2, // Limita el texto a dos líneas.
                    overflow = TextOverflow.Ellipsis, // Muestra el texto truncado si es largo.
                    modifier = Modifier
                        .fillMaxHeight() // La tarjeta ocupa toda la altura disponible.
                        .wrapContentHeight(Alignment.CenterVertically) // Centra el texto verticalmente.
                        .padding(dimensionResource(R.dimen.padding_small))
                        .align(Alignment.CenterHorizontally), // Centra la tarjeta horizontalmente.
                    textAlign = TextAlign.Center // Centra el texto dentro de la tarjeta.
                )
            }
        }
    }
}

@Preview(showBackground = true) // Previsualización del layout lineal.
@Composable
fun DessertReleaseLinearLayoutPreview() {
    DessertReleaseTheme {
        DessertReleaseLinearLayout() // Muestra la vista lineal.
    }
}

@Preview(showBackground = true) // Previsualización del layout en cuadrícula.
@Composable
fun DessertReleaseGridLayoutPreview() {
    DessertReleaseTheme {
        DessertReleaseGridLayout() // Muestra la vista en cuadrícula.
    }
}

@Preview // Previsualización de la pantalla completa.
@Composable
fun DessertReleaseAppPreview() {
    DessertReleaseTheme {
        DessertReleaseScreen(
            uiState = DessertReleaseUiState(),
            selectLayout = {}
        ) // Muestra la pantalla completa con estado inicial.
    }
}