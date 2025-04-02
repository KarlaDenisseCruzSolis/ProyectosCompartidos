//PROBLEMA PROPUESTO 161
/*Codicar la función de extensión llamada "hasta" que debe extender la clase Int y tiene por objetivo mostrar desde
el valor entero que almacena el objeto hasta el valor que llega como parámetro:
                                    fun Int.hasta(fin: Int) {*/
fun Int.hasta(fin: Int) {
    for(valor in this..fin)
        print("$valor-")
    println()
}

fun main(args: Array<String>) {
    val v = 10
    v.hasta(100)
    5.hasta(10)
}