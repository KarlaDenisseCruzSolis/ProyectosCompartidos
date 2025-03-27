package com.example.ak_cap11_12

// Definir la interfaz Foo
interface Foo {
    fun example() // Metodo a delegar
}

// Definir la clase Bar, que implementa el metodo example() de Foo
class Bar : Foo {
    override fun example() {
        println("Hello, world!") // Implementación del metodo
    }
}

// Definir la clase Baz, que delega la implementación de Foo a un objeto de tipo Bar
class Baz(b: Foo) : Foo by b // Delegación del comportamiento de la interfaz Foo a Bar

// Función main para ejecutar el ejemplo
fun main() {
    // Crear una instancia de Bar y pasarla a Baz
    Baz(Bar()).example() // Se imprime "Hello, world!" porque Baz delega a Bar
}
