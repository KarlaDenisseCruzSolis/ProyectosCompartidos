//PROBLEMA PROPUESTO 124
/*Desarrollar una clase que defina una propiedad privada de tipo arreglo de 5 enteros. En el bloque init llamar a un
método privado que cargue valores aleatorios comprendidos entre 0 y 10.
Definir otros tres métodos públicos que muestren el arreglo, el mayor y el menor elemento.*/
class Vector {
    private val vec = IntArray(5)
    init {
        cargar()
    }

    private fun cargar() {
        for(i in vec.indices)
            vec[i] = ((Math.random() * 11)).toInt()
    }

    fun imprimir() {
        println("Listado completo del arreglo")
        for(i in vec.indices)
            print("${vec[i]} - ")
        println()
    }

    fun mostrarMayor() {
        var mayor = vec[0]
        for(i in vec.indices)
            if (vec[i] > mayor)
                mayor = vec[i]
        println("El elemento mayor del arreglo es $mayor")
    }

    fun mostrarMenor() {
        var menor = vec[0]
        for(i in vec.indices)
            if (vec[i] < menor)
                menor = vec[i]
        println("El elemento menor del arreglo es $menor")
    }
}

fun main(parametro: Array<String>) {
    val vector1 = Vector()
    vector1.imprimir()
    vector1.mostrarMayor()
    vector1.mostrarMenor()
}
