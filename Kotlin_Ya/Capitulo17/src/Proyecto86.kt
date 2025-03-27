
// Definimos una función que recibe dos parámetros enteros y retorna el mayor de los dos.
// La función utiliza una expresión if para decidir cuál es el mayor.
fun retornarMayor(v1: Int, v2: Int) = if (v1 > v2) v1 else v2  // Sintaxis concisa con una única expresión.

fun main(parametro: Array<String>) {
    // Solicitar al usuario que ingrese el primer valor.
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt()  // Leemos la entrada del usuario y la convertimos a un entero.

    // Solicitar al usuario que ingrese el segundo valor.
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt()  // Leemos la entrada del usuario y la convertimos a un entero.

    // Llamamos a la función retornarMayor y mostramos el valor mayor entre los dos números.
    println("El mayor entre $valor1 y $valor2 es ${retornarMayor(valor1, valor2)}")
}
