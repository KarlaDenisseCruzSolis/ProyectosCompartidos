package com.example.ak_cap21_22_23_24

// Interfaz basica
interface MyInterface {
    fun bar()
}

class Child : MyInterface {
    override fun bar() {
        println("bar() was called")
    }
}

// Interfaz con implementacion por defecto
interface MyInterfaceWithDefault {
    fun withImplementation() {
        println("withImplementation() was called")
    }
}

class MyClass : MyInterfaceWithDefault {
    // No es necesario reimplementar
}

// Propiedades con getter
interface MyInterface2 {
    val helloWorld: String
        get() = "Hello World!"
}

// No se puede usar 'field' en interfaces
// Esto no compila
/*
interface MyInterface3 {
    var helloWorld: Int
        get() = field
        set(value) { field = value }
}
*/

// Interfaces multiples con metodos iguales
interface A {
    fun notImplemented()
    fun implementedOnlyInA() {
        println("only A")
    }

    fun implementedInBoth() {
        println("both, A")
    }

    fun implementedInOne() {
        println("implemented in A")
    }
}

interface B {
    fun implementedInBoth() {
        println("both, B")
    }

    fun implementedInOne() // Solo declarada
}

class MyMultiInterfaceClass : A, B {
    override fun notImplemented() {
        println("Normal implementation")
    }

    override fun implementedInBoth() {
        super<B>.implementedInBoth()
        super<A>.implementedInBoth()
    }

    override fun implementedInOne() {
        super<A>.implementedInOne()
        println("implementedInOne class implementation")
    }
}

// Propiedades en interfaces
interface MyInterfaceWithProperties {
    val property: Int

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        println(property)
    }
}

class ChildWithProperty : MyInterfaceWithProperties {
    override val property: Int = 29
}

// Conflictos entre interfaces
interface FirstTrait {
    fun foo() {
        println("first")
    }

    fun bar()
}

interface SecondTrait {
    fun foo() {
        println("second")
    }

    fun bar() {
        println("bar")
    }
}

class ClassWithConflict : FirstTrait, SecondTrait {
    override fun foo() {
        super<FirstTrait>.foo()
        super<SecondTrait>.foo()
    }

    override fun bar() {
        // Usa la implementacion por defecto de SecondTrait
        super<SecondTrait>.bar()
    }
}

// Uso de super en interfaces
interface MyInterfaceSuper {
    fun funcOne() {
        println("Function with default implementation")
    }
}

class MySuperClass : MyInterfaceSuper {
    override fun funcOne() {
        super.funcOne()
    }
}

// Funcion principal para probar todo
fun main() {
    println("== Interfaz basica ==")
    val child = Child()
    child.bar()

    println("\n== Implementacion por defecto ==")
    val myClass = MyClass()
    myClass.withImplementation()

    println("\n== Propiedad con getter por defecto ==")
    val propInstance = object : MyInterface2 {}
    println(propInstance.helloWorld)

    println("\n== Interfaces multiples ==")
    val multi = MyMultiInterfaceClass()
    multi.notImplemented()
    multi.implementedOnlyInA()
    multi.implementedInBoth()
    multi.implementedInOne()

    println("\n== Propiedades en interfaces ==")
    val childWithProp = ChildWithProperty()
    childWithProp.foo()
    println(childWithProp.propertyWithImplementation)

    println("\n== Conflictos entre interfaces ==")
    val conflictClass = ClassWithConflict()
    conflictClass.foo()
    conflictClass.bar()

    println("\n== Uso de super en interfaces ==")
    val superClass = MySuperClass()
    superClass.funcOne()
}
