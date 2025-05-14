//ORIGINAL
/*fun imprimirSi(arreglo: IntArray, fn:(Int) -> Boolean) {
    for(elemento in arreglo)
        if (fn(elemento))
            print("$elemento ")
    println();
}
fun main(parametro: Array<String>) {
    val arreglo1 = IntArray(10)
    for(i in arreglo1.indices)
        arreglo1[i] = ((Math.random() * 100)).toInt()
    println("Imprimir los valores múltiplos de 2")
    imprimirSi(arreglo1) {x -> x % 2 == 0}
    println("Imprimir los valores múltiplos de 3 o de 5")
    imprimirSi(arreglo1) {x -> x % 3 == 0 || x % 5 ==0}
    println("Imprimir los valores mayores o iguales a 50")
    imprimirSi(arreglo1) {x -> x >= 50}
    println("Imprimir los valores comprendidos entre 1 y 10, 20 y 30, 90 y 95")
    imprimirSi(arreglo1) {x -> when(x) {
        in 1..10 -> true
        in 20..30 -> true
        in 90..95 -> true
        else -> false
    }}
    println("Imprimir todos los valores")
    imprimirSi(arreglo1) {x -> true}
}*/

//ACOTACION 1
fun imprimirSi(arreglo: IntArray, fn:(Int) -> Boolean) {
    // Recorre cada elemento del arreglo
    for(elemento in arreglo)
    // Si la función fn devuelve true para ese elemento, lo imprime
        if (fn(elemento))
            print("$elemento ")
    println();  // Salto de línea después de imprimir todos los elementos que cumplen la condición
}

fun main(parametro: Array<String>) {
    // Declara un arreglo de 10 enteros
    val arreglo1 = IntArray(10)

    // Llena el arreglo con valores aleatorios entre 0 y 99
    for(i in arreglo1.indices)
        arreglo1[i] = ((Math.random() * 100)).toInt()

    // Imprime los valores que son múltiplos de 2
    println("Imprimir los valores múltiplos de 2")
    // Se pasa una lambda que verifica si un valor es múltiplo de 2
    imprimirSi(arreglo1) {it % 2 == 0}

    // Imprime los valores que son múltiplos de 3 o 5
    println("Imprimir los valores múltiplos de 3 o de 5")
    // Se pasa una lambda que verifica si un valor es múltiplo de 3 o de 5
    imprimirSi(arreglo1) {it % 3 == 0 || it % 5 == 0}

    // Imprime los valores que son mayores o iguales a 50
    println("Imprimir los valores mayores o iguales a 50")
    // Se pasa una lambda que verifica si el valor es mayor o igual a 50
    imprimirSi(arreglo1) {it >= 50}

    // Imprime los valores que están comprendidos entre 1 y 10, 20 y 30, o 90 y 95
    println("Imprimir los valores comprendidos entre 1 y 10, 20 y 30, 90 y 95")
    // Se pasa una lambda que usa un bloque when para verificar si un valor cae dentro de ciertos rangos
    imprimirSi(arreglo1) {when(it) {
        in 1..10 -> true
        in 20..30 -> true
        in 90..95 -> true
        else -> false
    }}

    // Imprime todos los valores del arreglo
    println("Imprimir todos los valores")
    // Se pasa una lambda que siempre devuelve true, por lo que todos los valores se imprimirán
    imprimirSi(arreglo1) {true}
}