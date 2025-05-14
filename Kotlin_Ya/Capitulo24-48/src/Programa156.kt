class Personaaaa(val nombre: String, val edad: Int) {
    // Metodo para imprimir los datos de la persona
    fun imprimir() {
        println("Nombre: $nombre Edad: $edad")
    }

    // Metodo para verificar si la persona es mayor de edad
    fun esMayor() = if (edad >= 18) true else false
}

fun main(parametro: Array<String>) {
    // Se crea un arreglo de objetos Personaaaa con diferentes nombres y edades
    val personas: Array<Personaaaa> = arrayOf(
        Personaaaa("ana", 22),
        Personaaaa("juan", 13),
        Personaaaa("carlos", 6),
        Personaaaa("maria", 72)
    )

    // Imprime el listado de personas
    println("Listado de personas")
    for (per in personas)
        per.imprimir()  // Imprime el nombre y la edad de cada persona

    // Se inicializa una variable para contar las personas mayores de edad
    var cant = 0
    // Se usa forEach para recorrer el arreglo de personas y contar las que son mayores de edad
    personas.forEach {
        if (it.esMayor())  // Si la persona es mayor de edad
            cant++  // Se incrementa el contador
    }

    // Se imprime la cantidad de personas mayores de edad
    println("Cantidad de personas mayores de edad: $cant")
}