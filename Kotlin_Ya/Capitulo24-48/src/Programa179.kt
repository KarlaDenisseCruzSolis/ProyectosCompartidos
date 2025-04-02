//PROBLEMA PROPUESTO 179
/*Confeccionar una clase que represente un Empleado. Definir como propiedades su nombre y su sueldo.
Definir una lista mutable con tres empleados.
Imprimir los datos de los empleados.
Calcular cuanto gasta la empresa en sueldos.
Agregar un nuevo empleado a la lista y calcular nuevamente el gasto en sueldos.*/
class Empleado0(var nombre: String, var sueldo: Double) {

    fun imprimir() {
        println("$nombre tiene un sueldo de $sueldo")
    }
}

fun calcularGastos(empleados: MutableList<Empleado0>) {
    val suma = empleados.sumByDouble { it.sueldo }
    println("Total de gastos de la empresa:$suma")
}

fun main(args: Array<String>) {
    val empleados: MutableList<Empleado0> = mutableListOf(Empleado0("Juan", 2000.0),
        Empleado0("Ana", 3500.0),
        Empleado0("Carlos", 1500.0))
    empleados.forEach { it.imprimir() }
    calcularGastos(empleados)
    empleados.add(Empleado0("Marcos", 3000.0))
    println("Gastos luego de ingresar un nuevo empleado que cobra 3000")
    calcularGastos(empleados)
}