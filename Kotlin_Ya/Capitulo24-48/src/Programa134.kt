// Objeto Matematica que contiene una constante y un metodo
object Matematica {
    val PI = 3.1416 // Constante que representa el valor de Pi

    // Metodo que genera un número aleatorio entre el mínimo y el máximo
    fun aleatorio(minimo: Int, maximo: Int) = ((Math.random() * (maximo + 1 - minimo)) + minimo).toInt()
}

fun main(parametro: Array<String>) {
    // Imprime el valor de Pi desde el objeto Matematica
    println("El valor de Pi es ${Matematica.PI}")

    // Imprime un valor aleatorio generado entre 5 y 10
    print("Un valor aleatorio entre 5 y 10: ")
    println(Matematica.aleatorio(5, 10)) // Llama al metodo aleatorio y lo imprime
}