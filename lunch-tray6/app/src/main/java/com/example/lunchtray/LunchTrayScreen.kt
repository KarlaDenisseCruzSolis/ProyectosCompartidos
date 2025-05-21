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
package com.example.lunchtray

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.ui.AccompanimentMenuScreen
import com.example.lunchtray.ui.CheckoutScreen
import com.example.lunchtray.ui.EntreeMenuScreen
import com.example.lunchtray.ui.OrderViewModel
import com.example.lunchtray.ui.SideDishMenuScreen
import com.example.lunchtray.ui.StartOrderScreen

/**
 * Enumeración que define las diferentes pantallas de la aplicación Lunch Tray.
 * Cada pantalla tiene un título asociado que se utiliza en la barra superior.
 *
 * @property title El ID del recurso de cadena para el título de la pantalla.
 */
enum class LunchTrayScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name), // Pantalla de inicio con el nombre de la aplicación.
    Entree(title = R.string.choose_entree), // Pantalla para elegir el plato principal.
    SideDish(title = R.string.choose_side_dish), // Pantalla para elegir el acompañamiento.
    Accompaniment(title = R.string.choose_accompaniment), // Pantalla para elegir el aderezo.
    Checkout(title = R.string.order_checkout) // Pantalla de resumen del pedido.
}

/**
 * Composable que muestra la barra superior y un botón de retroceso si la navegación hacia atrás es posible.
 *
 * @param currentScreenTitle El ID del recurso de cadena para el título de la pantalla actual.
 * @param canNavigateBack Un booleano que indica si se puede navegar hacia atrás.
 * @param navigateUp La función a ejecutar cuando se hace clic en el botón de retroceso.
 * @param modifier Modificador para aplicar a este componible.
 */
@OptIn(ExperimentalMaterial3Api::class) // Anotación para indicar que se utiliza una API experimental de Material 3.
@Composable
fun LunchTrayAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Barra superior centrada de Material Design 3.
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreenTitle)) }, // Título de la barra superior.
        modifier = modifier,
        navigationIcon = {
            // Muestra un botón de retroceso si la navegación hacia atrás es posible.
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) { // Botón clicable para navegar hacia arriba.
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, // Icono de flecha hacia atrás.
                        contentDescription = stringResource(R.string.back_button) // Descripción de contenido para accesibilidad.
                    )
                }
            }
        }
    )
}
/**
 * Composable principal de la aplicación Lunch Tray.
 * Configura la navegación y los diferentes composables de pantalla.
 */
@Composable
fun LunchTrayApp() {
    // Crea y recuerda un NavController para gestionar la navegación entre pantallas.
    val navController = rememberNavController()
    // Obtiene la entrada actual de la pila de retroceso como un State.
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Obtiene el nombre de la pantalla actual de la ruta de destino.
    val currentScreen = LunchTrayScreen.valueOf(
        backStackEntry?.destination?.route ?: LunchTrayScreen.Start.name // Si la ruta es nula, por defecto es la pantalla de inicio.
    )
    // Crea una instancia del ViewModel para gestionar el estado del pedido.
    val viewModel: OrderViewModel = viewModel()

    // Scaffold proporciona una estructura de diseño básica para Material Design.
    Scaffold(
        topBar = {
            // Muestra la barra superior de la aplicación.
            LunchTrayAppBar(
                currentScreenTitle = currentScreen.title, // Título de la pantalla actual.
                canNavigateBack = navController.previousBackStackEntry != null, // Verdadero si hay una entrada anterior en la pila de retroceso.
                navigateUp = { navController.navigateUp() } // Función para navegar hacia arriba.
            )
        }
    ) { innerPadding ->
        // Recopila el estado de la UI del pedido como un State.
        val uiState by viewModel.uiState.collectAsState()

        // NavHost define las posibles rutas de navegación y sus composables asociados.
        NavHost(
            navController = navController, // El controlador de navegación.
            startDestination = LunchTrayScreen.Start.name, // La pantalla de inicio.
            modifier = Modifier.padding(innerPadding) // Aplica el padding del Scaffold al NavHost.
        ) {
            // Define la ruta para la pantalla de inicio.
            composable(route = LunchTrayScreen.Start.name) {
                StartOrderScreen(
                    onStartOrderButtonClicked = {
                        navController.navigate(LunchTrayScreen.Entree.name) // Navega a la pantalla de entrada al hacer clic en el botón.
                    },
                    modifier = Modifier
                        .fillMaxSize() // Ocupa todo el tamaño disponible.
                )
            }

            // Define la ruta para la pantalla de selección de plato principal.
            composable(route = LunchTrayScreen.Entree.name) {
                EntreeMenuScreen(
                    options = DataSource.entreeMenuItems, // Opciones de platos principales desde DataSource.
                    onCancelButtonClicked = {
                        viewModel.resetOrder() // Reinicia el pedido.
                        // Vuelve a la pila de retroceso a la pantalla de inicio, excluyendo la pantalla actual.
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.SideDish.name) // Navega a la pantalla de acompañamiento.
                    },
                    onSelectionChanged = { item ->
                        viewModel.updateEntree(item) // Actualiza el plato principal seleccionado en el ViewModel.
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState()) // Permite el desplazamiento vertical.
                )
            }

            // Define la ruta para la pantalla de selección de guarnición.
            composable(route = LunchTrayScreen.SideDish.name) {
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems, // Opciones de guarniciones desde DataSource.
                    onCancelButtonClicked = {
                        viewModel.resetOrder() // Reinicia el pedido.
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Accompaniment.name) // Navega a la pantalla de aderezos.
                    },
                    onSelectionChanged = { item ->
                        viewModel.updateSideDish(item) // Actualiza la guarnición seleccionada en el ViewModel.
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState()) // Permite el desplazamiento vertical.
                )
            }

            // Define la ruta para la pantalla de selección de aderezos.
            composable(route = LunchTrayScreen.Accompaniment.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems, // Opciones de aderezos desde DataSource.
                    onCancelButtonClicked = {
                        viewModel.resetOrder() // Reinicia el pedido.
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Checkout.name) // Navega a la pantalla de resumen.
                    },
                    onSelectionChanged = { item ->
                        viewModel.updateAccompaniment(item) // Actualiza el aderezo seleccionado en el ViewModel.
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState()) // Permite el desplazamiento vertical.
                )
            }

            // Define la ruta para la pantalla de resumen del pedido.
            composable(route = LunchTrayScreen.Checkout.name) {
                CheckoutScreen(
                    orderUiState = uiState, // Pasa el estado actual del pedido.
                    onCancelButtonClicked = {
                        viewModel.resetOrder() // Reinicia el pedido.
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        viewModel.resetOrder() // Reinicia el pedido.
                        // Vuelve a la pantalla de inicio después de finalizar el pedido.
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState()) // Permite el desplazamiento vertical.
                        .padding(
                            start = dimensionResource(R.dimen.padding_medium),// Padding inicial.
                            end = dimensionResource(R.dimen.padding_medium),// Padding final.
                        )
                )
            }
        }
    }
}
