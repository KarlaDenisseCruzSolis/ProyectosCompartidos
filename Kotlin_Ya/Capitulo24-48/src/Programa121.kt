class Socio (val nombre: String, val antiguedad: Int) { // Definición de la clase Socio con las propiedades 'nombre' y 'antiguedad'.
    fun imprimir() { // Metodo 'imprimir' para mostrar el nombre y la antigüedad del socio.
        println("$nombre tiene una antiguedad de $antiguedad") // Imprime el nombre y la antigüedad del socio.
    }
}

class Club { // Definición de la clase Club que contiene tres objetos de la clase Socio.
    val socio1 = Socio("Juan", 22) // Crea un objeto 'socio1' con nombre "Juan" y antigüedad 22 años.
    val socio2 = Socio("Ana", 34) // Crea un objeto 'socio2' con nombre "Ana" y antigüedad 34 años.
    val socio3 = Socio("Carlos", 1) // Crea un objeto 'socio3' con nombre "Carlos" y antigüedad 1 año.

    fun mayorAntiguedad() { // Metodo 'mayorAntiguedad' que imprime el socio con mayor antigüedad.
        socio1.imprimir() // Llama al metodo 'imprimir' de 'socio1'.
        socio2.imprimir() // Llama al metodo 'imprimir' de 'socio2'.
        socio3.imprimir() // Llama al metodo 'imprimir' de 'socio3'.
        print("Socio con mayor antiguedad:") // Imprime el mensaje indicando el socio con mayor antigüedad.
        when { // Compara las antigüedades de los tres socios para determinar quién tiene más antigüedad.
            socio1.antiguedad > socio2.antiguedad && socio1.antiguedad > socio3.antiguedad -> print(socio1.nombre) // Si 'socio1' tiene la mayor antigüedad, se imprime su nombre.
            socio2.antiguedad > socio3.antiguedad -> print(socio2.nombre) // Si 'socio2' tiene la mayor antigüedad, se imprime su nombre.
            else -> print(socio3.nombre) // Si ninguno de los anteriores, se imprime el nombre de 'socio3'.
        }
    }
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta la lógica del club.
    val club1 = Club() // Crea un objeto 'club1' de la clase Club.
    club1.mayorAntiguedad() // Llama al metodo 'mayorAntiguedad' para mostrar el socio con más antigüedad.
}