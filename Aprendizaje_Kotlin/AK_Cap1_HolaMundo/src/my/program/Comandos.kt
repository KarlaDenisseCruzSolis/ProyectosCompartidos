// Función principal que se ejecuta al iniciar el programa
fun main(args: Array<String>) {
    println("Ingresa dos números separados por espacio:") //Mensaje modificado
    var input: String? // Variable para almacenar la entrada del usuario
    var validInput = false // Variable de control para validar la entrada
    var a: Int // Variable para el primer número
    var b: Int // Variable para el segundo número

    // Bucle que se repite hasta que el usuario ingrese una entrada válida
    while (!validInput) {
        input = readLine() // Leer la entrada del usuario

        // Verificar si la entrada es válida (no nula y contiene exactamente dos valores)
        if (input != null && input.split(' ').size == 2) {
            try { // Divide la entrada en dos valores y los convierte a enteros
                val (inputA, inputB) = input.split(' ')
                a = inputA.toInt()  // Convertir el primer número a entero
                b = inputB.toInt()  // Convertir el segundo número a entero
                validInput = true  // Marcar la entrada como válida
                println("El número máximo es: ${maxNum(a, b)}") // Llamar a la función maxNum() para obtener el número mayor e imprimirlo
            } catch (e: NumberFormatException) {
                println("Entrada inválida. Por favor, ingresa dos números enteros válidos.") // Si la conversión falla, mostrar un mensaje de error
            }
        } else {
            println("Entrada inválida. Por favor, ingresa exactamente dos números separados por un espacio.") // Si la entrada no tiene exactamente dos números, mostrar un mensaje de error
        }
    }
}
// Función que recibe dos números y devuelve el mayor de ellos
fun maxNum(a: Int, b: Int): Int {
    var max = if (a > b) { // Determinar cuál número es mayor usando una estructura condicional
        println("El valor de a es $a") //Mensaje modificado
        a // Retorna 'a' si es mayor
    } else {
        println("El valor de b es $b") //Mensaje modificado
        b // Retorna 'b' si es mayor o igual
    }
    return max // Devuelve el número mayor
}
