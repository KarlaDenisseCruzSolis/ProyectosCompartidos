class Dado2 { // Definición de la clase 'Dado2' que simula el lanzamiento de un dado.
    private var valor: Int = 1 // Variable privada 'valor' que almacena el valor del dado, inicializada en 1.

    fun tirar() { // Metodo público 'tirar' que simula el lanzamiento del dado.
        valor = ((Math.random() * 6) + 1).toInt() // Genera un número aleatorio entre 1 y 6 y lo asigna a 'valor'.
    }

    fun imprimir() { // Metodo público 'imprimir' que muestra el valor del dado.
        separador() // Llama al metodo 'separador' para imprimir una línea de separación antes del valor.
        println("Valor del dado: $valor") // Imprime el valor actual del dado.
        separador() // Llama nuevamente al metodo 'separador' para imprimir una línea de separación después del valor.
    }

    private fun separador() = println("**************************************") // Metodo privado 'separador' que imprime una línea de asteriscos.
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el programa.
    val dado1 = Dado2() // Crea un objeto 'dado1' de la clase 'Dado2'.
    dado1.tirar() // Llama al metodo 'tirar' para simular el lanzamiento del dado.
    dado1.imprimir() // Llama al metodo 'imprimir' para mostrar el valor del dado.
}