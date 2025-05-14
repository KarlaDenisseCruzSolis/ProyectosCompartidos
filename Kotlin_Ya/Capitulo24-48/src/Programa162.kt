class Vector0 {
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

    // Operador '+' sobrecargado para sumar dos vectores componente a componente
    operator fun plus(vector2: Vector0): Vector0 {
        var suma = Vector0() // Crea un nuevo objeto Vector0 para almacenar la suma
        for (i in arreglo.indices)
        // Suma cada elemento del vector actual con el correspondiente del segundo vector
            suma.arreglo[i] = arreglo[i] + vector2.arreglo[i]
        return suma // Retorna el vector con la suma
    }

    // Operador '-' sobrecargado para restar dos vectores componente a componente
    operator fun minus(vector2: Vector0): Vector0 {
        var resta = Vector0() // Crea un nuevo objeto Vector0 para almacenar la resta
        for (i in arreglo.indices)
        // Resta cada elemento del vector actual con el correspondiente del segundo vector
            resta.arreglo[i] = arreglo[i] - vector2.arreglo[i]
        return resta // Retorna el vector con la resta
    }

    // Operador '*' sobrecargado para multiplicar dos vectores componente a componente
    operator fun times(vector2: Vector0): Vector0 {
        var producto = Vector0() // Crea un nuevo objeto Vector0 para almacenar el producto
        for (i in arreglo.indices)
        // Multiplica cada elemento del vector actual con el correspondiente del segundo vector
            producto.arreglo[i] = arreglo[i] * vector2.arreglo[i]
        return producto // Retorna el vector con el producto
    }

    // Operador '/' sobrecargado para dividir dos vectores componente a componente
    operator fun div(vector2: Vector0): Vector0 {
        var division = Vector0() // Crea un nuevo objeto Vector0 para almacenar la división
        for (i in arreglo.indices)
        // Divide cada elemento del vector actual por el correspondiente del segundo vector
            division.arreglo[i] = arreglo[i] / vector2.arreglo[i]
        return division // Retorna el vector con la división
    }
}

fun main(args: Array<String>) {
    // Crea dos objetos de tipo Vector0
    val vec1 = Vector0()
    vec1.cargar() // Carga el primer vector con valores aleatorios

    val vec2 = Vector0()
    vec2.cargar() // Carga el segundo vector con valores aleatorios

    // Imprime ambos vectores
    vec1.imprimir()
    vec2.imprimir()

    // Suma los dos vectores componente a componente
    val vecSuma = vec1 + vec2
    println("Suma componente a componente de los dos vectores")
    vecSuma.imprimir()

    // Resta los dos vectores componente a componente
    val vecResta = vec1 - vec2
    println("La resta componente a componente de los dos vectores")
    vecResta.imprimir()

    // Multiplica los dos vectores componente a componente
    val vecProducto = vec1 * vec2
    println("El producto componente a componente de los dos vectores")
    vecProducto.imprimir()

    // Divide los dos vectores componente a componente
    val vecDivision = vec1 / vec2
    println("La división componente a componente de los dos vectores")
    vecDivision.imprimir()
}