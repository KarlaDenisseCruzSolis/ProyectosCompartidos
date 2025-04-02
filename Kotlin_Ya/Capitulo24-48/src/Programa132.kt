enum class TipoOperacionn (val tipo: String) {
    SUMA("+"),
    RESTA("-"),
    MULTIPLICACION("*"),
    DIVISION("/")
}
class Operacion (val valor1: Int, val valor2: Int, val tipoOperacion: TipoOperacionn) {
    fun operar() {
        var resultado: Int = 0
        when (tipoOperacion) {
            TipoOperacionn.SUMA -> resultado = valor1 + valor2
            TipoOperacionn.RESTA -> resultado = valor1 - valor2
            TipoOperacionn.MULTIPLICACION -> resultado = valor1 * valor2
            TipoOperacionn.DIVISION -> resultado = valor1 / valor2
        }
        println("$valor1 ${tipoOperacion.tipo} $valor2 es igual a $resultado")
    }
}
fun main(parametro: Array<String>) {
    val operacion1 = Operacion(10, 4, TipoOperacionn.SUMA)
    val operacion2 = Operacion(10, 4, TipoOperacionn.RESTA)
    val operacion3 = Operacion(10, 4, TipoOperacionn.MULTIPLICACION)
    val operacion4 = Operacion(10, 4, TipoOperacionn.DIVISION)
    operacion1.operar()
    operacion2.operar()
    operacion3.operar()
    operacion4.operar()
}