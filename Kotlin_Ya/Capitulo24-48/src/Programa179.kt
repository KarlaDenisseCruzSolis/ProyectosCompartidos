//PROBLEMA PROPUESTO 179
/*Confeccionar una clase que represente un Empleado. Definir como propiedades su nombre y su sueldo.
Definir una lista mutable con tres empleados.
Imprimir los datos de los empleados.
Calcular cuanto gasta la empresa en sueldos.
Agregar un nuevo empleado a la lista y calcular nuevamente el gasto en sueldos.*/

// Clase que representa un Empleado con dos propiedades: nombre y sueldo
class Empleado0(var nombre: String, var sueldo: Double) {

    // Metodo para imprimir los datos de un empleado
    fun imprimir() {
        println("$nombre tiene un sueldo de $sueldo")
    }
}

// Función para calcular el total de gastos de la empresa en sueldos
fun calcularGastos(empleados: MutableList<Empleado0>) {
    // Sumar los sueldos de todos los empleados y mostrar el total
    val suma = empleados.sumByDouble { it.sueldo }
    println("Total de gastos de la empresa:$suma")
}

fun main(args: Array<String>) {
    // Crear una lista mutable de empleados con tres empleados iniciales
    val empleados: MutableList<Empleado0> = mutableListOf(
        Empleado0("Juan", 2000.0),
        Empleado0("Ana", 3500.0),
        Empleado0("Carlos", 1500.0)
    )

    // Imprimir los datos de los empleados
    empleados.forEach { it.imprimir() }

    // Calcular y mostrar los gastos iniciales de la empresa
    calcularGastos(empleados)

    // Agregar un nuevo empleado a la lista
    empleados.add(Empleado0("Marcos", 3000.0))

    // Imprimir mensaje indicando que se agregó un nuevo empleado
    println("Gastos luego de ingresar un nuevo empleado que cobra 3000")

    // Calcular y mostrar nuevamente los gastos de la empresa
    calcularGastos(empleados)
}