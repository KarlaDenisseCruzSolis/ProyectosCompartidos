fun cargar(diccionario: MutableMap<String, String>) {
    // Inicia un ciclo do-while para cargar palabras en el diccionario
    do {
        print("Ingrese palabra en castellano:") // Solicitar al usuario la palabra en castellano
        val palCastellano = readLine()!! // Leer la palabra en castellano
        print("Ingrese palabra en ingles:") // Solicitar al usuario la palabra en inglés
        val palIngles = readLine()!! // Leer la palabra en inglés
        diccionario[palIngles] = palCastellano // Agregar al diccionario la palabra en inglés como clave y la palabra en castellano como valor
        print("Continua cargando otra palabra en el diccionario? (si/no):") // Preguntar si desea seguir cargando palabras
        val fin = readLine()!! // Leer la respuesta (si/no)
    } while (fin == "si") // Si la respuesta es "si", el ciclo continuará
}

fun listado(diccionario: MutableMap<String, String>) {
    // Recorrer el diccionario e imprimir cada palabra en inglés junto con su traducción al castellano
    for ((ingles, castellano) in diccionario)
        println("$ingles: $castellano") // Mostrar la traducción
    println() // Imprimir una línea vacía después de mostrar el listado
}

fun consultaIngles(diccionario: MutableMap<String, String>) {
    // Solicitar al usuario una palabra en inglés para consultar su traducción
    print("Ingrese una palabra en ingles para verificar su traducción:")
    val ingles = readLine() // Leer la palabra en inglés
    if (ingles in diccionario) // Verificar si la palabra en inglés existe en el diccionario
        println("La traducción en castellano es ${diccionario[ingles]}") // Imprimir la traducción al castellano
    else
        println("No existe esa palabra en el diccionario") // Informar que la palabra no está en el diccionario
}

fun main(args: Array<String>) {
    // Crear un diccionario vacío (mapa mutable) para almacenar las traducciones
    val diccionario: MutableMap<String, String> = mutableMapOf()

    // Llamar a la función cargar para permitir que el usuario cargue palabras al diccionario
    cargar(diccionario)

    // Llamar a la función listado para mostrar todas las palabras cargadas en el diccionario
    listado(diccionario)

    // Llamar a la función consultaIngles para permitir que el usuario consulte la traducción de una palabra en inglés
    consultaIngles(diccionario)
}