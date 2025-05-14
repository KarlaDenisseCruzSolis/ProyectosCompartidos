// Definición de un enum class 'Operacioon' con dos valores: SUMA y PROMEDIO
enum class Operacioon {
    SUMA,       // Operación de suma
    PROMEDIO    // Operación de promedio
}

// Función que recibe el tipo de operación y un número variable de enteros, y devuelve el resultado de la operación
fun operar(tipoOperacion: Operacioon, vararg arreglo: Int): Int {
    // Utilizamos un when para realizar la operación correspondiente según el tipo de operación
    when (tipoOperacion) {
        // Si la operación es SUMA, se devuelve la suma de todos los elementos del arreglo
        Operacioon.SUMA -> return arreglo.sum()

        // Si la operación es PROMEDIO, se devuelve el promedio de los elementos del arreglo convertido a entero
        Operacioon.PROMEDIO -> return arreglo.average().toInt()
    }
}

fun main(args: Array<String>) {
    // Llamamos a la función operar con el tipo de operación SUMA y algunos valores, almacenamos el resultado en resultado1
    val resultado1 = operar(Operacioon.SUMA, 10, 20, 30)
    // Imprimimos el resultado de la suma
    println("La suma es $resultado1")

    // Llamamos a la función operar con el tipo de operación PROMEDIO y algunos valores, almacenamos el resultado en resultado2
    val resultado2 = operar(Operacioon.PROMEDIO, 10, 20, 30)
    // Imprimimos el resultado del promedio
    println("El promedio es $resultado2")
}