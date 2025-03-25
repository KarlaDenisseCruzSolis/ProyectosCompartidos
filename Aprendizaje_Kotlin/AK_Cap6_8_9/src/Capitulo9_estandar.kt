
fun main() {
// Se declara una variable `str` y se le asigna el valor "Hello!"
    val str = "Hello!"

// Se evalúa si la longitud de `str` es igual a 0
    if (str.length == 0) {
        // Si la longitud es 0, se imprime el mensaje "The string is empty!"
        print("The string is empty!")
    }
// Si la longitud no es 0, se evalúa si la longitud es mayor que 5
    else if (str.length > 5) {
        // Si la longitud es mayor a 5, se imprime el mensaje "The string is short!"
        print("The string is short!")
    }
// Si ninguna de las condiciones anteriores se cumple
    else {
        // Se imprime el mensaje "The string is long!" en caso de que la longitud sea entre 1 y 5
        print("The string is long!")
    }
}
