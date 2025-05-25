fun Proyecto34() {
    println("Capitulo 34: Piezas aptas")
    print("Cuantas piezas procesará:")
    val n = readLine()!!.toInt()
    var x = 1
    var cantidad = 0
    while (x <= n) {
        print("Ingrese la medida de la pieza:")
        val largo = readLine()!!.toDouble()
        if (largo >= 1.20 && largo <= 1.30)
            cantidad = cantidad +1
        x = x + 1;
    }
    print("La cantidad de piezas aptas son: $cantidad")
}