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

package com.example.waterme.ui // Define el paquete en el que se encuentra este archivo Kotlin

import androidx.lifecycle.ViewModel // Importa la clase base ViewModel para lógica de UI desacoplada del ciclo de vida
import androidx.lifecycle.ViewModelProvider // Importa la clase que permite crear instancias de ViewModels
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY // Importa la clave para acceder a la instancia de Application
import androidx.lifecycle.viewmodel.initializer // Importa la función usada para inicializar un ViewModel dentro de un factory
import androidx.lifecycle.viewmodel.viewModelFactory // Importa la función para crear un factory de ViewModel
import com.example.waterme.WaterMeApplication // Importa la clase Application personalizada del proyecto
import com.example.waterme.data.Reminder // Importa la clase Reminder usada para programar recordatorios
import com.example.waterme.data.WaterRepository // Importa la interfaz que abstrae el origen de datos de las plantas

// Define la clase ViewModel llamada WaterViewModel que recibe un repositorio como dependencia
class WaterViewModel(private val waterRepository: WaterRepository) : ViewModel() {
    internal val plants = waterRepository.plants // Expone la lista de plantas desde el repositorio para la UI
    fun scheduleReminder(reminder: Reminder) { // Función que agenda un recordatorio
        waterRepository.scheduleReminder(reminder.duration, reminder.unit, reminder.plantName) // Llama al método del repositorio para programar el recordatorio
    }

    /**
     * Factory para [WaterViewModel] que provee la instancia del repositorio desde la clase Application
     */
    companion object { // Define un objeto companion que actúa como miembro estático
        val Factory: ViewModelProvider.Factory = viewModelFactory { // Crea una fábrica de ViewModels usando la API moderna
            initializer { // Define cómo inicializar el ViewModel dentro de la fábrica
                val waterRepository =
                    (this[APPLICATION_KEY] as WaterMeApplication).container.waterRepository
                // Obtiene el repositorio desde el contenedor de dependencias de la clase Application
                WaterViewModel( // Crea y devuelve una nueva instancia del ViewModel con su dependencia
                    waterRepository = waterRepository
                )
            }
        }
    }
}