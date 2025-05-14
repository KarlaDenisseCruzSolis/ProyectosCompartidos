class Personaaa(val nombre: String, val edad: Int) {
    fun imprimir() {
        println("Nombre: $nombre Edad: $edad")
    }
    // COMENTARIO: Esta función imprime el nombre y edad de la persona.

    fun esMayor() = if (edad >= 18) true else false
    // COMENTARIO: Esta función devuelve true si la edad es 18 o más, indicando que la persona es mayor de edad.
}

fun main(parametro: Array<String>) {
    val personas: Array<Personaaa> = arrayOf(
        Personaaa("ana", 22),
        Personaaa("juan", 13),
        Personaaa("carlos", 6),
        Personaaa("maria", 72)
    )
    // COMENTARIO: Se crea un arreglo de objetos Personaaa con nombre y edad.

    println("Listado de personas")
    // COMENTARIO: Se imprime el encabezado del listado.

    for(per in personas)
        per.imprimir()
    // COMENTARIO: Se recorre el arreglo y se imprime cada persona con el metodo imprimir().

    var cant = 0
    // COMENTARIO: Variable para contar cuántas personas son mayores de edad.

    for(per in personas)
        if (per.esMayor())
            cant++
    // COMENTARIO: Se recorre el arreglo y se incrementa 'cant' si la persona es mayor de edad.

    println("Cantidad de personas mayores de edad: $cant")
    // COMENTARIO: Se muestra el total de personas mayores de edad.
}