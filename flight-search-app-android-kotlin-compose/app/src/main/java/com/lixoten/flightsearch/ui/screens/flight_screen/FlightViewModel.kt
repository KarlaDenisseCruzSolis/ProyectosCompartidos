package com.lixoten.flightsearch.ui.screens.flight_screen

import androidx.compose.runtime.*
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.lixoten.flightsearch.FlightApplication
import com.lixoten.flightsearch.data.FlightRepository
import com.lixoten.flightsearch.model.Favorite
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlightViewModel(// ViewModel que maneja la lógica de estado para la pantalla de vuelos
    savedStateHandle: SavedStateHandle,// Maneja argumentos de navegación (como el código del aeropuerto)
    val flightRepository: FlightRepository// Repositorio para acceder a datos de vuelos y favoritos
): ViewModel()  {
    // Estado interno mutable de la UI expuesto como flujo de solo lectura
    private val _uiState = MutableStateFlow(FlightsUiState())
    val uiState: StateFlow<FlightsUiState> = _uiState

    // Obtiene el código del aeropuerto desde los argumentos de navegación
    private val airportCode: String = savedStateHandle[FlightScreenDestination.codeArg] ?: ""

    // Variable que indica si el vuelo fue agregado o eliminado de favoritos
    var flightAdded: Boolean by mutableStateOf(false)

//    private var getFlightsJob: Job? = null
// Bloque de inicialización que se ejecuta al crear el ViewModel
    init {
        viewModelScope.launch {
            processFlightList(airportCode)// Procesa la lista de aeropuertos y favoritos
        }
    }

    // Carga los datos de aeropuertos y favoritos, y actualiza el estado UI
    private fun processFlightList(airportCode: String) {

        viewModelScope.launch {
            val ff = flightRepository.getAllFavoritesFlights().toMutableStateList()// Lista de favoritos
            val aa = flightRepository.getAllAirports().toMutableStateList()// Lista de aeropuertos
            val departureAirport = aa.first { it.code == airportCode }// Aeropuerto de salida
            _uiState.update {// Actualiza el estado UI con los datos obtenidos
                uiState.value.copy(
                    code = airportCode,
                    favoriteList = ff,
                    destinationList = aa,
                    departureAirport = departureAirport,
                )
            }
        }
    }

    // Agrega o elimina un vuelo favorito según si ya existe o no
    fun addFavoriteFlight(departureCode: String, destinationCode: String) {
        viewModelScope.launch {
            val favorite: Favorite = flightRepository.getSingleFavorite(departureCode, destinationCode)

            if (favorite == null) {
                // Si no existe, se crea y se agrega como favorito
                val tmp = Favorite(
                    departureCode = departureCode,
                    destinationCode = destinationCode,
                )
                flightAdded = true
                flightRepository.insertFavoriteFlight(tmp)
            } else {
                // Si ya existe, se elimina de favoritos
                flightAdded = false
                flightRepository.deleteFavoriteFlight(favorite)
            }

            // Fuerza una recomposición al actualizar manualmente la lista de favoritos
            val play = flightRepository.getAllFavoritesFlights()
            _uiState.update {
                uiState.value.copy(
                    favoriteList = play,
                )
            }
        }
    }

    /**
     * Fábrica para crear instancias del ViewModel con dependencias (repositorio)
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                // Obtiene la instancia de la aplicación y su contenedor de dependencias
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FlightApplication)
                val flightRepository = application.container.flightRepository
                FlightViewModel(// Crea el ViewModel con el SavedStateHandle y el repositorio inyectado
                    this.createSavedStateHandle(),
                    flightRepository = flightRepository
                )
            }
        }
    }
}