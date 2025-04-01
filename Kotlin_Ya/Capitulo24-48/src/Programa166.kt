class TaTeTi {
    val tablero = IntArray(9)
    fun imprimir() {
        for(fila in 0..2) {
            for (columna in 0..2)
                print("${this[fila, columna]} ")
            println()
        }
        println()
    }
    operator fun set(fila: Int, columna: Int, valor: Int){
        tablero[fila*3 + columna] = valor
        imprimir()
    }
    operator fun get(fila: Int, columna: Int): Int{
        return tablero[fila*3 + columna]
    }
}
fun main(args: Array<String>) {
    val juego = TaTeTi()
    juego[0, 0] = 1
    juego[0, 2] = 2
    juego[2, 0] = 1
    juego[1, 2] = 2
    juego[1, 0] = 1
}