package com.example.ak_cap17_18_19_20

fun main() {
    val x = "Hola"
    val y = "Hola"
    val z = x

    println("x == y: ${x == y}")     // true, compara contenido
    println("x === y: ${x === y}")   // Puede ser true o false (depende de interning)

    println("x === z: ${x === z}")   // true, misma referencia
}
