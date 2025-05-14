fun cargaar(): Int {
    // Solicita al usuario que ingrese un entero
    print("Ingrese un entero:")
    val valor = readLine()!!.toInt()  // Lee la entrada del usuario y la convierte a un entero
    return valor  // Retorna el valor ingresado
}

fun main(args: Array<String>) {
    // Crea una lista de enteros solicitando 5 valores al usuario
    var lista1: List<Int> = List(5, {cargaar()})  // Llama a cargaar() para cada elemento de la lista
    println(lista1)  // Imprime la lista de enteros ingresados por el usuario
}