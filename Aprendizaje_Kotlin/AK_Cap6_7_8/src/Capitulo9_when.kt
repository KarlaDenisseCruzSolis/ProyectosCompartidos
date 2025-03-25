
fun main() {
// Declaramos una cadena de texto
    val str = "Hello!"

// Usamos la sentencia 'when' como una alternativa a 'if-else-if' para evaluar la longitud de la cadena
    when {
        str.length == 0 -> print("The string is empty!") // Si la longitud de la cadena es 0, imprime "The string is empty!"
        str.length > 5 -> print("The string is short!") // Si la longitud de la cadena es mayor que 5, imprime "The string is short!"
        else -> print("The string is long!")  // Si no cumple ninguna de las condiciones anteriores, imprime "The string is long!"
    }
}
