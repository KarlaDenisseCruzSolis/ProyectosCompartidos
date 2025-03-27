package com.example.ak_cap11_12

// Definimos una enumeración mutable para Planet con una propiedad de población
enum class Planet(var population: Int = 0) {
    EARTH(7 * 100000000),  // Población de la Tierra
    MARS();  // Población de Marte inicialmente es 0

    // Sobreescribimos el método toString para personalizar cómo se imprime
    override fun toString() = "$name[population=$population]"
}

fun main() {
    // Imprimimos el valor inicial de MARS
    println(Planet.MARS) // MARS[population=0]

    // Modificamos la población de Marte
    Planet.MARS.population = 3

    // Imprimimos el valor actualizado de MARS
    println(Planet.MARS) // MARS[population=3]
}
