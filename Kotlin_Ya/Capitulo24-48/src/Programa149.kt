// Función que recibe dos enteros y una función que opera sobre ellos, y devuelve el resultado
fun operarr(v1: Int, v2: Int, fn: (Int, Int) -> Int) : Int {
    return fn(v1, v2)  // Ejecuta la función pasada como parámetro con v1 y v2
}

fun main(parametro: Array<String>) {
    // Llama a operarr pasando una lambda que suma 2 y 3
    val suma = operarr(2, 3, { x, y -> x + y })
    println(suma)  // Imprime: 5

    // Llama a operarr pasando una lambda que resta 12 - 2
    val resta = operarr(12, 2, { x, y -> x - y })
    println(resta)  // Imprime: 10

    // Llama a operarr con una lambda que eleva 2 a la 4ta potencia (2^4 = 16)
    var elevarCuarta = operarr(2, 4, { x, y ->
        var valor = 1  // Variable que almacena el resultado
        for(i in 1..y)  // Repite y veces
            valor = valor * x  // Multiplica valor por x cada vez
        valor  // Devuelve el resultado
    })
    println(elevarCuarta)  // Imprime: 16
}