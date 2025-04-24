package com.example.ak_cap25_al_28

import java.text.SimpleDateFormat
import java.util.*
import java.io.File
import mu.KLogging

// Ejemplo de extensión para agregar elementos de un array a otro
fun IntArray.addTo(dest: IntArray) {
    for (i in 0 until size) {
        dest[i] += this[i]
    }
}

// Ejemplo de extensión para convertir un número a una cadena legible por humanos
fun Long.humanReadable(): String {
    if (this <= 0) return "0"
    val units = arrayOf("B", "KB", "MB", "GB", "TB", "EB")
    val digitGroups = (Math.log10(this.toDouble()) / Math.log10(1024.0)).toInt()
    return String.format("%,.1f %s", this / Math.pow(1024.0, digitGroups.toDouble()), units[digitGroups])
}

fun Int.humanReadable(): String {
    return this.toLong().humanReadable()
}

// Ejemplo de extensión para File (en lugar de Path)
fun File.exists(): Boolean = this.exists()
fun File.notExists(): Boolean = !this.exists()
fun File.deleteRecursively(): Boolean = this.deleteRecursively()

// Extensión para obtener la fecha actual en formato legible
fun Date.toIsoString(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    return dateFormat.format(this)
}

// Definimos la clase con logging usando KLogging
class FooWithLoggingNew {
    companion object : KLogging()

    fun bar(name: String) {
        logger.info { "hello $name" }
    }

    fun logException(e: Exception) {
        logger.error(e) { "Error occurred" }
    }
}

// Función main para probar las extensiones
fun main() {
    // 1. Ejemplo de metodo de extensión de IntArray
    val myArray = intArrayOf(1, 2, 3)
    intArrayOf(4, 5, 6).addTo(myArray)
    println("Array after addTo: ${myArray.joinToString(", ")}")

    // 2. Ejemplo de uso de humanReadable
    println(1999549L.humanReadable())
    val someInt = 102400
    println(someInt.humanReadable())

    // 3. Ejemplo de File extension (en lugar de Path)
    val dir = File("dirName")
    if (dir.exists()) dir.deleteRecursively()

    // 4. Uso de KLogging con la clase FooWithLoggingNew
    val foo = FooWithLoggingNew()
    foo.bar("Kotlin User")

    // Simulamos una excepción
    try {
        throw Exception("Something went wrong!")
    } catch (e: Exception) {
        foo.logException(e)
    }

    // 5. Uso de Date toIsoString (en lugar de Temporal)
    val date = Date()
    println(date.toIsoString())
}
