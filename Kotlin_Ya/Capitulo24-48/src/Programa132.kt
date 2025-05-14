// Enum que define los tipos de operación que se pueden realizar
enum class TipoOperacionn (val tipo: String) {
    SUMA("+"), // Representa la operación de suma
    RESTA("-"), // Representa la operación de resta
    MULTIPLICACION("*"), // Representa la operación de multiplicación
    DIVISION("/") // Representa la operación de división
}

// Clase Operacion que realiza una operación entre dos números
class Operacion (val valor1: Int, val valor2: Int, val tipoOperacion: TipoOperacionn) {
    // Metodo que ejecuta la operación según el tipo de operación seleccionado
    fun operar() {
        var resultado: Int = 0 // Variable para almacenar el resultado de la operación

        // Estructura 'when' para elegir la operación correspondiente
        when (tipoOperacion) {
            TipoOperacionn.SUMA -> resultado = valor1 + valor2 // Suma
            TipoOperacionn.RESTA -> resultado = valor1 - valor2 // Resta
            TipoOperacionn.MULTIPLICACION -> resultado = valor1 * valor2 // Multiplicación
            TipoOperacionn.DIVISION -> resultado = valor1 / valor2 // División
        }

        // Imprime el resultado de la operación
        println("$valor1 ${tipoOperacion.tipo} $valor2 es igual a $resultado")
    }
}

fun main(parametro: Array<String>) {
    // Se crean instancias de la clase Operacion con diferentes tipos de operaciones
    val operacion1 = Operacion(10, 4, TipoOperacionn.SUMA) // Operación de suma
    val operacion2 = Operacion(10, 4, TipoOperacionn.RESTA) // Operación de resta
    val operacion3 = Operacion(10, 4, TipoOperacionn.MULTIPLICACION) // Operación de multiplicación
    val operacion4 = Operacion(10, 4, TipoOperacionn.DIVISION) // Operación de división

    // Se ejecutan las operaciones
    operacion1.operar()
    operacion2.operar()
    operacion3.operar()
    operacion4.operar()
}