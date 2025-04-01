// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {

    // Declaración e inicialización de un arreglo de enteros con 10 elementos
    val arreglo = IntArray(10)

    // Bucle para solicitar al usuario que ingrese los 10 elementos del arreglo
    for(i in 0..arreglo.size-1) {
        // Solicita al usuario que ingrese un número
        print("Ingrese elemento:")

        // Lee el valor ingresado, lo convierte a entero y lo almacena en el arreglo
        arreglo[i] = readLine()!!.toInt()
    }

    // Variable booleana para verificar si el arreglo está ordenado de menor a mayor
    var ordenado = true

    // Bucle que recorre el arreglo para comprobar si está ordenado
    for(i in 0..arreglo.size-2)
    // Si un elemento es mayor que el siguiente, el arreglo no está ordenado
        if (arreglo[i+1] < arreglo[i])
            ordenado = false

    // Si la variable 'ordenado' sigue siendo 'true', significa que el arreglo está ordenado
    if (ordenado)
        print("Los elementos están ordenados de menor a mayor")
    else
        print("Los elementos no están ordenados de menor a mayor")
}
