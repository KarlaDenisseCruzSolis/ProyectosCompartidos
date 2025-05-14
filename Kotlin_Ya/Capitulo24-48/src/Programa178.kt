//PROBLEMA PROPUESTO 178
/*Crear una lista inmutable de 100 elementos enteros con valores aleatorios comprendidos entre 0 y 20.
contar cuantos hay comprendidos entre 1 y 4, 5 y 8 y cuantos entre 10 y 13.
Imprimir si el valor 20 está presente en la lista.*/

fun main(args: Array<String>) {
    // Crear una lista inmutable de 100 elementos con valores aleatorios entre 0 y 20
    val lista1 = List(100, { ((Math.random() * 21)).toInt() })

    // Imprimir la lista generada
    println(lista1)

    // Variables para contar los elementos en los rangos especificados
    var cant1 = 0
    var cant2 = 0
    var cant3 = 0

    // Recorrer la lista y contar los elementos dentro de los diferentes rangos
    lista1.forEach {
        when(it) {
            in 1..4 -> cant1++  // Si el valor está entre 1 y 4, incrementar cant1
            in 5..8 -> cant2++  // Si el valor está entre 5 y 8, incrementar cant2
            in 10..13 -> cant3++ // Si el valor está entre 10 y 13, incrementar cant3
        }
    }

    // Imprimir la cantidad de valores en cada rango
    println("Cantidad de valores comprendidos entre 1..4: $cant1")
    println("Cantidad de valores comprendidos entre 5..8: $cant2")
    println("Cantidad de valores comprendidos entre 10..13: $cant1")

    // Verificar si el valor 20 está presente en la lista
    if (lista1.contains(20))
        println("La lista contiene el 20")
    else
        println("La lista no contiene el 20")
}