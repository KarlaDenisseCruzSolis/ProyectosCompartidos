//PROBLEMA PROPUESTO 139
/*Declarar una clase Dado que genere un valor aleatorio entre 1 y 6, mostrar su valor.
Crear una segunda clase llamada DadoRecuadro que genere un valor entre 1 y 6, mostrar el valor recuadrado en asteríscos.
Utilizar la herencia entre estas dos clases.*/
open class Dado10{
    protected var valor: Int = 1
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    open fun imprimir() {
        println("$valor")
    }
}

class DadoRecuadro: Dado10() {
    override fun imprimir() {
        println("***")
        println("*$valor*")
        println("***")
    }
}

fun main(parametro: Array<String>) {
    val dado1 = Dado10()
    dado1.tirar()
    dado1.imprimir()

    val dado2 = DadoRecuadro()
    dado2.tirar()
    dado2.imprimir()
}
