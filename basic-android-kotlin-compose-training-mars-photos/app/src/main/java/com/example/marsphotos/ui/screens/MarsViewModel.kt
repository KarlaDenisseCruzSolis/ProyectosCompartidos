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
package com.example.marsphotos.ui.screens // Define el paquete donde se encuentra esta clase.

import androidx.compose.runtime.getValue // Importa el getter para `by` delegado de Compose.
import androidx.compose.runtime.mutableStateOf // Permite crear un estado mutable observable.
import androidx.compose.runtime.setValue // Importa el setter para `by` delegado de Compose.
import androidx.lifecycle.ViewModel // Clase base para los ViewModel de Android.
import androidx.lifecycle.ViewModelProvider // Proveedor para instanciar ViewModels.
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY // Clave para acceder a la aplicación en el factory.
import androidx.lifecycle.viewModelScope // Proporciona un scope de corrutina atado al ciclo de vida del ViewModel.
import androidx.lifecycle.viewmodel.initializer // Función para inicializar un ViewModel personalizado.
import androidx.lifecycle.viewmodel.viewModelFactory // Permite crear un ViewModelFactory personalizado.
import com.example.marsphotos.MarsPhotosApplication // Importa la clase de aplicación personalizada.
import com.example.marsphotos.data.MarsPhotosRepository // Repositorio que obtiene los datos de la API.
import com.example.marsphotos.model.MarsPhoto // Modelo que representa una foto de Marte.
import kotlinx.coroutines.launch // Permite lanzar corrutinas.
import retrofit2.HttpException // Excepción que representa errores HTTP.
import java.io.IOException // Excepción para errores de entrada/salida.

/**
 * UI state for the Home screen
 */
// Define una interfaz sellada que representa el estado de la interfaz de usuario (UI).
sealed interface MarsUiState {
    data class Success(val photos: List<MarsPhoto>) : MarsUiState // Estado de éxito con una lista de fotos.
    object Error : MarsUiState // Estado de error.
    object Loading : MarsUiState // Estado de carga (cuando se están obteniendo los datos).
}

// ViewModel que gestiona la lógica y el estado de la pantalla principal.
class MarsViewModel(private val marsPhotosRepository: MarsPhotosRepository) : ViewModel() {

    /** The mutable State that stores the status of the most recent request */
    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading) // Estado observable que indica si la app está cargando, tuvo éxito o falló.
        private set // El setter es privado para que solo el ViewModel pueda modificar el estado.

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos() // Llama automáticamente a getMarsPhotos() al crear el ViewModel para iniciar la carga de datos.
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getMarsPhotos() {
        viewModelScope.launch { // Lanza una corrutina que vive mientras el ViewModel esté activo.
            marsUiState = MarsUiState.Loading // Establece el estado como 'Loading' al iniciar la solicitud.
            marsUiState = try {
                // Intenta obtener las fotos del repositorio. Si tiene éxito, establece el estado en Success con los datos.
                MarsUiState.Success(marsPhotosRepository.getMarsPhotos())
            } catch (e: IOException) {
                MarsUiState.Error // Si ocurre un error de red (sin conexión), establece el estado en Error.
            } catch (e: HttpException) {
                MarsUiState.Error // Si ocurre un error HTTP (como 404 o 500), también establece el estado en Error.
            }
        }
    }

    /**
     * Factory for [MarsViewModel] that takes [MarsPhotosRepository] as a dependency
     */
    companion object {
        // Crea una instancia personalizada del ViewModel usando un ViewModelFactory.
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotosApplication) // Obtiene la aplicación personalizada.
                val marsPhotosRepository = application.container.marsPhotosRepository // Obtiene el repositorio desde el contenedor de dependencias.
                MarsViewModel(marsPhotosRepository = marsPhotosRepository) // Devuelve una instancia de MarsViewModel con su dependencia inyectada.
            }
        }
    }
}