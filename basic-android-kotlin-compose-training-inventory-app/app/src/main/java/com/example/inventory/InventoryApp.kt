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

package com.example.inventory

import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventory.R.string
import com.example.inventory.ui.navigation.InventoryNavHo

/**
 * Top level composable that represents screens for the application.
 * (Función composable de nivel superior que representa las pantallas de la aplicación)
 */
@Composable
fun InventoryApp(navController: NavHostController = rememberNavController()) {
    InventoryNavHost(navController = navController) // Llama a la función que maneja la navegación dentro de la app
}

/**
 * App bar to display title and conditionally display the back navigation.
 * (Barra de aplicación para mostrar el título y la navegación hacia atrás opcionalmente)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryTopAppBar(
    title: String,
    canNavigateBack: Boolean,// Flag para determinar si se puede navegar hacia atrás
    modifier: Modifier = Modifier, // Modificador opcional para personalizar la barra
    scrollBehavior: TopAppBarScrollBehavior? = null, // Comportamiento de desplazamiento de la barra de app
    navigateUp: () -> Unit = {} // Función para manejar la acción de navegar hacia atrás
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {// Define un ícono de navegación
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(// Define el ícono de la flecha hacia atrás
                        imageVector = Filled.ArrowBack,
                        contentDescription = stringResource(string.back_button)
                    )
                }
            }
        }
    )
}
