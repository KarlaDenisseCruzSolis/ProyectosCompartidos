package com.example.ak_cap11_12

// Clase de excepción personalizada
class AssertException(message: String) : Exception(message)

// Operador `invoke` para la clase String que recibe un bloque lambda
operator fun <R> String.invoke(block: () -> R) {
    println("Executing block for: $this")  // Verificar si entra en invoke
    try {
        block.invoke() // Ejecutar el bloque
    } catch (e: AssertException) {
        println("$this\n${e.message}") // Captura de excepciones
    }
}

// Función de extensión `shouldBe` para comparar resultados
infix fun Any.shouldBe(expected: Any) {
    println("Comparing $this with $expected")  // Mensaje de depuración
    if (this != expected) {
        throw AssertException("Expected: $expected, but got: $this")
    }
}

// Función para simular el parseo de una expresión
fun parse(expression: String): AST {
    return AST(expression) // Crear un AST basado en la expresión
}

// Clase que simula un árbol de sintaxis abstracta (AST) y su evaluación
class AST(val expression: String) {
    fun buildAST(): AST {
        // Lógica para construir el árbol de sintaxis (simplificado)
        return this
    }

    fun evaluate(): Int {
        // Evaluación de la expresión (simplificada para "1 + 1")
        return if (expression == "1 + 1") 2 else 0
    }
}

// Función principal donde se realiza la prueba
fun main() {
    println("Starting test...")  // Verificar si entra en main

    // Sintaxis DSL personalizada usando la cadena "it should return 2"
    "it should return 2" {
        println("Inside the block...")  // Verificar si entra en el bloque DSL
        val result = parse("1 + 1").buildAST().evaluate() // Evaluar la expresión
        println("Result of evaluation: $result")  // Verificación del resultado
        result shouldBe 2 // Verificar que el resultado sea 2
    }
}
