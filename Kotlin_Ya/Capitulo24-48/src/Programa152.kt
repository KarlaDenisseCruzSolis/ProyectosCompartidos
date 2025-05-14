fun main(parametro: Array<String>) {
    // Se crea un arreglo de 20 elementos, cada uno generado aleatoriamente entre 0 y 10
    var arreglo = IntArray(20) {(Math.random() * 11).toInt()}

    // Se imprime el listado completo del arreglo
    println("Listado completo del arreglo")
    for(elemento in arreglo)
        print("$elemento ")  // Imprime cada elemento del arreglo en una línea
    println()  // Nueva línea al final de la impresión

    // Se cuenta la cantidad de elementos menores o iguales a 5 en el arreglo
    val cant1 = arreglo.count { it <= 5}
    println("Cantidad de elementos menores o iguales a 5: $cant1")

    // Verifica si todos los elementos en el arreglo son menores o iguales a 9
    if (arreglo.all {it <= 9})
        println("Todos los elementos son menores o iguales a 9")
    else
        println("No todos los elementos son menores o iguales a 9")

    // Verifica si al menos uno de los elementos del arreglo es igual a 10
    if (arreglo.any {it == 10})
        println("Al menos uno de los elementos es un 10")
    else
        println("Todos los elementos son distintos a 10")
}