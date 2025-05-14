//ORIGINAL
/*interface Figura {
    fun calcularSuperficie(): Int
    fun calcularperimetro(): Int
    fun tituloResultado() {
        println("Datos de la figura")
    }
}
// COMENTARIO: Se define una interfaz llamada Figura con tres métodos. Uno de ellos, tituloResultado, ya incluye una implementación.

abstract class Cuadradoo(val lado: Int): Figura {
    override fun calcularSuperficie(): Int {
        return lado * lado
    }
    override fun calcularperimetro(): Int{
        return lado * 4
    }
}
// COMENTARIO: Clase abstracta Cuadradoo que hereda de Figura e implementa los métodos calcularSuperficie y calcularperimetro.

abstract class Rectanguloo(val ladoMayor:Int, val ladoMenor: Int): Figura {
    override fun calcularSuperficie(): Int {
        return ladoMayor * ladoMenor
    }
    fun calcularPerimetro(): Int {
        return (ladoMayor * 2) + (ladoMenor * 2)
    }
}
// COMENTARIO: Clase abstracta Rectanguloo que implementa calcularSuperficie y tiene su propia versión de calcularPerimetro (con mayúscula diferente).

fun main(parametro: Array<String>) {
    val cuadrado1 = object : Cuadradoo(10) {
        override fun calcularperimetro(): Int {
            return lado * 4
        }
    }
    // COMENTARIO: Se crea una instancia anónima de Cuadradoo y se sobreescribe calcularperimetro.

    cuadrado1.tituloResultado()
    println("Perimetro del cuadrado : ${cuadrado1.calcularperimetro()}")
    println("Superficie del cuadrado : ${cuadrado1.calcularSuperficie()}")

    val rectangulo1 = object : Rectanguloo(10, 5) {
        override fun calcularperimetro(): Int {
            return (ladoMayor * 2) + (ladoMenor * 2)
        }
    }
    // COMENTARIO: Se crea una instancia anónima de Rectanguloo y se sobreescribe calcularperimetro con el mismo cálculo que ya estaba definido.

    rectangulo1.tituloResultado()
    println("Perimetro del rectangulo : ${rectangulo1.calcularperimetro()}")
    println("Superficie del cuadrado : ${rectangulo1.calcularSuperficie()}")
}*/

// COMENTARIO: Fin del bloque ORIGINAL — contiene implementación basada en clases abstractas y objetos anónimos.

//ACOTACION 1
interface Figura {
    fun calcularSuperficie(): Int
    fun calcularPerimetro(): Int
    fun tituloResultado() {
        println("Datos de la figura")
    }
}
// COMENTARIO: Interfaz Figura rediseñada con nombres de métodos unificados (camelCase correcto).

class Cuadrado(val lado: Int): Figura {
    override fun calcularSuperficie(): Int {
        return lado * lado
    }
    override fun calcularPerimetro(): Int{
        return lado * 4
    }
}
// COMENTARIO: Clase concreta Cuadrado que implementa Figura. Calcula su superficie y perímetro.

class Rectangulo(val ladoMayor:Int, val ladoMenor: Int): Figura {
    override fun calcularSuperficie(): Int {
        return ladoMayor * ladoMenor
    }
    override fun calcularPerimetro(): Int {
        return (ladoMayor * 2) + (ladoMenor * 2)
    }
}
// COMENTARIO: Clase concreta Rectangulo que implementa Figura. Calcula superficie y perímetro correctamente.

fun imprimir(fig: Figura) {
    println("Perimetro: ${fig.calcularPerimetro()}")
    println("Superficie: ${fig.calcularSuperficie()}")
}
// COMENTARIO: Función utilitaria que imprime los datos de cualquier figura que implemente la interfaz Figura.

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
// COMENTARIO: En este main se crean instancias concretas de Cuadrado y Rectangulo y se imprimen sus datos usando tanto llamadas directas como la función imprimir.
