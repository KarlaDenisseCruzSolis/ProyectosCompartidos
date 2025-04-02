package com.example.ak_cap13_14_16

//Captura de múltiples excepciones
import java.io.IOException

// Renombré la función para evitar conflicto
fun doSomethingWithMultipleExceptions() {
    // Código que podría generar una de las excepciones listadas
    throw IOException("Error en el sistema de archivos")
}

// Renombré la función 'handle' a 'handleException' para evitar conflicto
fun handleException(e: Exception) {
    // Manejo de la excepción
    println("Excepcion capturada: ${e.message}")
}

// Renombré la función 'cleanup' a 'cleanupResources' para evitar conflicto
fun cleanupResources() {
    // Código para limpiar recursos
    println("Limpiando recursos...")
}

fun main() {
    try {
        doSomethingWithMultipleExceptions() // Intentamos hacer algo que puede generar una excepción
    } catch (e: IOException) {
        handleException(e) // Si ocurre una IOException, la manejamos
    } catch (e: Exception) {
        // Esto captura cualquier otra excepción
        handleException(e)
    } finally {
        cleanupResources() // Se ejecutará siempre, ocurra o no una excepción
    }
}

