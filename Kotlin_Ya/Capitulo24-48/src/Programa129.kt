data class Persona4(var nombre: String, var edad: Int) {
    override fun toString(): String {
        return "$nombre, $edad"
    }
}
fun main(parametro: Array<String>) {
    var persona1 = Persona4("Juan", 22)
    var persona2 = Persona4("Ana", 59)
    println(persona1)
    println(persona2)
}
