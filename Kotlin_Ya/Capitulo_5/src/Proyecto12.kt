
fun main(parametro: Array<String>) {  // Define la función principal 'main', con un parámetro de tipo Array<String>
    print("Ingrese el primer valor:")  // Muestra un mensaje solicitando al usuario que ingrese el primer valor
    val valor1 = readLine()!!.toInt()  // Lee la entrada del usuario, la convierte a un entero (Int) y la guarda en 'valor1'
    print("Ingrese el segundo valor:")  // Muestra un mensaje solicitando al usuario que ingrese el segundo valor
    val valor2 = readLine()!!.toInt()  // Lee la entrada del usuario, la convierte a un entero (Int) y la guarda en 'valor2'

    if (valor1 < valor2) {  // Verifica si 'valor1' es menor que 'valor2'
        val suma = valor1 + valor2  // Si la condición es verdadera, se calcula la suma de los dos valores y se guarda en 'suma'
        val resta = valor1 - valor2  // Se calcula la resta de 'valor1' y 'valor2' y se guarda en 'resta'
        println("La suma de los dos valores es: $suma")  // Imprime el resultado de la suma
        println("La resta de los dos valores es: $resta")  // Imprime el resultado de la resta
    } else {  // Si la condición anterior no es verdadera, se ejecuta el bloque 'else'
        val producto = valor1 * valor2  // Se calcula el producto de 'valor1' y 'valor2' y se guarda en 'producto'
        val division = valor1 / valor2  // Se calcula la división de 'valor1' entre 'valor2' y se guarda en 'division'
        println("El producto de los dos valores es: $producto")  // Imprime el resultado del producto
        println("La división de los dos valores es: $division")  // Imprime el resultado de la división
    }
}
