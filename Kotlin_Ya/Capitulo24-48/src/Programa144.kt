class Personaaa(val nombre: String, val edad: Int) {
    fun imprimir() {
        println("Nombre: $nombre Edad: $edad")
    }
    fun esMayor() = if (edad >= 18) true else false
}
fun main(parametro: Array<String>) {
    val personas: Array<Personaaa> = arrayOf(Personaaa("ana", 22), Personaaa("juan", 13), Personaaa("carlos", 6), Personaaa("maria", 72))
    println("Listado de personas")
    for(per in personas)
        per.imprimir()
    var cant = 0
    for(per in personas)
        if (per.esMayor())
            cant++
    println("Cantidad de personas mayores de edad: $cant")
}