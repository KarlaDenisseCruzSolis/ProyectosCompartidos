//PROBLEMA PROPUESTO 126
/*Confeccionar una clase que represente un Empleado. Definir como propiedades su nombre y su sueldo.
No permitir que se cargue un valor negativo en su sueldo.
Codificar el método imprimir en la clase.*/
class Empleado(var nombre: String, sueldo: Double) {

    var sueldo: Double = 0.0
        set(valor) {
            if (valor < 0)
                field = 0.0
            else
                field = valor
        }

    init {
        this.sueldo = sueldo
    }

    fun imprimir() {
        println("$nombre tiene un sueldo de $sueldo")
    }
}

fun main(parametro: Array<String>) {
    val empleado1 = Empleado("Juan", 12000.50)
    empleado1.imprimir()
    val empleado2 = Empleado("Ana", -1200.0)
    empleado2.imprimir()
}
