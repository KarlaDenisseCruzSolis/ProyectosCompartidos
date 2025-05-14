// Clase abstracta 'Operacionn' que define una estructura común para operaciones matemáticas
// Contiene las propiedades 'valor1', 'valor2' y 'resultado', y un metodo abstracto 'operar' que debe ser implementado en las clases hijas
abstract class Operacionn(val valor1: Int, val valor2: Int) {
    protected var resultado: Int = 0  // Propiedad para almacenar el resultado de la operación

    // Metodo abstracto que debe ser implementado por las clases hijas para realizar la operación
    abstract fun operar()

    // Metodo para imprimir el resultado de la operación
    fun imprimir() {
        println("Resultado: $resultado")
    }
}

// Clase 'Suma' que hereda de 'Operacionn' e implementa el metodo 'operar' para realizar una suma
class Suma(valor1: Int, valor2: Int) : Operacionn(valor1, valor2) {
    // Implementación del metodo 'operar' para realizar la suma de valor1 y valor2
    override fun operar() {
        resultado = valor1 + valor2
    }
}

// Clase 'Resta' que hereda de 'Operacionn' e implementa el metodo 'operar' para realizar una resta
class Resta(valor1: Int, valor2: Int) : Operacionn(valor1, valor2) {
    // Implementación del metodo 'operar' para realizar la resta de valor1 y valor2
    override fun operar() {
        resultado = valor1 - valor2
    }
}

fun main(parametro: Array<String>) {
    // Crear una instancia de 'Suma' y ejecutar la operación de suma
    val suma1 = Suma(10, 4)
    suma1.operar()  // Realiza la operación de suma
    suma1.imprimir()  // Imprime el resultado de la suma

    // Crear una instancia de 'Resta' y ejecutar la operación de resta
    val resta1 = Resta(20, 5)
    resta1.operar()  // Realiza la operación de resta
    resta1.imprimir()  // Imprime el resultado de la resta
}