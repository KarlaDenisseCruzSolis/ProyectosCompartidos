package com.lixoten.flightsearch.ui.screens.flight_screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lixoten.flightsearch.NavigationDestination
import com.lixoten.flightsearch.R

// Objeto que define la ruta de navegación para la pantalla de vuelos
object FlightScreenDestination : NavigationDestination {
    override val route = "flight_screen"// Ruta base de esta pantalla
    override val titleRes = R.string.app_name// Título de la pantalla (desde recursos)
    const val codeArg = "code"// Argumento que se espera (ej. código de aeropuerto)
    val routeWithArgs = "$route/{$codeArg}"// Ruta con argumento para navegación dinámica

}

@Composable
fun FlightScreen() {// Función composable principal que representa la pantalla de vuelos
    val viewModel: FlightViewModel = viewModel(factory = FlightViewModel.Factory)// Se obtiene el ViewModel asociado a la pantalla, usando su fábrica personalizada
    val uiState = viewModel.uiState.collectAsState()// Se observa el estado UI del ViewModel como un State en Compose

    val context = LocalContext.current// Se obtiene el contexto actual (necesario para mostrar Toasts)
    // val scope = rememberCoroutineScope()
    Column {// Layout en columna para organizar verticalmente los elementos
            // Componente que muestra la lista de resultados de vuelos
            FlightResults(
                departureAirport = uiState.value.departureAirport,// Aeropuerto de salida
                destinationList = uiState.value.destinationList,// Lista de aeropuertos destino
                favoriteList = uiState.value.favoriteList,// Lista de favoritos actuales
                onFavoriteClick = { s1: String, s2: String ->// Acción al hacer clic en "favorito"
                        viewModel.addFavoriteFlight(s1, s2)// Agrega o elimina el favorito en el ViewModel
                    if(viewModel.flightAdded){// Muestra un mensaje emergente según el estado actual
                        Toast.makeText(context,"ADDED", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"DELETED", Toast.LENGTH_SHORT).show()
                    }
                }
            )
    }
}