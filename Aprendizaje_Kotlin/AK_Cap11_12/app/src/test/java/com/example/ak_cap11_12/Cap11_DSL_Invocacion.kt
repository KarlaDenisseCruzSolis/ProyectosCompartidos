package com.example.ak_cap11_12

// Clase MyExample con el operador invoke
class MyExample(val i: Int) {
    // Operador invoke que ejecuta un bloque de código en el contexto de MyExample
    operator fun <R> invoke(block: MyExample.() -> R) = block()

    // Metodo de extensión que compara el valor de un Int con i
    fun Int.bigger() = this > i
}

fun main(args: Array<String>) {
    // Crear una instancia de MyExample con el valor 233
    val ex = MyExample(233)

    // Usamos el bloque ex { ... } para ejecutar código dentro de su contexto
    ex {
        // `bigger` es accesible dentro del contexto de `ex`
        // Comprobamos si 777 es mayor que 233 y luego imprimimos un mensaje
        if (777.bigger()) {
            kotlin.io.println("why")  // Esto imprimirá "why" porque 777 es mayor que 233
        }
    }
}
