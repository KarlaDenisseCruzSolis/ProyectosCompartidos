//Lectura de entrada desde la línea de comandos
fun main(args: Array<String>) {
    println("Ingresa dos números separados por espacio:") //Cambié mensaje original
    var input: String?
    var validInput = false
    var a: Int
    var b: Int

    // Bucle para asegurar que los datos sean números enteros
    while (!validInput) {
        input = readLine()

        // Intentar leer los números y validarlos
        if (input != null && input.split(' ').size == 2) {
            try {
                val (inputA, inputB) = input.split(' ')
                a = inputA.toInt()  // Convertir a número entero
                b = inputB.toInt()  // Convertir a número entero
                validInput = true  // Si no hay error, los números son válidos
                println("El número máximo es: ${maxNum(a, b)}")
            } catch (e: NumberFormatException) {
                println("Entrada inválida. Por favor, ingresa dos números enteros válidos.")
            }
        } else {
            println("Entrada inválida. Por favor, ingresa exactamente dos números separados por un espacio.")
        }
    }
}

fun maxNum(a: Int, b: Int): Int {
    var max = if (a > b) {
        println("El valor de a es $a") //Cambié mensaje original
        a
    } else {
        println("El valor de b es $b") //Cambié mensaje original
        b
    }
    return max
}
