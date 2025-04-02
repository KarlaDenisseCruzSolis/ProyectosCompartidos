package com.example.ak_cap13_14_16

//Usando try como expresión
fun getString(): String {
    // Imagina que aquí hay alguna operación que podría fallar
    return "Texto"
}

fun main() {
    // Usamos try como una expresión para manejar excepciones
    val s: String? = try {
        getString() // Si no hay excepciones, se devuelve el valor
    } catch (e: Exception) {
        null // Si ocurre una excepción, retornamos null
    }

    // Imprime el resultado de la expresión try
    println(s) // Imprime el valor o null dependiendo si hubo una excepción
}
