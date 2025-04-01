// Función que solicita al usuario la cantidad de sueldos a ingresar y los almacena en un arreglo
fun cargar(): IntArray {
    print("Cuantos sueldos quiere cargar:")

    // Lee el número ingresado por el usuario y lo convierte a entero
    val cantidad = readLine()!!.toInt()

    // Crea un arreglo de enteros con la cantidad de elementos especificada por el usuario
    val sueldos = IntArray(cantidad)

    // Bucle para recorrer los índices del arreglo y solicitar cada sueldo
    for(i in sueldos.indices) {
        print("Ingrese sueldo:")
        sueldos[i] = readLine()!!.toInt()
    }

    return sueldos
}

// Función que imprime todos los sueldos almacenados en el arreglo
fun imprimirSueldos(sueldos: IntArray) {  // ← Cambio de nombre de la función
    println("Listado de todos los sueldos")

    for(sueldo in sueldos)
        println(sueldo)
}

// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {

    // Llamada a la función 'cargar' para obtener el arreglo con los sueldos ingresados por el usuario
    val sueldos = cargar()

    // Llamada a la función 'imprimirSueldos' para mostrar los valores almacenados en el arreglo
    imprimirSueldos(sueldos)  // ← Se llama la nueva función corregida
}
