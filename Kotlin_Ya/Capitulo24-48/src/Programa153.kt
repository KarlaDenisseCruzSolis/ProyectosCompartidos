//PROBLEMA PROPUESTO 153
/*Crear un arreglo de tipo FloatArray de 10 elementos, cargar sus elementos por teclado.
Imprimir la cantidad de valores ingresados menores a 50.
Imprimir un mensaje si todos los valores son menores a 50.*/

fun main(parametro: Array<String>) {
    // Se crea un arreglo de tipo FloatArray con 10 elementos
    val arreglo = FloatArray(10)

    // Se solicita al usuario ingresar los elementos por teclado
    for (i in arreglo.indices) {
        print("Ingrese elemento:")  // Se muestra un mensaje solicitando el ingreso de un número
        arreglo[i] = readln().toFloat()  // Lee el valor ingresado y lo convierte a tipo Float
    }

    // Se imprime el listado completo del arreglo
    println("Listado completo del arreglo")
    for (elemento in arreglo)
        print("$elemento ")  // Se imprime cada elemento del arreglo en una misma línea
    println()  // Salto de línea después de imprimir el arreglo

    // Se cuenta cuántos valores del arreglo son menores a 50
    val cant = arreglo.count { it < 50 }
    println("Cantidad de valores ingresados menores a 50: $cant")

    // Verifica si todos los valores del arreglo son menores a 50
    if (arreglo.all { it < 50 })
        println("Todos los valores son menores a 50")
    else
        println("No todos los valores son menores a 50")
}