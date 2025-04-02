fun operarr(v1: Int, v2: Int, fn: (Int, Int) -> Int) : Int{
    return fn(v1, v2)
}
fun main(parametro: Array<String>) {
    val suma = operarr(2, 3, {x, y -> x + y})
    println(suma)
    val resta = operarr(12, 2, {x, y -> x - y})
    println(resta)
    var elevarCuarta = operarr(2, 4, {x, y ->
        var valor = 1
        for(i in 1..y)
            valor = valor * x
        valor
    })
    println(elevarCuarta)
}