package com.example.ak_cap13_14_16

// Funciones que toman otras funciones (Funciones de orden superior)

// Función que acepta una lambda como parámetro y la ejecuta dos veces
fun twice(x: () -> Any?) {
    x()  // Ejecuta la función lambda
    x()  // Vuelve a ejecutar la función lambda
}

fun main() {
    // Llamada a la función 'twice' pasando una lambda
    twice {
        println("Foo")  // Imprime "Foo" dos veces
    }
}
