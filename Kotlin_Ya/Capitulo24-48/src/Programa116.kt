//PROBLEMA PROPUESTO 116
/*Cofeccionar una clase que represente un punto en el plano, la coordenada de un punto en el plano está dado por dos valores enteros x e y.
Al constructor llega la ubicación del punto en x e y. Implementar un método que retorne un String que indique en que cuadrante se ubica
dicho punto. (1º Cuadrante si x > 0 Y y > 0 , 2º Cuadrante: x < 0 Y y > 0, 3º Cuadrante: x < 0 Y y < 0, 4º Cuadrante: x > 0 Y y < 0)
Si alguno o los dos valores son cero luego el punto se encuentra en un eje. Definir luego 5 objetos de la clase Punto en cada uno de
los cuadrantes y uno en un eje.*/
class Punto (val x: Int, val y: Int) {

    fun retornarCuadrante() = when {
        x > 0 && y > 0 -> "Primer cuadrate"
        x < 0 && y > 0 -> "Segundo cuadrante"
        x < 0 && y < 0 -> "Tercer cuadrante"
        x > 0 && y < 0 -> "Cuarto cuadrante"
        else -> "Un eje"
    }
}

fun main(parametro: Array<String>) {
    val punto1 = Punto(12, 3)
    println("La coordenada ${punto1.x}, ${punto1.y} se encuentra en ${punto1.retornarCuadrante()}")
    val punto2 = Punto(-4, 3)
    println("La coordenada ${punto2.x}, ${punto2.y} se encuentra en ${punto2.retornarCuadrante()}")
    val punto3 = Punto(-2, -2)
    println("La coordenada ${punto3.x}, ${punto3.y} se encuentra en ${punto3.retornarCuadrante()}")
    val punto4 = Punto(12, -5)
    println("La coordenada ${punto4.x}, ${punto4.y} se encuentra en ${punto4.retornarCuadrante()}")
    val punto5 = Punto(0, -5)
    println("La coordenada ${punto5.x}, ${punto5.y} se encuentra en ${punto5.retornarCuadrante()}")
}
