// Se define la interfaz 'Puntoo', que obliga a las clases que la implementen a definir el método 'imprimir'
interface Puntoo {
    // Metodo 'imprimir' que debe ser implementado en las clases que implementen la interfaz
    fun imprimir()
}

// Clase 'PuntoPlano' que implementa la interfaz 'Puntoo' y representa un punto en el plano 2D
class PuntoPlano(val x: Int, val y: Int): Puntoo {
    // Implementación del metodo 'imprimir' para mostrar las coordenadas de un punto en el plano
    override fun imprimir() {
        println("Punto en el plano: ($x,$y)")  // Muestra las coordenadas del punto en el plano 2D
    }
}

// Clase 'PuntoEspacio' que implementa la interfaz 'Puntoo' y representa un punto en el espacio 3D
class PuntoEspacio(val x: Int, val y: Int, val z: Int): Puntoo {
    // Implementación del metodo 'imprimir' para mostrar las coordenadas de un punto en el espacio 3D
    override fun imprimir() {
        println("Punto en el espacio: ($x,$y,$z)")  // Muestra las coordenadas del punto en el espacio 3D
    }
}

// Función 'main', punto de entrada del programa
fun main(parametro: Array<String>) {
    // Crea un objeto 'puntoPlano1' de la clase 'PuntoPlano' con las coordenadas (10, 4)
    val puntoPlano1 = PuntoPlano(10, 4)
    puntoPlano1.imprimir()  // Llama al metodo 'imprimir' para mostrar las coordenadas del punto en el plano

    // Crea un objeto 'puntoEspacio1' de la clase 'PuntoEspacio' con las coordenadas (20, 50, 60)
    val puntoEspacio1 = PuntoEspacio(20, 50, 60)
    puntoEspacio1.imprimir()  // Llama al metodo 'imprimir' para mostrar las coordenadas del punto en el espacio
}