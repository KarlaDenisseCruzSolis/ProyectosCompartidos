//PROBLEMA PROPUESTO 126
/*Confeccionar una clase que represente un Empleado. Definir como propiedades su nombre y su sueldo.
No permitir que se cargue un valor negativo en su sueldo.
Codificar el metodo imprimir en la clase.*/

class Empleado(var nombre: String, sueldo: Double) { // Clase 'Empleado' con propiedades 'nombre' y 'sueldo'.

    var sueldo: Double = 0.0 // Propiedad 'sueldo' de tipo Double, inicializada en 0.0.
        set(valor) { // Setter personalizado para la propiedad 'sueldo'.
            if (valor < 0) // Si el valor es menor que 0,
                field = 0.0 // Asigna 0.0 al campo de respaldo.
            else
                field = valor // Si el valor es mayor o igual a 0, asigna el valor proporcionado.
        }

    init { // Bloque 'init' que se ejecuta cuando se crea una instancia de la clase.
        this.sueldo = sueldo // Asigna el sueldo recibido en el constructor al campo 'sueldo' usando el setter.
    }

    fun imprimir() { // Metodo 'imprimir' para mostrar el nombre y el sueldo del empleado.
        println("$nombre tiene un sueldo de $sueldo") // Muestra el nombre y el sueldo en consola.
    }
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el programa.
    val empleado1 = Empleado("Juan", 12000.50) // Crea un objeto 'empleado1' de la clase 'Empleado' con un sueldo positivo.
    empleado1.imprimir() // Llama al metodo 'imprimir' de 'empleado1', mostrando su sueldo.
    val empleado2 = Empleado("Ana", -1200.0) // Crea un objeto 'empleado2' con un sueldo negativo.
    empleado2.imprimir() // Llama al metodo 'imprimir' de 'empleado2', pero el sueldo se corregirá a 0.0 por el setter.
}