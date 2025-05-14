// Clase base 'Calculadora' que tiene propiedades 'valor1', 'valor2' y 'resultado'
// Contiene métodos para realizar operaciones matemáticas básicas
open class Calculadora(val valor1: Double, val valor2: Double) {
    var resultado: Double = 0.0  // Propiedad para almacenar el resultado de la operación

    // Metodo para sumar los dos valores y almacenar el resultado
    fun sumar() {
        resultado = valor1 + valor2
    }

    // Metodo para restar los dos valores y almacenar el resultado
    fun restar() {
        resultado = valor1 - valor2
    }

    // Metodo para multiplicar los dos valores y almacenar el resultado
    fun multiplicar() {
        resultado = valor1 * valor2
    }

    // Metodo para dividir los dos valores y almacenar el resultado
    fun dividir() {
        resultado = valor1 / valor2
    }

    // Metodo para imprimir el resultado de la operación
    fun imprimir() {
        println("Resultado: $resultado")
    }
}

// Clase 'CalculadoraCientifica' que hereda de 'Calculadora' y agrega operaciones científicas
class CalculadoraCientifica(valor1: Double, valor2: Double): Calculadora(valor1, valor2) {

    // Metodo para calcular el cuadrado del primer valor
    fun cuadrado() {
        resultado = valor1 * valor1
    }

    // Metodo para calcular la raíz cuadrada del primer valor
    fun raiz() {
        resultado = Math.sqrt(valor1)
    }
}

fun main(parametro: Array<String>) {
    // Prueba de la clase 'Calculadora' con una suma de dos números
    println("Prueba de la clase Calculadora (suma de dos números)")
    val calculadora1 = Calculadora(10.0, 2.0)
    calculadora1.sumar()  // Realiza la suma de los dos números
    calculadora1.imprimir()  // Imprime el resultado

    // Prueba de la clase 'CalculadoraCientifica' con una suma, cuadrado y raíz del primer número
    println("Prueba de la clase Calculadora Científica (suma de dos números y el cuadrado y la raiz del primero)")
    val calculadoraCientifica1 = CalculadoraCientifica(10.0, 2.0)
    calculadoraCientifica1.sumar()  // Realiza la suma de los dos números
    calculadoraCientifica1.imprimir()  // Imprime el resultado de la suma
    calculadoraCientifica1.cuadrado()  // Realiza el cálculo del cuadrado del primer número
    calculadoraCientifica1.imprimir()  // Imprime el resultado del cuadrado
    calculadoraCientifica1.raiz()  // Realiza el cálculo de la raíz cuadrada del primer número
    calculadoraCientifica1.imprimir()  // Imprime el resultado de la raíz
}