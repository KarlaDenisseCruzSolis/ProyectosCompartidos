fun main(args: Array<String>) {
    val lista: MutableList<Int> = MutableList(20) { ((Math.random() * 6) + 1).toInt() }
    println("Lista completa")
    println(lista)
    val cant = lista.count { it == 1 }
    println("Cantidad de elementos con el valor 1: $cant")
    lista.removeAll { it == 6 }
    println("Lista luego de borrar los elementos con el valor 6")
    println(lista)
}