data class Fechaa(val dia: Int, val mes: Int, val año: Int)
fun main(args: Array<String>) {
    var feriados: Set<Fechaa> = setOf(Fechaa(1, 1, 2017),
        Fechaa(25, 12, 2017))
    println("Ingrese una fecha")
    print("Ingrese el día:")
    val dia = readLine()!!.toInt()
    print("Ingrese el mes:")
    val mes = readLine()!!.toInt()
    print("Ingrese el año:")
    val año = readLine()!!.toInt()
    if (Fechaa(dia, mes, año) in feriados)
        println("La fecha ingresada es feriado")
    else
        println("La fecha ingresada no es feriado")
}