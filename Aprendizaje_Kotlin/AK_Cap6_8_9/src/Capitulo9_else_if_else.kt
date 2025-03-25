
fun main() {
    // Declaramos una cadena de texto
    val str = "Hello!"

    // Usamos una cadena de sentencias 'if-else-if' para evaluar la longitud de la cadena
    if (str.length == 0) {
        print("The string is empty!") // Si la longitud de la cadena es 0, imprime "The string is empty!"
    } else if (str.length > 5) {
        print("The string is short!") // Si la longitud de la cadena es mayor que 5, imprime "The string is short!"
    } else {
        print("The string is long!")  // Si ninguna de las condiciones anteriores se cumple, imprime "The string is long!"
    }

}