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
package com.example.lunchtray.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.OrderUiState

/**
 * Composable que representa la pantalla de resumen del pedido.
 * Muestra un resumen de los elementos seleccionados, el subtotal, el impuesto y el total final.
 *
 * @param orderUiState El estado actual de la UI del pedido, que contiene los elementos seleccionados y los precios.
 * @param onNextButtonClicked La acción a realizar cuando se hace clic en el botón "Enviar pedido".
 * @param onCancelButtonClicked La acción a realizar cuando se hace clic en el botón "Cancelar".
 * @param modifier Modificador para aplicar a este Composable.
 */
@Composable
fun CheckoutScreen(
    orderUiState: OrderUiState,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(// Columna principal que organiza los elementos del resumen del pedido.
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        Text(// Título "Resumen del pedido".
            text = stringResource(R.string.order_summary),
            fontWeight = FontWeight.Bold
        )
        // Muestra el resumen del plato principal, si está seleccionado.
        ItemSummary(item = orderUiState.entree, modifier = Modifier.fillMaxWidth())
        // Muestra el resumen de la guarnición, si está seleccionada.
        ItemSummary(item = orderUiState.sideDish, modifier = Modifier.fillMaxWidth())
        // Muestra el resumen del aderezo, si está seleccionado.
        ItemSummary(item = orderUiState.accompaniment, modifier = Modifier.fillMaxWidth())

        Divider(// Divisor visual para separar los elementos del resumen de los costos.
            thickness = dimensionResource(R.dimen.thickness_divider),
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small))
        )

        OrderSubCost(// Muestra el subtotal del pedido.
            resourceId = R.string.subtotal,// ID del recurso de cadena para "Subtotal".
            price = orderUiState.itemTotalPrice.formatPrice(),// Precio del subtotal formateado.
            Modifier.align(Alignment.End)// Alinea el texto al final (derecha).
        )

        OrderSubCost(// Muestra el impuesto del pedido.
            resourceId = R.string.tax,// ID del recurso de cadena para "Impuesto".
            price = orderUiState.orderTax.formatPrice(),// Precio del impuesto formateado.
            Modifier.align(Alignment.End)// Alinea el texto al final (derecha).
        )

        Text(// Muestra el precio total del pedido.
            text = stringResource(R.string.total, orderUiState.orderTotalPrice.formatPrice()), // Texto del total con el precio formateado.
            modifier = Modifier.align(Alignment.End),
            fontWeight = FontWeight.Bold// Texto en negrita.
        )

        Row(// Fila que contiene los botones "Cancelar" y "Enviar pedido".
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))// Espacio entre los botones.
        ){
            // Botón con contorno para "Cancelar".
            OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
                Text(stringResource(R.string.cancel).uppercase())
            }
            Button(// Botón sólido para "Enviar pedido".
                modifier = Modifier.weight(1f),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.submit).uppercase())
            }
        }
    }
}

/**
 * Composable que muestra un resumen de un elemento del menú (nombre y precio).
 *
 * @param item El [MenuItem] a resumir. Puede ser nulo si no se ha seleccionado ningún elemento.
 * @param modifier Modificador para aplicar a este Composable.
 */
@Composable
fun ItemSummary(
    item: MenuItem?,
    modifier: Modifier = Modifier
) {
    Row(// Fila que muestra el nombre y el precio del elemento.
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Muestra el nombre del elemento o una cadena vacía si el elemento es nulo.
        Text(item?.name ?: "")
        // Muestra el precio formateado del elemento o una cadena vacía si el elemento es nulo.
        Text(item?.getFormattedPrice() ?: "")
    }
}

/**
 * Composable que muestra un costo secundario del pedido (como subtotal o impuesto).
 *
 * @param resourceId El ID del recurso de cadena para la etiqueta del costo (ej. R.string.subtotal).
 * @param price La cadena que representa el precio formateado.
 * @param modifier Modificador para aplicar a este Composable.
 */
@Composable
fun OrderSubCost(
    @StringRes resourceId: Int,
    price: String,
    modifier: Modifier = Modifier
) {
    Text(// Texto que muestra la etiqueta del costo y su valor.
        text = stringResource(resourceId, price),
        modifier = modifier
    )
}

/**
 * Vista previa del `CheckoutScreen` en el panel de diseño.
 * Muestra cómo se verá la pantalla de resumen del pedido con datos de ejemplo.
 */
@Preview
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen(
        orderUiState = OrderUiState(
            entree = DataSource.entreeMenuItems[0],// Primer plato principal como ejemplo.
            sideDish = DataSource.sideDishMenuItems[0],// Primera guarnición como ejemplo.
            accompaniment = DataSource.accompanimentMenuItems[0],// Primer aderezo como ejemplo.
            itemTotalPrice = 15.00,// Precio total de los ítems de ejemplo.
            orderTax = 1.00, // Impuesto de ejemplo.
            orderTotalPrice = 16.00// Precio total de ejemplo.
        ),
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())// Permite el desplazamiento vertical para simular contenido completo.
    )
}
