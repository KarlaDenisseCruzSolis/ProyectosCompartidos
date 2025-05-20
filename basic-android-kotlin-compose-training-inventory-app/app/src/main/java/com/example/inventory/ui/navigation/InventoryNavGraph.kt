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

package com.example.inventory.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.inventory.ui.home.HomeDestination
import com.example.inventory.ui.home.HomeScreen
import com.example.inventory.ui.item.ItemDetailsDestination
import com.example.inventory.ui.item.ItemDetailsScreen
import com.example.inventory.ui.item.ItemEditDestination
import com.example.inventory.ui.item.ItemEditScreen
import com.example.inventory.ui.item.ItemEntryDestination
import com.example.inventory.ui.item.ItemEntryScreen

/**
 * Proporciona el grafo de navegación para la aplicación.
 */
@Composable
fun InventoryNavHost(
    navController: NavHostController, // El controlador de navegación para manejar las operaciones de navegación.
    modifier: Modifier = Modifier, // Un modificador para aplicar al NavHost.
) {
    NavHost(
        navController = navController, // Asocia el NavHost con el NavController.
        startDestination = HomeDestination.route, // Define la ruta inicial al cargar el NavHost.
        modifier = modifier // Aplica el modificador al NavHost.
    ) {
        // Define el destino para la ruta de la pantalla de inicio.
        composable(route = HomeDestination.route) {
            HomeScreen(
                // Callback para navegar a la pantalla de entrada de un nuevo ítem.
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                // Callback para navegar a la pantalla de actualización de un ítem existente.
                navigateToItemUpdate = {
                    navController.navigate("${ItemDetailsDestination.route}/${it}")
                }
            )
        }
        // Define el destino para la ruta de la pantalla de entrada de un nuevo ítem.
        composable(route = ItemEntryDestination.route) {
            ItemEntryScreen(
                // Callback para regresar a la pila de navegación anterior.
                navigateBack = { navController.popBackStack() },
                // Callback para navegar hacia arriba en la jerarquía de navegación.
                onNavigateUp = { navController.navigateUp() }
            )
        }
        // Define el destino para la ruta de la pantalla de detalles del ítem, incluyendo argumentos.
        composable(
            route = ItemDetailsDestination.routeWithArgs, // La ruta que incluye el marcador de posición para el argumento.
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType // Especifica que el argumento es de tipo entero.
            })
        ) {
            ItemDetailsScreen(
                // Callback para navegar a la pantalla de edición de un ítem específico.
                navigateToEditItem = { navController.navigate("${ItemEditDestination.route}/$it") },
                // Callback para navegar hacia atrás en la pila de navegación.
                navigateBack = { navController.navigateUp() }
            )
        }
        // Define el destino para la ruta de la pantalla de edición del ítem, incluyendo argumentos.
        composable(
            route = ItemEditDestination.routeWithArgs, // La ruta que incluye el marcador de posición para el argumento.
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType // Especifica que el argumento es de tipo entero.
            })
        ) {
            ItemEditScreen(
                // Callback para regresar a la pila de navegación anterior.
                navigateBack = { navController.popBackStack() },
                // Callback para navegar hacia arriba en la jerarquía de navegación.
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}
