package com.example.ak_cap17_18_19_20

fun main() {

    println("→ Rango ascendente (1..4):")
    for (i in 1..4) print(i)  // Output: 1234
    println("\n")

    println("→ Rango descendente (4..1):")
    for (i in 4..1) print(i)  // Output: (nada, rango inválido)
    println("\n")

    println("→ Rango descendente con downTo (4 downTo 1):")
    for (i in 4 downTo 1) print(i)  // Output: 4321
    println("\n")

    println("→ Rango con paso step (1..4 step 2):")
    for (i in 1..4 step 2) print(i)  // Output: 13
    println("\n")

    println("→ Rango descendente con paso (4 downTo 1 step 2):")
    for (i in 4 downTo 1 step 2) print(i)  // Output: 42
    println("\n")

    println("→ Rango hasta con until (1 until 10):")
    for (i in 1 until 10) {
        print(i)  // Output: 123456789
    }
    println()
}
