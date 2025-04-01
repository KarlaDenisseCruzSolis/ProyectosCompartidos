// Función que solicita 10 valores al usuario y cuenta cuántos son múltiplos de 2 y cuántos de 5
fun multiplos2y5() {

    // Función interna que verifica si un número es múltiplo de otro
    fun multiplo(numero: Int, valor: Int) = numero % valor == 0

    // Variables para contar los múltiplos de 2 y 5
    var mult2 = 0
    var mult5 = 0

    // Bucle que se ejecuta 10 veces para pedir 10 valores al usuario
    for(i in 1..10) {
        // Solicita al usuario un valor
        print("Ingrese valor:")

        // Lee el valor ingresado por el usuario y lo convierte a entero
        val valor = readLine()!!.toInt()

        // Si el valor es múltiplo de 2, incrementa el contador de múltiplos de 2
        if (multiplo(valor, 2))
            mult2++

        // Si el valor es múltiplo de 5, incrementa el contador de múltiplos de 5
        if (multiplo(valor, 5))
            mult5++
    }

    // Muestra la cantidad de números ingresados que fueron múltiplos de 2
    println("Cantidad de múltiplos de 2 : $mult2")

    // Muestra la cantidad de números ingresados que fueron múltiplos de 5
    println("Cantidad de múltiplos de 5 : $mult5")
}

// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {
    // Llama a la función que cuenta los múltiplos de 2 y 5
    multiplos2y5()
}