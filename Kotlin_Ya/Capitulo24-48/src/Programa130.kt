// Definición de la clase de datos Dados con una única propiedad: valor.
data class Dados(var valor: Int) {

    // Sobrescribe el metodo toString para devolver una cadena de asteriscos cuyo número corresponde al valor de la propiedad 'valor'.
    override fun toString(): String {
        var cadena = "" // Inicializa una cadena vacía.
        for (i in 1..valor) // Recorre un rango desde 1 hasta el valor de la propiedad 'valor'.
            cadena = cadena + "*" // Añade un asterisco a la cadena en cada iteración.
        return cadena // Retorna la cadena resultante de asteriscos.
    }
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el programa.

    val dado1 = Dados(4) // Crea un objeto 'dado1' con valor 4.
    val dado2 = Dados(6) // Crea un objeto 'dado2' con valor 6.
    val dado3 = Dados(1) // Crea un objeto 'dado3' con valor 1.

    println(dado1) // Imprime 'dado1', que mostrará una cadena de 4 asteriscos.
    println(dado2) // Imprime 'dado2', que mostrará una cadena de 6 asteriscos.
    println(dado3) // Imprime 'dado3', que mostrará una cadena de 1 asterisco.
}