class Persona00 (var nombre: String, var edad: Int) {
    // Metodo para imprimir el nombre y la edad de la persona
    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    // Metodo para verificar si la persona es mayor de edad
    fun esMayorEdad() {
        if (edad >= 18)
            println("Es mayor de edad $nombre")
        else
            println("No es mayor de edad $nombre")
    }
}

fun main(args: Array<String>) {
    // Crea una lista mutable de objetos Persona00 con diferentes edades
    val personas: MutableList<Persona00>
    personas = mutableListOf(Persona00("Juan", 22), Persona00("Ana", 19), Persona00("Marcos", 12))

    // Imprime los detalles de todas las personas en la lista
    println("Listado de todas personas")
    personas.forEach { it.imprimir() }

    // Cuenta cuántas personas en la lista son mayores de edad (edad >= 18)
    val cant = personas.count { it.edad >= 18 }

    // Imprime la cantidad de personas mayores de edad
    println("La cantidad de personas mayores de edad es $cant")
}