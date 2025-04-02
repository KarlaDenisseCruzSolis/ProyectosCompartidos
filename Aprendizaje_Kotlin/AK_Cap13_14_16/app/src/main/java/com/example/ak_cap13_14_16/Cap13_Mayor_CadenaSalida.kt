package com.example.ak_cap13_14_16

// Ejemplo #5: Encontrar personas mayores de edad, una cadena con formato de salida
data class Persona(val name: String, val age: Int)

fun main() {
    val persons = listOf(
        Persona("Tod", 5),
        Persona("Max", 33),
        Persona("Frank", 13),
        Persona("Peter", 80),
        Persona("Pamela", 18)
    )

    val phrase = persons
        .filter { it.age >= 18 }
        .map { it.name }
        .joinToString(" and ", "In Germany ", " are of legal age.")

    println(phrase)
    // In Germany Max and Peter and Pamela are of legal age.
}
