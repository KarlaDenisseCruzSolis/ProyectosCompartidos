
fun mmostrarMensaje(mensaje: String) {  // Función que muestra un mensaje enmarcado con asteriscos
    println("*****************")  // Imprime una línea de asteriscos para enmarcar el mensaje
    println(mensaje)  // Imprime el mensaje que se pasa como parámetro
    println("*****************")  // Imprime otra línea de asteriscos para cerrar el enmarcado
}

fun cargarSumar() {  // Función que solicita dos valores al usuario y calcula su suma
    print("Ingrese el primer valor:")  // Solicita al usuario el primer valor
    val valor1 = readLine()!!.toInt()  // Lee el valor ingresado, lo convierte a entero y lo guarda en 'valor1'

    print("Ingrese el segundo valor:")  // Solicita al usuario el segundo valor
    val valor2 = readLine()!!.toInt()  // Lee el valor ingresado, lo convierte a entero y lo guarda en 'valor2'

    val suma = valor1 + valor2  // Calcula la suma de los dos valores ingresados y lo guarda en 'suma'
    println("La suma de los dos valores es: $suma")  // Muestra el resultado de la suma
}

fun main(parametro: Array<String>) {  // Función principal del programa
    mmostrarMensaje("El programa calcula la suma de dos valores ingresados por teclado.")  // Muestra un mensaje introductorio
    cargarSumar()  // Llama a la función 'cargarSumar()' para solicitar los valores y calcular la suma
    mmostrarMensaje("Gracias por utilizar este programa")  // Muestra un mensaje final de agradecimiento
}
