package com.example.ak_cap25_al_28

// Importamos la librería para el logging
import mu.KLogging

// Definimos la clase con logging
class FooWithLogging {

    // Usamos el companion object para configurar el logger
    companion object : KLogging()

    // Metodo que hace log de un mensaje con nivel INFO
    fun bar(name: String) {
        logger.info { "hello $name" }
    }

    // Metodo que hace log de una excepción con nivel ERROR
    fun logException(e: Exception) {
        logger.error(e) { "Error occurred" }
    }
}

fun main() {
    // Crear una instancia de la clase FooWithLogging
    val foo = FooWithLogging()

    // Llamamos al metodo bar para hacer log de un mensaje
    foo.bar("Kotlin User")

    // Simulamos una excepción y la registramos con logException
    try {
        throw Exception("Something went wrong!")
    } catch (e: Exception) {
        foo.logException(e)
    }
}
