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

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.reply.R
import com.example.reply.data.Email
import com.example.reply.data.MailboxType

// Composable que representa la pantalla de detalles de un correo electrónico.
@Composable
fun ReplyDetailsScreen(
    replyUiState: ReplyUiState, // El estado actual de la UI de la aplicación Reply.
    onBackPressed: () -> Unit, // Función de lambda que se invoca cuando se presiona el botón de retroceso.
    modifier: Modifier = Modifier, // Modificador opcional para aplicar al composable.
    isFullScreen: Boolean = false // Indica si la pantalla se muestra en modo de pantalla completa.
) {
    // Maneja el botón de retroceso del sistema, invocando onBackPressed.
    BackHandler {
        onBackPressed()
    }
    Box(modifier = modifier) {
        LazyColumn(
            // Relleno de contenido para tener en cuenta la barra de estado y otros insets seguros.
            contentPadding = PaddingValues(
                top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding(),
            ),
            modifier = Modifier
                .testTag(stringResource(R.string.details_screen)) // Añade una etiqueta para pruebas.
                .fillMaxSize() // Ocupa todo el tamaño disponible.
                .background(color = MaterialTheme.colorScheme.inverseOnSurface) // Color de fondo del LazyColumn.
        ) {
            item {
                // Muestra la barra superior de detalles solo si la pantalla está en modo de pantalla completa.
                if (isFullScreen) {
                    ReplyDetailsScreenTopBar(
                        onBackPressed, // Callback para el botón de retroceso.
                        replyUiState, // Estado de la UI.
                        Modifier
                            .fillMaxWidth() // Ocupa todo el ancho.
                            .padding( // Relleno de la barra superior.
                                bottom = dimensionResource(R.dimen.detail_topbar_padding_bottom),
                                top = dimensionResource(R.dimen.topbar_padding_vertical)
                            )
                    )
                }
                // Muestra la tarjeta de detalles del correo electrónico.
                ReplyEmailDetailsCard(
                    email = replyUiState.currentSelectedEmail, // Correo electrónico seleccionado actualmente.
                    mailboxType = replyUiState.currentMailbox, // Tipo de buzón actual.
                    isFullScreen = isFullScreen, // Indica si la pantalla está en modo de pantalla completa.
                    modifier = if (isFullScreen) {
                        Modifier.padding(horizontal = dimensionResource(R.dimen.detail_card_outer_padding_horizontal))
                    } else {
                        Modifier
                    }
                )
            }
        }
    }
}

// Composable para la barra superior de la pantalla de detalles.
@Composable
private fun ReplyDetailsScreenTopBar(
    onBackButtonClicked: () -> Unit, // Función de lambda para el clic del botón de retroceso.
    replyUiState: ReplyUiState, // Estado de la UI.
    modifier: Modifier = Modifier // Modificador opcional para el diseño.
) {
    Row(
        modifier = modifier, // Aplica el modificador a la fila.
        verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente los elementos al centro.
    ) {
        IconButton(
            onClick = onBackButtonClicked, // Define la acción al hacer clic en el botón.
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.detail_topbar_back_button_padding_horizontal)) // Relleno horizontal.
                .background(MaterialTheme.colorScheme.surface, shape = CircleShape), // Fondo circular.
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack, // Icono de flecha hacia atrás.
                contentDescription = stringResource(id = R.string.navigation_back) // Descripción de contenido para accesibilidad.
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center, // Centra horizontalmente los elementos.
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho disponible.
                .padding(end = dimensionResource(R.dimen.detail_subject_padding_end)) // Relleno al final.
        ) {
            Text(
                text = stringResource(replyUiState.currentSelectedEmail.subject), // Muestra el asunto del correo.
                style = MaterialTheme.typography.titleMedium, // Estilo de texto.
                color = MaterialTheme.colorScheme.onSurfaceVariant // Color del texto.
            )
        }
    }
}

// Composable para la tarjeta que muestra los detalles del correo electrónico.
@Composable
private fun ReplyEmailDetailsCard(
    email: Email, // El objeto Email con los detalles a mostrar.
    mailboxType: MailboxType, // El tipo de buzón al que pertenece el correo.
    modifier: Modifier = Modifier, // Modificador opcional para el diseño.
    isFullScreen: Boolean = false // Indica si la tarjeta se muestra en modo de pantalla completa.
) {
    val context = LocalContext.current // Obtiene el contexto de Android.
    // Define una función de lambda para mostrar un Toast.
    val displayToast = { text: String ->
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
    Card(
        modifier = modifier, // Aplica el modificador a la tarjeta.
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface) // Colores de la tarjeta.
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho disponible.
                .padding(dimensionResource(R.dimen.detail_card_inner_padding)) // Relleno interno de la tarjeta.
        ) {
            // Cabecera de la pantalla de detalles con información del remitente.
            DetailsScreenHeader(
                email,
                Modifier.fillMaxWidth() // Ocupa todo el ancho.
            )
            // Muestra el asunto del correo de manera diferente según si está en pantalla completa o no.
            if (isFullScreen) {
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.detail_content_padding_top))) // Espacio superior.
            } else {
                Text(
                    text = stringResource(email.subject), // Asunto del correo.
                    style = MaterialTheme.typography.bodyMedium, // Estilo de texto.
                    color = MaterialTheme.colorScheme.outline, // Color del texto.
                    modifier = Modifier.padding( // Relleno del asunto.
                        top = dimensionResource(R.dimen.detail_content_padding_top),
                        bottom = dimensionResource(R.dimen.detail_expanded_subject_body_spacing)
                    ),
                )
            }
            Text(
                text = stringResource(email.body), // Cuerpo del correo.
                style = MaterialTheme.typography.bodyLarge, // Estilo de texto.
                color = MaterialTheme.colorScheme.onSurfaceVariant, // Color del texto.
            )
            // Barra de botones de acción basada en el tipo de buzón.
            DetailsScreenButtonBar(mailboxType, displayToast)
        }
    }
}

// Composable para la barra de botones de acción en la pantalla de detalles.
@Composable
private fun DetailsScreenButtonBar(
    mailboxType: MailboxType, // El tipo de buzón para determinar qué botones mostrar.
    displayToast: (String) -> Unit, // Función de lambda para mostrar un Toast.
    modifier: Modifier = Modifier // Modificador opcional para el diseño.
) {
    Box(modifier = modifier) {
        // Muestra botones diferentes según el tipo de buzón.
        when (mailboxType) {
            MailboxType.Drafts -> // Si es un borrador.
                ActionButton(
                    text = stringResource(id = R.string.continue_composing), // Botón "Continuar redactando".
                    onButtonClicked = displayToast // Al hacer clic, muestra un Toast.
                )

            MailboxType.Spam -> // Si es spam.
                Row(
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa todo el ancho.
                        .padding(
                            vertical = dimensionResource(R.dimen.detail_button_bar_padding_vertical)
                        ), // Relleno vertical.
                    horizontalArrangement = Arrangement.spacedBy( // Espacio horizontal entre botones.
                        dimensionResource(R.dimen.detail_button_bar_item_spacing)
                    ),
                ) {
                    ActionButton(
                        text = stringResource(id = R.string.move_to_inbox), // Botón "Mover a bandeja de entrada".
                        onButtonClicked = displayToast, // Al hacer clic, muestra un Toast.
                        modifier = Modifier.weight(1f) // Pesa para ocupar el espacio disponible.
                    )
                    ActionButton(
                        text = stringResource(id = R.string.delete), // Botón "Eliminar".
                        onButtonClicked = displayToast, // Al hacer clic, muestra un Toast.
                        containIrreversibleAction = true, // Indica que es una acción irreversible (para cambiar el color).
                        modifier = Modifier.weight(1f) // Pesa para ocupar el espacio disponible.
                    )
                }

            MailboxType.Sent, MailboxType.Inbox -> // Si es enviado o bandeja de entrada.
                Row(
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa todo el ancho.
                        .padding(
                            vertical = dimensionResource(R.dimen.detail_button_bar_padding_vertical)
                        ), // Relleno vertical.
                    horizontalArrangement = Arrangement.spacedBy( // Espacio horizontal entre botones.
                        dimensionResource(R.dimen.detail_button_bar_item_spacing)
                    ),
                ) {
                    ActionButton(
                        text = stringResource(id = R.string.reply), // Botón "Responder".
                        onButtonClicked = displayToast, // Al hacer clic, muestra un Toast.
                        modifier = Modifier.weight(1f) // Pesa para ocupar el espacio disponible.
                    )
                    ActionButton(
                        text = stringResource(id = R.string.reply_all), // Botón "Responder a todos".
                        onButtonClicked = displayToast, // Al hacer clic, muestra un Toast.
                        modifier = Modifier.weight(1f) // Pesa para ocupar el espacio disponible.
                    )
                }
        }
    }
}

// Composable para la cabecera de la pantalla de detalles (información del remitente).
@Composable
private fun DetailsScreenHeader(email: Email, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        ReplyProfileImage(
            drawableResource = email.sender.avatar, // Recurso drawable de la imagen de perfil del remitente.
            description = stringResource(email.sender.firstName) + " "
                    + stringResource(email.sender.lastName), // Descripción de contenido (nombre completo).
            modifier = Modifier.size( // Tamaño de la imagen de perfil.
                dimensionResource(R.dimen.email_header_profile_size)
            )
        )
        Column(
            modifier = Modifier
                .weight(1f) // Pesa para ocupar el espacio restante.
                .padding( // Relleno de la columna.
                    horizontal = dimensionResource(R.dimen.email_header_content_padding_horizontal),
                    vertical = dimensionResource(R.dimen.email_header_content_padding_vertical)
                ),
            verticalArrangement = Arrangement.Center // Centra los elementos verticalmente.
        ) {
            Text(
                text = stringResource(email.sender.firstName), // Nombre del remitente.
                style = MaterialTheme.typography.labelMedium // Estilo de texto.
            )
            Text(
                text = stringResource(email.createdAt), // Fecha de creación del correo.
                style = MaterialTheme.typography.labelMedium, // Estilo de texto.
                color = MaterialTheme.colorScheme.outline // Color del texto.
            )
        }
    }
}

// Composable para un botón de acción genérico.
@Composable
private fun ActionButton(
    text: String, // El texto a mostrar en el botón.
    onButtonClicked: (String) -> Unit, // Función de lambda que se invoca al hacer clic en el botón, pasando el texto del botón.
    modifier: Modifier = Modifier, // Modificador opcional para el diseño.
    containIrreversibleAction: Boolean = false, // Indica si la acción es irreversible (para cambiar el color del botón).
) {
    Box(modifier = modifier) {
        Button(
            onClick = { onButtonClicked(text) }, // Define la acción al hacer clic en el botón.
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho disponible.
                .padding(vertical = dimensionResource(R.dimen.detail_action_button_padding_vertical)), // Relleno vertical del botón.
            colors = ButtonDefaults.buttonColors( // Colores del botón.
                containerColor =
                if (containIrreversibleAction) { // Si la acción es irreversible, usa onErrorContainer.
                    MaterialTheme.colorScheme.onErrorContainer
                } else { // De lo contrario, usa primaryContainer.
                    MaterialTheme.colorScheme.primaryContainer
                }
            )
        ) {
            Text(
                text = text, // Texto del botón.
                color = if (containIrreversibleAction) { // Si la acción es irreversible, usa onError.
                    MaterialTheme.colorScheme.onError
                } else { // De lo contrario, usa onSurfaceVariant.
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
    }
}
