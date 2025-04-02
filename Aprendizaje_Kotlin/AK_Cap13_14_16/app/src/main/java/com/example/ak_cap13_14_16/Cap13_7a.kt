package com.example.ak_cap13_14_16

// 7a - Asigne nombres, únase junto con delimitador
data class Persona3(val name: String, val age: Int)

fun main() {
    val persons = listOf(
        Persona3("Max", 33),
        Persona3("Peter", 23),
        Persona3("Pamela", 18),
        Persona3("David", 10)
    )

    val names = persons.map { it.name.toUpperCase() }.joinToString(" | ")

    println(names)
    // Output: MAX | PETER | PAMELA | DAVID
}
