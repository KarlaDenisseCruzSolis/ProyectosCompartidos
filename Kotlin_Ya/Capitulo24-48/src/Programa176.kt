fun main(args: Array<String>) {
    // Crea una lista mutable de 20 elementos con valores aleatorios entre 1 y 6
    val lista: MutableList<Int> = MutableList(20) { ((Math.random() * 6) + 1).toInt() }

    // Imprime la lista completa
    println("Lista completa")
    println(lista)

    // Cuenta cuántos elementos en la lista son iguales a 1
    val cant = lista.count { it == 1 }
    println("Cantidad de elementos con el valor 1: $cant")

    // Elimina todos los elementos de la lista con el valor 6
    lista.removeAll { it == 6 }
    println("Lista luego de borrar los elementos con el valor 6")
    println(lista)
}