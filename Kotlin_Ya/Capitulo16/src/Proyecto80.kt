
// Definimos la función 'retornarMayor' que toma dos parámetros enteros (v1 y v2) y devuelve el mayor de los dos.
fun retornarMayor(v1: Int, v2: Int): Int {
    if (v1 > v2)  // Comprobamos si el primer valor es mayor que el segundo
        return v1  // Si v1 es mayor, devolvemos v1
    else
        return v2  // Si no, devolvemos v2 (es decir, v2 es mayor o igual a v1)
}

fun main(parametro: Array<String>) {
    // Solicitar al usuario que ingrese el primer valor
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt()  // Leemos la entrada del usuario y la convertimos a entero

    // Solicitar al usuario que ingrese el segundo valor
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt()  // Leemos la entrada del usuario y la convertimos a entero

    // Imprimir el mayor entre los dos valores ingresados, utilizando la función 'retornarMayor'
    println("El mayor entre $valor1 y $valor2 es ${retornarMayor(valor1, valor2)}")
}
