package com.example.ak_cap13_14_16

//Referencias de funciones

// Definición de la función que se va a referenciar
fun addTwo(x: Int) = x + 2

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    // Usando la referencia de la función addTwo
    val result = numbers.map(::addTwo)
    println(result)  // Output: [3, 4, 5, 6]
}
