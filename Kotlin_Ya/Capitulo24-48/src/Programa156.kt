class Personaaaa(val nombre: String, val edad: Int) {
    fun imprimir() {
        println("Nombre: $nombre Edad: $edad")
    }
    fun esMayor() = if (edad >= 18) true else false
}
fun main(parametro: Array<String>) {
    val personas: Array<Personaaaa> = arrayOf(Personaaaa("ana", 22),
        Personaaaa("juan", 13),
        Personaaaa("carlos", 6),
        Personaaaa("maria", 72))
    println("Listado de personas")
    for(per in personas)
        per.imprimir()
    var cant = 0
    personas.forEach {
        if (it.esMayor())
            cant++
    }
    println("Cantidad de personas mayores de edad: $cant")
}