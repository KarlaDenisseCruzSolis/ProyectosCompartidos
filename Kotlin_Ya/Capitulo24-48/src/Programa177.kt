class Persona00 (var nombre: String, var edad: Int) {
    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }
    fun esMayorEdad() {
        if (edad >= 18)
            println("Es mayor de edad $nombre")
        else
            println("No es mayor de edad $nombre")
    }
}
fun main(args: Array<String>) {
    val personas: MutableList<Persona00>
    personas = mutableListOf(Persona00("Juan", 22), Persona00("Ana", 19), Persona00("Marcos", 12))
            println("Listado de todas personas")
            personas.forEach { it.imprimir() }
        val cant = personas.count { it.edad >= 18}
            println("La cantidad de personas mayores de edad es $cant")
}