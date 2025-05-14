//PROBLEMA PROPUESTO 161
/*Codicar la función de extensión llamada "hasta" que debe extender la clase Int y tiene por objetivo mostrar desde
el valor entero que almacena el objeto hasta el valor que llega como parámetro:
                                    fun Int.hasta(fin: Int) {*/

fun Int.hasta(fin: Int) {
    // Recorre desde el valor almacenado en el objeto (this) hasta el valor 'fin' proporcionado
    for (valor in this..fin)
    // Imprime cada valor seguido de un guion
        print("$valor-")
    // Imprime una línea en blanco al final de la secuencia
    println()
}

fun main(args: Array<String>) {
    // Crea una variable 'v' con el valor 10 y llama al metodo 'hasta' pasando 100 como parámetro
    val v = 10
    v.hasta(100)  // Esto imprimirá: 10-11-12-...-100-

    // Llama al metodo 'hasta' directamente sobre el valor 5 y pasando 10 como parámetro
    5.hasta(10)  // Esto imprimirá: 5-6-7-8-9-10-
}