
fun presentacion() {  // Función que muestra la presentación inicial del programa
    println("Programa que permite cargar dos valores por teclado.")  // Imprime una breve descripción del programa
    println("Efectua la suma de los valores")  // Explica que el programa realiza la suma de los valores
    println("Muestra el resultado de la suma")  // Explica que el resultado de la suma será mostrado
    println("***********")  // Imprime una línea de asteriscos para separar visualmente
}

fun cargarSumar() {  // Función que pide al usuario ingresar dos valores y luego los suma
    print("Ingrese el primer valor:")  // Solicita al usuario ingresar el primer valor
    val valor1 = readLine()!!.toInt()  // Lee el valor ingresado, lo convierte a entero y lo asigna a 'valor1'

    print("Ingrese el segundo valor:")  // Solicita al usuario ingresar el segundo valor
    val valor2 = readLine()!!.toInt()  // Lee el valor ingresado, lo convierte a entero y lo asigna a 'valor2'

    val suma = valor1 + valor2  // Calcula la suma de los dos valores ingresados y la guarda en 'suma'
    println("La suma de los dos valores es: $suma")  // Muestra el resultado de la suma
}

fun finalizacion() {  // Función que muestra el mensaje de despedida
    println("***********")  // Imprime una línea de asteriscos para separar visualmente
    println("Gracias por utilizar este programa")  // Muestra un mensaje de agradecimiento
}

fun main(parametro: Array<String>) {  // Función principal del programa
    presentacion()  // Llama a la función 'presentacion()' para mostrar la descripción del programa
    cargarSumar()  // Llama a la función 'cargarSumar()' para pedir los valores e imprimir la suma
    finalizacion()  // Llama a la función 'finalizacion()' para mostrar el mensaje de despedida
}
