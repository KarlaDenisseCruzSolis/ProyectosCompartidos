package com.lixoten.flightsearch.ui.screens.flight_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lixoten.flightsearch.data.MockData
import com.lixoten.flightsearch.model.Airport
import com.lixoten.flightsearch.model.Favorite

@Composable
fun FlightResults( // Función composable que muestra los resultados de vuelos desde un aeropuerto de salida
    modifier: Modifier = Modifier,// Modificador opcional para personalizar la UI desde fuera
    departureAirport: Airport,// Aeropuerto de salida seleccionado
    destinationList: List<Airport>,// Lista de aeropuertos de destino
    favoriteList: List<Favorite>,// Lista de rutas favoritas del usuario
    onFavoriteClick: (String, String) -> Unit // Función de callback al marcar/desmarcar favorito
) {
    Column {
        //Text(text = uiState.value.play)
        // Contenedor de tipo columna para apilar elementos verticalmente

        // LazyColumn para mostrar la lista de aeropuertos de destino
        LazyColumn(
            modifier = modifier
                .padding(8.dp)// Agrega un espacio de 8dp alrededor de la lista
                .fillMaxWidth() // Hace que la lista ocupe todo el ancho disponible
        ) {
            items(destinationList, key = { it.id }) { item ->// Itera sobre cada destino en la lista
                val isFavorite = favoriteList.find { f ->// Busca si la combinación salida-destino ya está en favoritos
                    f.departureCode == departureAirport.code &&
                            f.destinationCode == item.code }

                FlightRow(// Muestra una fila de vuelo con los datos actuales
                    isFavorite = isFavorite != null,// Marca como favorito si ya existe en la lista
                    departureAirportCode = departureAirport.code,// Código del aeropuerto de salida
                    departureAirportName = departureAirport.name,// Nombre del aeropuerto de salida
                    destinationAirportCode = item.code,// Código del aeropuerto de destino
                    destinationAirportName = item.name,// Nombre del aeropuerto de destino
                    onFavoriteClick = onFavoriteClick// Callback al hacer clic en el ícono de favorito
                )
            }
        }
    }
}

// Función composable de vista previa que muestra cómo se ve FlightResults con datos simulados
@Preview
@Composable
fun FlightResultsPreview() {
    val mockData = MockData.airports// Carga aeropuertos de prueba

    FlightResults(
        departureAirport = mockData[0],// Usa el primer aeropuerto como punto de partida
        destinationList = mockData,// Usa toda la lista como destinos
        favoriteList = emptyList(),// Sin favoritos en la vista previa
        onFavoriteClick = { _: String, _: String -> }// No se hace nada al hacer clic en favorito
    )
}