package com.example.ak_cap13_14_16

//Ejemplo #6: Agrupar personas por edad, mostrar la edad y los nombres juntos
data class Persona2(val name: String, val age: Int)

fun main() {
    val persons = listOf(
        Persona2("Tod", 5),
        Persona2("Max", 33),
        Persona2("Frank", 13),
        Persona2("Peter", 80),
        Persona2("Pamela", 18)
    )

    val map = persons.groupBy { it.age }.mapValues { it.value.joinToString(";") { it.name } }

    println(map)
}
