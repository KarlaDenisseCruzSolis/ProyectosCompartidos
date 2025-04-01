//PROBLEMA PROPUESTO 145
/*Se tiene la declaración del siguiente data class:
            data class Articulo(val codigo: Int, val descripcion: String, var precio: Float)
Definir un Array con 4 elmentos de tipo Articulo. Implementar dos funciones, una que le enviemos el Array y nos muestre
todos sus componentes, y otra que también reciba el Array de artículos y proceda a aumentar en 10% a todos los productos.*/
data class Articuloo(val codigo: Int, val descripcion: String, var precio: Float)

fun imprimir(articulos: Array<Articuloo>) {
    for(articulo in articulos)
        println("Código: ${articulo.codigo} - Descripción ${articulo.descripcion} Precio: ${articulo.precio}")
}

fun aumentarPrecio(articulos: Array<Articuloo>) {
    for(articulo in articulos)
        articulo.precio = articulo.precio + (articulo.precio * 0.10f)
}

fun main(parametro: Array<String>) {
    val articulos: Array<Articuloo> = arrayOf(Articuloo(1, "papas", 7.5f),
        Articuloo(2, "manzanas", 23.2f),
        Articuloo(1, "naranjas", 12f),
        Articuloo(1, "cebolla", 21f))
    println("Listado de precios actual")
    imprimir(articulos)
    aumentarPrecio(articulos)
    println();
    println("Listado de precios con aumento del 10%")
    imprimir(articulos)
}
