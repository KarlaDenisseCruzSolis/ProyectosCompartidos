fun Proyecto18() {
    println("Capitulo 18: Promedio sentencia")
    print("Ingrese primer nota:")
    val nota1 = readLine()!!.toInt()
    print("Ingrese segunda nota:")
    val nota2 = readLine()!!.toInt()
    print("Ingrese tercer nota:")
    val nota3 = readLine()!!.toInt()
    val promedio = (nota1 + nota2 + nota3) / 3
    val estado = if (promedio >= 7) "Promocionado"
    else if (promedio >= 4) "Regular"
    else "Libre"
    print("Estado del alumno $estado")
}