package com.example.ak_cap13_14_16

//Sobrecarga de operadores

// Sobrecargando el operador `[]` para la clase IntListWrapper
data class IntListWrapper(val wrapped: List<Int>) {
    operator fun get(position: Int): Int = wrapped[position]
}

fun main() {
    val listWrapper = IntListWrapper(listOf(1, 2, 3, 4))
    // Usando el operador sobrecargado para acceder a los elementos de la lista
    println(listWrapper[2])  // Output: 3 (Accede al tercer elemento de la lista)
}
