
fun mostrarPerimetro(lado: Int) {  // Función que calcula y muestra el perímetro de un cuadrado dado el valor de su lado
    val perimetro = lado * 4  // Calcula el perímetro multiplicando el lado por 4
    println("El perímetro es $perimetro")  // Imprime el resultado del perímetro
}

fun mostrarSuperficie(lado: Int) {  // Función que calcula y muestra la superficie de un cuadrado dado el valor de su lado
    val superficie = lado * lado  // Calcula la superficie (área) multiplicando el lado por sí mismo
    println("La superficie es $superficie")  // Imprime el resultado de la superficie
}

fun main(parametro: Array<String>) {  // Función principal del programa
    print("Ingrese el valor del lado de un cuadrado:")  // Solicita al usuario que ingrese el valor del lado
    val la = readLine()!!.toInt()  // Lee el valor ingresado y lo convierte a un entero (Int), lo guarda en 'la'

    print("Quiere calcular el perímetro o la superficie[ingresar texto: perimetro/superficie]")  // Solicita al usuario si quiere calcular el perímetro o la superficie
    var respuesta = readLine()!!  // Lee la respuesta del usuario (perimetro o superficie) y la guarda en 'respuesta'

    when (respuesta) {  // Utiliza una expresión 'when' para comparar la respuesta del usuario
        "perimetro" -> mostrarPerimetro(la)  // Si el usuario ingresa "perimetro", llama a la función 'mostrarPerimetro' con el valor de 'la'
        "superficie" -> mostrarSuperficie(la)  // Si el usuario ingresa "superficie", llama a la función 'mostrarSuperficie' con el valor de 'la'
    }
}
