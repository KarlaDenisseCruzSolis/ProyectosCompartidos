//PROBLEMA PROPUESTO 118
/*Declarar una clase llamada Hijos. Definir dentro de la misma un arreglo para almacenar las edades de 5 personas.
Definir un metodo cargar donde se ingrese por teclado el arreglo de las edades y llame a otros dos métodos que impriman
la mayor edad y el promedio de edades.*/

class Hijos { // Definición de la clase 'Hijos' que tiene un arreglo para almacenar las edades de 5 personas.
    val edades = IntArray(5) // Arreglo 'edades' de tipo entero que puede almacenar 5 valores.

    fun cargar() { // Función 'cargar' que permite ingresar las edades y llama a otros métodos para imprimir la mayor edad y el promedio.
        for(i in edades.indices) { // Recorre el arreglo 'edades' para solicitar las edades a través del teclado.
            print("Ingrese edad:") // Muestra el mensaje para que el usuario ingrese la edad.
            edades[i] = readln().toInt() // Lee la edad ingresada por el usuario y la asigna al índice correspondiente en el arreglo.
        }
        mayorEdad() // Llama al metodo 'mayorEdad' para mostrar la mayor edad.
        promedio() // Llama al metodo 'promedio' para mostrar el promedio de las edades.
    }

    fun mayorEdad() { // Función 'mayorEdad' que determina y muestra la mayor edad del arreglo.
        var mayor = edades[0] // Asume que la primera edad es la mayor inicialmente.
        for(i in edades.indices) // Recorre todo el arreglo 'edades'.
            if (edades[i] > mayor) // Si encuentra una edad mayor, la asigna a 'mayor'.
                mayor = edades[i] // Actualiza la variable 'mayor' con la edad mayor encontrada.
        println("El hijo con mayor edad es $mayor") // Muestra el resultado de la mayor edad.
    }

    fun promedio() { // Función 'promedio' que calcula y muestra el promedio de las edades.
        var suma = 0 // Variable 'suma' que almacenará la suma de todas las edades.
        for(i in edades.indices) // Recorre el arreglo 'edades'.
            suma += edades[i] // Suma cada edad al total de la variable 'suma'.
        val promedio = suma / edades.size // Calcula el promedio dividiendo la suma entre el número de elementos en el arreglo.
        println("La edad promedio de los hijos es $promedio") // Muestra el resultado del promedio de las edades.
    }
}

fun main(parametros: Array<String>) { // Función principal 'main' que ejecuta el programa.
    val hijos1 = Hijos() // Crea un objeto de la clase 'Hijos' llamado 'hijos1'.
    hijos1.cargar() // Llama a la función 'cargar' del objeto 'hijos1' para ingresar las edades y calcular la mayor edad y el promedio.
}