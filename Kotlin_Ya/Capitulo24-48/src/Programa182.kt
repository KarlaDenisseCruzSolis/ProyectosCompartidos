fun imprimir(productos: Map<String, Float>) {
    for((clave, valor) in productos)
        println("$clave tiene un precio $valor")
    println();
}
fun cantidadPrecioMayor20(productos: Map<String, Float>) {
    val cant = productos.count{ it.value > 20}
    println("Cantidad de productos con un precio superior a 20: $cant")
}
fun main(args: Array<String>) {
    val productos: Map<String, Float> = mapOf("papas" to 12.5f,
        "manzanas" to 26f,
        "peras" to 31f,
        "mandarinas" to 15f,
        "pomelos" to 28f)
    imprimir(productos)
    cantidadPrecioMayor20(productos)
}