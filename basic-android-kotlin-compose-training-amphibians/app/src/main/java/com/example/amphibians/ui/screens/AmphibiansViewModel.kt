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

package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibiansApplication
import com.example.amphibians.data.AmphibiansRepository
import com.example.amphibians.model.Amphibian
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Home screen
 */
sealed interface AmphibiansUiState {   // Interfaz sellada que define estados posibles de la UI
    data class Success(val amphibians: List<Amphibian>) : AmphibiansUiState  // Estado éxito con lista de anfibios
    object Error : AmphibiansUiState       // Estado error si falla la carga de datos
    object Loading : AmphibiansUiState     // Estado carga mientras se obtienen datos
}

/**
 * ViewModel containing the app data and method to retrieve the data
 */
class AmphibiansViewModel(private val amphibiansRepository: AmphibiansRepository) : ViewModel() {

    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)  // Estado observable inicializado en Loading
        private set   // El setter es privado para que solo esta clase pueda modificar el estado

    init {
        getAmphibians()   // Al crear el ViewModel, inicia la carga de datos
    }

    fun getAmphibians() {
        viewModelScope.launch {  // Lanza una corrutina ligada al ciclo de vida del ViewModel
            amphibiansUiState = AmphibiansUiState.Loading  // Cambia estado a Loading antes de obtener datos
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibiansRepository.getAmphibians())  // Intenta obtener datos y asignar estado éxito
            } catch (e: IOException) {
                AmphibiansUiState.Error    // Si ocurre un error de red o disco, cambia a estado error
            } catch (e: HttpException) {
                AmphibiansUiState.Error    // Si ocurre un error HTTP, cambia a estado error
            }
        }
    }

    /**
     * Factory for [AmphibiansViewModel] that takes [AmphibiansRepository] as a dependency
     */
    companion object {    // Objeto companion que contiene la fábrica para crear este ViewModel
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as AmphibiansApplication)  // Obtiene la instancia de la aplicación personalizada
                val amphibiansRepository = application.container.amphibiansRepository  // Obtiene el repositorio del contenedor de dependencias
                AmphibiansViewModel(amphibiansRepository = amphibiansRepository)  // Crea y retorna el ViewModel con el repositorio inyectado
            }
        }
    }
}
