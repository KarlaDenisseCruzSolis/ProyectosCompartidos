
// Definimos una función que recibe un número entero y lo convierte a su equivalente en castellano
// o retorna "error" si el número no está entre 1 y 5.
fun convertirCastelano(valor: Int) = when (valor) {
    1 -> "uno"       // Si el valor es 1, devuelve "uno"
    2 -> "dos"       // Si el valor es 2, devuelve "dos"
    3 -> "tres"      // Si el valor es 3, devuelve "tres"
    4 -> "cuatro"    // Si el valor es 4, devuelve "cuatro"
    5 -> "cinco"     // Si el valor es 5, devuelve "cinco"
    else -> "error"  // Si el valor no está entre 1 y 5, devuelve "error"
}

fun main(parametro: Array<String>) {
    // Un bucle que va del 1 al 6, llamando a la función convertirCastelano con cada número
    for(i in 1..6)
        println(convertirCastelano(i))  // Imprime la conversión del número a castellano o "error"
}
