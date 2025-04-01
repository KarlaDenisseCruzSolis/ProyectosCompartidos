//PROBLEMA PROPUESTO 157
/*Declarar una clase Dado que tenga como propiedad su valor y dos métodos que permitan tirar el dado e imprimir su valor.
En la main definir un Array con 5 objetos de tipo Dado.
Tirar los 5 dados e imprimir cuantos 1, 2, 3, 4, 5 y 6 salieron.*/
class Dado0 (var valor: Int = 1){

    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    fun imprimir() {
        println("Valor del dado: $valor")
    }
}

fun main(parametro: Array<String>) {
    var dados: Array<Dado0> = arrayOf(Dado0(), Dado0(), Dado0(), Dado0(), Dado0())
    for(dado in dados)
        dado.tirar()
    for(dado in dados)
        dado.imprimir()
    var cant1 = 0
    var cant2 = 0
    var cant3 = 0
    var cant4 = 0
    var cant5 = 0
    var cant6 = 0
    dados.forEach {
        when (it.valor) {
            1 -> cant1++
            2 -> cant2++
            3 -> cant3++
            4 -> cant4++
            5 -> cant5++
            6 -> cant6++
        }
    }
    println("Cantidad de dados que tienen el valor 1: $cant1")
    println("Cantidad de dados que tienen el valor 2: $cant2")
    println("Cantidad de dados que tienen el valor 3: $cant3")
    println("Cantidad de dados que tienen el valor 4: $cant4")
    println("Cantidad de dados que tienen el valor 5: $cant5")
    println("Cantidad de dados que tienen el valor 6: $cant6")
}