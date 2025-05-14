fun recorrerTodo(arreglo: IntArray, fn:(Int) -> Unit) {
    for(elemento in arreglo)
        (fn(elemento))  // Ejecuta la función fn con el elemento del arreglo
}

fun main(parametro: Array<String>) {
    // Se crea un arreglo de 10 elementos con valores aleatorios entre 0 y 99
    val arreglo1 = IntArray(10)
    for (i in arreglo1.indices)
        arreglo1[i] = ((Math.random() * 100)).toInt()  // Asigna un valor aleatorio entre 0 y 99 a cada elemento del arreglo

    // Se imprime todo el arreglo
    println("Impresion de todo el arreglo")
    for (elemento in arreglo1)
        print("$elemento ")  // Imprime cada elemento del arreglo seguido de un espacio
    println()  // Salto de línea

    // Se inicializa la variable cantidad para contar cuántos múltiplos de 3 hay
    var cantidad = 0
    // Se llama a la función recorrerTodo para contar los múltiplos de 3
    recorrerTodo(arreglo1) {
        if (it % 3 == 0)  // Si el número es múltiplo de 3, se incrementa cantidad
            cantidad++
    }
    println("La cantidad de elementos múltiplos de 3 son $cantidad")

    // Se inicializa la variable suma para calcular la suma de los elementos mayores a 50
    var suma = 0
    // Se llama a la función recorrerTodo para calcular la suma de los elementos mayores a 50
    recorrerTodo(arreglo1) {
        if (it > 50)  // Si el número es mayor a 50, se añade a la variable suma
            suma += it
    }
    println("La suma de todos los elementos mayores a 50 es $suma")
}