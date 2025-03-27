package com.example.ak_cap11_12

// Definir la enumeración con funciones y propiedades
enum class ColorWithFunctions {

    // Definimos los objetos de la enumeración con su implementación personalizada de `rgb`
    RED {
        // Sobrescribimos la propiedad `rgb` para el color rojo
        override val rgb: Int = 0xFF0000  // Valor RGB de color rojo
    },
    GREEN {
        // Sobrescribimos la propiedad `rgb` para el color verde
        override val rgb: Int = 0x00FF00  // Valor RGB de color verde
    },
    BLUE {
        // Sobrescribimos la propiedad `rgb` para el color azul
        override val rgb: Int = 0x0000FF  // Valor RGB de color azul
    };

    // Declaración de la propiedad `rgb` que será implementada por cada constante
    abstract val rgb: Int

    // Definimos una función que convierte el valor RGB en un string hexadecimal
    fun colorString() = "#%06X".format(0xFFFFFF and rgb)  // Convierte el valor RGB en formato hexadecimal
}

fun main() {
    // Llamamos al método `values()` que devuelve todas las constantes de la enumeración `ColorWithFunctions`
    val allColors = ColorWithFunctions.values()

    // Imprimimos el encabezado de la lista de colores con funciones
    println("Lista de colores con funciones:")

    // Iteramos sobre todas las constantes de la enumeración
    for (color in allColors) {
        // Imprimimos el nombre del color, su valor RGB y su representación en formato hexadecimal
        println("${color.name} - RGB: ${color.rgb} - Hex: ${color.colorString()}")
    }
}
