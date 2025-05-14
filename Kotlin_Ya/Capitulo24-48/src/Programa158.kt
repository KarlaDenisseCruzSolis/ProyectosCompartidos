fun String.mitadPrimera(): String {
    // Retorna la primera mitad de la cadena (hasta la mitad menos uno)
    return this.substring(0..this.length/2-1)
}

fun String.segundaMitad(): String{
    // Retorna la segunda mitad de la cadena (desde la mitad hasta el final)
    return this.substring(this.length/2..this.length-1)
}

fun main(args: Array<String>) {
    // Se define una cadena de texto
    val cadena1 = "Viento"

    // Se imprime la primera mitad de la cadena usando el metodo mitadPrimera()
    println(cadena1.mitadPrimera())

    // Se imprime la segunda mitad de la cadena usando el metodo segundaMitad()
    println(cadena1.segundaMitad())
}