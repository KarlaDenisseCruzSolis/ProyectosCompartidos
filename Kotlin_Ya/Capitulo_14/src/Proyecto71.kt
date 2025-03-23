
fun cargarSuma() {  // Función que solicita al usuario dos valores y calcula su suma
    print("Ingrese el primer valor:")  // Solicita al usuario que ingrese el primer valor
    val valor1 = readLine()!!.toInt()  // Lee el valor ingresado, lo convierte a entero y lo guarda en 'valor1'

    print("Ingrese el segundo valor:")  // Solicita al usuario que ingrese el segundo valor
    val valor2 = readLine()!!.toInt()  // Lee el valor ingresado, lo convierte a entero y lo guarda en 'valor2'

    val suma = valor1 + valor2  // Calcula la suma de los dos valores ingresados y lo guarda en 'suma'
    println("La suma de los dos valores es: $suma")  // Muestra el resultado de la suma
}

fun separacion() {  // Función que imprime una línea de separación
    println("***********")  // Imprime una línea de asteriscos para separar visualmente las ejecuciones
}

fun main(parametro: Array<String>) {  // Función principal del programa
    for (i in 1..5) {  // Ciclo que se ejecuta 5 veces
        cargarSuma()  // Llama a la función 'cargarSuma()' para pedir los valores e imprimir la suma
        separacion()  // Llama a la función 'separacion()' para imprimir una línea de separación
    }
}
