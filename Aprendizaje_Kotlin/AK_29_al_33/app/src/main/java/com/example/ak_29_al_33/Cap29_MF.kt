package com.example.ak_29_al_33

//Métodos fluidos en Kotlin
fun <T: Any> T.fluently(func: () -> Unit): T {
    func()
    return this
}

fun someOtherAction() {
    println("Some other action executed!")
}

fun main() {
    // Llamar a un metodo fluido que ejecuta una acción adicional
    "Test String".fluently {
        someOtherAction() // Llama a la acción adicional
    }
}
