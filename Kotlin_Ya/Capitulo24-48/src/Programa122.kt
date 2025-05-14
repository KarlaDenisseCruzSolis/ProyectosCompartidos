class Operaciones2 { // Definición de la clase Operaciones2 que contiene las operaciones de suma y resta.
    private var valor1: Int = 0 // Declaración de la variable privada 'valor1', inicializada en 0.
    private var valor2: Int = 0 // Declaración de la variable privada 'valor2', inicializada en 0.

    fun cargar() { // Metodo público 'cargar' que solicita al usuario ingresar los valores.
        print("Ingrese primer valor:") // Solicita el primer valor al usuario.
        valor1 = readLine()!!.toInt() // Lee el valor ingresado por el usuario y lo convierte a un entero.
        print("Ingrese segundo valor:") // Solicita el segundo valor al usuario.
        valor2 = readLine()!!.toInt() // Lee el segundo valor ingresado y lo convierte a un entero.
        sumar() // Llama al metodo 'sumar' para realizar la suma.
        restar() // Llama al metodo 'restar' para realizar la resta.
    }

    private fun sumar() { // Metodo privado 'sumar' para realizar la suma de los dos valores.
        val suma = valor1 + valor2 // Realiza la suma de 'valor1' y 'valor2' y la guarda en 'suma'.
        println("La suma de $valor1 y $valor2 es $suma") // Imprime el resultado de la suma.
    }

    private fun restar() { // Metodo privado 'restar' para realizar la resta de los dos valores.
        val resta = valor1 - valor2 // Realiza la resta de 'valor1' y 'valor2' y la guarda en 'resta'.
        println("La resta de $valor1 y $valor2 es $resta") // Imprime el resultado de la resta.
    }
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta la lógica del programa.
    val operaciones1 = Operaciones2() // Crea un objeto 'operaciones1' de la clase 'Operaciones2'.
    operaciones1.cargar() // Llama al metodo 'cargar' para que el usuario ingrese los valores y realice las operaciones.
}