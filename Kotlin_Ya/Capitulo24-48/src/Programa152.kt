fun main(parametro: Array<String>) {
    var arreglo = IntArray(20) {(Math.random() * 11).toInt()}
    println("Listado completo del arreglo")
    for(elemento in arreglo)
        print("$elemento ")
    println()
    val cant1 = arreglo.count { it <= 5}
    println("Cantidad de elementos menores o iguales a 5: $cant1")
    if (arreglo.all {it <= 9})
        println("Todos los elementos son menores o iguales a 9")
    else
        println("No todos los elementos son menores o iguales a 9")
    if (arreglo.any {it == 10})
        println("Al menos uno de los elementos es un 10")
    else
        println("Todos los elementos son distintos a 10")
}