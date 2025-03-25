
fun main() {
    val x = "German" // Se define la variable x con el valor "German"

    // Se usa when como una expresión para asignar un valor a la variable greeting
    val greeting = when (x) {
        "English" -> "How are you?" // Si x es "English", greeting toma este valor
        "German" -> "Wie geht es dir?" // Si x es "German", greeting toma este otro valor
        else -> "I don't know that language yet :(" // Si x no coincide, greeting toma este valor
    }

    println(greeting) // Se imprime el resultado almacenado en greeting
}
