package com.example.ak_cap21_22_23_24

fun main() {
    // Declaración de variables
    val finalValue: Int = 42        // Inmutable (como final en Java)
    var mutableValue = 100          // Mutable con inferencia de tipo

    println("Final: $finalValue, Mutable: $mutableValue")

    // Kotlin es null-safe
    var name: String? = null
    println("Longitud del nombre (seguro para nulos): ${name?.length ?: "desconocido"}")

    // Igualdad e identidad
    val a = "Hola"
    val b = "Hola"
    val c = a

    println("a == b: ${a == b}")     // Igualdad de contenido
    println("a === b: ${a === b}")   // Identidad de referencia
    println("a === c: ${a === c}")   // Mismo objeto

    // Expresiones if y try
    val edad = 20
    val mensaje = if (edad >= 18) "Mayor de edad" else "Menor de edad"
    println(mensaje)

    val resultado = try {
        "123".toInt()
    } catch (e: Exception) {
        0
    }
    println("Resultado del try: $resultado")

    // Creación de objeto sin 'new'
    val persona = Persona("Karla", 22)
    println("Nombre: ${persona.nombre}, Edad: ${persona.edad}")

    // Data class con equals y hashCode automáticos
    val persona2 = Persona("Karla", 22)
    println("Son iguales?: ${persona == persona2}") // true

    // Acceso a mapa con operador []
    val mapa = mapOf("clave" to "valor")
    println("Valor en mapa['clave']: ${mapa["clave"]}")
}

// Data class (con equals/hashCode/toString automáticos)
data class Persona(val nombre: String, val edad: Int)
