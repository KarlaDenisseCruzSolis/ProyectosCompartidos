//PROBLEMA PROPUESTO 157
/*Declarar una clase Dado que tenga como propiedad su valor y dos métodos que permitan tirar el dado e imprimir su valor.
En la main definir un Array con 5 objetos de tipo Dado.
Tirar los 5 dados e imprimir cuantos 1, 2, 3, 4, 5 y 6 salieron.*/
class Dado0 (var valor: Int = 1){
    // Metodo para simular el lanzamiento del dado, asignando un valor aleatorio entre 1 y 6
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    // Metodo para imprimir el valor del dado
    fun imprimir() {
        println("Valor del dado: $valor")
    }
}

fun main(parametro: Array<String>) {
    // Se crea un arreglo de 5 objetos Dado0, todos con valor inicial 1
    var dados: Array<Dado0> = arrayOf(Dado0(), Dado0(), Dado0(), Dado0(), Dado0())

    // Se tiran todos los dados
    for(dado in dados)
        dado.tirar()

    // Se imprime el valor de cada dado después de ser tirado
    for(dado in dados)
        dado.imprimir()

    // Inicialización de las variables para contar cuántos 1, 2, 3, 4, 5 y 6 han salido
    var cant1 = 0
    var cant2 = 0
    var cant3 = 0
    var cant4 = 0
    var cant5 = 0
    var cant6 = 0

    // Se recorre el arreglo de dados para contar la cantidad de veces que salió cada valor
    dados.forEach {
        when (it.valor) {
            1 -> cant1++  // Si el valor del dado es 1, incrementa la cantidad de 1
            2 -> cant2++  // Si el valor del dado es 2, incrementa la cantidad de 2
            3 -> cant3++  // Si el valor del dado es 3, incrementa la cantidad de 3
            4 -> cant4++  // Si el valor del dado es 4, incrementa la cantidad de 4
            5 -> cant5++  // Si el valor del dado es 5, incrementa la cantidad de 5
            6 -> cant6++  // Si el valor del dado es 6, incrementa la cantidad de 6
        }
    }

    // Se imprime la cantidad de veces que salió cada número en los dados
    println("Cantidad de dados que tienen el valor 1: $cant1")
    println("Cantidad de dados que tienen el valor 2: $cant2")
    println("Cantidad de dados que tienen el valor 3: $cant3")
    println("Cantidad de dados que tienen el valor 4: $cant4")
    println("Cantidad de dados que tienen el valor 5: $cant5")
    println("Cantidad de dados que tienen el valor 6: $cant6")
}