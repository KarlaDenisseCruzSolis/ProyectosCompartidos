class Vector0 {
    val arreglo = IntArray(5)
    fun cargar() {
        for(i in arreglo.indices)
            arreglo[i] = (Math.random() * 11 + 1).toInt()
    }
    fun imprimir() {
        for(elemento in arreglo)
            print("$elemento ")
        println()
    }
    operator fun plus(vector2: Vector0): Vector0 {
        var suma = Vector0()
        for(i in arreglo.indices)
            suma.arreglo[i] = arreglo[i] + vector2.arreglo[i]
        return suma
    }
    operator fun minus(vector2: Vector0): Vector0 {
        var resta = Vector0()
        for(i in arreglo.indices)
            resta.arreglo[i] = arreglo[i] - vector2.arreglo[i]
        return resta
    }
    operator fun times(vector2: Vector0): Vector0 {
        var producto = Vector0()
        for(i in arreglo.indices)
            producto.arreglo[i] = arreglo[i] * vector2.arreglo[i]
        return producto
    }
    operator fun div(vector2: Vector0): Vector0 {
        var division = Vector0()
        for(i in arreglo.indices)
            division.arreglo[i] = arreglo[i] / vector2.arreglo[i]
        return division
    }
}
fun main(args: Array<String>) {
    val vec1 = Vector0()
    vec1.cargar()
    val vec2 = Vector0()
    vec2.cargar()
    vec1.imprimir()
    vec2.imprimir()
    val vecSuma = vec1 + vec2
    println("Suma componente a componente de los dos vectores")
    vecSuma.imprimir()
    val vecResta = vec1 - vec2
    println("La resta componente a componente de los dos vectores")
    vecResta.imprimir()
    val vecProducto = vec1 * vec2
    println("El producto componente a componente de los dos vectores")
    vecProducto.imprimir()
    val vecDivision = vec1 / vec2
    println("La división componente a componente de los dos vectores")
    vecDivision.imprimir()
}