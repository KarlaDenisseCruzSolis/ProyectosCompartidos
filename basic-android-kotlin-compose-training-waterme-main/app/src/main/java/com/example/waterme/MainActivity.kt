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

package com.example.waterme // Define el paquete donde se encuentra esta clase

import android.os.Bundle // Permite acceder a la clase Bundle para guardar/restaurar estado
import androidx.activity.ComponentActivity // Base para actividades que usan Jetpack Compose
import androidx.activity.compose.setContent // Permite definir el contenido de la actividad en Compose
import androidx.activity.enableEdgeToEdge // Habilita contenido detrás de barras del sistema para mejor estética
import androidx.compose.foundation.layout.fillMaxSize // Modificador para ocupar toda la pantalla disponible
import androidx.compose.material3.MaterialTheme // Tema visual Material 3 para UI consistente
import androidx.compose.material3.Surface // Composable contenedor que aplica color de fondo, elevación, etc.
import androidx.compose.ui.Modifier // Para modificar comportamiento y apariencia de los composables
import com.example.waterme.ui.WaterMeApp // Importa el composable principal de la app
import com.example.waterme.ui.theme.WaterMeTheme // Importa el tema personalizado de la app

class MainActivity : ComponentActivity() { // Clase principal que extiende ComponentActivity para Compose

    override fun onCreate(savedInstanceState: Bundle?) { // Método llamado al iniciar la actividad
        enableEdgeToEdge() // Permite que el contenido se dibuje detrás de la barra de estado y navegación
        super.onCreate(savedInstanceState) // Llama al método base para inicializar la actividad correctamente
        setContent { // Define el contenido de la interfaz de usuario usando Jetpack Compose
            WaterMeTheme { // Aplica el tema personalizado de la app (colores, tipografía, estilos)
                // Surface es un contenedor visual que aplica un color de fondo
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa toda el área de la pantalla
                    color = MaterialTheme.colorScheme.background // Usa el color de fondo definido por el tema
                ) {
                    WaterMeApp() // Composable principal que contiene toda la interfaz de usuario de la app
                }
            }
        }
    }
}