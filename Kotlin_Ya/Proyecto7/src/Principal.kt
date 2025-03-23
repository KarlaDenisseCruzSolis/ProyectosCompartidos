
fun main(parametro: Array<String>) {  // Define la función principal 'main', con un parámetro de tipo Array<String>
    print("Ingrese el precio del producto:")  // Muestra un mensaje solicitando el precio del producto
    val precio = readLine()!!.toDouble()  // Lee el precio ingresado por el usuario, lo convierte a un número decimal (Double) y lo guarda en 'precio'
    print("Ingrese la cantidad de productos:")  // Muestra un mensaje solicitando la cantidad de productos
    val cantidad = readLine()!!.toInt()  // Lee la cantidad ingresada por el usuario, la convierte a un número entero (Int) y lo guarda en 'cantidad'
    val total = precio * cantidad  // Calcula el total multiplicando 'precio' por 'cantidad' y lo guarda en 'total'
    println("El total a pagar es $total")  // Muestra el total a pagar en la consola, mostrando el valor calculado de 'total'
}
