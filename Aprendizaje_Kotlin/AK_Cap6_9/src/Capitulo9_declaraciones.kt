
fun main() {
    val x = "English" // Se define una variable x con el valor "English"

    // Se usa la instrucción when para comparar x con distintos valores
    when (x) {
        "English" -> println("How are you?") // Si x es "English", imprime este mensaje
        "German" -> println("Wie geht es dir?") // Si x es "German", imprime este otro mensaje
        else -> println("I don't know that language yet :(") // Si x no coincide con ninguno, imprime esto
    }
}
