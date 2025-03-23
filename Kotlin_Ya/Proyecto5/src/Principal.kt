fun main(argumento: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese primer valor:")
    val valor1 = readLine()!!.toInt() // Lee el valor ingresado por teclado y lo convierte a entero

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese segundo valor:")
    val valor2 = readLine()!!.toInt() // Lee el valor ingresado por teclado y lo convierte a entero

    // Calcula la suma de los dos valores
    val suma = valor1 + valor2
    // Imprime el resultado de la suma
    println("La suma de $valor1 y $valor2 es $suma")

    // Calcula el producto de los dos valores
    val producto = valor1 * valor2
    // Imprime el resultado del producto
    println("El producto de $valor1 y $valor2 es $producto")
}
