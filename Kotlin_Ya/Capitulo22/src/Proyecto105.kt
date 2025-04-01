// Función para cargar valores en el arreglo
fun cargar(arreglo: IntArray) {
    // Bucle para recorrer los índices del arreglo y solicitar valores al usuario
    for(i in arreglo.indices) {
        // Solicita al usuario que ingrese un número
        print("Ingrese elemento:")

        // Lee el valor ingresado, lo convierte a entero y lo almacena en el arreglo
        arreglo[i] = readLine()!!.toInt()
    }
}

// Función para imprimir los elementos del arreglo
fun imprimir(arreglo: IntArray) {
    // Bucle para recorrer cada elemento del arreglo
    for(elemento in arreglo)
    // Imprime el elemento actual
        println(elemento)
}

// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {

    // Declaración e inicialización de un arreglo de enteros con 5 elementos
    val arre = IntArray(5)

    // Llamada a la función 'cargar' para llenar el arreglo con valores ingresados por el usuario
    cargar(arre)

    // Llamada a la función 'imprimir' para mostrar los valores almacenados en el arreglo
    imprimir(arre)
}
