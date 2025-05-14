// Función que recibe una cantidad variable de enteros como parámetros
fun sumar(vararg numeros: Int): Int {
    // Inicializamos la variable suma en 0 para almacenar el total
    var suma = 0

    // Iteramos sobre cada número en el array 'numeros'
    for(elemento in numeros)
    // Acumulamos cada número en la variable suma
        suma += elemento

    // Devolvemos la suma total
    return suma
}

fun main(args: Array<String>) {
    // Llamamos a la función sumar con varios valores y almacenamos el resultado en 'total'
    val total = sumar(10, 20, 30, 40, 50)

    // Imprimimos el resultado de la suma
    println(total)
}