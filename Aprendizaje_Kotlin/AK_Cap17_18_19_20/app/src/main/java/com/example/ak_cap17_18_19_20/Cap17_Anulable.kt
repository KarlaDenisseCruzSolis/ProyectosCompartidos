package com.example.ak_cap17_18_19_20

fun main() {
    // Referencia no anulable
    var a: String = "abc"
    // a = null // Esto genera error de compilación

    // Referencia anulable
    var b: String? = "abc"
    b = null // Esto sí se permite

    println("a: $a")
    println("b: $b")
}
