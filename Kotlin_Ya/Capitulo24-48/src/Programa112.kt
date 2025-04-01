//ORIGINAL
class Persona2 constructor(nombre: String, edad: Int) {
    var nombre: String = nombre
    var edad: Int = edad
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
fun main(parametro: Array<String>) {
    val persona1 = Persona2("Juan", 12)
    persona1.imprimir()
    persona1.esMayorEdad()
}

//ACOTACION 1
/*class Persona2 (var nombre: String, var edad: Int) {
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
fun main(parametro: Array<String>) {
    val persona1 = Persona2("Juan", 12)
    persona1.imprimir()
    persona1.esMayorEdad()
}*/

//ACOTACION 2
/*class Persona2 (var nombre: String, var edad: Int) {
    init {
        if (edad < 0)
            edad = 0
    }
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
fun main(parametro: Array<String>) {
    val persona1 = Persona2("Juan", -12)
    persona1.imprimir()
    persona1.esMayorEdad()
}*/