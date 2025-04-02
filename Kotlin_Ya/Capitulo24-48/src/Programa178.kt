//PROBLEMA PROPUESTO 178
/*Crear una lista inmutable de 100 elementos enteros con valores aleatorios comprendidos entre 0 y 20.
contar cuantos hay comprendidos entre 1 y 4, 5 y 8 y cuantos entre 10 y 13.
Imprimir si el valor 20 está presente en la lista.*/
fun main(args: Array<String>) {
    val lista1 = List(100, { ((Math.random() * 21)).toInt() })
    println(lista1)
    var cant1 = 0
    var cant2 = 0
    var cant3 = 0
    lista1.forEach { when(it) {
        in 1..4 -> cant1++
        in 5..8 -> cant2++
        in 10..13 -> cant3++
    } }
    println("Cantidad de valores comprendidos entre 1..4: $cant1")
    println("Cantidad de valores comprendidos entre 5..8: $cant2")
    println("Cantidad de valores comprendidos entre 10..13: $cant1")
    if (lista1.contains(20))
        println("La lista contiene el 20")
    else
        println("La lista no contiene el 20")
}