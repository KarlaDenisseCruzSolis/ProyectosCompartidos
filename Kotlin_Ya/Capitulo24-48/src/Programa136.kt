// Definición de un objeto nombrado 'Mayor' con tres métodos llamados 'maximo'
object Mayor {
    // Metodo que recibe dos parámetros de tipo Int y devuelve el mayor de ellos
    fun maximo(x1: Int, x2: Int) = if (x1 > x2) x1 else x2

    // Metodo que recibe dos parámetros de tipo Float y devuelve el mayor de ellos
    fun maximo(x1: Float, x2: Float) = if (x1 > x2) x1 else x2

    // Metodo que recibe dos parámetros de tipo Double y devuelve el mayor de ellos
    fun maximo(x1: Double, x2: Double) = if (x1 > x2) x1 else x2
}

fun main(parametro: Array<String>) {
    // Llamada al metodo 'maximo' con parámetros de tipo Int y muestra el resultado
    println(Mayor.maximo(4, 5))

    // Llamada al metodo 'maximo' con parámetros de tipo Float y muestra el resultado
    println(Mayor.maximo(10.2f, 23.5f))

    // Llamada al metodo 'maximo' con parámetros de tipo Double y muestra el resultado
    println(Mayor.maximo(4.5, 5.2))
}