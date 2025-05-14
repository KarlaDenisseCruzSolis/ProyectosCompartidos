// Definición de la clase de datos Persona4 con dos propiedades: nombre y edad.
data class Persona4(var nombre: String, var edad: Int) {

    // Sobrescribe el metodo toString para personalizar la representación en forma de cadena de la clase.
    override fun toString(): String {
        return "$nombre, $edad" // Retorna una cadena con el nombre y la edad de la persona.
    }
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el programa.

    var persona1 = Persona4("Juan", 22) // Crea un objeto 'persona1' con nombre "Juan" y edad 22.
    var persona2 = Persona4("Ana", 59) // Crea un objeto 'persona2' con nombre "Ana" y edad 59.

    println(persona1) // Imprime el objeto 'persona1', llamando al metodo toString que devuelve "Juan, 22".
    println(persona2) // Imprime el objeto 'persona2', llamando al metodo toString que devuelve "Ana, 59".
}