
fun main(parametro: Array<String>) {  // Define la función principal 'main', con un parámetro de tipo Array<String>
    print("Ingrese el sueldo del empleado:")  // Muestra un mensaje solicitando al usuario que ingrese el sueldo del empleado
    val sueldo = readLine()!!.toDouble()  // Lee el sueldo ingresado por el usuario, lo convierte a un número decimal (Double) y lo guarda en 'sueldo'
    if (sueldo > 3000) {  // Verifica si el sueldo ingresado es mayor a 3000
        println("Debe pagar impuestos")  // Si el sueldo es mayor a 3000, muestra el mensaje "Debe pagar impuestos"
    }
}
