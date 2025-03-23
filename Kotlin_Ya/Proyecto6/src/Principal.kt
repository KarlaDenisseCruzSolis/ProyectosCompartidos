
fun main(parametro: Array<String>) {  // Corrección con tipo String
    print("Ingrese la medida del lado del cuadrado:")
    val lado = readLine()!!.toInt()
    val perimetro = lado * 4
    println("El perímetro del cuadrado es $perimetro")
}

//de forma extensa: val lado:Int, lado= readLine()!!.toInt()
