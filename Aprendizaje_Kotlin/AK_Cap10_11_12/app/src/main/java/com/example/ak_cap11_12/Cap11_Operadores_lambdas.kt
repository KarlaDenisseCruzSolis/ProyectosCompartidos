package com.example.ak_cap11_12
import kotlin.random.Random

val r = Random(233)

// Función de extensión para el operador rem
infix inline operator fun Int.rem(block: () -> Unit) {
    // Genera un número aleatorio entre 0 y 99
    if (r.nextInt(100) < this) {
        block() // Ejecuta el bloque si la condición se cumple
    }
}

// Ejemplo de uso
fun main() {
    80 % { //cambié de 20 a 80
        println("The possibility you see this message is 80%") //cambié de 20 a 80
    }
}

