fun imprimir(productos: Map<String, Float>) {
    // Recorrer el mapa de productos e imprimir cada clave (producto) con su valor (precio)
    for((clave, valor) in productos)
        println("$clave tiene un precio $valor")
    println() // Imprimir una línea vacía al final
}

fun cantidadPrecioMayor20(productos: Map<String, Float>) {
    // Contar la cantidad de productos cuyo precio es mayor a 20
    val cant = productos.count{ it.value > 20}
    println("Cantidad de productos con un precio superior a 20: $cant")
}

fun main(args: Array<String>) {
    // Crear un mapa de productos con su nombre como clave y el precio como valor
    val productos: Map<String, Float> = mapOf("papas" to 12.5f,
        "manzanas" to 26f,
        "peras" to 31f,
        "mandarinas" to 15f,
        "pomelos" to 28f)

    // Llamar a la función imprimir para mostrar los productos y sus precios
    imprimir(productos)

    // Llamar a la función cantidadPrecioMayor20 para contar los productos con precio mayor a 20
    cantidadPrecioMayor20(productos)
}