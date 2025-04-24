package com.example.ak_cap17_18_19_20.ui.theme
// Ejemplo con Unit declarado
fun printHelloWithUnit(name: String?): Unit {
    if (name != null)
        println("Hello $name")
}

// Ejemplo sin Unit declarado (equivalente)
fun printHello(name: String?) {
    if (name != null)
        println("Hello $name")
}

fun main() {
    printHelloWithUnit("Carlos")
    printHello("Maria")
}
