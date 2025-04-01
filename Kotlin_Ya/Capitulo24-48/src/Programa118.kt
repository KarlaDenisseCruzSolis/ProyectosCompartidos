//PROBLEMA PROPUESTO 118
/*Declarar una clase llamada Hijos. Definir dentro de la misma un arreglo para almacenar las edades de 5 personas.
Definir un método cargar donde se ingrese por teclado el arreglo de las edades y llame a otros dos método que impriman
la mayor edad y el promedio de edades.*/
class Hijos {
    val edades = IntArray(5)

    fun cargar() {
        for(i in edades.indices) {
            print("Ingrese edad:")
            edades[i] = readln().toInt()
        }
        mayorEdad()
        promedio()
    }

    fun mayorEdad() {
        var mayor = edades[0]
        for(i in edades.indices)
            if (edades[i] > mayor)
                mayor = edades[i]
        println("El hijo con mayor edad es $mayor")
    }

    fun promedio() {
        var suma = 0
        for(i in edades.indices)
            suma += edades[i]
        val promedio = suma / edades.size
        println("La edad promedio de los hijos es $promedio")
    }
}

fun main(parametros: Array<String>) {
    val hijos1 = Hijos()
    hijos1.cargar()
}

