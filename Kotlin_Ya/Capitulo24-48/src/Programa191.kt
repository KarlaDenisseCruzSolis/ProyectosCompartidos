// Importamos el paquete 'entradateclado', que contiene la función 'retornarInt' para leer valores enteros desde la entrada del usuario.
import entradateclado.*

fun main(args: Array<String>) {
    // Llamamos a la función 'retornarInt' pasando el mensaje "Ingrese primer valor:" para pedir al usuario que ingrese un número.
    // La función retorna un valor entero que se almacena en la variable 'numero1'.
    val numero1 = retornarInt("Ingrese primer valor:")

    // Llamamos nuevamente a la función 'retornarInt' con el mensaje "Ingrese segundo valor" para pedir al usuario el segundo número.
    // La función retorna un valor entero que se almacena en la variable 'numero2'.
    val numero2 = retornarInt("Ingrese segundo valor")

    // Calculamos la suma de 'numero1' y 'numero2' y la imprimimos en consola.
    // El resultado se muestra como una cadena con el formato "La suma es X".
    println("La suma es ${numero1 + numero2}")
}