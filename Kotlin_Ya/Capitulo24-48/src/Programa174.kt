fun cargaar(): Int {
    print("Ingrese un entero:")
    val valor = readLine()!!.toInt()
    return valor
}
fun main(args: Array<String>) {
    var lista1: List<Int> = List(5, {cargaar()})
    println(lista1)
}