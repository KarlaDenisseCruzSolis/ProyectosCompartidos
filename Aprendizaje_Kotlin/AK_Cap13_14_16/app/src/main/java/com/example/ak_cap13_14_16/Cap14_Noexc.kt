package com.example.ak_cap13_14_16

//Función que lanza una excepción (sin tener que manejarla explícitamente)
import java.io.File
import java.io.IOException

fun fileToString(file: File): String {
    // Usamos FileInputStream para leer el contenido del archivo
    val fileContent = file.inputStream().readBytes() // Lee_todo el contenido como un arreglo de bytes
    return String(fileContent) // Convierte el contenido de bytes a String
}

fun main() {
    // Creamos un archivo de ejemplo (debes reemplazar esto por un archivo real si pruebas)
    val file = File("path/to/file.txt")

    try {
        val content = fileToString(file)
        println(content) // Imprime el contenido del archivo
    } catch (e: IOException) {
        println("Ocurrio un error al leer el archivo: ${e.message}")
    }
}