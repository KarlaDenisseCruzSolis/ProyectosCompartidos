package com.example.ak_29_al_33

//Filtrando una lista
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    // Filtrar números pares
    val even = list.filter { it % 2 == 0 }
    println(even) // Imprime: [2, 4, 6]
}
