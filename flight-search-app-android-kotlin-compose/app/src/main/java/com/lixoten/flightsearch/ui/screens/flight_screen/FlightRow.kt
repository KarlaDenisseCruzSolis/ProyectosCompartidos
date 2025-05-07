package com.lixoten.flightsearch.ui.screens.flight_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lixoten.flightsearch.data.MockData
import com.lixoten.flightsearch.ui.screens.search.AirportRow

@Composable// Composable que representa una fila de vuelo, con información de salida, llegada y botón de favorito
fun FlightRow(
    modifier: Modifier = Modifier,// Modificador opcional para personalizar externamente
    isFavorite: Boolean,// Indica si la ruta está marcada como favorita
    departureAirportCode: String,// Código del aeropuerto de salida (ej: "LAX")
    departureAirportName: String,// Nombre del aeropuerto de salida (ej: "Los Angeles")
    destinationAirportCode: String,// Código del aeropuerto de destino
    destinationAirportName: String,// Nombre del aeropuerto de destino
    onFavoriteClick: (String, String) -> Unit,// Callback para marcar/desmarcar como favorito
) {
    Card( // Tarjeta con sombra para mostrar la información del vuelo
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row {// Fila horizontal que contiene la información del vuelo y el botón de favorito
            Column(// Columna para mostrar los datos de salida y llegada
                modifier = modifier.weight(10f)// Ocupa la mayor parte del espacio horizontal
            ) {
                Column {
                    Text(// Etiqueta para el aeropuerto de salida
                        text = "Depart",
                        style = MaterialTheme.typography.overline,
                        modifier = Modifier.padding(start = 32.dp)
                    )
                    // Componente que muestra código y nombre del aeropuerto de salida
                    AirportRow(code = departureAirportCode, name = departureAirportName)
                    Text(// Etiqueta para el aeropuerto de llegada
                        text = "Arrival",
                        style = MaterialTheme.typography.overline,
                        modifier = Modifier.padding(start = 32.dp)
                    )
                    // Componente que muestra código y nombre del aeropuerto de llegada
                    AirportRow(code = destinationAirportCode, name = destinationAirportName)
                }
            }
            IconButton(// Botón de ícono para marcar como favorito (alineado verticalmente al centro)
                onClick = {// Al hacer clic, se llama a la función con los códigos de salida y destino
                    onFavoriteClick(departureAirportCode, destinationAirportCode)
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(// Ícono que cambia según si es favorito o no, con color correspondiente
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    tint = if (isFavorite) Color.Red else Color.LightGray,// Rojo si es favorito, gris si no
                    contentDescription = null
                )
            }
        }
    }
}


@Preview
@Composable
fun FlightRowPreview() {// Vista previa del componente FlightRow usando datos simulados
    val mock = MockData// Acceso a datos de ejemplo
    FlightRow(
        isFavorite = true,// Ruta marcada como favorita en la vista previa
        departureAirportCode = mock.airports[1].code,// Código del aeropuerto de salida de prueba
        departureAirportName = mock.airports[1].name,// Nombre del aeropuerto de salida
        destinationAirportCode = mock.airports[2].code,// Código del aeropuerto de destino
        destinationAirportName = mock.airports[2].name,// Nombre del aeropuerto de destino
        onFavoriteClick = { _: String, _:String ->}// No hace nada al hacer clic (solo es preview)
    )
}

