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

package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme

/**
 * MainActivity es el punto de entrada de la aplicación Superheroes.
 * Extiende ComponentActivity, que es la clase base para actividades que usan Jetpack Compose.
 */
class MainActivity : ComponentActivity() {
    /**
     * Llamado cuando la actividad se crea por primera vez. Aquí es donde debes hacer toda tu
     * configuración estática normal: crear vistas, vincular datos a listas, etc.
     *
     * @param savedInstanceState Si la actividad está siendo reinicializada después de
     * haber sido cerrada previamente, este Bundle contiene los datos que suministró más recientemente
     * en onSaveInstanceState(Bundle). Nota: De lo contrario, es nulo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita la visualización de borde a borde para la actividad, permitiendo que el contenido se extienda debajo de las barras del sistema.
        enableEdgeToEdge()
        // Establece el contenido componible para esta actividad.
        setContent {
            // Aplica el tema Superheroes a toda la aplicación.
            SuperheroesTheme {
                // Un contenedor de superficie que usa el color 'background' del tema.
                Surface(
                    // Llena el tamaño máximo disponible y aplica el color de fondo del tema.
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Función componible que muestra el contenido principal de la aplicación Superheroes.
                    SuperheroesApp()
                }
            }
        }
    }

    /**
     * Composable que muestra una barra de aplicación y una lista de héroes.
     */
    @Composable
    fun SuperheroesApp() {
        // Scaffold proporciona una estructura de diseño básica para los componentes de Material Design.
        Scaffold(
            // Hace que el Scaffold llene el tamaño máximo disponible.
            modifier = Modifier.fillMaxSize(),
            // Define la barra de aplicación superior para la pantalla.
            topBar = {
                TopAppBar()
            }
        ) {
            /* Importante: No es una buena práctica acceder a la fuente de datos directamente desde la interfaz de usuario.
            En unidades posteriores aprenderás a usar ViewModel en escenarios donde toma la
            fuente de datos como dependencia y expone a los héroes.
             */
            // Recupera la lista de héroes del HeroesRepository.
            val heroes = HeroesRepository.heroes
            // Muestra una lista de héroes, pasando los héroes recuperados y el padding de contenido.
            HeroesList(heroes = heroes, contentPadding = it)
        }
    }

    /**
     * Composable that displays a Top Bar with an icon and text.
     * Composable que muestra una barra superior con un ícono y texto.
     * @param modifier modifiers to set to this composable
     */
    @OptIn(ExperimentalMaterial3Api::class)// Opt-in para usar APIs experimentales de Material 3 como CenterAlignedTopAppBar.
    @Composable
    fun TopAppBar(modifier: Modifier = Modifier) {
        CenterAlignedTopAppBar(// CenterAlignedTopAppBar es una barra de aplicación superior de Material Design que centra su título.
            title = {// Define el título de la barra de aplicación superior.
                Text(
                    text = stringResource(R.string.app_name),// Establece el texto del título a partir de los recursos de cadena.
                    style = MaterialTheme.typography.displayLarge, // Aplica un estilo de tipografía de visualización grande al texto.
                )
            },
            modifier = modifier// Aplica el modificador proporcionado a la barra de aplicación superior.
        )
    }
    /**
     * Composable de vista previa para la SuperheroesApp.
     * Muestra una vista previa de la SuperheroesApp en la vista de diseño de Android Studio.
     */
    @Preview(showBackground = true) // Anotación para mostrar una vista previa con un fondo.
    @Composable
    fun SuperHeroesPreview() {
        SuperheroesTheme {// Aplica el tema Superheroes a la vista previa.
            SuperheroesApp()// Muestra la SuperheroesApp para fines de vista previa.
        }
    }
}
