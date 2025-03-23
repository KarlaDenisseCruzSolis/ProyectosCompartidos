
fun main(parametro: Array<String>) {  // Define la función principal 'main', con un parámetro de tipo Array<String> (no utilizado en este caso)
    print("Ingrese un valor entero entre 1 y 5:")  // Solicita al usuario que ingrese un valor entero entre 1 y 5
    val valor = readLine()!!.toInt()  // Lee la entrada del usuario, la convierte a un entero (Int) y lo guarda en 'valor'

    // Estructura 'when' para evaluar el valor ingresado y mostrar el nombre del número correspondiente
    when (valor) {
        1 -> print("uno")  // Si el valor es 1, imprime "uno"
        2 -> print("dos")  // Si el valor es 2, imprime "dos"
        3 -> print("tres")  // Si el valor es 3, imprime "tres"
        4 -> print("cuatro")  // Si el valor es 4, imprime "cuatro"
        5 -> print("cinco")  // Si el valor es 5, imprime "cinco"
        else -> print("valor fuera de rango")  // Si el valor no está en el rango de 1 a 5, imprime "valor fuera de rango"
    }
}
