fun recorrerTodo(arreglo: IntArray, fn:(Int) -> Unit) {
    for(elemento in arreglo)
        (fn(elemento))
}
fun main(parametro: Array<String>) {
    val arreglo1 = IntArray(10)
    for (i in arreglo1.indices)
        arreglo1[i] = ((Math.random() * 100)).toInt()
    println("Impresion de todo el arreglo")
    for (elemento in arreglo1)
        print("$elemento ")
    println()
    var cantidad = 0
    recorrerTodo(arreglo1) {
        if (it % 3 == 0)
            cantidad++
    }
    println("La cantidad de elementos múltiplos de 3 son $cantidad")
    var suma = 0
    recorrerTodo(arreglo1) {
        if (it > 50)
            suma += it
    }
    println("La suma de todos los elementos mayores a 50 es $suma")
}