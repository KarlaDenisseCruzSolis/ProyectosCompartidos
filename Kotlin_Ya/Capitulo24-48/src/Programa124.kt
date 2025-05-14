//PROBLEMA PROPUESTO 124
/*Desarrollar una clase que defina una propiedad privada de tipo arreglo de 5 enteros. En el bloque init llamar a un
metodo privado que cargue valores aleatorios comprendidos entre 0 y 10.
Definir otros tres métodos públicos que muestren el arreglo, el mayor y el menor elemento.*/
class Vector {
    private val vec = IntArray(5) // Propiedad privada 'vec' de tipo arreglo de 5 enteros.

    init { // Bloque init que se ejecuta al crear un objeto de la clase.
        cargar() // Llama al metodo privado 'cargar' para llenar el arreglo con valores aleatorios.
    }

    private fun cargar() { // Metodo privado 'cargar' que asigna valores aleatorios al arreglo.
        for(i in vec.indices) // Itera a través de los índices del arreglo.
            vec[i] = ((Math.random() * 11)).toInt() // Asigna un valor aleatorio entre 0 y 10 a cada elemento del arreglo.
    }

    fun imprimir() { // Metodo público 'imprimir' que muestra el arreglo completo.
        println("Listado completo del arreglo") // Imprime un encabezado.
        for(i in vec.indices) // Itera a través de los índices del arreglo.
            print("${vec[i]} - ") // Imprime cada valor del arreglo seguido de un guion.
        println() // Salto de línea después de imprimir el arreglo.
    }

    fun mostrarMayor() { // Metodo público 'mostrarMayor' que muestra el mayor elemento del arreglo.
        var mayor = vec[0] // Inicializa 'mayor' con el primer elemento del arreglo.
        for(i in vec.indices) // Itera a través de los índices del arreglo.
            if (vec[i] > mayor) // Si el valor del arreglo es mayor que 'mayor',
                mayor = vec[i] // Asigna el nuevo valor a 'mayor'.
        println("El elemento mayor del arreglo es $mayor") // Imprime el valor mayor.
    }

    fun mostrarMenor() { // Metodo público 'mostrarMenor' que muestra el menor elemento del arreglo.
        var menor = vec[0] // Inicializa 'menor' con el primer elemento del arreglo.
        for(i in vec.indices) // Itera a través de los índices del arreglo.
            if (vec[i] < menor) // Si el valor del arreglo es menor que 'menor',
                menor = vec[i] // Asigna el nuevo valor a 'menor'.
        println("El elemento menor del arreglo es $menor") // Imprime el valor menor.
    }
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el programa.
    val vector1 = Vector() // Crea un objeto 'vector1' de la clase 'Vector'.
    vector1.imprimir() // Llama al metodo 'imprimir' para mostrar el arreglo completo.
    vector1.mostrarMayor() // Llama al metodo 'mostrarMayor' para mostrar el mayor elemento.
    vector1.mostrarMenor() // Llama al metodo 'mostrarMenor' para mostrar el menor elemento.
}