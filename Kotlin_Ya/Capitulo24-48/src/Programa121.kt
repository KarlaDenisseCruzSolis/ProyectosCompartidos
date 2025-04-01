//PROBLEMA PROPUESTO 121
/*Plantear una clase Club y otra clase Socio.
La clase Socio debe tener los siguientes propiedades: nombre y la antigüedad en el club (en años).
Al constructor de la clase socio hacer que llegue el nombre y su antigüedad.
La clase Club debe tener como propiedades 3 objetos de la clase Socio.
Definir un método en la clase Club para imprimir el nombre del socio con mayor antigüedad en el club.*/
class Socio (val nombre: String, val antiguedad: Int) {
    fun imprimir() {
        println("$nombre tiene una antiguedad de $antiguedad")
    }
}

class Club {
    val socio1 = Socio("Juan", 22)
    val socio2 = Socio("Ana", 34)
    val socio3 = Socio("Carlos", 1)

    fun mayorAntiguedad() {
        socio1.imprimir()
        socio2.imprimir()
        socio3.imprimir()
        print("Socio con mayor antiguedad:")
        when {
            socio1.antiguedad > socio2.antiguedad && socio1.antiguedad > socio3.antiguedad -> print(socio1.nombre)
            socio2.antiguedad > socio3.antiguedad -> print(socio2.nombre)
            else -> print(socio3.nombre)
        }
    }
}

fun main(parametro: Array<String>) {
    val club1 = Club()
    club1.mayorAntiguedad()
}
