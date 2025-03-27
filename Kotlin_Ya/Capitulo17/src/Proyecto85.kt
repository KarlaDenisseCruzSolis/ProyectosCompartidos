
// Definimos una función que recibe un parámetro de tipo Int (el valor del lado del cuadrado)
// y retorna la superficie (el área del cuadrado) que se calcula como lado * lado.
fun retornarSuperficie(lado: Int) = lado * lado  // Sintaxis concisa de una función de una sola expresión.

fun main(parametro: Array<String>) {
    // Solicitar al usuario que ingrese el valor del lado del cuadrado.
    print("Ingrese el valor del lado del cuadrado:")
    val la = readLine()!!.toInt()  // Leemos la entrada del usuario y la convertimos a un entero.

    // Llamamos a la función 'retornarSuperficie' y mostramos el resultado en pantalla.
    // El valor devuelto por la función se inserta en el String mediante la interpolación de cadenas.
    println("La superficie del cuadrado es ${retornarSuperficie(la)}")
}
