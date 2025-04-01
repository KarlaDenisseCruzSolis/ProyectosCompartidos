open class Persona6(val nombre: String, val edad: Int) {
    open fun imprimir() {
        println("Nombre: $nombre")
        println("Edad: $edad")
    }
}
class Empleado4(nombre: String, edad: Int, val sueldo: Double): Persona6(nombre, edad) {
    override fun imprimir() {
        super.imprimir()
        println("Sueldo: $sueldo")
    }
    fun pagaImpuestoss() {
        if (sueldo > 3000)
            println("El empleado $nombre paga impuestos")
        else
            println("El empleado $nombre no paga impuestos")
    }
}
fun main(parametro: Array<String>) {
    val persona1 = Persona6("Jose", 22)
    println("Datos de la persona")
    persona1.imprimir()
    val empleado1 = Empleado4("Ana", 30, 5000.0)
    println("Datos del empleado")
    empleado1.imprimir()
    empleado1.pagaImpuestoss()
}