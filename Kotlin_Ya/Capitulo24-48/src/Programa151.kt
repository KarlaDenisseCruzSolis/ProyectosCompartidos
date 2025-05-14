fun filtrar(cadena: String, fn: (Char) -> Boolean): String
{
    // Se crea un StringBuilder vacío para acumular los caracteres que cumplan con la condición
    val cad = StringBuilder()

    // Recorre cada carácter de la cadena
    for(ele in cadena)
    // Si el carácter cumple con la condición definida por la función fn, lo agrega al StringBuilder
        if (fn(ele))
            cad.append(ele)

    // Devuelve la cadena formada por los caracteres que cumplieron con la condición
    return cad.toString()
}

fun main(parametro: Array<String>) {
    // Se define la cadena de texto de entrada
    val cadena = "¿Esto es la prueba 1 o la prueba 2?"

    // Imprime la cadena original
    println("String original")
    println(cadena)

    // Llama a la función filtrar para obtener solo las vocales (mayúsculas y minúsculas)
    val resultado1 = filtrar(cadena) {
        // La condición verifica si el carácter es una vocal
        if (it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' ||
            it == 'A' || it == 'E' || it == 'I' || it == 'O' || it == 'U' )
            true  // Si es vocal, retorna true
        else
            false // Si no es vocal, retorna false
    }

    // Imprime el resultado con solo las vocales
    println("Solo las vocales")
    println(resultado1)

    // Llama a la función filtrar para obtener solo los caracteres en minúsculas
    var resultado2 = filtrar(cadena) {
        // La condición verifica si el carácter está en el rango de 'a' a 'z' (minúsculas)
        if (it in 'a'..'z')
            true  // Si está en minúsculas, retorna true
        else
            false // Si no está en minúsculas, retorna false
    }

    // Imprime el resultado con solo los caracteres en minúsculas
    println("Solo los caracteres en minúsculas")
    println(resultado2)

    // Llama a la función filtrar para obtener solo los caracteres no alfabéticos
    var resultado3 = filtrar(cadena) {
        // La condición verifica si el carácter no está en el rango de 'a' a 'z' ni 'A' a 'Z'
        if (it !in 'a'..'z' && it !in 'A'..'Z')
            true  // Si no es alfabético, retorna true
        else
            false // Si es alfabético, retorna false
    }

    // Imprime el resultado con solo los caracteres no alfabéticos
    println("Solo los caracteres no alfabéticos")
    println(resultado3)
}