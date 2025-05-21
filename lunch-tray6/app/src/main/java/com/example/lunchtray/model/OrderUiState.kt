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
package com.example.lunchtray.model

/**
 * Clase de datos que representa el estado de la interfaz de usuario del pedido.
 *
 * Esta clase contiene los elementos seleccionados por el usuario para su pedido,
 * así como los cálculos de precios asociados.
 *
 * @property entree El [MenuItem.EntreeItem] seleccionado como plato principal. Es nulo si no se ha seleccionado ninguno.
 * @property sideDish El [MenuItem.SideDishItem] seleccionado como guarnición. Es nulo si no se ha seleccionado ninguno.
 * @property accompaniment El [MenuItem.AccompanimentItem] seleccionado como aderezo. Es nulo si no se ha seleccionado ninguno.
 * @property itemTotalPrice El precio total de los elementos seleccionados antes de impuestos. Se inicializa en 0.0.
 * @property orderTax El monto del impuesto calculado para el pedido. Se inicializa en 0.0.
 * @property orderTotalPrice El precio total del pedido, incluyendo impuestos. Se inicializa en 0.0.
 */
data class OrderUiState(
    // Selección del plato principal
    // Entree Selection
    val entree: MenuItem.EntreeItem? = null,
    // Selección de la guarnición
    val sideDish: MenuItem.SideDishItem? = null,
    // Selección del aderezo
    val accompaniment: MenuItem.AccompanimentItem? = null,
    val itemTotalPrice: Double = 0.0,
    val orderTax: Double = 0.0,
    val orderTotalPrice: Double = 0.0
)
