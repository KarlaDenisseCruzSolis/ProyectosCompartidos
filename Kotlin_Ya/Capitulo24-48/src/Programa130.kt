//PROBLEMA PROPUESTO 130
/*Plantear un data class llamado Dado con una única propiedad llamada valor.
Sobreescribir el método toString para que muestre tantos asteriscos como indica la propiedad valor.*/
data class Dados (var valor: Int) {
    override fun toString(): String {
        var cadena = ""
        for(i in 1..valor)
            cadena = cadena +"*"
        return cadena
    }
}

fun main(parametro: Array<String>) {
    val dado1 = Dados(4)
    val dado2 = Dados(6)
    val dado3 = Dados(1)
    println(dado1)
    println(dado2)
    println(dado3)
}
