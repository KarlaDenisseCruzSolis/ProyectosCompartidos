// Función que imprime un título subrayado con un carácter específico
fun tituloSubrayado(titulo: String, caracter: String = "*") {
    // Imprime el título recibido como parámetro
    println(titulo)

    // Bucle que imprime el carácter de subrayado tantas veces como la longitud del título
    for(i in 1..titulo.length)
        print(caracter)

    // Imprime un salto de línea para separar visualmente el título del siguiente contenido
    println()
}

// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {
    // Llama a la función 'tituloSubrayado' con el título "Sistema de Administración"
    // Como no se proporciona un segundo parámetro, usa el valor por defecto "*"
    tituloSubrayado("Sistema de Administracion")

    // Llama a la función 'tituloSubrayado' con el título "Ventas"
    // En este caso, el subrayado se hará con el carácter "-" en lugar de "*"
    tituloSubrayado("Ventas", "-")
}