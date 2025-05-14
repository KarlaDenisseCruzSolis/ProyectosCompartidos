class Operaciones { // Definición de la clase 'Operaciones' que tendrá dos propiedades 'valor1' y 'valor2' para almacenar números enteros.

    var valor1: Int = 0 // Propiedad 'valor1' que se inicializa con 0.
    var valor2: Int = 0 // Propiedad 'valor2' que se inicializa con 0.

    fun cargar() { // Función 'cargar' que solicita al usuario ingresar dos valores y luego realiza las operaciones.
        print("Ingrese primer valor:") // Muestra un mensaje pidiendo el primer valor.
        valor1 = readLine()!!.toInt() // Lee la entrada del usuario y convierte el valor a un entero para asignarlo a 'valor1'.
        print("Ingrese segundo valor:") // Muestra un mensaje pidiendo el segundo valor.
        valor2 = readLine()!!.toInt() // Lee la entrada del usuario y convierte el valor a un entero para asignarlo a 'valor2'.
        sumar() // Llama a la función 'sumar' para realizar la suma de los valores.
        restar() // Llama a la función 'restar' para realizar la resta de los valores.
    }

    fun sumar() { // Función 'sumar' que calcula la suma de 'valor1' y 'valor2'.
        val suma = valor1 + valor2 // Calcula la suma de los dos valores.
        println("La suma de $valor1 y $valor2 es $suma") // Muestra el resultado de la suma.
    }

    fun restar() { // Función 'restar' que calcula la resta de 'valor1' y 'valor2'.
        val resta = valor1 - valor2 // Calcula la resta de los dos valores.
        println("La resta de $valor1 y $valor2 es $resta") // Muestra el resultado de la resta.
    }
}

fun main(parametro: Array<String>) { // Función principal 'main', que ejecuta el programa.
    val operaciones1 = Operaciones() // Crea un objeto de la clase 'Operaciones' llamado 'operaciones1'.
    operaciones1.cargar() // Llama a la función 'cargar' del objeto 'operaciones1' para ingresar los valores y realizar las operaciones.
}