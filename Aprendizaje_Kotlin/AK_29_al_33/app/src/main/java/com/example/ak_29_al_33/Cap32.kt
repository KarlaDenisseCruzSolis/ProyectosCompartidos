package com.example.ak_29_al_33

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import java.lang.ref.WeakReference
import kotlin.reflect.KProperty

// Inicialización perezosa
val foo: Int by lazy { 1 + 1 }

// Delegación personalizada
class MyDelegate {
    operator fun getValue(owner: Any?, property: KProperty<*>): String {
        return "Delegated value"
    }
}

// Uso de WeakReference con Delegado
class WeakReferenceDelegate<T>(initialValue: T? = null) : ReadWriteProperty<Any, T?> {
    private var reference = WeakReference(initialValue)

    override fun getValue(thisRef: Any, property: KProperty<*>): T? = reference.get()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        reference = WeakReference(value)
    }
}

// Clase para manejar referencia débil
class MyMemoryExpensiveClass {
    companion object {
        var reference: MyMemoryExpensiveClass? by WeakReferenceDelegate()

        fun doWithReference(block: (MyMemoryExpensiveClass) -> Unit) {
            reference?.let(block)
        }
    }

    init {
        // La referencia es inicializada dentro del constructor de la clase
        reference = this // Inicializamos la referencia
    }
}

fun main() {
    // Inicialización perezosa
    println(foo)  // Imprime: 2

    // Propiedades observables
    var fooObservable: Int by Delegates.observable(1) { property, oldValue, newValue ->
        println("${property.name} was changed from $oldValue to $newValue")
    }
    fooObservable = 2  // Imprime: fooObservable was changed from 1 to 2

    // Propiedades respaldadas por el mapa con valor predeterminado
    val map = mapOf("foo" to 1)
    val fooFromMap: Int by map.withDefault { 0 }  // Aquí se añade un valor predeterminado
    println(fooFromMap)  // Imprime: 1 (valor del mapa, o 0 si la clave no existe)

    // Delegación personalizada
    val fooDelegate: String by MyDelegate()
    println(fooDelegate)  // Imprime: Delegated value

    // Crear una instancia de MyMemoryExpensiveClass
    val expensiveObj = MyMemoryExpensiveClass()

    // Usar el delegado de WeakReference
    MyMemoryExpensiveClass.doWithReference {
        println("Accessed expensive object: $it")
    }
}

