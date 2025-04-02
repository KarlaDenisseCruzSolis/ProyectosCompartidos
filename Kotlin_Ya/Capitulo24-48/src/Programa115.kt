//PROBLEMA PROPUESTO 115
/*Implementar una clase llamada Alumno que tenga como propiedades su nombre y su nota. Al constructor llega su nombre y nota.
Imprimir el nombre y su nota. Mostrar un mensaje si está regular (nota mayor o igual a 4) Definir dos objetos de la clase Alumno.*/
class Alumno3 (val nombre: String, val nota: Int){

    fun imprimir() {
        println("Alumno: $nombre tiene una nota de $nota")
    }

    fun mostrarEstado () {
        if (nota >= 4)
            println("$nombre se encuentra en estado REGULAR")
        else
            println("$nombre no está REGULAR")
    }
}

fun main(parametros: Array<String>) {
    val alumno1 = Alumno3("Ana", 7)
    alumno1.imprimir()
    alumno1.mostrarEstado()
    val alumno2 = Alumno3("Carlos", 2)
    alumno2.imprimir()
    alumno2.mostrarEstado()
}
