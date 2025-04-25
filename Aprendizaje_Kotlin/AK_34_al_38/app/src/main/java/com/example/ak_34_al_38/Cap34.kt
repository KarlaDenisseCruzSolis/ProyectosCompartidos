package com.example.ak_34_al_38

import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KVisibility
import kotlin.reflect.jvm.isAccessible

// Clase MyClass agregada
class MyClass(val name: String)

fun main() {
    // Hacer referencia a una clase
    val c1 = String::class
    val c2 = MyClass::class  // Asegúrate de que MyClass esté definida
    println(c1)
    println(c2)

    // Haciendo referencia a una función
    fun isPositive(x: Int) = x > 0
    val numbers = listOf(-2, -1, 0, 1, 2)
    println(numbers.filter(::isPositive)) // [1, 2]

    // Interoperación con la reflexión de Java
    val stringKClass: KClass<String> = String::class
    val c1Java: Class<String> = stringKClass.java
    println(c1Java)

    // Establecer valores de todas las propiedades de una clase
    val instance = TestClass()
    TestClass::class.memberProperties
        .filter { it.visibility == KVisibility.PUBLIC }
        .filterIsInstance<KMutableProperty<*>>()
        .forEach { prop ->
            prop.isAccessible = true // Aseguramos acceso a propiedades privadas
            try {
                // Establece el valor de la propiedad
                prop.setter.call(instance, "Our Value")
            } catch (e: Exception) {
                println("Error al establecer el valor para ${prop.name}: ${e.message}")
            }
        }

    // Imprimir el estado actualizado de la instancia
    println("Updated TestClass instance: ${instance.readWriteString}")
}

open class BaseExample(val baseField: String)

class Example(val field1: String, val field2: Int, baseField: String) : BaseExample(baseField) {
    val field3: String
        get() = "Property without backing field"

    val field4 by lazy { "Delegated value" }

    private val privateField: String = "Private value"
}

class TestClass {
    val readOnlyProperty: String
        get() = "Read only!"

    var readWriteString = "asd"
    var readWriteInt = 23
    var readWriteBackedStringProperty: String = ""
        get() = field + '5'
        set(value) { field = value + '5' }

    var readWriteBackedIntProperty: Int = 0
        get() = field + 1
        set(value) { field = value - 1 }

    var delegatedProperty: Int by TestDelegate()

    private var privateProperty = "This should be private"
}

private class TestDelegate {
    private var backingField = 3

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): Int {
        return backingField
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: Int) {
        backingField += value
    }
}