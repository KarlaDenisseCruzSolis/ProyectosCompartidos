package com.example.ak_29_al_33

//Uso de let
fun main() {
    val str: String? = "foo"
    str?.let {
        println(it) // Imprime: foo
    }
}
