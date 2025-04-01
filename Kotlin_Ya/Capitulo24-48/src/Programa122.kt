class Operaciones2 {
    private var valor1: Int = 0
    private var valor2: Int = 0
    fun cargar() {
        print("Ingrese primer valor:")
        valor1 = readLine()!!.toInt()
        print("Ingrese segundo valor:")
        valor2 = readLine()!!.toInt()
        sumar()
        restar()
    }
    private fun sumar() {
        val suma = valor1 + valor2
        println("La suma de $valor1 y $valor2 es $suma")
    }
    private fun restar() {
        val resta = valor1 - valor2
        println("La resta de $valor1 y $valor2 es $resta")
    }
}
fun main(parametro: Array<String>) {
    val operaciones1 = Operaciones2()
    operaciones1.cargar()
}