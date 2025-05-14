data class Fechaa(val dia: Int, val mes: Int, val año: Int)

fun main(args: Array<String>) {
    // Crear un conjunto de fechas feriadas con dos fechas iniciales
    var feriados: Set<Fechaa> = setOf(
        Fechaa(1, 1, 2017),  // Año nuevo
        Fechaa(25, 12, 2017) // Navidad
    )

    // Solicitar al usuario que ingrese una fecha
    println("Ingrese una fecha")

    // Solicitar el día de la fecha
    print("Ingrese el día:")
    val dia = readLine()!!.toInt()

    // Solicitar el mes de la fecha
    print("Ingrese el mes:")
    val mes = readLine()!!.toInt()

    // Solicitar el año de la fecha
    print("Ingrese el año:")
    val año = readLine()!!.toInt()

    // Crear una instancia de Fechaa con los datos ingresados
    val fechaIngresada = Fechaa(dia, mes, año)

    // Verificar si la fecha ingresada está en el conjunto de feriados
    if (fechaIngresada in feriados)
        println("La fecha ingresada es feriado")  // Si está en el conjunto, imprimir que es feriado
    else
        println("La fecha ingresada no es feriado")  // Si no está en el conjunto, imprimir que no es feriado
}