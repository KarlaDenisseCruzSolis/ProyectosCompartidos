// Clase que representa a una persona con nombre y edad
class Personaa(val nombre: String, val edad: Int) {

    // Función que determina si la persona es mayor según una función recibida como parámetro
    fun esMayor(fn:(Int) -> Boolean): Boolean {
        return fn(edad) // Llama a la función 'fn' pasando la edad de la persona
    }
}

// Función que define la mayoría de edad en Estados Unidos (21 años)
fun mayorEstadosUnidos(edad: Int): Boolean {
    if (edad >= 21)
        return true
    else
        return false
}

// Función que define la mayoría de edad en Argentina (18 años)
fun mayorArgentina(edad: Int): Boolean {
    if (edad >= 18)
        return true
    else
        return false
}

fun main(parametro: Array<String>) {
    // Se crea un objeto de tipo Personaa con nombre "juan" y edad 18
    val persona1 = Personaa("juan", 18)

    // Se verifica si es mayor de edad según las leyes de Argentina
    if (persona1.esMayor(::mayorArgentina))
        println("${persona1.nombre} es mayor si vive en Argentina")
    else
        println("${persona1.nombre} no es mayor si vive en Argentina")

    // Se verifica si es mayor de edad según las leyes de Estados Unidos
    if (persona1.esMayor(::mayorEstadosUnidos))
        println("${persona1.nombre} es mayor si vive en Estados Unidos")
    else
        println("${persona1.nombre} no es mayor si vive en Estados Unidos")
}