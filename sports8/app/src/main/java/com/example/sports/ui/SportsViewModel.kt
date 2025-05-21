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

package com.example.sports.ui

import androidx.lifecycle.ViewModel
import com.example.sports.data.LocalSportsDataProvider
import com.example.sports.model.Sport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel para la aplicación Sports.
 * Gestiona el estado de la UI relacionado con los deportes y la navegación entre listas y detalles.
 */
class SportsViewModel : ViewModel() {
    // MutableStateFlow que contiene el estado actual de la UI de la aplicación Sports.
    // Inicializa la lista de deportes con los datos de LocalSportsDataProvider
    // y establece el deporte actual como el primero de la lista o el deporte por defecto.
    private val _uiState = MutableStateFlow(
        SportsUiState(
            sportsList = LocalSportsDataProvider.getSportsData(),
            currentSport = LocalSportsDataProvider.getSportsData().getOrElse(0) {
                LocalSportsDataProvider.defaultSport
            }
        )
    )
    val uiState: StateFlow<SportsUiState> = _uiState

    /**
     * Actualiza el deporte actualmente seleccionado en el estado de la UI.
     *
     * @param selectedSport El objeto [Sport] que se ha seleccionado.
     */
    fun updateCurrentSport(selectedSport: Sport) {
        _uiState.update {
            it.copy(currentSport = selectedSport)
        }
    }

    /**
     * Navega a la página de la lista de deportes.
     * Esto actualiza el estado de la UI para indicar que se debe mostrar la lista.
     */
    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    /**
     * Navega a la página de detalles de un deporte.
     * Esto actualiza el estado de la UI para indicar que se debe mostrar la vista de detalles.
     */
    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}

/**
 * Clase de datos que representa el estado de la interfaz de usuario de la aplicación Sports.
 *
 * @property sportsList La lista de todos los [Sport] disponibles. Por defecto, es una lista vacía.
 * @property currentSport El [Sport] que está actualmente seleccionado o se está mostrando en detalle. Por defecto, es [LocalSportsDataProvider.defaultSport].
 * @property isShowingListPage Un booleano que indica si la pantalla actual debe mostrar la lista de deportes (true) o los detalles de un deporte (false). Por defecto, es 'true'.
 */
data class SportsUiState(
    val sportsList: List<Sport> = emptyList(),
    val currentSport: Sport = LocalSportsDataProvider.defaultSport,
    val isShowingListPage: Boolean = true
)
