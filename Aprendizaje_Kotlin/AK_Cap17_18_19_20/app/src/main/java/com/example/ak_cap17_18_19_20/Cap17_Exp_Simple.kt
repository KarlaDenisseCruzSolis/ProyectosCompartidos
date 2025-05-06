package com.example.ak_cap17_18_19_20

// Función con tipo de retorno explícito
fun doubleExplicit(x: Int): Int = x * 2

// Función con tipo inferido
fun doubleInferred(x: Int) = x * 2

fun main() {
    println("Doble explicito: ${doubleExplicit(4)}") // Output: 8
    println("Doble inferido: ${doubleInferred(5)}")  // Output: 10
}
