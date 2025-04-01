class Persona0 (val nombre: String, val edad: Int) {
    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }
    operator fun compareTo(per2: Persona0): Int {
        return when {
            edad < per2.edad -> -1
            edad > per2.edad -> 1
            else -> 0
        }
    }
}
fun main(parametro: Array<String>) {
    val persona1 = Persona0("Juan", 30)
    persona1.imprimir()
    val persona2 = Persona0("Ana", 30)
    persona2.imprimir()
    println("Persona mayor")
    when {
        persona1 > persona2 -> persona1.imprimir()
        persona1 < persona2 -> persona2.imprimir()
        else -> println("Tienen la misma edad")
    }
}