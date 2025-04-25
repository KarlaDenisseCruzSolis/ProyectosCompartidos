package com.example.ak_34_al_38

fun main() {
    // Tipos anulables y no anulables
    var string: String = "Hello World!"
    var nullableString: String? = null
    // string = nullableString  // Error: no se puede asignar nullable a no nullable
    nullableString = string  // Esto sí funciona

    // Operador de llamada segura
    val nullableStr: String? = "Hello World!"
    println(nullableStr?.length)  // Imprime la longitud de la cadena o "null" si es nulo

    // Llamar a múltiples métodos con apply
    nullableStr?.apply {
        println(length)
        println(toUpperCase())
    }

    // Uso de let para convertir a no nullable dentro de un bloque
    nullableStr?.let { notNull ->
        println(notNull.length)
        println(notNull.toUpperCase())
    }

    // Moldes inteligentes
    var str: String? = "Hello!"
    if (str != null) {
        println(str.length)  // Funciona, ya que Kotlin sabe que str no es nulo
    }

    // Eliminar nulos de una lista
    val a: List<Int?> = listOf(1, 2, 3, null)
    val filteredList: List<Int> = a.filterNotNull()  // Elimina los nulos de la lista
    println(filteredList)  // Imprime [1, 2, 3]

    // Elvis Operator (Null Coalescing)
    val value: String = nullableStr?.takeIf { it.length > 5 } ?: "Nothing here."
    println(value)  // Imprime el valor o "Nothing here." si es nulo

    // Lanzando excepción usando el operador Elvis
    val result: String = nullableStr?.takeIf { it.length > 5 }
        ?: throw IllegalArgumentException("Value can't be null!")
    println(result)

    // Operador de aserción !!
    val message: String? = null
    try {
        println(message ?: "Mensaje es nulo")  // Imprime "Mensaje es nulo" si message es nulo
    } catch (e: KotlinNullPointerException) {
        println("Error: $e")
    }

    // Uso del operador Elvis para verificación de null
    val nullableLength = nullableStr?.length ?: -1  // Si nullableStr es nulo, se asigna -1
    println(nullableLength)
}
