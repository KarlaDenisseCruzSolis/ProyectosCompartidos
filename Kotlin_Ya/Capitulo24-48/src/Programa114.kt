class Triangulo2 (var lado1: Int, var lado2: Int, var lado3: Int){ // Definición de la clase 'Triangulo2' con tres propiedades: 'lado1', 'lado2', y 'lado3'.
    constructor():this(0, 0, 0) { // Constructor secundario que inicializa los lados con valores por defecto (0, 0, 0) y solicita los valores del usuario.
        print("Ingrese primer lado:") // Solicita al usuario que ingrese el valor del primer lado.
        lado1 = readLine()!!.toInt() // Lee la entrada del usuario, la convierte a entero y la asigna a 'lado1'.
        print("Ingrese segundo lado:") // Solicita al usuario que ingrese el valor del segundo lado.
        lado2 = readLine()!!.toInt() // Lee la entrada del usuario, la convierte a entero y la asigna a 'lado2'.
        print("Ingrese tercer lado:") // Solicita al usuario que ingrese el valor del tercer lado.
        lado3 = readLine()!!.toInt() // Lee la entrada del usuario, la convierte a entero y la asigna a 'lado3'.
    }
    fun ladoMayor() { // Definición de la función 'ladoMayor', que no recibe parámetros.
        print("Lado mayor:") // Imprime "Lado mayor:" antes de mostrar el valor del lado mayor.
        when { // Estructura de control 'when' que evalúa cuál de los tres lados es el mayor.
            lado1 > lado2 && lado1 > lado3 -> println(lado1) // Si 'lado1' es mayor que 'lado2' y 'lado3', imprime 'lado1'.
            lado2 > lado3 -> println(lado2) // Si 'lado2' es mayor que 'lado3', pero no se cumple la primera condición, imprime 'lado2'.
            else -> println(lado3) // Si ninguna de las condiciones anteriores se cumple, imprime 'lado3'.
        }
    }
    fun esEquilatero() { // Definición de la función 'esEquilatero', que no recibe parámetros.
        if (lado1 == lado2 && lado1 == lado3) // Verifica si los tres lados son iguales, es decir, si es un triángulo equilátero.
            println("Es un triángulo equilátero") // Si los tres lados son iguales, imprime "Es un triángulo equilátero".
        else
            println("No es un triángulo equilátero") // Si no son iguales, imprime "No es un triángulo equilátero".
    }
}
fun main(parametro: Array<String>) { // Función principal 'main', que recibe un parámetro 'parametro' de tipo Array de String.
    val triangulo1 = Triangulo2() // Crea un objeto de tipo 'Triangulo2' utilizando el constructor secundario, que solicita los valores al usuario.
    triangulo1.ladoMayor() // Llama a la función 'ladoMayor' del objeto triangulo1 para mostrar el lado mayor.
    triangulo1.esEquilatero() // Llama a la función 'esEquilatero' del objeto triangulo1 para verificar si es equilátero.
    val triangulo2 = Triangulo2(6, 6, 6) // Crea un objeto de tipo 'Triangulo2' con lados 6, 6, y 6, utilizando el constructor principal.
    triangulo2.ladoMayor() // Llama a la función 'ladoMayor' del objeto triangulo2 para mostrar el lado mayor.
    triangulo2.esEquilatero() // Llama a la función 'esEquilatero' del objeto triangulo2 para verificar si es equilátero.
}