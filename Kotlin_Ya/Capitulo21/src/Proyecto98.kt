// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {

    // Declaración de un arreglo de enteros llamado 'sueldos'
    val sueldos: IntArray

    // Inicialización del arreglo con tamaño 5
    sueldos = IntArray(5)

    // Bucle para cargar los sueldos ingresados por el usuario
    for(i in 0..4) {
        // Solicita al usuario que ingrese un sueldo
        print("Ingrese sueldo:")

        // Lee el valor ingresado y lo convierte a entero, almacenándolo en el arreglo
        sueldos[i] = readLine()!!.toInt()
    }

    // Bucle para imprimir los sueldos almacenados en el arreglo
    for(i in 0..4) {
        // Imprime el sueldo almacenado en la posición 'i' del arreglo
        println(sueldos[i])
    }
}
