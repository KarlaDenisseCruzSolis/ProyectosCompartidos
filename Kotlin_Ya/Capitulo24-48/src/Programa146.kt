//PROBLEMA PROPUESTO 146
/*Declarar una clase Dado que tenga como propiedad su valor y dos métodos que permitan tirar el dado e imprimir su valor.
En la main definir un Array con 5 objetos de tipo Dado.
Tirar los 5 dados e imprimir los valores de cada uno.*/

// Definición de la clase Dadoo con una propiedad 'valor' inicializada en 1
class Dadoo (var valor: Int = 1){

    // Metodo para tirar el dado: genera un número aleatorio entre 1 y 6 y lo asigna a 'valor'
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    // Metodo para imprimir el valor actual del dado
    fun imprimir() {
        println("Valor del dado: $valor")
    }
}

fun main(parametro: Array<String>) {
    // Se crea un array de 5 dados, cada uno inicializado con valor por defecto
    var dados: Array<Dadoo> = arrayOf(Dadoo(), Dadoo(), Dadoo(), Dadoo(), Dadoo())

    // Se tiran los 5 dados (se les asigna un valor aleatorio entre 1 y 6)
    for(dado in dados)
        dado.tirar()

    // Se imprime el valor de cada dado después de haber sido lanzado
    for(dado in dados)
        dado.imprimir()
}