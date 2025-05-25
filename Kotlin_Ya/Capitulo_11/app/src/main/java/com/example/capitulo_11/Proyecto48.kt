fun Proyecto48() {
    println("Proyecto 48: Suma y Promedio con ciclo for")
    var suma = 0
    for(i in 1..10) {
        print("Ingrese un valor:")
        val valor = readLine()!!.toInt()
        suma += valor
    }
    println("La suma de los valores ingresados es $suma")
    val promedio = suma / 10
    println("Su promedio es $promedio")
    println("")
}