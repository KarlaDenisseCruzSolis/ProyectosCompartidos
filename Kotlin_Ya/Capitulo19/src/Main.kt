// Función que calcula el sueldo de un empleado basado en su nombre, costo por hora y cantidad de horas trabajadas
fun calcularSueldo(nombre: String, costoHora: Double, cantidadHoras: Int) {
    // Calcula el sueldo multiplicando el costo por hora por la cantidad de horas trabajadas
    val sueldo = costoHora * cantidadHoras

    // Imprime el resultado con los datos del empleado y el sueldo calculado
    println("$nombre trabajó $cantidadHoras horas, se le paga por hora $costoHora por lo tanto le corresponde un sueldo de $sueldo")
}

// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {
    // Llama a la función 'calcularSueldo' con los valores:
    // Nombre: "juan", Costo por hora: 10.5, Horas trabajadas: 120
    calcularSueldo("juan", 10.5, 120)

    // Llama a la función 'calcularSueldo' utilizando argumentos nombrados:
    // Nombre: "ana", Costo por hora: 12.0, Horas trabajadas: 40
    calcularSueldo(costoHora = 12.0, cantidadHoras = 40, nombre = "ana")

    // Llama a la función 'calcularSueldo' utilizando argumentos nombrados en otro orden:
    // Nombre: "luis", Costo por hora: 7.25, Horas trabajadas: 90
    calcularSueldo(cantidadHoras = 90, nombre = "luis", costoHora = 7.25)
}