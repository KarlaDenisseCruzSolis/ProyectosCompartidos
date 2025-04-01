// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {

    // Declaración e inicialización de un arreglo de enteros con 10 elementos
    val arreglo = IntArray(10)

    // Bucle para solicitar al usuario que ingrese los 10 elementos del arreglo
    for(i in arreglo.indices) {
        // Solicita al usuario que ingrese un número
        print("Ingrese elemento:")

        // Lee el valor ingresado, lo convierte a entero y lo almacena en el arreglo
        arreglo[i] = readLine()!!.toInt()
    }

    // Imprime el primer elemento del arreglo
    println("Primera componente del arreglo ${arreglo[0]}")

    // Imprime el último elemento del arreglo utilizando 'lastIndex' para obtener su posición
    println("Ultima componente del arreglo ${arreglo[arreglo.lastIndex]}")
}
