
fun main(parametro: Array<String>) {  // Define la función principal 'main', con un parámetro de tipo Array<String>
    print("Ingrese un valor entero positivo comprendido entre 1 y 99999:")  // Muestra un mensaje solicitando al usuario que ingrese un valor entero positivo entre 1 y 99999
    val valor = readLine()!!.toInt()  // Lee el valor ingresado por el usuario, lo convierte a un número entero (Int) y lo guarda en la variable 'valor'

    // Utiliza una estructura 'when' para evaluar en qué rango se encuentra el valor ingresado
    when (valor) {
        in 1..9 -> print("Tiene 1 dígito")  // Si el valor está entre 1 y 9 (inclusive), imprime "Tiene 1 dígito"
        in 10..99 -> print("Tiene 2 dígitos")  // Si el valor está entre 10 y 99 (inclusive), imprime "Tiene 2 dígitos"
        in 100..999 -> print("Tiene 3 dígitos")  // Si el valor está entre 100 y 999 (inclusive), imprime "Tiene 3 dígitos"
        in 1000..9999 -> print("Tiene 4 dígitos")  // Si el valor está entre 1000 y 9999 (inclusive), imprime "Tiene 4 dígitos"
        in 10000..99999 -> print("Tiene 5 dígitos")  // Si el valor está entre 10000 y 99999 (inclusive), imprime "Tiene 5 dígitos"
        else -> print("No se encuentra comprendido en el rango indicado")  // Si el valor no se encuentra en ningún rango especificado, imprime un mensaje indicando que el valor está fuera del rango
    }
}
