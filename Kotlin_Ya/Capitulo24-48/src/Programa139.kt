// Clase base 'Dado10' que genera un valor aleatorio entre 1 y 6
// La clase tiene una propiedad protegida 'valor' y un metodo para tirar el dado
open class Dado10 {
    protected var valor: Int = 1  // Propiedad que almacena el valor del dado

    // Metodo para tirar el dado y asignar un valor aleatorio entre 1 y 6
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    // Metodo para imprimir el valor del dado
    open fun imprimir() {
        println("$valor")
    }
}

// Clase 'DadoRecuadro' que hereda de 'Dado10' y sobrecarga el método imprimir
// En lugar de solo mostrar el valor, lo muestra recuadrado con asteriscos
class DadoRecuadro : Dado10() {
    // Sobrescritura del metodo imprimir para mostrar el valor recuadrado con asteriscos
    override fun imprimir() {
        println("***")  // Imprime la parte superior del recuadro
        println("*$valor*")  // Imprime el valor dentro del recuadro
        println("***")  // Imprime la parte inferior del recuadro
    }
}

fun main(parametro: Array<String>) {
    // Crear una instancia de la clase 'Dado10' y tirar el dado
    val dado1 = Dado10()
    dado1.tirar()  // Llama al metodo tirar para asignar un valor aleatorio
    dado1.imprimir()  // Imprime el valor del dado

    // Crear una instancia de la clase 'DadoRecuadro' y tirar el dado
    val dado2 = DadoRecuadro()
    dado2.tirar()  // Llama al metodo tirar para asignar un valor aleatorio
    dado2.imprimir()  // Imprime el valor del dado recuadrado con asteriscos
}