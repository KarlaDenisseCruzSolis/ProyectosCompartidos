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
package com.example.cupcake

import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.data.DataSource
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.ui.OrderViewModel
import com.example.cupcake.ui.SelectOptionScreen
import com.example.cupcake.ui.StartOrderScreen

/**
 * enum values that represent the screens in the app
 */
enum class CupcakeScreen(@StringRes val title: Int) {  // Enum con las pantallas de la app, con título asociado como recurso string
    Start(title = R.string.app_name),  // Pantalla inicio
    Flavor(title = R.string.choose_flavor),  // Selección de sabor
    Pickup(title = R.string.choose_pickup_date),  // Selección fecha recogida
    Summary(title = R.string.order_summary)  // Resumen del pedido
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun CupcakeAppBar(
    currentScreen: CupcakeScreen,  // Pantalla actual para mostrar título
    canNavigateBack: Boolean,  // Indica si se puede navegar atrás
    navigateUp: () -> Unit,  // Acción para navegar atrás
    modifier: Modifier = Modifier  // Modificador opcional para el componente
) {
    TopAppBar(  // Barra superior con título y botón atrás condicional
        title = { Text(stringResource(currentScreen.title)) },  // Muestra el título de la pantalla
        colors = TopAppBarDefaults.mediumTopAppBarColors(  // Colores para la barra superior
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,  // Aplica modificadores recibidos
        navigationIcon = {  // Ícono para navegación atrás
            if (canNavigateBack) {  // Si es posible navegar atrás
                IconButton(onClick = navigateUp) {  // Botón con función para volver atrás
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,  // Icono de flecha hacia atrás
                        contentDescription = stringResource(R.string.back_button)  // Descripción para accesibilidad
                    )
                }
            }
        }
    )
}

@Composable
fun CupcakeApp(
    viewModel: OrderViewModel = viewModel(),  // Obtiene el ViewModel para manejar estado del pedido
    navController: NavHostController = rememberNavController()  // Controlador de navegación recordado
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()  // Observa la entrada actual en la pila de navegación
    // Get the name of the current screen
    val currentScreen = CupcakeScreen.valueOf(
        backStackEntry?.destination?.route ?: CupcakeScreen.Start.name  // Obtiene la ruta actual o la de inicio si es nula
    )

    Scaffold(  // Estructura base de UI con topBar
        topBar = {
            CupcakeAppBar(
                currentScreen = currentScreen,  // Muestra barra con título de pantalla actual
                canNavigateBack = navController.previousBackStackEntry != null,  // Si hay pantalla anterior para poder regresar
                navigateUp = { navController.navigateUp() }  // Acción para navegar atrás en la pila
            )
        }
    ) { innerPadding ->  // Contenido de la pantalla con padding interno
        val uiState by viewModel.uiState.collectAsState()  // Obtiene el estado UI del pedido como estado Compose

        NavHost(
            navController = navController,  // Controlador de navegación
            startDestination = CupcakeScreen.Start.name,  // Pantalla de inicio
            modifier = Modifier
                .fillMaxSize()  // Ocupa todo el espacio disponible
                .verticalScroll(rememberScrollState())  // Permite scroll vertical
                .padding(innerPadding)  // Aplica padding proporcionado por Scaffold
        ) {
            composable(route = CupcakeScreen.Start.name) {  // Destino Start
                StartOrderScreen(
                    quantityOptions = DataSource.quantityOptions,  // Opciones para cantidad de cupcakes
                    onNextButtonClicked = {  // Acción al dar siguiente
                        viewModel.setQuantity(it)  // Actualiza cantidad en ViewModel
                        navController.navigate(CupcakeScreen.Flavor.name)  // Navega a pantalla de selección de sabor
                    },
                    modifier = Modifier
                        .fillMaxSize()  // Ocupa todo el espacio
                        .padding(dimensionResource(R.dimen.padding_medium))  // Aplica padding
                )
            }
            composable(route = CupcakeScreen.Flavor.name) {  // Destino Flavor
                val context = LocalContext.current  // Contexto local para recursos
                SelectOptionScreen(
                    subtotal = uiState.price,  // Muestra subtotal del precio
                    onNextButtonClicked = { navController.navigate(CupcakeScreen.Pickup.name) },  // Navega a Pickup
                    onCancelButtonClicked = {  // Cancela pedido y vuelve a inicio
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    options = DataSource.flavors.map { id -> context.resources.getString(id) },  // Lista de sabores como strings
                    onSelectionChanged = { viewModel.setFlavor(it) },  // Actualiza sabor en ViewModel
                    modifier = Modifier.fillMaxHeight()  // Ocupa altura completa
                )
            }
            composable(route = CupcakeScreen.Pickup.name) {  // Destino Pickup
                SelectOptionScreen(
                    subtotal = uiState.price,  // Muestra subtotal precio
                    onNextButtonClicked = { navController.navigate(CupcakeScreen.Summary.name) },  // Navega a resumen
                    onCancelButtonClicked = {  // Cancela pedido y vuelve a inicio
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    options = uiState.pickupOptions,  // Opciones para fecha recogida
                    onSelectionChanged = { viewModel.setDate(it) },  // Actualiza fecha en ViewModel
                    modifier = Modifier.fillMaxHeight()  // Ocupa altura completa
                )
            }
            composable(route = CupcakeScreen.Summary.name) {  // Destino Summary
                val context = LocalContext.current  // Contexto local
                OrderSummaryScreen(
                    orderUiState = uiState,  // Estado UI completo del pedido
                    onCancelButtonClicked = {  // Cancela y vuelve a inicio
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    onSendButtonClicked = { subject: String, summary: String ->  // Acción para compartir pedido
                        shareOrder(context, subject = subject, summary = summary)
                    },
                    modifier = Modifier.fillMaxHeight()  // Ocupa altura completa
                )
            }
        }
    }
}

/**
 * Resets the [OrderUiState] and pops up to [CupcakeScreen.Start]
 */
private fun cancelOrderAndNavigateToStart(
    viewModel: OrderViewModel,  // ViewModel para resetear estado
    navController: NavHostController  // Controlador para navegación
) {
    viewModel.resetOrder()  // Resetea el pedido a estado inicial
    navController.popBackStack(CupcakeScreen.Start.name, inclusive = false)  // Navega a la pantalla de inicio sin eliminarla de la pila
}

/**
 * Creates an intent to share order details
 */
private fun shareOrder(context: Context, subject: String, summary: String) {
    // Create an ACTION_SEND implicit intent with order details in the intent extras
    val intent = Intent(Intent.ACTION_SEND).apply {  // Intent para compartir texto
        type = "text/plain"  // Tipo de contenido a compartir
        putExtra(Intent.EXTRA_SUBJECT, subject)  // Asunto del mensaje
        putExtra(Intent.EXTRA_TEXT, summary)  // Texto del mensaje
    }
    context.startActivity(  // Lanza selector de apps para compartir el pedido
        Intent.createChooser(
            intent,
            context.getString(R.string.new_cupcake_order)  // Título para el chooser
        )
    )
}
