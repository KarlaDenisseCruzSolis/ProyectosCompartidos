package com.example.ak_29_al_33

fun printNumbers(vararg numbers: Int) {
    for (number in numbers) {
        println(number)
    }
}

fun main() {
    // Llamada con varios parámetros directamente
    printNumbers(0, 1)                // Imprime "0" "1"
    printNumbers(10, 20, 30, 500)     // Imprime "10" "20" "30" "500"

    // Usando el operador de propagación * para pasar un array
    val numbers = intArrayOf(1, 2, 3)
    printNumbers(*numbers)            // Imprime "1" "2" "3"

    // Pasando un array con otros parámetros
    printNumbers(10, 20, *numbers, 30, 40)  // Imprime "10" "20" "1" "2" "3" "30" "40"
}
