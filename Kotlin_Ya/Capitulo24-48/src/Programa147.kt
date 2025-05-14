// Función de orden superior que recibe dos enteros y una función que opera sobre ellos, y devuelve el resultado
fun operar(v1: Int, v2: Int, fn: (Int, Int) -> Int) : Int {
    return fn(v1, v2) // Se aplica la función 'fn' a los valores v1 y v2
}

// Función que suma dos enteros
fun sumar(x1: Int, x2: Int) = x1 + x2

// Función que resta el segundo entero al primero
fun restar(x1: Int, x2: Int) = x1 - x2

// Función que multiplica dos enteros
fun multiplicar(x1: Int, x2: Int) = x1 * x2

// Función que divide el primer entero entre el segundo
fun dividir(x1: Int, x2: Int) = x1 / x2

fun main(parametro: Array<String>) {
    // Se llama a la función 'operar' pasando 10, 5 y la función de suma
    val resu1 = operar(10, 5, ::sumar)
    println("La suma de 10 y 5 es $resu1")

    // Otra llamada a 'operar' usando la suma, con valores distintos
    val resu2 = operar(5, 2, ::sumar)
    println("La suma de 5 y 2 es $resu2")

    // Llamada a 'operar' para restar 40 a 100
    println("La resta de 100 y 40 es ${operar(100, 40, ::restar)}")

    // Llamada a 'operar' para multiplicar 5 por 20
    println("El producto entre 5 y 20 es ${operar(5, 20, ::multiplicar)}")

    // Llamada a 'operar' para dividir 10 entre 5
    println("La división entre 10 y 5 es ${operar(10, 5, ::dividir)}")
}