class Dadoss () {
    // Propiedad que representa un arreglo de 10 elementos de tipo Int.
    val arreglo = IntArray(10)

    // Metodo para simular el lanzamiento de 10 dados. Cada dado obtiene un valor entre 1 y 6.
    fun tirar() {
        // Itera sobre el arreglo utilizando sus índices (0 hasta 9)
        for(i in arreglo.indices)
        // Asigna un valor aleatorio entre 1 y 6 a cada dado
            arreglo[i] = ((Math.random() * 6) + 1).toInt()
    }

    // Sobrecarga del operador "invoke" para acceder al valor de un dado específico en el arreglo.
    operator fun invoke(nro: Int) = arreglo[nro]
}

fun main(args: Array<String>) {
    // Se crea una instancia de la clase Dadoss, llamada "dados".
    var dados = Dadoss()

    // Llama al metodo "tirar" para simular el lanzamiento de los dados.
    dados.tirar()

    // Imprime el valor del primer dado (índice 0) utilizando el operador "invoke".
    println(dados(0))
    // Imprime el valor del segundo dado (índice 1) utilizando el operador "invoke".
    println(dados(1))

    // Imprime los valores de los dados restantes (índices 2 a 9) utilizando el operador "invoke".
    for(i in 2..9)
        println(dados(i))
}