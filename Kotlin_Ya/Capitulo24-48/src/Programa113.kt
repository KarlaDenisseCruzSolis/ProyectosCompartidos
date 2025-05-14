class Triangulos (var lado1: Int, var lado2: Int, var lado3: Int){ // Definición de la clase 'Triangulos' con tres propiedades: 'lado1', 'lado2', y 'lado3'.
    fun ladoMayor() { // Definición de la función 'ladoMayor', que no recibe parámetros.
        print("Lado mayor:") // Imprime la cadena "Lado mayor:" antes de mostrar el valor del lado mayor.
        when { // Estructura de control 'when' que evalúa cuál de los tres lados es el mayor.
            lado1 > lado2 && lado1 > lado3 -> println(lado1) // Si 'lado1' es mayor que 'lado2' y 'lado3', imprime 'lado1'.
            lado2 > lado3 -> println(lado2) // Si 'lado2' es mayor que 'lado3', pero no se cumple la primera condición, imprime 'lado2'.
            else -> println(lado3) // Si ninguna de las condiciones anteriores se cumple, imprime 'lado3'.
        }
    }
    fun esEquilatero() { // Definición de la función 'esEquilatero', que no recibe parámetros.
        if (lado1 == lado2 && lado1 == lado3) // Verifica si los tres lados son iguales, es decir, si es un triángulo equilátero.
            print("Es un triángulo equilátero") // Si los tres lados son iguales, imprime "Es un triángulo equilátero".
        else
            print("No es un triángulo equilátero") // Si no son iguales, imprime "No es un triángulo equilátero".
    }
}
fun main(parametro: Array<String>) { // Función principal 'main', que recibe un parámetro 'parametro' de tipo Array de String.
    val triangulo1 = Triangulos(12, 45, 24) // Crea un objeto de tipo 'Triangulos' con lados 12, 45, y 24.
    triangulo1.ladoMayor() // Llama a la función 'ladoMayor' del objeto triangulo1 para mostrar el lado mayor.
    triangulo1.esEquilatero() // Llama a la función 'esEquilatero' del objeto triangulo1 para verificar si es equilátero.
}