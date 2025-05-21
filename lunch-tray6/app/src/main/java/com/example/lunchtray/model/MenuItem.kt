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

import java.text.NumberFormat

/**
 * Una clase sellada [MenuItem] que representa un elemento en el menú.
 * Las clases selladas permiten definir una jerarquía de clases restringida,
 * lo que significa que todas las subclases deben ser conocidas en el momento de la compilación.
 * Esto es útil para modelar un conjunto finito de posibilidades, como los diferentes tipos de elementos del menú.
 *
 * @property name El nombre del elemento del menú.
 * @property description Una breve descripción del elemento del menú.
 * @property price El precio del elemento del menú.
 */
sealed class MenuItem(
    open val name: String,
    open val description: String,
    open val price: Double
) {
    /**
     * Clase de datos que representa un plato principal (Entree) en el menú.
     * Hereda de [MenuItem].
     *
     * @param name El nombre del plato principal.
     * @param description La descripción del plato principal.
     * @param price El precio del plato principal.
     */
    data class EntreeItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    /**
     * Clase de datos que representa una guarnición (Side Dish) en el menú.
     * Hereda de [MenuItem].
     *
     * @param name El nombre de la guarnición.
     * @param description La descripción de la guarnición.
     * @param price El precio de la guarnición.
     */
    data class SideDishItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    /**
     * Clase de datos que representa un aderezo (Accompaniment) en el menú.
     * Hereda de [MenuItem].
     *
     * @param name El nombre del aderezo.
     * @param description La descripción del aderezo.
     * @param price El precio del aderezo.
     */
    data class AccompanimentItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    /**
     * Metodo getter para el precio formateado.
     * Formatea el precio de un elemento del menú a un formato de moneda local.
     * Por ejemplo, 2.50 se puede formatear a "$2.50" o "2,50 €" dependiendo de la configuración regional.
     *
     * @return Una cadena que representa el precio formateado.
     */
    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}
