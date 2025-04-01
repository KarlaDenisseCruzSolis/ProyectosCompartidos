//PROBLEMA PROPUESTO 153
/*Crear un arreglo de tipo FloatArray de 10 elementos, cargar sus elementos por teclado.
Imprimir la cantidad de valores ingresados menores a 50.
Imprimir un mensaje si todos los valores son menores a 50.*/
fun main(parametro: Array<String>) {
    val arreglo = FloatArray(10)
    for (i in arreglo.indices) {
        print("Ingrese elemento:")
        arreglo[i] = readln().toFloat()
    }
    println("Listado completo del arreglo")
    for (elemento in arreglo)
        print("$elemento ")
    println()
    val cant = arreglo.count { it < 50 }
    println("Cantidad de valores ingresados menores a 50: $cant")
    if (arreglo.all { it < 50 })
        println("Todos los valores son menores a 50")
    else
        println("No todos los valores son menores a 50")
}