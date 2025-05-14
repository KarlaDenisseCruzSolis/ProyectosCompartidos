// Importamos el paquete 'matematica', que contiene las funciones 'sumar' y 'restar'.
import matematica.*

fun main(args: Array<String>) {
    // Llamamos a la función 'sumar' que se encuentra en el paquete 'matematica'
    // Le pasamos los valores 5 y 7 como argumentos para sumar
    val su = sumar(5, 7)
    // Imprimimos el resultado de la suma
    println("La suma es $su")

    // Llamamos a la función 'restar' que se encuentra en el paquete 'matematica'
    // Le pasamos los valores 10 y 3 como argumentos para restar
    val re = restar(10, 3)
    // Imprimimos el resultado de la resta
    println("La resta es $re")
}