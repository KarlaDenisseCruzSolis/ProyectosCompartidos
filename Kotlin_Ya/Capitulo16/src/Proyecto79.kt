
// Función que calcula la superficie de un cuadrado dado su lado.
fun retornarSuperficie(lado: Int): Int {
    val sup = lado * lado  // Calculamos la superficie del cuadrado (lado * lado)
    return sup  // Devolvemos la superficie calculada
}

fun main(parametro: Array<String>) {
    print("Ingrese el valor del lado del cuadrado:")  // Solicitar el valor al usuario
    val la = readLine()!!.toInt()  // Leer el valor ingresado y convertirlo a entero
    val superficie = retornarSuperficie(la)  // Guardar el valor devuelto por retornarSuperficie en la variable superficie
    println("La superficie del cuadrado es $superficie")  // Imprimir el resultado utilizando la variable superficie

    // Llamar directamente a la función y pasar el resultado a println sin almacenarlo en una variable
    println("La superficie del cuadrado es ${retornarSuperficie(la)}")
}
