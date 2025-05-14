//PROBLEMA PROPUESTO 160
/*Agregar a la clase String un metodo imprimir que muestre todos los caracteres que tiene almacenado en una línea.*/
fun String.imprimir() {
    // Imprime la cadena completa en una sola línea
    println(this)
}

fun main(args: Array<String>) {
    // Llama al metodo imprimir para mostrar la cadena "Hola Mundo"
    "Hola Mundo".imprimir()

    // Crea una nueva cadena y la imprime usando el metodo imprimir
    val cadena1 = "Fin"
    cadena1.imprimir()
}