//PROBLEMA PROPUESTO 141
/*Declarar una clase abstracta Cuenta y dos subclases CajaAhorra y PlazoFijo. Definir las propiedades y métodos comunes
entre una caja de ahorro y un plazo fijo y agruparlos en la clase Cuenta. Una caja de ahorro y un plazo fijo tienen un
nombre de titular y un monto. Un plazo fijo añade un plazo de imposición en días y una tasa de interés. Hacer que la caja
de ahorro no genera intereses. En la función main del programa definir un objeto de la clase CajaAhorro y otro de la clase PlazoFijo.*/
abstract class Cuenta(val titular: String, val monto: Double) {
    open fun imprimir() {
        println("Titular: $titular")
        println("Monto: $monto")
    }
}

class CajaAhorro(titular: String, monto: Double): Cuenta(titular, monto) {
    override fun imprimir() {
        println("Cuenta de caja de ahorro")
        super.imprimir()
    }
}

class PlazoFijo(titular: String, monto: Double, val plazo: Int, val interes: Double): Cuenta(titular, monto) {
    override fun imprimir() {
        println("Cuenta de plazo fijo")
        println("Plazo en dias: $plazo")
        println("Intereses: $interes")
        val ganancia =  monto * interes / 100
        println("Importe del interes: $ganancia")
        super.imprimir()
    }
}

fun main(parametro: Array<String>) {
    val cajaAhorro1 = CajaAhorro("juan", 10000.0)
    cajaAhorro1.imprimir()
    val plazoFijo1 = PlazoFijo("Ana", 5000.0, 30, 1.23)
    plazoFijo1.imprimir()
}
