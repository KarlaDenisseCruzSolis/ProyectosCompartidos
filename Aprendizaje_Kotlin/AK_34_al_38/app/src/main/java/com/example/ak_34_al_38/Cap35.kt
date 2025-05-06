package com.example.ak_34_al_38

import kotlin.text.Regex

fun main() {
    val string = "abc123"

    // Usando el patrón de visitante
    when (RegexWhenArgument(string)) {
        RegexWhenArgument("c|d") -> println("Coincide con c o d (visitante)")
        RegexWhenArgument("\\d+") -> println("Coincide con números (visitante)")
        else -> println("No coincide (visitante)")
    }
}

// Clase para el patrón de visitante
class RegexWhenArgument(val whenArgument: CharSequence) {

    // Sobrescribir el metodo equals para permitir comparación con Regex
    fun matches(whenEntry: Regex): Boolean {
        return whenEntry.matches(whenArgument)
    }

    // Sobrescribir el metodo equals de Any para comparar instancias de RegexWhenArgument
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as RegexWhenArgument
        return whenArgument == other.whenArgument
    }

    override fun hashCode(): Int {
        return whenArgument.hashCode()
    }
}
