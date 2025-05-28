fun Proyecto32() {
    println("Capitulo 32: Del 1 hasta donde tu quieras")
    print("Ingrese un valor:")
    val valor = readLine()!!.toInt()
    var x = 1
    while (x <= valor) {
        println(x)
        x = x + 1
    }
}