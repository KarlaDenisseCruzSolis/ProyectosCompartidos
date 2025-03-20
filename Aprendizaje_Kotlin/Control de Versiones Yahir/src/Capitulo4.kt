fun Capitulo4(){
    println("Capitulo 4: Arreglos \n")
    // Archivo: Capitulo4.kt

// Arreglo Genérico con emptyArray
    val empty = emptyArray<String>() // Crea un arreglo vacío de Strings

// Crear un arreglo con tamaño y valores iniciales
    var strings = Array<String>(size = 5, init = { index -> "Item #$index" })
    println(strings.joinToString()) // Muestra los elementos del arreglo

// Cambiar el valor en un índice específico
    strings[2] = "ChangedItem"
    println(strings[2]) // Muestra el valor cambiado

// Obtener el valor con .get() o usando el índice directamente
    println(strings.get(2)) // Muestra el valor cambiado
    println(strings[2]) // Muestra el valor cambiado

// Funciones sobre arreglos
    println("Promedio de un arreglo de doubles: " + doubleArrayOf(1.5, 3.0).average())  // Promedio de un arreglo de Double
    println("Promedio de un arreglo de enteros: " + intArrayOf(1, 4).average())  // Promedio de un arreglo de Int

// Uso de `first()` y `last()` en arreglos
    val firstElement = strings.first()  // Primer elemento
    val lastElement = strings.last()  // Último elemento
    println("Primer elemento: $firstElement")
    println("Último elemento: $lastElement")

// Crear un arreglo sin inicializar (arreglo de elementos anulables)
    val nullArray = arrayOfNulls<Int>(3)  // Crea un arreglo de Int? con valores null
    println(nullArray.joinToString())  // Muestra el arreglo de nulos

// Iterar sobre un arreglo
    val asc = Array(5) { i -> (i * i).toString() }
    for (s in asc) {
        println(s)  // Muestra cada elemento del arreglo
    }

// Ordenar arreglos
    val sortedArray = strings.sortedArray() // Ordena en orden ascendente
    println("Arreglo ordenado: ${sortedArray.joinToString()}")

    val sortedDescendingArray = strings.sortedArrayDescending() // Ordena en orden descendente
    println("Arreglo ordenado de forma descendente: ${sortedDescendingArray.joinToString()}")

// Crear un HashSet a partir de un arreglo
    val hashSet = strings.toHashSet()
    println("HashSet creado: $hashSet")
    println("")
}