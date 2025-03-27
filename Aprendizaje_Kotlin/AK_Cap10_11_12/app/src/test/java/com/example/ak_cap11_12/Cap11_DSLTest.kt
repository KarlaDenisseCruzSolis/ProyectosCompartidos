package com.example.ak_cap11_12  // Define el paquete donde se encuentra la clase

import org.junit.Test  // Importa la anotación @Test de JUnit para pruebas unitarias
import org.junit.Assert.assertEquals  // Importa el metodo assertEquals para validaciones

// Función de extensión infix que compara si un valor es igual al esperado
infix fun <T> T?.shouldBe(expected: T?) = assertEquals(expected, this)

// Función de extensión para la clase Int que incrementa el valor en 1
fun Int.plusOne(): Int = this + 1

// Clase de prueba para probar las funciones definidas
class DSLTest {
    @Test  // Indica que este método es una prueba unitaria
    fun test() {
        // Prueba que verifica si 100.plusOne() devuelve 101
        100.plusOne() shouldBe 101
    }
}
