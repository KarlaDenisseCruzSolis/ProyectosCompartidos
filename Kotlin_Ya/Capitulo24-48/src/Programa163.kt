class Vector1 {
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

    // Operador '*' sobrecargado para multiplicar un vector por un valor entero
    operator fun times(valor: Int): Vector1 {
        var producto = Vector1() // Crea un nuevo objeto Vector1 para almacenar el resultado
        for (i in arreglo.indices)
        // Multiplica cada elemento del vector por el valor entero
            producto.arreglo[i] = arreglo[i] * valor
        return producto // Retorna el vector con el producto
    }
}

fun main(args: Array<String>) {
    // Crea un objeto de tipo Vector1
    val vec1 = Vector1()
    vec1.cargar() // Carga el vector con valores aleatorios

    // Imprime el vector original
    vec1.imprimir()

    // Imprime el mensaje antes de mostrar el producto
    println("El producto de un vector con el número 10 es")

    // Multiplica el vector vec1 por el número 10
    val vecProductoEnt = vec1 * 10
    // Imprime el resultado del producto
    vecProductoEnt.imprimir()
}