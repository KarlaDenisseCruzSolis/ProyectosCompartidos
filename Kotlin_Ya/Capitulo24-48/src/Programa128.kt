// Definición de la clase de datos Articulo con tres propiedades: codigo, descripcion y precio.
data class Articulo(var codigo: Int, var descripcion: String, var precio: Float)

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el programa.

    val articulo1 = Articulo(1, "papas", 34f) // Crea un objeto 'articulo1' con código 1, descripción "papas" y precio 34.
    var articulo2 = Articulo(2, "manzanas", 24f) // Crea un objeto 'articulo2' con código 2, descripción "manzanas" y precio 24.
    println(articulo1) // Imprime el objeto 'articulo1', mostrando sus propiedades.
    println(articulo2) // Imprime el objeto 'articulo2', mostrando sus propiedades.

    val puntero = articulo1 // Asigna 'articulo1' a una nueva variable 'puntero'. Ahora ambas referencias apuntan al mismo objeto.
    puntero.precio = 100f // Cambia el precio de 'puntero', lo que también afecta a 'articulo1' debido a que ambas referencias apuntan al mismo objeto.
    println(articulo1) // Imprime 'articulo1', mostrando el precio modificado a 100.

    var articulo3 = articulo1.copy() // Crea una copia del objeto 'articulo1' en 'articulo3'. Los objetos son independientes.
    articulo1.precio = 200f // Cambia el precio de 'articulo1' a 200, sin afectar a 'articulo3'.
    println(articulo1) // Imprime 'articulo1' con el precio actualizado a 200.
    println(articulo3) // Imprime 'articulo3', mostrando el precio original de 'articulo1' (100).

    // Compara 'articulo1' y 'articulo3' para ver si son iguales.
    if (articulo1 == articulo3)
        println("Son iguales $articulo1 y $articulo3") // Si son iguales, muestra el mensaje correspondiente.
    else
        println("Son distintos $articulo1 y $articulo3") // Si son distintos, muestra el mensaje correspondiente.

    articulo3.precio = 200f // Cambia el precio de 'articulo3' a 200.
    // Compara nuevamente 'articulo1' y 'articulo3' para ver si ahora son iguales.
    if (articulo1 == articulo3)
        println("Son iguales $articulo1 y $articulo3") // Si ahora son iguales, muestra el mensaje correspondiente.
    else
        println("Son distintos $articulo1 y $articulo3") // Si siguen siendo distintos, muestra el mensaje correspondiente.
}