//PROBLEMA PROPUESTO 115
/*Implementar una clase llamada Alumno que tenga como propiedades su nombre y su nota. Al constructor llega su nombre y nota.
Imprimir el nombre y su nota. Mostrar un mensaje si está regular (nota mayor o igual a 4) Definir dos objetos de la clase Alumno.*/
class Alumno3 (val nombre: String, val nota: Int){ // Definición de la clase 'Alumno3' con dos propiedades inmutables: 'nombre' y 'nota'.

    fun imprimir() { // Definición de la función 'imprimir', que no recibe parámetros.
        println("Alumno: $nombre tiene una nota de $nota") // Imprime el nombre del alumno y su nota.
    }

    fun mostrarEstado () { // Definición de la función 'mostrarEstado', que no recibe parámetros.
        if (nota >= 4) // Verifica si la nota es mayor o igual a 4.
            println("$nombre se encuentra en estado REGULAR") // Si la nota es mayor o igual a 4, imprime que el alumno está en estado regular.
        else
            println("$nombre no está REGULAR") // Si la nota es menor a 4, imprime que el alumno no está en estado regular.
    }
}

fun main(parametros: Array<String>) { // Función principal 'main', que recibe un parámetro 'parametros' de tipo Array de String.
    val alumno1 = Alumno3("Ana", 7) // Crea un objeto de tipo 'Alumno3' con nombre "Ana" y nota 7.
    alumno1.imprimir() // Llama a la función 'imprimir' del objeto alumno1 para mostrar su nombre y nota.
    alumno1.mostrarEstado() // Llama a la función 'mostrarEstado' del objeto alumno1 para mostrar su estado.
    val alumno2 = Alumno3("Carlos", 2) // Crea un objeto de tipo 'Alumno3' con nombre "Carlos" y nota 2.
    alumno2.imprimir() // Llama a la función 'imprimir' del objeto alumno2 para mostrar su nombre y nota.
    alumno2.mostrarEstado() // Llama a la función 'mostrarEstado' del objeto alumno2 para mostrar su estado.
}