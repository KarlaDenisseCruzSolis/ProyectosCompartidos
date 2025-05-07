package com.lixoten.flightsearch.data

import com.lixoten.flightsearch.model.Airport
import com.lixoten.flightsearch.model.Favorite
import kotlinx.coroutines.flow.Flow

// Interfaz que define las operaciones disponibles para interactuar con los datos de aeropuertos y vuelos favoritos.
interface FlightRepository {

    fun getAllAirportsFlow(): Flow<List<Airport>>// Metodo que retorna un flujo de todos los aeropuertos (sin filtros).
    fun getAllAirportsFlow(query: String): Flow<List<Airport>>// Metodo que retorna un flujo de aeropuertos filtrados por una cadena de búsqueda.
    fun getAirportByCodeFlow(code: String): Flow<Airport> // Metodo que retorna un flujo de un aeropuerto específico según su código.

    suspend fun getAllAirports(): List<Airport>// Metodo suspendido que obtiene todos los aeropuertos de la base de datos (sin filtros).
    suspend fun getAllAirports(query: String): List<Airport>// Mwtodo suspendido que obtiene los aeropuertos de la base de datos filtrados por una cadena de búsqueda.
    suspend fun getAirportByCode(code: String): Airport// Metodo suspendido que obtiene un aeropuerto específico según su código.

    suspend fun getAirportById(id: Int): Airport// Metodo suspendido que obtiene un aeropuerto específico por su ID.

    fun getAllFavoritesFlightsFlow():  Flow<List<Favorite>>// Metodo que retorna un flujo de todos los vuelos favoritos.
    suspend fun getAllFavoritesFlights(): List<Favorite>// Metodo suspendido que obtiene todos los vuelos favoritos desde la base de datos.
    suspend fun insertFavoriteFlight(flight: Favorite)// Metodo suspendido para insertar un vuelo favorito en la base de datos.
    suspend fun deleteFavoriteFlight(flight: Favorite)// Metodo suspendido para eliminar un vuelo favorito de la base de datos.

    suspend fun getSingleFavorite(departureCode: String, destinationCode: String): Favorite// Metodo suspendido que obtiene un solo vuelo favorito, según los códigos de salida y destino.
}