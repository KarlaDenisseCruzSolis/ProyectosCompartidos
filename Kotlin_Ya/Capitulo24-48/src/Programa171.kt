enum class Operacioon{
    SUMA,
    PROMEDIO
}
fun operar(tipoOperacion: Operacioon, vararg arreglo: Int): Int {
    when (tipoOperacion) {
        Operacioon.SUMA -> return arreglo.sum()
        Operacioon.PROMEDIO -> return arreglo.average().toInt()
    }
}
fun main(args: Array<String>) {
    val resultado1 = operar(Operacioon.SUMA, 10, 20, 30)
    println("La suma es $resultado1")
    val resultado2 = operar(Operacioon.PROMEDIO, 10, 20, 30)
    println("El promedio es $resultado2")
}