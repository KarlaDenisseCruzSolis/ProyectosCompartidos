fun main(parametro: Array<String>) { //Mismo que Principal.kt  pero con cambios.
    val valor1: Int = 100 // Podemos definir la variable e inmediatamente asignar su valor. Podemos asignar un valor literal como el 100
    val valor2: Int = 400
    var resultado: Int = valor1 + valor2 //o el contenido de otras variables
    println("La suma de $valor1 + $valor2 es $resultado")
    resultado = valor1 * valor2
    println("El producto de $valor1 * $valor2 es $resultado")
}