class Dado (var valor: Int){ // Definición de la clase Dado con una propiedad 'valor' que representa el valor del dado.
    fun tirar() { // Metodo 'tirar' que simula el lanzamiento de un dado.
        valor = ((Math.random() * 6) + 1).toInt() // Genera un número aleatorio entre 1 y 6 y lo asigna a 'valor'.
        imprimir() // Llama al metodo 'imprimir' para mostrar el valor del dado después de lanzarlo.
    }
    fun imprimir() { // Metodo 'imprimir' que muestra el valor actual del dado.
        println("Valor del dado: $valor") // Imprime el valor del dado.
    }
}

class JuegoDeDados { // Definición de la clase JuegoDeDados que contiene los dados y la lógica del juego.
    val dado1 = Dado(1) // Crea un objeto 'dado1' con un valor inicial de 1.
    val dado2 = Dado(1) // Crea un objeto 'dado2' con un valor inicial de 1.
    val dado3 = Dado(1) // Crea un objeto 'dado3' con un valor inicial de 1.

    fun jugar() { // Metodo 'jugar' que ejecuta el juego de lanzar los dados.
        dado1.tirar() // Llama al metodo 'tirar' para lanzar el dado1.
        dado2.tirar() // Llama al metodo 'tirar' para lanzar el dado2.
        dado3.tirar() // Llama al metodo 'tirar' para lanzar el dado3.
        if (dado1.valor == dado2.valor && dado2.valor == dado3.valor) // Si los tres dados tienen el mismo valor, el jugador gana.
            println("Ganó") // Imprime "Ganó" si los tres dados tienen el mismo valor.
        else
            print("Perdió") // Si los tres dados no tienen el mismo valor, imprime "Perdió".
    }
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el juego.
    val juego1 = JuegoDeDados() // Crea un objeto 'juego1' de la clase JuegoDeDados.
    juego1.jugar() // Llama al metodo 'jugar' para comenzar el juego.
}