//ORIGINAL
/*interface Figura {
    fun calcularSuperficie(): Int
    fun calcularperimetro(): Int
    fun tituloResultado() {
        println("Datos de la figura")
    }
}
abstract class Cuadradoo(val lado: Int): Figura {
    override fun calcularSuperficie(): Int {
        return lado * lado
    }
    override fun calcularperimetro(): Int{
        return lado * 4
    }
}
abstract class Rectanguloo(val ladoMayor:Int, val ladoMenor: Int): Figura {
    override fun calcularSuperficie(): Int {
        return ladoMayor * ladoMenor
    }
    fun calcularPerimetro(): Int {
        return (ladoMayor * 2) + (ladoMenor * 2)
    }
}
fun main(parametro: Array<String>) {
    val cuadrado1 = object : Cuadradoo(10) {
        override fun calcularperimetro(): Int {
            return lado * 4
        }
    }
    cuadrado1.tituloResultado()
    println("Perimetro del cuadrado : ${cuadrado1.calcularperimetro()}")
    println("Superficie del cuadrado : ${cuadrado1.calcularSuperficie()}")
    val rectangulo1 = object : Rectanguloo(10, 5) {
        override fun calcularperimetro(): Int {
            return (ladoMayor * 2) + (ladoMenor * 2)
        }
    }
    rectangulo1.tituloResultado()
    println("Perimetro del rectangulo : ${rectangulo1.calcularperimetro()}")
    println("Superficie del cuadrado : ${rectangulo1.calcularSuperficie()}")
}*/

//ACOTACION 1
interface Figura {
    fun calcularSuperficie(): Int
    fun calcularPerimetro(): Int
    fun tituloResultado() {
        println("Datos de la figura")
    }
}
class Cuadrado(val lado: Int): Figura {
    override fun calcularSuperficie(): Int {
        return lado * lado
    }
    override fun calcularPerimetro(): Int{
        return lado * 4
    }
}
class Rectangulo(val ladoMayor:Int, val ladoMenor: Int): Figura {
    override fun calcularSuperficie(): Int {
        return ladoMayor * ladoMenor
    }
    override fun calcularPerimetro(): Int {
        return (ladoMayor * 2) + (ladoMenor * 2)
    }
}
fun imprimir(fig: Figura) {
    println("Perimetro: ${fig.calcularPerimetro()}")
    println("Superficie: ${fig.calcularSuperficie()}")
}
fun main(parametro: Array<String>) {
    val cuadrado1 = Cuadrado(10)
    cuadrado1.tituloResultado()
    println("Perimetro del cuadrado : ${cuadrado1.calcularPerimetro()}")
    println("Superficie del cuadrado : ${cuadrado1.calcularSuperficie()}")
    val rectangulo1 = Rectangulo(10, 5)
    rectangulo1.tituloResultado()
    println("Perimetro del rectangulo : ${rectangulo1.calcularPerimetro()}")
    println("Superficie del cuadrado : ${rectangulo1.calcularSuperficie()}")
    imprimir(cuadrado1)
    imprimir(rectangulo1)
}