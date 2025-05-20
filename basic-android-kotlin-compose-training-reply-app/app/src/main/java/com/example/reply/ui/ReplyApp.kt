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
package com.example.reply.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.ui.utils.ReplyContentType
import com.example.reply.ui.utils.ReplyNavigationType

// Composable principal de la aplicación Reply.
@Composable
fun ReplyApp(
    windowSize: WindowWidthSizeClass, // La clase de tamaño del ancho de la ventana, que determina el diseño adaptable.
    modifier: Modifier = Modifier, // Modificador opcional para aplicar al composable.
) {
    val navigationType: ReplyNavigationType // Variable para almacenar el tipo de navegación.
    val contentType: ReplyContentType // Variable para almacenar el tipo de contenido.
    val viewModel: ReplyViewModel = viewModel() // Obtiene una instancia del ReplyViewModel.
    // Recolecta el estado de la UI del ViewModel como un State de Compose.
    val replyUiState = viewModel.uiState.collectAsState().value

    // Lógica para determinar el tipo de navegación y contenido según el tamaño de la ventana.
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            // Para pantallas compactas (teléfonos en modo vertical).
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION // Navegación inferior.
            contentType = ReplyContentType.LIST_ONLY // Solo muestra la lista de correos.
        }
        WindowWidthSizeClass.Medium -> {
            // Para pantallas medianas (tabletas pequeñas o plegables).
            navigationType = ReplyNavigationType.NAVIGATION_RAIL // Barra de navegación lateral (rail).
            contentType = ReplyContentType.LIST_ONLY // Solo muestra la lista de correos.
        }
        WindowWidthSizeClass.Expanded -> {
            // Para pantallas expandidas (tabletas grandes o escritorios).
            navigationType = ReplyNavigationType.PERMANENT_NAVIGATION_DRAWER // Cajón de navegación permanente.
            contentType = ReplyContentType.LIST_AND_DETAIL // Muestra lista y detalles del correo.
        }
        else -> {
            // Caso por defecto, para cualquier otro tamaño no especificado.
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION // Navegación inferior.
            contentType = ReplyContentType.LIST_ONLY // Solo muestra la lista de correos.
        }
    }
    // Renderiza la pantalla principal de Reply.
    ReplyHomeScreen(
        navigationType = navigationType, // Pasa el tipo de navegación determinado.
        contentType = contentType, // Pasa el tipo de contenido determinado.
        replyUiState = replyUiState, // Pasa el estado actual de la UI.
        onTabPressed = { mailboxType: MailboxType ->
            // Callback cuando se presiona una pestaña del buzón.
            viewModel.updateCurrentMailbox(mailboxType = mailboxType) // Actualiza el buzón actual en el ViewModel.
            viewModel.resetHomeScreenStates() // Restablece los estados de la pantalla de inicio.
        },
        onEmailCardPressed = { email: Email ->
            // Callback cuando se presiona una tarjeta de correo electrónico.
            viewModel.updateDetailsScreenStates(
                email = email // Actualiza los estados de la pantalla de detalles con el correo seleccionado.
            )
        },
        onDetailScreenBackPressed = {
            // Callback cuando se presiona el botón de atrás en la pantalla de detalles.
            viewModel.resetHomeScreenStates() // Restablece los estados de la pantalla de inicio.
        },
        modifier = modifier // Aplica el modificador al composable.
    )
}