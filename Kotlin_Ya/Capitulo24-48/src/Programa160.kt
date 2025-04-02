//PROBLEMA PROPUESTO 160
/*Agregar a la clase String un método imprimir que muestre todos los caracteres que tiene almacenado en una línea.*/
fun String.imprimir() {
    println(this)
}

fun main(args: Array<String>) {
    "Hola Mundo".imprimir()
    val cadena1 = "Fin"
    cadena1.imprimir()
}