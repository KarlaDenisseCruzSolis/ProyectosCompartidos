
fun main(parametro: Array<String>) {  // Define la función principal 'main', con un parámetro de tipo Array<String>
    print("Ingrese un valor entero:")  // Solicita al usuario que ingrese un valor entero
    val valor = readLine()!!.toInt()  // Lee la entrada del usuario, la convierte a un entero (Int) y lo guarda en 'valor'
    // Condición que verifica si el valor es par (valor % 2 == 0)
    val resultado = if (valor % 2 == 0) {
        print("Cuadrado:")  // Si el valor es par, imprime "Cuadrado:"
        valor * valor  // Calcula el cuadrado de 'valor' y lo asigna a 'resultado'
    } else {
        print("Cubo:")  // Si el valor es impar, imprime "Cubo:"
        valor * valor * valor  // Calcula el cubo de 'valor' y lo asigna a 'resultado'
    }
    print(resultado)  // Imprime el resultado calculado, ya sea el cuadrado o el cubo
}
