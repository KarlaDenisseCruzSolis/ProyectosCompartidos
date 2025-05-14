class Vector3 {
    // Crea un arreglo de enteros de tamaño 5
    val arreglo = IntArray(5)

    // Metodo para cargar el arreglo con valores aleatorios entre 1 y 11
    fun cargar() {
        for (i in arreglo.indices)
        // Asigna un número aleatorio entre 1 y 11 (inclusive) a cada posición del arreglo
            arreglo[i] = (Math.random() * 11 + 1).toInt()
    }

    // Metodo para imprimir los elementos del arreglo
    fun imprimir() {
        for (elemento in arreglo)
            print("$elemento ") // Imprime cada elemento del arreglo
        println() // Salto de línea al final de la impresión
    }

    // Sobrecarga del operador "++" (incremento)
    // Este operador suma 1 a cada elemento del arreglo
    operator fun inc(): Vector3 {
        var suma1 = Vector3() // Crea un nuevo objeto Vector3 para almacenar el resultado
        for (i in arreglo.indices)
        // Incrementa cada elemento del vector en 1
            suma1.arreglo[i] = arreglo[i] + 1
        return suma1 // Retorna el vector con los elementos incrementados
    }

    // Sobrecarga del operador "--" (decremento)
    // Este operador resta 1 a cada elemento del arreglo
    operator fun dec(): Vector3 {
        var resta1 = Vector3() // Crea un nuevo objeto Vector3 para almacenar el resultado
        for (i in arreglo.indices)
        // Decrementa cada elemento del vector en 1
            resta1.arreglo[i] = arreglo[i] - 1
        return resta1 // Retorna el vector con los elementos decrementados
    }
}

fun main(args: Array<String>) {
    // Crea un objeto de tipo Vector3
    var vec1 = Vector3()
    vec1.cargar() // Carga el vector con valores aleatorios

    // Imprime el vector original
    println("Vector original")
    vec1.imprimir()

    // Llama al operador "++" (incremento)
    vec1++
    println("Luego de llamar al operador ++")
    vec1.imprimir()

    // Llama al operador "--" (decremento)
    vec1--
    println("Luego de llamar al operador --")
    vec1.imprimir()
}