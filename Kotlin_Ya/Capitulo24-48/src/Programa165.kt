class Persona0 (val nombre: String, val edad: Int) {
    // Metodo para imprimir el nombre y la edad de la persona
    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    // Sobrecarga del operador "compareTo" para comparar dos objetos de tipo Persona0 por edad
    operator fun compareTo(per2: Persona0): Int {
        return when {
            // Si la edad de la primera persona es menor que la de la segunda
            edad < per2.edad -> -1
            // Si la edad de la primera persona es mayor que la de la segunda
            edad > per2.edad -> 1
            // Si las edades son iguales
            else -> 0
        }
    }
}

fun main(parametro: Array<String>) {
    // Se crea una persona con nombre "Juan" y edad 30
    val persona1 = Persona0("Juan", 30)
    persona1.imprimir() // Imprime los detalles de la persona1

    // Se crea una persona con nombre "Ana" y edad 30
    val persona2 = Persona0("Ana", 30)
    persona2.imprimir() // Imprime los detalles de la persona2

    // Imprime quién es la persona mayor
    println("Persona mayor")
    when {
        // Si persona1 es mayor que persona2 (edad mayor)
        persona1 > persona2 -> persona1.imprimir()
        // Si persona1 es menor que persona2 (edad menor)
        persona1 < persona2 -> persona2.imprimir()
        // Si las edades son iguales
        else -> println("Tienen la misma edad")
    }
}