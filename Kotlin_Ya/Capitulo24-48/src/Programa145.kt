//PROBLEMA PROPUESTO 145
/*Se tiene la declaración del siguiente data class:
            data class Articulo(val codigo: Int, val descripcion: String, var precio: Float)
Definir un Array con 4 elmentos de tipo Articulo. Implementar dos funciones, una que le enviemos el Array y nos muestre
todos sus componentes, y otra que también reciba el Array de artículos y proceda a aumentar en 10% a todos los productos.*/

data class Articuloo(val codigo: Int, val descripcion: String, var precio: Float)
// COMENTARIO: Se define un data class llamado Articuloo con tres propiedades: código, descripción y precio.

// COMENTARIO: Función que recibe un array de artículos y muestra sus atributos.
fun imprimir(articulos: Array<Articuloo>) {
    for(articulo in articulos)
        println("Código: ${articulo.codigo} - Descripción ${articulo.descripcion} Precio: ${articulo.precio}")
}

// COMENTARIO: Función que aumenta en un 10% el precio de cada artículo del array.
fun aumentarPrecio(articulos: Array<Articuloo>) {
    for(articulo in articulos)
        articulo.precio = articulo.precio + (articulo.precio * 0.10f)
}

fun main(parametro: Array<String>) {
    val articulos: Array<Articuloo> = arrayOf(
        Articuloo(1, "papas", 7.5f),
        Articuloo(2, "manzanas", 23.2f),
        Articuloo(1, "naranjas", 12f),
        Articuloo(1, "cebolla", 21f)
    )
    // COMENTARIO: Se crea un array de 4 artículos con su código, descripción y precio.

    println("Listado de precios actual")
    // COMENTARIO: Muestra mensaje previo al listado original.

    imprimir(articulos)
    // COMENTARIO: Llama a la función para imprimir los artículos antes del aumento.

    aumentarPrecio(articulos)
    // COMENTARIO: Aplica el aumento del 10% a cada artículo.

    println();
    // COMENTARIO: Línea vacía para separación visual.

    println("Listado de precios con aumento del 10%")
    // COMENTARIO: Muestra mensaje previo al nuevo listado con precios actualizados.

    imprimir(articulos)
    // COMENTARIO: Llama a la función para imprimir los artículos con el precio aumentado.
}