//PROBLEMA PROPUESTO 127
/*Plantear una clase llamada Dado. Definir una propiedad llamada valor que permita cargar un valor comprendido entre 1 y 6 si
llega un valor que no está comprendido en este rango se debe cargar un 1. Definir dos métodos, uno que genere un número aleatorio entre 1 y 6 y otro que lo imprima.
Al constructor llega el valor inicial que debe tener el dado (tratar de enviarle el número 7)*/

class Dado4(valor: Int) { // Clase 'Dado4' que recibe un valor inicial en su constructor.

    var valor: Int = 1 // Propiedad 'valor' de tipo entero con un valor inicial de 1.
        set(valor) { // Setter personalizado para la propiedad 'valor'.
            if (valor >= 1 && valor <= 6) // Si el valor está en el rango de 1 a 6,
                field = valor // Asigna el valor recibido.
            else
                field = 1 // Si el valor no está en el rango, asigna el valor 1.
        }

    init { // Bloque de inicialización que se ejecuta cuando se crea el objeto.
        this.valor = valor // Asigna el valor recibido en el constructor utilizando el setter.
    }

    fun tirar() { // Metodo 'tirar' que genera un valor aleatorio entre 1 y 6.
        valor = ((Math.random() * 6) + 1).toInt() // Asigna un número aleatorio entre 1 y 6 a la propiedad 'valor'.
    }

    fun imprimir() = println("Valor del dado: $valor") // Metodo 'imprimir' que muestra el valor actual del dado.
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el programa.
    val dado1 = Dado4(7) // Crea un objeto 'dado1' de la clase 'Dado4' con el valor inicial 7, que será reemplazado por 1.
    dado1.imprimir() // Llama al metodo 'imprimir' para mostrar el valor inicial del dado (1).
    dado1.tirar() // Llama al metodo 'tirar' para generar un nuevo valor aleatorio entre 1 y 6.
    dado1.imprimir() // Llama nuevamente al metodo 'imprimir' para mostrar el nuevo valor del dado después de tirar.
}