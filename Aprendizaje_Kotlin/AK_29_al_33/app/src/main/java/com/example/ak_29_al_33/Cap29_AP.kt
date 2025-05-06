package com.example.ak_29_al_33

//Uso de apply para inicializar objetos o lograr encadenamiento de métodos
import java.io.File

fun main() {
    val dir = "someDirectoryPath"
    // Usando apply para crear un directorio
    File(dir).apply { mkdirs() }
    println("Directory created")
}
