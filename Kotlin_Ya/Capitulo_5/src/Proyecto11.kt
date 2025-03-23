
fun main(parametro: Array<String>) {  // Define la función principal 'main', con un parámetro de tipo Array<String>
    print("Ingrese primer valor:")  // Muestra un mensaje solicitando al usuario que ingrese el primer valor
    val valor1 = readLine()!!.toInt()  // Lee la entrada del usuario, la convierte a un entero (Int) y la guarda en 'valor1'
    print("Ingrese segundo valor:")  // Muestra un mensaje solicitando al usuario que ingrese el segundo valor
    val valor2 = readLine()!!.toInt()  // Lee la entrada del usuario, la convierte a un entero (Int) y la guarda en 'valor2'
    if (valor1 > valor2) {  // Verifica si 'valor1' es mayor que 'valor2'
        print("El mayor valor es $valor1")  // Si 'valor1' es mayor, muestra el mensaje con el valor de 'valor1'
    } else {  // Si la condición anterior no es verdadera, se ejecuta el bloque 'else'
        print("El mayor valor es $valor2")  // Muestra el mensaje con el valor de 'valor2', ya que es mayor o igual a 'valor1'
    }
}
