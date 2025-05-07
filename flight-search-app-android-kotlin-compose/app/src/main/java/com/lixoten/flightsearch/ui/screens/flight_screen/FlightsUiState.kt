package com.lixoten.flightsearch.ui.screens.flight_screen

import com.lixoten.flightsearch.model.Airport
import com.lixoten.flightsearch.model.Favorite

// Clase de datos que representa el estado de la interfaz de usuario (UI) para la pantalla de vuelos
data class FlightsUiState(
    val code: String = "",// Código del aeropuerto de salida (o buscado)
    val favoriteList: List<Favorite> = emptyList(),// Lista de vuelos marcados como favoritos
    val destinationList: List<Airport> = emptyList(),// Lista de aeropuertos destino sugeridos
    val departureAirport: Airport = Airport(),// Aeropuerto de salida seleccionado
)
