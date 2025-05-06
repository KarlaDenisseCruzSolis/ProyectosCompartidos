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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dessertrelease.DessertReleaseApplication
import com.example.dessertrelease.R
import com.example.dessertrelease.data.UserPreferencesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
 * View model of Dessert Release components
 */
class DessertReleaseViewModel( // Define el ViewModel para manejar la UI de los postres.
    private val userPreferencesRepository: UserPreferencesRepository // Repositorio para manejar las preferencias del usuario.
) : ViewModel() {
    // Estado de la UI que observa las preferencias de layout (lineal o cuadrícula).
    val uiState: StateFlow<DessertReleaseUiState> =
        userPreferencesRepository.isLinearLayout.map { isLinearLayout -> // Mapea las preferencias de layout.
            DessertReleaseUiState(isLinearLayout) // Crea el estado UI con la preferencia de layout.
        }.stateIn(
            scope = viewModelScope, // Usa el scope del ViewModel.
            started = SharingStarted.WhileSubscribed(5_000), // Mantiene el flujo activo mientras la app esté en primer plano.
            initialValue = runBlocking {
                DessertReleaseUiState(
                    isLinearLayout = userPreferencesRepository.isLinearLayout.first() // Obtiene el valor inicial del flujo.
                )
            }
        )

    /*
     * Cambia el layout (lineal o cuadrícula) y guarda la selección en el repositorio de preferencias.
     */
    fun selectLayout(isLinearLayout: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.saveLayoutPreference(isLinearLayout) // Guarda la preferencia del usuario.
        }
    }

    companion object {
        // Crea el Factory para inicializar el ViewModel.
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as DessertReleaseApplication)
                DessertReleaseViewModel(application.userPreferencesRepository) // Inicializa el ViewModel con el repositorio.
            }
        }
    }
}

/*
 * Data class que contiene varios estados UI para las pantallas de Dessert Release.
 */
data class DessertReleaseUiState(
    val isLinearLayout: Boolean = true, // Determina si el layout es lineal.
    val toggleContentDescription: Int =
        if (isLinearLayout) R.string.grid_layout_toggle else R.string.linear_layout_toggle, // Define el texto para el botón de cambio de layout.
    val toggleIcon: Int =
        if (isLinearLayout) R.drawable.ic_grid_layout else R.drawable.ic_linear_layout // Define el ícono para el cambio de layout.
)
