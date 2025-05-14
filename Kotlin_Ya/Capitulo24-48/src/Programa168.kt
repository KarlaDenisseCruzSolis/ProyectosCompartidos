class Vector4 {
    // Propiedad que representa un arreglo de 5 elementos de tipo Int. Se inicializa con los valores de 0 a 4.
    val arreglo = IntArray(5, {it})

    // Metodo para imprimir los elementos del arreglo, separados por un espacio.
    fun imprimir() {
        // Itera sobre el arreglo e imprime cada elemento seguido de un espacio.
        for (elemento in arreglo)
            print("$elemento ")
        // Imprime una nueva línea al final.
        println()
    }

    // Sobrecarga del operador `plusAssign` (+=) para sumar componente a componente dos vectores.
    operator fun plusAssign(vec2: Vector4) {
        // Itera sobre los índices del arreglo y suma los elementos correspondientes de los dos vectores.
        for(i in arreglo.indices)
            arreglo[i] += vec2.arreglo[i]
    }
}

fun main(args: Array<String>) {
    // Se crea una instancia de la clase Vector4 llamada vec1.
    val vec1 = Vector4()
    // Imprime el contenido del arreglo de vec1.
    vec1.imprimir()

    // Se crea una segunda instancia de la clase Vector4 llamada vec2.
    val vec2 = Vector4()
    // Imprime el contenido del arreglo de vec2.
    vec2.imprimir()

    // Utiliza el operador `+=` para sumar componente a componente los dos vectores.
    vec1 += vec2

    // Imprime el resultado de la suma de los dos vectores.
    vec1.imprimir()
}