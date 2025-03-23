
fun main(parametro: Array<String>) {  // Define la función principal 'main', con un parámetro de tipo Array<String> (no utilizado en este caso)
    print("Ingrese primer valor:")  // Solicita al usuario que ingrese el primer valor
    val valor1 = readLine()!!.toInt()  // Lee el valor ingresado por el usuario, lo convierte a entero (Int) y lo guarda en 'valor1'
    print("Ingrese segundo valor:")  // Solicita al usuario que ingrese el segundo valor
    val valor2 = readLine()!!.toInt()  // Lee el valor ingresado por el usuario, lo convierte a entero (Int) y lo guarda en 'valor2'
    // Compara los dos valores y asigna a 'mayor' el valor más grande entre valor1 y valor2
    val mayor = if (valor1 > valor2) valor1 else valor2
    // Imprime el mayor de los dos valores
    println("El mayor entre $valor1 y $valor2 es $mayor")
}
