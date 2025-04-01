//PROBLEMA PROPUESTO 127
/*Plantear una clase llamada Dado. Definir una propiedad llamada valor que permita cargar un valor comprendido entre 1 y 6 si
llega un valor que no está comprendido en este rango se debe cargar un 1. Definir dos métodos, uno que genere un número aleatorio entre 1 y 6 y otro que lo imprima.
Al constructor llega el valor inicial que debe tener el dado (tratar de enviarle el número 7)*/
class Dado4(valor: Int){
    var valor: Int = 1
        set(valor) {
            if (valor >=1 && valor <= 6)
                field = valor
            else
                field = 1
        }

    init {
        this.valor = valor
    }

    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    fun imprimir() = println("Valor del dado: $valor")
}

fun main(parametro: Array<String>) {
    val dado1 = Dado4(7)
    dado1.imprimir()
    dado1.tirar()
    dado1.imprimir()
}
