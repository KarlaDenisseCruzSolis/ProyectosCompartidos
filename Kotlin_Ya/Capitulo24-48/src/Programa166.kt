class TaTeTi {
    // Propiedad que representa el tablero del juego, un arreglo de enteros de 9 elementos.
    val tablero = IntArray(9)

    // Metodo para imprimir el estado actual del tablero.
    fun imprimir() {
        // Itera a través de las filas (0, 1, 2)
        for(fila in 0..2) {
            // Itera a través de las columnas (0, 1, 2) para cada fila
            for (columna in 0..2)
            // Imprime el valor en la posición [fila, columna] del tablero
                print("${this[fila, columna]} ")
            // Salto de línea después de imprimir cada fila
            println()
        }
        // Salto de línea adicional después de imprimir el tablero completo
        println()
    }

    // Sobrecarga del operador "set" para asignar un valor en la posición [fila, columna] del tablero.
    operator fun set(fila: Int, columna: Int, valor: Int) {
        // Calcula la posición en el arreglo del tablero con la fórmula fila*3 + columna
        tablero[fila*3 + columna] = valor
        // Llama al método imprimir para mostrar el estado del tablero después de realizar el movimiento
        imprimir()
    }

    // Sobrecarga del operador "get" para obtener el valor en la posición [fila, columna] del tablero.
    operator fun get(fila: Int, columna: Int): Int {
        // Devuelve el valor correspondiente en el tablero usando la fórmula fila*3 + columna
        return tablero[fila*3 + columna]
    }
}

fun main(args: Array<String>) {
    // Se crea una instancia del juego TaTeTi
    val juego = TaTeTi()

    // Se asignan valores en el tablero utilizando los operadores sobrecargados
    // Los valores "1" y "2" representan los jugadores, y se colocan en diferentes posiciones del tablero
    juego[0, 0] = 1  // Jugador 1 coloca en la posición (0,0)
    juego[0, 2] = 2  // Jugador 2 coloca en la posición (0,2)
    juego[2, 0] = 1  // Jugador 1 coloca en la posición (2,0)
    juego[1, 2] = 2  // Jugador 2 coloca en la posición (1,2)
    juego[1, 0] = 1  // Jugador 1 coloca en la posición (1,0)
}