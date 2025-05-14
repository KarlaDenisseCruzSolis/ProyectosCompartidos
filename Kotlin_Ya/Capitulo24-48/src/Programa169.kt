// Definición de la clase data para representar a un alumno con documento y nombre.
data class Alumnoo(val documento: Int, val nombre: String)

// Definición de la clase Curso, que tiene un arreglo de alumnos.
class Curso {
    // Se inicializa un arreglo de objetos Alumnoo con tres alumnos.
    val alumnos = arrayOf(
        Alumnoo(123456, "Marcos"),
        Alumnoo(666666, "Ana"),
        Alumnoo(777777, "Luis")
    )

    // Sobrecarga del operador `contains` (in) para verificar si un alumno está en el curso.
    // Utiliza el documento del alumno para hacer la búsqueda.
    operator fun contains(documento: Int): Boolean {
        // La función `any` devuelve true si algún elemento del arreglo cumple con la condición.
        return alumnos.any { documento == it.documento }
    }
}

fun main(args: Array<String>) {
    // Se crea una instancia de la clase Curso llamada curso1.
    val curso1 = Curso()

    // Se verifica si el alumno con documento 123456 está inscrito en el curso.
    if (123456 in curso1)
    // Si el alumno está inscrito, imprime que está inscrito.
        println("El alumno Marcos está inscrito en el curso")
    else
    // Si el alumno no está inscrito, imprime que no está inscrito.
        println("El alumno Marcos no está inscrito en el curso")
}