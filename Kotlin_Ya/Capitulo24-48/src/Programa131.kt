// Definición del enum TipoCarta, que tiene cuatro valores: DIAMANTE, TREBOL, CORAZON, y PICA.
enum class TipoCarta {
    DIAMANTE, // Representa el tipo de carta Diamante.
    TREBOL,   // Representa el tipo de carta Trebol.
    CORAZON,  // Representa el tipo de carta Corazon.
    PICA      // Representa el tipo de carta Pica.
}

// Clase Carta que toma como parámetros un tipo de carta (TipoCarta) y un valor (Int).
class Carta(val tipo: TipoCarta, val valor: Int) {

    // Metodo para imprimir la carta, mostrando su tipo y su valor.
    fun imprimir() {
        println("Carta: $tipo y su valor es $valor") // Imprime en consola el tipo y valor de la carta.
    }
}

// Función principal 'main' que ejecuta el programa.
fun main(parametro: Array<String>) {

    // Crea un objeto 'carta1' de la clase Carta con tipo TREBOL y valor 4.
    val carta1 = Carta(TipoCarta.TREBOL, 4)

    // Llama al metodo imprimir para mostrar en consola los detalles de 'carta1'.
    carta1.imprimir()
}
