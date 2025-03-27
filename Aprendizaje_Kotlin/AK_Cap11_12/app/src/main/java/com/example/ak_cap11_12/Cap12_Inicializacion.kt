package com.example.ak_cap11_12

import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets

// Definimos una enumeración de colores con un valor RGB asociado
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

// Función principal para demostrar el uso de enums
fun main() {
    // Configurar la salida estándar en UTF-8 sin usar PrintStream (Compatible con API 24+)
    val writer = OutputStreamWriter(System.out, StandardCharsets.UTF_8)

    // Obtener todas las constantes del enum
    val allColors = Color.values()
    writer.write("Lista de colores:\n")
    for (color in allColors) {
        writer.write("${color.name} - RGB: ${color.rgb} - Posición: ${color.ordinal}\n")
    }

    // Obtener una constante por su nombre
    val colorName = "GREEN"
    val color = try {
        Color.valueOf(colorName) // Busca el color por su nombre
    } catch (e: IllegalArgumentException) {
        writer.write("Error: No existe un color llamado $colorName\n")
        null
    }

    // Si se encontró el color, imprimimos su información
    color?.let {
        writer.write("\nColor obtenido por valueOf('$colorName'):\n")
        writer.write("Nombre: ${it.name}, RGB: ${it.rgb}, Posición: ${it.ordinal}\n")
    }

    // Comparar dos colores usando la interfaz Comparable
    writer.write("\nComparación de colores:\n")
    writer.write("¿RED es menor que BLUE? ${Color.RED < Color.BLUE}\n")

    writer.flush() // Asegurar que los datos se impriman correctamente
}
