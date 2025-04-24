package com.example.ak_cap17_18_19_20

// Ejemplo de variación del sitio de la declaración (in)
class Consumer<in T> {
    fun consume(t: T) {
        println("Consuming: $t")
    }
}

fun charSequenceConsumer(): Consumer<CharSequence> {
    return Consumer()
}

fun declarationSiteVariance() {
    println("→ Variacion del sitio de la declaracion")

    val stringConsumer: Consumer<String> = charSequenceConsumer() // OK: String es subtipo de CharSequence
    stringConsumer.consume("Hola Mundo")

    // val anyConsumer: Consumer<Any> = charSequenceConsumer() // Error: Any no es subtipo de CharSequence

    // val outConsumer: Consumer<out CharSequence> = charSequenceConsumer() // Error: no se puede usar `out` en parámetro `in`
}

// ----------------------------

fun useSiteVariance() {
    println("\n→ Variacion del sitio de uso")

    // Out-proyección: Solo lectura
    val takeList: MutableList<out CharSequence> = mutableListOf("Uno", "Dos", "Tres")
    val takenValue: CharSequence = takeList[0]
    println("Leido desde out-list: $takenValue")
    // takeList.add("Nuevo") // Error: no se puede agregar por ambigüedad de tipo

    // In-proyección: Solo escritura
    val putList: MutableList<in String> = mutableListOf<Any>("A", "B", "C")
    val valueToPut: String = "Agregado"
    putList.add(valueToPut)
    println("Tamano tras agregar a in-list: ${putList.size}")
    val valueRead = putList[0]  // Tipo: Any
    println("Valor leido de in-list: $valueRead")
}

// ----------------------------

fun starProjectionExample() {
    println("\n→ Proyeccion de estrellas")

    val starList: MutableList<*> = mutableListOf("X", "Y", "Z")
    val first = starList[0]  // Tipo: Any
    println("Elemento de lista con *: $first")

    // starList.add("Otro") // Error: no se puede agregar con proyección estrella
}

fun main() {
    declarationSiteVariance()
    useSiteVariance()
    starProjectionExample()
}
