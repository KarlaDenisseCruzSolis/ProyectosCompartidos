//PROBLEMA PROPUESTO 146
/*Declarar una clase Dado que tenga como propiedad su valor y dos métodos que permitan tirar el dado e imprimir su valor.
En la main definir un Array con 5 objetos de tipo Dado.
Tirar los 5 dados e imprimir los valores de cada uno.*/
class Dadoo (var valor: Int = 1){

    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    fun imprimir() {
        println("Valor del dado: $valor")
    }
}

fun main(parametro: Array<String>) {
    var dados: Array<Dadoo> = arrayOf(Dadoo(), Dadoo(), Dadoo(), Dadoo(), Dadoo())
    for(dado in dados)
        dado.tirar()
    for(dado in dados)
        dado.imprimir()
}