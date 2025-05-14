// Clase abstracta 'Cuenta', que tiene propiedades y métodos comunes para las cuentas bancarias
// Contiene las propiedades 'titular' (nombre del titular) y 'monto' (monto de la cuenta)
abstract class Cuenta(val titular: String, val monto: Double) {
    // Metodo 'imprimir' que imprime los detalles básicos de la cuenta (titular y monto)
    open fun imprimir() {
        println("Titular: $titular")
        println("Monto: $monto")
    }
}

// Clase 'CajaAhorro' que hereda de 'Cuenta' y representa una cuenta de ahorro
// Sobrescribe el metodo 'imprimir' para agregar una línea indicando que es una caja de ahorro
class CajaAhorro(titular: String, monto: Double): Cuenta(titular, monto) {
    // Sobrescribe el metodo 'imprimir' para personalizar la salida para una cuenta de ahorro
    override fun imprimir() {
        println("Cuenta de caja de ahorro")  // Indica que es una caja de ahorro
        super.imprimir()  // Llama al metodo 'imprimir' de la clase base para imprimir los detalles comunes
    }
}

// Clase 'PlazoFijo' que hereda de 'Cuenta' y representa una cuenta de plazo fijo
// Añade dos propiedades específicas: 'plazo' (número de días de imposición) e 'interes' (tasa de interés)
class PlazoFijo(titular: String, monto: Double, val plazo: Int, val interes: Double): Cuenta(titular, monto) {
    // Sobrescribe el metodo 'imprimir' para incluir información sobre el plazo y los intereses de la cuenta
    override fun imprimir() {
        println("Cuenta de plazo fijo")  // Indica que es una cuenta de plazo fijo
        println("Plazo en dias: $plazo")  // Muestra el plazo en días
        println("Intereses: $interes")  // Muestra la tasa de interés
        val ganancia = monto * interes / 100  // Calcula la ganancia por los intereses
        println("Importe del interes: $ganancia")  // Muestra el monto de los intereses generados
        super.imprimir()  // Llama al metodo 'imprimir' de la clase base para imprimir los detalles comunes
    }
}

fun main(parametro: Array<String>) {
    // Crea un objeto 'cajaAhorro1' de la clase 'CajaAhorro' con titular "juan" y monto de 10000.0
    val cajaAhorro1 = CajaAhorro("juan", 10000.0)
    cajaAhorro1.imprimir()  // Llama al metodo 'imprimir' para mostrar los detalles de la cuenta de ahorro

    // Crea un objeto 'plazoFijo1' de la clase 'PlazoFijo' con titular "Ana", monto de 5000.0, plazo de 30 días e interés de 1.23%
    val plazoFijo1 = PlazoFijo("Ana", 5000.0, 30, 1.23)
    plazoFijo1.imprimir()  // Llama al metodo 'imprimir' para mostrar los detalles de la cuenta de plazo fijo
}