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

import androidx.lifecycle.ViewModel
import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.data.local.LocalEmailsDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * [ReplyViewModel] es un ViewModel que gestiona el estado de la interfaz de usuario de la aplicación Reply.
 * Extiende [ViewModel] para sobrevivir a los cambios de configuración.
 */
class ReplyViewModel : ViewModel() {

    // '_uiState' es un MutableStateFlow privado que contiene el estado actual de la UI.
    // Solo puede ser modificado dentro de este ViewModel.
    private val _uiState = MutableStateFlow(ReplyUiState())

    // 'uiState' es un StateFlow público e inmutable que expone el estado de la UI a los coleccionistas.
    // Las vistas pueden observar este StateFlow para reaccionar a los cambios de estado.
    val uiState: StateFlow<ReplyUiState> = _uiState

    // Bloque de inicialización que se ejecuta cuando se crea una instancia de ReplyViewModel.
    init {
        initializeUIState() // Llama a la función para configurar el estado inicial de la UI.
    }

    /**
     * Inicializa el estado de la UI de la aplicación.
     * Agrupa todos los correos electrónicos por su tipo de buzón y establece el correo electrónico
     * seleccionado actualmente en el primer correo de la bandeja de entrada, o un correo por defecto
     * si la bandeja de entrada está vacía.
     */
    private fun initializeUIState() {
        // Agrupa todos los correos electrónicos de LocalEmailsDataProvider por su 'mailbox' (buzón).
        val mailboxes: Map<MailboxType, List<Email>> =
            LocalEmailsDataProvider.allEmails.groupBy { it.mailbox }
        // Actualiza el valor de _uiState con el mapa de buzones y el correo electrónico inicial seleccionado.
        _uiState.value =
            ReplyUiState(
                mailboxes = mailboxes,
                currentSelectedEmail = mailboxes[MailboxType.Inbox]?.get(0) // Intenta obtener el primer correo de Inbox.
                    ?: LocalEmailsDataProvider.defaultEmail // Si Inbox está vacío, usa el correo por defecto.
            )
    }

    /**
     * Actualiza el estado de la pantalla de detalles cuando se selecciona un correo electrónico.
     * Establece el [email] proporcionado como el correo electrónico seleccionado actualmente
     * y oculta la página de inicio.
     *
     * @param email El correo electrónico que se ha seleccionado para ver los detalles.
     */
    fun updateDetailsScreenStates(email: Email) {
        _uiState.update { currentState -> // Actualiza el estado actual de forma segura.
            currentState.copy( // Crea una copia del estado actual.
                currentSelectedEmail = email, // Establece el correo electrónico seleccionado.
                isShowingHomepage = false // Indica que no se está mostrando la página de inicio.
            )
        }
    }

    /**
     * Restablece el estado de la pantalla principal.
     * Vuelve a establecer el correo electrónico seleccionado en el primer correo del buzón actual
     * y muestra la página de inicio.
     */
    fun resetHomeScreenStates() {
        _uiState.update { currentState -> // Actualiza el estado actual de forma segura.
            currentState.copy( // Crea una copia del estado actual.
                currentSelectedEmail = currentState.mailboxes[currentState.currentMailbox]?.get(0) // Obtiene el primer correo del buzón actual.
                    ?: LocalEmailsDataProvider.defaultEmail, // Si el buzón actual está vacío, usa el correo por defecto.
                isShowingHomepage = true // Indica que se está mostrando la página de inicio.
            )
        }
    }

    /**
     * Actualiza el buzón actualmente seleccionado.
     * Esto cambiará la lista de correos electrónicos que se muestran en la pantalla principal.
     *
     * @param mailboxType El nuevo tipo de buzón a establecer como actual.
     */
    fun updateCurrentMailbox(mailboxType: MailboxType) {
        _uiState.update { currentState -> // Actualiza el estado actual de forma segura.
            currentState.copy( // Crea una copia del estado actual.
                currentMailbox = mailboxType // Actualiza el buzón actual.
            )
        }
    }
}
