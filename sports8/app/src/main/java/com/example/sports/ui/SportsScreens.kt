/*
 * Copyright (c) 2023 The Android Open Source Project
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

package com.example.sports.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sports.R
import com.example.sports.data.LocalSportsDataProvider
import com.example.sports.model.Sport
import com.example.sports.ui.theme.SportsTheme
import com.example.sports.utils.SportsContentType

/**
 * Composable principal que actúa como contenedor y muestra el contenido según [uiState] y [windowSize].
 * Es el punto de entrada principal para la UI de la aplicación Sports.
 *
 * @param windowSize La clase de tamaño de ancho de la ventana, utilizada para adaptar el diseño.
 * @param onBackPressed La acción a ejecutar cuando se presiona el botón de retroceso.
 */
@Composable
fun SportsApp(
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit,
) {
    val viewModel: SportsViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState() // Recolecta el estado de la UI del ViewModel como un State.
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,// Pantallas pequeñas (teléfonos en modo retrato).
        WindowWidthSizeClass.Medium -> SportsContentType.ListOnly// Pantallas medianas (tabletas en modo retrato, teléfonos grandes en modo paisaje).

        WindowWidthSizeClass.Expanded -> SportsContentType.ListAndDetail
        else -> SportsContentType.ListOnly
    }

    Scaffold(// Scaffold proporciona una estructura de diseño básica para Material Design (barra superior, contenido principal, etc.).
        topBar = {
            SportsAppBar(
                isShowingListPage = uiState.isShowingListPage,
                onBackButtonClick = { viewModel.navigateToListPage() },
                windowSize = windowSize
            )
        }
    ) { innerPadding ->
        // Muestra un diseño de lista y detalle si el tipo de contenido lo permite.
        if (contentType == SportsContentType.ListAndDetail) {
            SportsListAndDetail(
                sports = uiState.sportsList,
                selectedSport = uiState.currentSport,
                onClick = {
                    viewModel.updateCurrentSport(it)
                },
                onBackPressed = onBackPressed,
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxWidth()
            )
        } else { // Si no es un diseño de lista y detalle, decide entre la lista o el detalle.
            if (uiState.isShowingListPage) {
                SportsList(
                    sports = uiState.sportsList,
                    onClick = {
                        viewModel.updateCurrentSport(it)
                        viewModel.navigateToDetailPage()
                    },
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                    contentPadding = innerPadding,
                )
            } else {// Muestra los detalles de un deporte.
                SportsDetail(
                    selectedSport = uiState.currentSport,
                    contentPadding = innerPadding,
                    onBackPressed = {
                        viewModel.navigateToListPage()
                    }
                )
            }
        }
    }
}

/**
 * Composable que muestra la barra superior y un botón de retroceso si la navegación hacia atrás es posible.
 *
 * @param onBackButtonClick La acción a realizar cuando se hace clic en el botón de retroceso.
 * @param isShowingListPage Booleano que indica si se está mostrando la página de la lista (verdadero) o la de detalles (falso).
 * @param windowSize La clase de tamaño de ancho de la ventana, utilizada para determinar la visibilidad del botón de retroceso.
 * @param modifier Modificador para aplicar a este Composable.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportsAppBar(
    onBackButtonClick: () -> Unit,
    isShowingListPage: Boolean,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    // Determina si se está mostrando la página de detalles (cuando el tamaño de la ventana no es expandido y no se está mostrando la lista).
    val isShowingDetailPage = windowSize != WindowWidthSizeClass.Expanded && !isShowingListPage
    TopAppBar(
        title = {
            Text(
                text =
                if (isShowingDetailPage) {
                    stringResource(R.string.detail_fragment_label)
                } else {
                    stringResource(R.string.list_fragment_label)
                },
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = if (isShowingDetailPage) {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        } else { // Si no se está mostrando la página de detalles, se muestra una Box vacía para no tener icono de navegación.
            { Box {} }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
    )
}

/**
 * Composable que muestra un elemento individual de la lista de deportes (tarjeta).
 *
 * @param sport El objeto [Sport] a mostrar.
 * @param onItemClick La acción a realizar cuando se hace clic en la tarjeta del deporte.
 * @param modifier Modificador para aplicar a este Composable.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SportsListItem(
    sport: Sport,
    onItemClick: (Sport) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(sport) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            SportsListImageItem(
                sport = sport,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column(// Columna para el texto del deporte (título, subtítulo, conteo de jugadores, estado olímpico).
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(// Título del deporte.
                    text = stringResource(sport.titleResourceId),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Text(// Subtítulo del deporte.
                    text = stringResource(sport.subtitleResourceId),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
                Spacer(Modifier.weight(1f))
                Row {// Conteo de jugadores.
                    Text(
                        text = pluralStringResource(
                            R.plurals.player_count_caption,
                            sport.playerCount,
                            sport.playerCount
                        ),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(Modifier.weight(1f))
                    if (sport.olympic) {
                        Text(
                            text = stringResource(R.string.olympic_caption),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}

/**
 * Composable que muestra la imagen de un elemento de la lista de deportes.
 *
 * @param sport El objeto [Sport] cuya imagen se mostrará.
 * @param modifier Modificador para aplicar a este Composable.
 */
@Composable
private fun SportsListImageItem(sport: Sport, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(sport.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

/**
 * Composable que muestra una lista desplazable de deportes utilizando LazyColumn.
 *
 * @param sports La lista de objetos [Sport] a mostrar.
 * @param onClick La acción a realizar cuando se hace clic en un elemento de la lista.
 * @param modifier Modificador para aplicar a este Composable.
 * @param contentPadding El padding a aplicar al contenido de la lista.
 */
@Composable
private fun SportsList(
    sports: List<Sport>,
    onClick: (Sport) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium)),
    ) {
        items(sports, key = { sport -> sport.id }) { sport ->
            SportsListItem(
                sport = sport,
                onItemClick = onClick
            )
        }
    }
}

/**
 * Composable que muestra la pantalla de detalles de un deporte.
 *
 * @param selectedSport El objeto [Sport] cuyos detalles se mostrarán.
 * @param onBackPressed La acción a realizar cuando se presiona el botón de retroceso.
 * @param contentPadding El padding a aplicar al contenido de la pantalla de detalles.
 * @param modifier Modificador para aplicar a este Composable.
 */
@Composable
private fun SportsDetail(
    selectedSport: Sport,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed()
    }
    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current
    Box(
        modifier = modifier
            .verticalScroll(state = scrollState)
            .padding(top = contentPadding.calculateTopPadding())
    ) {
        Column(
            modifier = Modifier
                .padding(
                    bottom = contentPadding.calculateTopPadding(),
                    start = contentPadding.calculateStartPadding(layoutDirection),
                    end = contentPadding.calculateEndPadding(layoutDirection)
                )
        ) {
            Box {
                Box {
                    Image(
                        painter = painterResource(selectedSport.sportsImageBanner),
                        contentDescription = null,
                        alignment = Alignment.TopCenter,
                        contentScale = ContentScale.FillWidth,
                    )
                }
                Column(
                    Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, MaterialTheme.colorScheme.scrim),
                                0f,
                                400f
                            )
                        )
                ) {
                    Text(
                        text = stringResource(selectedSport.titleResourceId),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(R.dimen.padding_small))
                    )
                    Row(
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    ) {
                        Text(
                            text = pluralStringResource(
                                R.plurals.player_count_caption,
                                selectedSport.playerCount,
                                selectedSport.playerCount
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = stringResource(R.string.olympic_caption),
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                        )
                    }
                }
            }
            Text(
                text = stringResource(selectedSport.sportDetails),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.padding_detail_content_vertical),
                    horizontal = dimensionResource(R.dimen.padding_detail_content_horizontal)
                )
            )
        }
    }
}

/**
 * Composable que muestra un diseño de lista y detalle para los deportes.
 * Se utiliza en pantallas grandes (como tabletas en modo paisaje) donde ambos paneles pueden ser visibles.
 *
 * @param sports La lista de objetos [Sport] a mostrar en el panel de la lista.
 * @param selectedSport El objeto [Sport] actualmente seleccionado para mostrar detalles.
 * @param onClick La acción a realizar cuando se hace clic en un elemento de la lista.
 * @param onBackPressed La acción a realizar cuando se presiona el botón de retroceso (generalmente para salir de la aplicación en este contexto).
 * @param modifier Modificador para aplicar a este Composable.
 * @param contentPadding El padding a aplicar al contenido.
 */

@Composable
private fun SportsListAndDetail(
    sports: List<Sport>,
    selectedSport: Sport,
    onClick: (Sport) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Row(
        modifier = modifier
    ) {
        SportsList(
            sports = sports,
            onClick = onClick,
            contentPadding = PaddingValues(
                top = contentPadding.calculateTopPadding(),
            ),
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
        )
        SportsDetail(
            selectedSport = selectedSport,
            modifier = Modifier.weight(3f),
            contentPadding = PaddingValues(
                top = contentPadding.calculateTopPadding(),
            ),
            onBackPressed = onBackPressed,
        )
    }
}

/**
 * Vista previa de un elemento individual de la lista de deportes.
 */
@Preview
@Composable
fun SportsListItemPreview() {
    SportsTheme {
        SportsListItem(
            sport = LocalSportsDataProvider.defaultSport,
            onItemClick = {}
        )
    }
}

/**
 * Vista previa de la lista completa de deportes.
 */
@Preview
@Composable
fun SportsListPreview() {
    SportsTheme {
        Surface {
            SportsList(
                sports = LocalSportsDataProvider.getSportsData(),
                onClick = {},
            )
        }
    }
}

/**
 * Vista previa del diseño de lista y detalle para tabletas (modo paisaje).
 */
@Preview(device = Devices.TABLET)// Vista previa en un dispositivo de tableta.
@Composable
fun SportsListAndDetailsPreview() {
    SportsTheme {
        Surface {
            SportsListAndDetail(
                sports = LocalSportsDataProvider.getSportsData(),
                selectedSport = LocalSportsDataProvider.getSportsData().getOrElse(0) {
                    LocalSportsDataProvider.defaultSport
                },
                onClick = {},
                onBackPressed = {},
            )
        }
    }
}
