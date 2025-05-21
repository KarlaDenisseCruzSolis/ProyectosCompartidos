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

import androidx.lifecycle.ViewModel
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.model.MenuItem.EntreeItem
import com.example.lunchtray.model.MenuItem.SideDishItem
import com.example.lunchtray.model.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

/**
 * [OrderViewModel] es un ViewModel que gestiona el estado de un pedido en la aplicación Lunch Tray.
 * Contiene la lógica para actualizar los elementos del menú seleccionados, calcular los precios y reiniciar el pedido.
 */
class OrderViewModel : ViewModel() {

    // Define la tasa de impuestos que se aplicará al total del pedido.
    private val taxRate = 0.08

    // Estado de la interfaz de usuario del pedido, representado por un MutableStateFlow.
    // Los cambios en este StateFlow activarán recomposiciones en la UI.
    private val _uiState = MutableStateFlow(OrderUiState())
    // Exposición inmutable del estado de la UI para que los Componibles solo puedan leerlo.
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    /**
     * Actualiza el plato principal seleccionado en el pedido.
     * @param entree El [EntreeItem] recién seleccionado.
     */
    fun updateEntree(entree: EntreeItem) {
        val previousEntree = _uiState.value.entree // Obtiene el plato principal previamente seleccionado.
        updateItem(entree, previousEntree) // Llama a la función genérica para actualizar el elemento.
    }

    /**
     * Actualiza la guarnición seleccionada en el pedido.
     * @param sideDish El [SideDishItem] recién seleccionado.
     */
    fun updateSideDish(sideDish: SideDishItem) {
        val previousSideDish = _uiState.value.sideDish // Obtiene la guarnición previamente seleccionada.
        updateItem(sideDish, previousSideDish) // Llama a la función genérica para actualizar el elemento.
    }

    /**
     * Actualiza el aderezo seleccionado en el pedido.
     * @param accompaniment El [AccompanimentItem] recién seleccionado.
     */
    fun updateAccompaniment(accompaniment: AccompanimentItem) {
        val previousAccompaniment = _uiState.value.accompaniment // Obtiene el aderezo previamente seleccionado.
        updateItem(accompaniment, previousAccompaniment) // Llama a la función genérica para actualizar el elemento.
    }

    /**
     * Reinicia el pedido a su estado inicial, borrando todas las selecciones y restableciendo los precios a cero.
     */
    fun resetOrder() {
        _uiState.value = OrderUiState() // Asigna una nueva instancia de OrderUiState para reiniciar el estado.
    }

    /**
     * Función privada genérica para actualizar un elemento del menú en el estado del pedido.
     * Calcula el nuevo precio total de los artículos y el impuesto.
     *
     * @param newItem El nuevo [MenuItem] seleccionado.
     * @param previousItem El [MenuItem] previamente seleccionado de la misma categoría, o nulo si no había uno.
     */
    private fun updateItem(newItem: MenuItem, previousItem: MenuItem?) {
        _uiState.update { currentState -> // Actualiza el estado actual del flujo.
            val previousItemPrice = previousItem?.price ?: 0.0 // Obtiene el precio del elemento anterior (0.0 si es nulo).
            // Resta el precio del elemento anterior en caso de que ya se haya añadido un elemento de esta categoría.
            // Luego, suma el precio del nuevo elemento.
            val itemTotalPrice = currentState.itemTotalPrice - previousItemPrice + newItem.price
            // Recalcula el impuesto en base al nuevo precio total de los artículos.
            val tax = itemTotalPrice * taxRate
            // Crea una copia del estado actual con los valores actualizados.
            currentState.copy(
                itemTotalPrice = itemTotalPrice, // Actualiza el precio total de los artículos.
                orderTax = tax, // Actualiza el impuesto del pedido.
                orderTotalPrice = itemTotalPrice + tax, // Actualiza el precio total del pedido (artículos + impuesto).
                // Actualiza el elemento específico (plato principal, guarnición o aderezo)
                // basándose en el tipo del `newItem`.
                entree = if (newItem is EntreeItem) newItem else currentState.entree,
                sideDish = if (newItem is SideDishItem) newItem else currentState.sideDish,
                accompaniment =
                if (newItem is AccompanimentItem) newItem else currentState.accompaniment
            )
        }
    }
}

/**
 * Extensión de función para formatear un [Double] como una cadena de precio con formato de moneda.
 *
 * @return Una cadena que representa el precio formateado según la configuración regional predeterminada.
 */
fun Double.formatPrice(): String {
    return NumberFormat.getCurrencyInstance().format(this) // Utiliza NumberFormat para formatear el número como moneda.
}