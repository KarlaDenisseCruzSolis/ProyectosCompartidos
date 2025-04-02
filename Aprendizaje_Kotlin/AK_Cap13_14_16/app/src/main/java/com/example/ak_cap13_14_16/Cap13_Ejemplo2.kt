package com.example.ak_cap13_14_16

fun main() {
    // Diferentes tipos de transmisiones # 2: usar perezosamente el primer elemento si existe
    println("Ejemplo 2:")
    sequenceOf("a1", "a2", "a3").firstOrNull()?.apply(::println)

    // Diferentes tipos de transmisiones # 3: iterar un rango de enteros
    println("Ejemplo 3:")
    (1..3).forEach(::println)

    // Diferentes tipos de transmisiones # 4: iterar una matriz, mapear los valores, calcular el promedio
    println("Ejemplo 4:")
    arrayOf(1, 2, 3).map { 2 * it + 1 }.average().apply(::println)

    // Diferentes tipos de flujos n.° 5: iterar perezosamente una lista de cadenas, mapear los valores, convertir a Int, encontrar máx.
    println("Ejemplo 5:")
    sequenceOf("a1", "a2", "a3")
        .map { it.substring(1) }
        .map(String::toInt)
        .max().apply(::println)

    // Diferentes tipos de flujos n.° 6: iterar perezosamente un flujo de Ints, mapear los valores, imprimir resultados
    println("Ejemplo 6:")
    (1..3).map { "a$it" }.forEach(::println)

    // Diferentes tipos de transmisiones # 7: iteraciones perezosas dobles, mapa a Int, mapa a Cadena, imprimir cada
    println("Ejemplo 7:")
    sequenceOf(1.0, 2.0, 3.0).map(Double::toInt).map { "a$it" }.forEach(::println)

    // Contando elementos en una lista después de aplicar el filtro
    println("Contando elementos despues de aplicar el filtro:")
    val items = listOf("apple", "banana", "orange", "tomato")
    val count = items.count { it.startsWith('t') }
    println(count)

    // Cómo funcionan las secuencias - filtre, mayúsculas, luego ordene una lista
    println("Filtrar, mayusculas, y ordenar:")
    val list = listOf("a1", "a2", "b1", "c2", "c1")
    list.filter { it.startsWith('c') }
        .map(String::toUpperCase)
        .sorted()
        .forEach(::println)

    // Diferentes tipos de transmisiones # 1: ansiosos por usar el primer elemento si existe
    println("Ejemplo 1:")
    listOf("a1", "a2", "a3").firstOrNull()?.apply(::println)
}

// Crear una función de extensión en String llamada ifPresent:
inline fun String?.ifPresent(thenDo: (String) -> Unit) = this?.apply { thenDo(this) }
