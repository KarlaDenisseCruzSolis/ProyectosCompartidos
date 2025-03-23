
fun main(parametro: Array<String>) {  // Define la función principal 'main', con un parámetro de tipo Array<String>
    var cant1 = 0  // Declara la variable 'cant1' que llevará la cuenta de los números 0 ingresados
    var cant2 = 0  // Declara la variable 'cant2' que llevará la cuenta de los números 1, 5, o 10 ingresados

    // Inicia un bucle 'for' que se repite 10 veces (de 1 a 10)
    for(i in 1..10) {
        print("Ingrese un valor entero:")  // Muestra un mensaje solicitando al usuario que ingrese un valor entero
        val valor = readLine()!!.toInt()  // Lee el valor ingresado por el usuario, lo convierte a entero (Int) y lo guarda en la variable 'valor'

        // Utiliza una estructura 'when' para realizar un control según el valor ingresado
        when (valor) {
            0 -> cant1++  // Si el valor ingresado es 0, incrementa 'cant1' en 1
            1, 5, 10 -> cant2++  // Si el valor es 1, 5 o 10, incrementa 'cant2' en 1
        }
    }

    // Muestra la cantidad de veces que se ingresó el número 0
    println("Cantidad de números 0 ingresados: $cant1")
    // Muestra la cantidad de veces que se ingresaron los números 1, 5 o 10
    println("Cantidad de números 1,5 o 10 ingresados: $cant2")
}
