
fun mostrarMayor(v1: Int, v2: Int, v3: Int) {  // Función que recibe tres valores enteros como parámetros
    print("Mayor:")  // Imprime la palabra "Mayor:" antes de mostrar el número mayor
    if (v1 > v2 && v1 > v3)  // Si 'v1' es mayor que 'v2' y 'v3'
        println(v1)  // Muestra 'v1' como el mayor
    else  // Si la condición anterior no es verdadera
        if (v2 > v3)  // Si 'v2' es mayor que 'v3'
            print(v2)  // Muestra 'v2' como el mayor
        else  // Si ninguna de las condiciones anteriores se cumple
            print(v3)  // Muestra 'v3' como el mayor
}

fun main(parametro: Array<String>) {  // Función principal del programa
    print("Ingrese primer valor:")  // Solicita al usuario el primer valor
    val valor1 = readLine()!!.toInt()  // Lee el valor ingresado, lo convierte a entero y lo guarda en 'valor1'

    print("Ingrese segundo valor:")  // Solicita al usuario el segundo valor
    val valor2 = readLine()!!.toInt()  // Lee el valor ingresado, lo convierte a entero y lo guarda en 'valor2'

    print("Ingrese tercer valor:")  // Solicita al usuario el tercer valor
    val valor3 = readLine()!!.toInt()  // Lee el valor ingresado, lo convierte a entero y lo guarda en 'valor3'

    mostrarMayor(valor1, valor2, valor3)  // Llama a la función 'mostrarMayor()' pasando los tres valores como parámetros
}
