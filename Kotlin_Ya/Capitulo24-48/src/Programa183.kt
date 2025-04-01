fun cargar(diccionario: MutableMap<String, String>) {
    do {
        print("Ingrese palabra en castellano:")
        val palCastellano = readLine()!!
        print("Ingrese palabra en ingles:")
        val palIngles = readLine()!!
        diccionario[palIngles] = palCastellano
        print("Continua cargando otra palabra en el diccionario? (si/no):")
        val fin = readLine()!!
    } while (fin=="si")
}
fun listado(diccionario: MutableMap<String,String>) {
    for((ingles, castellano) in diccionario)
        println("$ingles: $castellano")
    println()
}
fun consultaIngles(diccionario: MutableMap<String, String>) {
    print("Ingrese una palabra en ingles para verificar su traducción:")
    val ingles = readLine()
    if (ingles in diccionario)
        println("La traducción en castellano es ${diccionario[ingles]}")
    else
        println("No existe esa palabra en el diccionario")
}
fun main(args: Array<String>) {
    val diccionario: MutableMap<String, String> = mutableMapOf()
    cargar(diccionario)
    listado(diccionario)
    consultaIngles(diccionario)
}