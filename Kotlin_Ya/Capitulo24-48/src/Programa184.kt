data class Producto(val nombre: String, val precio: Float, val cantidad: Int)

fun cargar(productos: MutableMap<Int, Producto>) {
    // Cargar productos en el mapa con clave de código (Int) y valor Producto
    productos[1] = Producto("Papas", 13.15f, 200) // Producto con código 1
    productos[15] = Producto("Manzanas", 20f, 0)  // Producto con código 15, sin stock
    productos[20] = Producto("Peras", 3.50f, 0)   // Producto con código 20, sin stock
}

fun listadoCompleto(productos: MutableMap<Int, Producto>) {
    // Imprimir el listado completo de productos
    println("Listado completo de productos")
    for ((codigo, producto) in productos) // Recorrer cada entrada en el mapa
    // Imprimir detalles de cada producto (código, nombre, precio y cantidad en stock)
        println("Código: $codigo Descripción ${producto.nombre} Precio: ${producto.precio} Stock Actual: ${producto.cantidad}")
    println() // Imprimir una línea vacía para separar el listado
}

fun consultaProducto(productos: MutableMap<Int, Producto>) {
    // Solicitar al usuario el código de un producto para consultar sus detalles
    print("Ingrese el código de un producto:")
    val codigo = readLine()!!.toInt() // Leer el código ingresado por el usuario y convertirlo a entero
    if (codigo in productos) // Verificar si el código existe en el mapa
    // Imprimir los detalles del producto si existe
        println("Nombre: ${productos[codigo]?.nombre} Precio: ${productos[codigo]?.precio} Stock: ${productos[codigo]?.cantidad}")
    else
    // Si el código no existe, informar al usuario
        println("No existe un producto con dicho código")
}

fun sinStock(productos: MutableMap<Int, Producto>) {
    // Contar cuántos productos tienen cantidad igual a 0 (sin stock)
    val cant = productos.count { it.value.cantidad == 0 }
    // Imprimir la cantidad de productos sin stock
    println("Cantidad de artículos sin stock: $cant")
}

fun main(args: Array<String>) {
    // Crear un mapa mutable para almacenar los productos con código como clave y Producto como valor
    val productos: MutableMap<Int, Producto> = mutableMapOf()

    // Llamar a la función cargar para cargar productos en el mapa
    cargar(productos)

    // Llamar a la función listadoCompleto para mostrar todos los productos almacenados
    listadoCompleto(productos)

    // Llamar a la función consultaProducto para permitir que el usuario consulte un producto por su código
    consultaProducto(productos)

    // Llamar a la función sinStock para contar cuántos productos están sin stock
    sinStock(productos)
}