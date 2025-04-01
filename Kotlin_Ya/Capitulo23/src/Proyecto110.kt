// Definición de la clase Triangulo
class Triangulo {
    // Atributos para los tres lados del triángulo, todos de tipo entero
    var lado1: Int = 0
    var lado2: Int = 0
    var lado3: Int = 0

    // Metodo para inicializar los lados del triángulo solicitando al usuario los valores
    fun inicializar() {
        // Solicita el valor del lado 1 y lo almacena
        print("Ingrese lado 1:")
        lado1 = readLine()!!.toInt()

        // Solicita el valor del lado 2 y lo almacena
        print("Ingrese lado 2:")
        lado2 = readLine()!!.toInt()

        // Solicita el valor del lado 3 y lo almacena
        print("Ingrese lado 3:")
        lado3 = readLine()!!.toInt()
    }

    // Metodo que determina el lado mayor del triángulo
    fun ladoMayor() {
        // Imprime el mensaje "Lado mayor:"
        print("Lado mayor:")

        // Usamos 'when' para determinar cuál de los tres lados es el mayor
        when {
            // Si lado1 es mayor que los otros dos, se imprime el valor de lado1
            lado1 > lado2 && lado1 > lado3 -> println(lado1)

            // Si lado2 es mayor que lado3, se imprime el valor de lado2
            lado2 > lado3 -> println(lado2)

            // Si ninguna de las condiciones anteriores es verdadera, se imprime lado3
            else -> println(lado3)
        }
    }

    // Metodo que verifica si el triángulo es equilátero
    fun esEquilatero() {
        // Si los tres lados son iguales, es un triángulo equilátero
        if (lado1 == lado2 && lado1 == lado3)
            print("Es un triángulo equilátero")
        else
            print("No es un triángulo equilátero")
    }
}

// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {
    // Se crea una instancia de la clase Triangulo
    val triangulo1 = Triangulo()

    // Se inicializan los valores de los lados del triángulo
    triangulo1.inicializar()

    // Se determina e imprime el lado mayor del triángulo
    triangulo1.ladoMayor()

    // Se verifica si el triángulo es equilátero e imprime el resultado
    triangulo1.esEquilatero()
}
