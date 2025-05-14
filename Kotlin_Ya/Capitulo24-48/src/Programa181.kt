fun main(args: Array<String>) {
    // Crear un mapa inmutable con países como claves y sus poblaciones como valores
    val paises: Map<String, Int> = mapOf( Pair("argentina", 40000000),
        Pair("españa", 46000000),
        Pair("uruguay", 3400000))

    // Imprimir el listado completo del mapa
    println("Listado completo del Map")
    println(paises)

    // Recorrer el mapa e imprimir cada clave y su valor
    for ((clave, valor) in paises)
        println("Para la clave $clave tenemos almacenado $valor")

    // Imprimir la cantidad de elementos en el mapa
    println("La cantidad de elementos del mapa es ${paises.size}")

    // Buscar la cantidad de habitantes de "argentina" y mostrar el resultado
    val cantHabitantes1: Int? = paises["argentina"]
    if (cantHabitantes1 != null)
        println("La cantidad de habitantes de argentina es $cantHabitantes1")

    // Intentar buscar la cantidad de habitantes de "brasil" y manejar si no está presente
    val cantHabitantes2: Int? = paises["brasil"]
    if (cantHabitantes2 != null)
        println("La cantidad de habitantes de brasil es $cantHabitantes2")
    else
        println("brasil no se encuentra cargado en el Map")

    // Calcular la cantidad total de habitantes sumando los valores del mapa
    var suma = 0
    paises.forEach { suma += it.value }
    println("Cantidad total de habitantes de todos los paises es $suma")
}