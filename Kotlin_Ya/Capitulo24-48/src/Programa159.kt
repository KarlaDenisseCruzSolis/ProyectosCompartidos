fun IntArray.imprimir() {
    // Imprime la representación del arreglo entre corchetes
    print("[")

    // Recorre cada elemento del arreglo y lo imprime
    for(elemento in this) {
        print("$elemento ") // Imprime cada elemento seguido de un espacio
    }

    // Imprime el corchete de cierre
    println("]")
}

fun main(args: Array<String>) {
    // Se crea un arreglo de enteros de tamaño 10, con valores del 0 al 9
    val arreglo1 = IntArray(10, { it })

    // Llama al metodo imprimir para mostrar el arreglo
    arreglo1.imprimir()
}