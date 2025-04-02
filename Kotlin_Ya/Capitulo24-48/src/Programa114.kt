class Triangulo2 (var lado1: Int, var lado2: Int, var lado3: Int){
    constructor():this(0, 0, 0) {
        print("Ingrese primer lado:")
        lado1 = readLine()!!.toInt()
        print("Ingrese segundo lado:")
        lado2 = readLine()!!.toInt()
        print("Ingrese tercer lado:")
        lado3 = readLine()!!.toInt()
    }
    fun ladoMayor() {
        print("Lado mayor:")
        when {
            lado1 > lado2 && lado1 > lado3 -> println(lado1)
            lado2 > lado3 -> println(lado2)
            else -> println(lado3)
        }
    }
    fun esEquilatero() {
        if (lado1 == lado2 && lado1 == lado3)
            println("Es un triángulo equilátero")
        else
            println("No es un triángulo equilátero")
    }
}
fun main(parametro: Array<String>) {
    val triangulo1 = Triangulo2()
    triangulo1.ladoMayor()
    triangulo1.esEquilatero()
    val triangulo2 = Triangulo2(6, 6, 6)
    triangulo2.ladoMayor()
    triangulo2.esEquilatero()
}