class Vector3 {
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
    operator fun inc(): Vector3 {
        var suma1 = Vector3()
        for(i in arreglo.indices)
            suma1.arreglo[i] = arreglo[i] + 1
        return suma1
    }
    operator fun dec(): Vector3 {
        var resta1 = Vector3()
        for(i in arreglo.indices)
            resta1.arreglo[i] = arreglo[i] - 1
        return resta1
    }
}
fun main(args: Array<String>) {
    var vec1 = Vector3()
    vec1.cargar()
    println("Vector original")
    vec1.imprimir()
    vec1++
    println("Luego de llamar al operador ++")
    vec1.imprimir()
    vec1--
    println("Luego de llamar al operador --")
    vec1.imprimir()
}