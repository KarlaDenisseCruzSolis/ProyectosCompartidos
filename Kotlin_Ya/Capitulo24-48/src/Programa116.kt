//PROBLEMA PROPUESTO 116
/*Cofeccionar una clase que represente un punto en el plano, la coordenada de un punto en el plano está dado por dos valores enteros x e y.
Al constructor llega la ubicación del punto en x e y. Implementar un método que retorne un String que indique en que cuadrante se ubica
dicho punto. (1º Cuadrante si x > 0 Y y > 0 , 2º Cuadrante: x < 0 Y y > 0, 3º Cuadrante: x < 0 Y y < 0, 4º Cuadrante: x > 0 Y y < 0)
Si alguno o los dos valores son cero luego el punto se encuentra en un eje. Definir luego 5 objetos de la clase Punto en cada uno de
los cuadrantes y uno en un eje.*/
class Punto (val x: Int, val y: Int) { // Definición de la clase 'Punto' con dos propiedades inmutables: 'x' y 'y', que representan las coordenadas del punto.

    fun retornarCuadrante() = when { // Definición de la función 'retornarCuadrante', que no recibe parámetros y retorna un String.
        x > 0 && y > 0 -> "Primer cuadrante" // Si x es mayor que 0 y y es mayor que 0, el punto está en el primer cuadrante.
        x < 0 && y > 0 -> "Segundo cuadrante" // Si x es menor que 0 y y es mayor que 0, el punto está en el segundo cuadrante.
        x < 0 && y < 0 -> "Tercer cuadrante" // Si x es menor que 0 y y es menor que 0, el punto está en el tercer cuadrante.
        x > 0 && y < 0 -> "Cuarto cuadrante" // Si x es mayor que 0 y y es menor que 0, el punto está en el cuarto cuadrante.
        else -> "Un eje" // Si alguno de los valores (x o y) es cero, el punto está en un eje.
    }
}

fun main(parametro: Array<String>) { // Función principal 'main', que recibe un parámetro 'parametro' de tipo Array de String.
    val punto1 = Punto(12, 3) // Crea un objeto de tipo 'Punto' con coordenadas (12, 3).
    println("La coordenada ${punto1.x}, ${punto1.y} se encuentra en ${punto1.retornarCuadrante()}") // Llama a la función 'retornarCuadrante' para determinar el cuadrante de 'punto1'.
    val punto2 = Punto(-4, 3) // Crea un objeto de tipo 'Punto' con coordenadas (-4, 3).
    println("La coordenada ${punto2.x}, ${punto2.y} se encuentra en ${punto2.retornarCuadrante()}") // Llama a la función 'retornarCuadrante' para determinar el cuadrante de 'punto2'.
    val punto3 = Punto(-2, -2) // Crea un objeto de tipo 'Punto' con coordenadas (-2, -2).
    println("La coordenada ${punto3.x}, ${punto3.y} se encuentra en ${punto3.retornarCuadrante()}") // Llama a la función 'retornarCuadrante' para determinar el cuadrante de 'punto3'.
    val punto4 = Punto(12, -5) // Crea un objeto de tipo 'Punto' con coordenadas (12, -5).
    println("La coordenada ${punto4.x}, ${punto4.y} se encuentra en ${punto4.retornarCuadrante()}") // Llama a la función 'retornarCuadrante' para determinar el cuadrante de 'punto4'.
    val punto5 = Punto(0, -5) // Crea un objeto de tipo 'Punto' con coordenadas (0, -5).
    println("La coordenada ${punto5.x}, ${punto5.y} se encuentra en ${punto5.retornarCuadrante()}") // Llama a la función 'retornarCuadrante' para determinar el cuadrante de 'punto5'.
}