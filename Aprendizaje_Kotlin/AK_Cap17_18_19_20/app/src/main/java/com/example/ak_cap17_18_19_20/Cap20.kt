package com.example.ak_cap17_18_19_20

// → Ejemplo 1: Clases abiertas usando `open`
open class Thing {
    fun info() = println("I can now be extended!")
}

// → Ejemplo 2: Herencia de campos
open class BaseClass {
    val x = 10
}

class DerivedClass : BaseClass() {
    fun foo() {
        println("x is equal to $x")
    }
}

// → Ejemplo 3: Herencia de métodos
open class Person {
    fun jump() {
        println("Jumping...")
    }
}

class Ninja : Person() {
    fun sneak() {
        println("Sneaking around...")
    }
}

// → Ejemplo 4: Anulación de propiedades y métodos
abstract class Car {
    abstract val name: String
    open var speed: Int = 0
}

class BrokenCar(override val name: String) : Car() {
    override var speed: Int
        get() = 0
        set(value) {
            throw UnsupportedOperationException("The car is broken")
        }
}

// → Ejemplo 5: Métodos de interfaz y su override en objeto
interface Ship {
    fun sail()
    fun sink()
}

object Titanic : Ship {

    var canSail = true

    override fun sail() {
        println("Sailing... now sinking.")
        sink()
    }

    override fun sink() {
        println("Sinking the Titanic!")
        canSail = false
    }
}

// → Main para probar todos los ejemplos
fun main() {
    println("→ Herencia de campos")
    val derivedClass = DerivedClass()
    derivedClass.foo()

    println("\n→ Herencia de metodos")
    val ninja = Ninja()
    ninja.jump()
    ninja.sneak()

    println("\n→ Override de propiedades")
    val car: Car = BrokenCar("Lada")
    try {
        car.speed = 10 // Lanza excepción
    } catch (e: UnsupportedOperationException) {
        println("Error: ${e.message}")
    }

    println("\n→ Override de metodos en interfaz")
    println("Puede navegar Titanic?: ${Titanic.canSail}")
    Titanic.sail()
    println("Puede navegar Titanic despues?: ${Titanic.canSail}")
}
