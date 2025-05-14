fun main(args: Array<String>) {
    // Crear una lista de días de la semana
    var lista1: List<String> = listOf("lunes", "martes", "miercoles", "jueves",
        "viernes", "sábado", "domingo")

    println("Imprimir la lista completa")
    println(lista1)  // Imprime la lista completa

    println("Imprimir el primer elemento de la lista")
    println(lista1[0])  // Imprime el primer elemento de la lista

    println("Imprimir el primer elemento de la lista")
    println(lista1.first())  // Imprime el primer elemento de la lista utilizando la función first()

    println("Imprimir el último elemento de la lista")
    println(lista1.last())  // Imprime el último elemento de la lista utilizando la función last()

    println("Imprimir el último elemento de la lista")
    println(lista1[lista1.size-1])  // Imprime el último elemento de la lista accediendo por índice

    println("Imprimir la cantidad de elementos de la lista")
    println(lista1.size)  // Imprime el número de elementos en la lista

    println("Recorrer la lista completa con un for")
    for(elemento in lista1)
        print("$elemento ")  // Imprime cada elemento de la lista

    println()  // Salto de línea después de recorrer la lista

    println("Imprimir el elemento y su posición")
    for(posicion in lista1.indices)
        print("[$posicion]${lista1[posicion]} ")  // Imprime el índice y el elemento correspondiente en la lista
}