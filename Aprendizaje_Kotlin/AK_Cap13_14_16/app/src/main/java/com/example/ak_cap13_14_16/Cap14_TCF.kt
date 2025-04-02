package com.example.ak_cap13_14_16

// Captura de excepciones con try-catch-finally
class MyException(message: String) : Exception(message)

fun doSomething() {
    // Código que podría generar una excepción
    throw MyException("Algo salio mal!")
}

fun handle(e: MyException) {
    // Manejo de la excepción
    println("Excepcion capturada: ${e.message}")
}

fun cleanup() {
    // Código para limpiar recursos
    println("Limpiando recursos...")
}

fun main() {
    try {
        doSomething() // Intentamos hacer algo que puede generar una excepción
    } catch (e: MyException) {
        handle(e) // Si ocurre una MyException, la manejamos
    } finally {
        cleanup() // Se ejecutará siempre, ocurra o no una excepción
    }
}
