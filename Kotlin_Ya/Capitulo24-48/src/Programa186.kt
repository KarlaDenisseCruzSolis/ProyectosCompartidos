// Definir la clase Fecha con día, mes y año como atributos
data class Fecha(val dia: Int, val mes: Int, val año: Int)

// Función para cargar datos en la agenda
fun cargar(agenda: MutableMap<Fecha, String>) {
    do {
        // Solicitar al usuario la fecha y actividades para ese día
        println("Ingrese fecha")
        print("Ingrese el día:") // Solicitar el día
        val dia = readln().toInt() // Leer el día
        print("Ingrese el mes:") // Solicitar el mes
        val mes = readln().toInt() // Leer el mes
        print("Ingrese el año:") // Solicitar el año
        val año = readln().toInt() // Leer el año
        print("Ingrese todas las actividades para ese día:") // Solicitar las actividades del día
        val actividades = readln() // Leer las actividades del día

        // Almacenar las actividades en el mapa con la fecha como clave
        agenda[Fecha(dia, mes, año)] = actividades

        // Preguntar si desea agregar otra fecha
        print("Ingrese otra fecha (si/no):")
        val opcion = readln() // Leer la opción para continuar
    } while (opcion == "si") // Continuar si la respuesta es "si"
}

// Función para imprimir el listado completo de la agenda
fun imprimir(agenda: MutableMap<Fecha, String>) {
    // Recorrer todo el mapa de la agenda
    for((fecha, actividad) in agenda) {
        // Imprimir la fecha y las actividades asociadas a esa fecha
        println("Fecha ${fecha.dia}/${fecha.mes}/${fecha.año}") // Mostrar la fecha
        println("Actividades: $actividad") // Mostrar las actividades
        println() // Línea en blanco para separar los registros
    }
}

// Función para consultar las actividades de una fecha específica
fun consultaFecha(agenda: MutableMap<Fecha, String>) {
    // Solicitar al usuario la fecha para realizar la consulta
    println("Ingrese una fecha a consultar")
    print("Ingrese el día:") // Solicitar el día
    val dia = readln().toInt() // Leer el día
    print("Ingrese el mes:") // Solicitar el mes
    val mes = readln().toInt() // Leer el mes
    print("Ingrese el año:") // Solicitar el año
    val año = readln().toInt() // Leer el año

    // Crear una instancia de la clase Fecha con los datos ingresados
    val fecha = Fecha(dia, mes, año)

    // Consultar si la fecha está en la agenda y mostrar las actividades
    if (fecha in agenda) // Verificar si la fecha existe en el mapa
        println("Actividades: ${agenda[fecha]}") // Mostrar las actividades
    else
        println("No existen actividades registradas para dicha fecha") // Mensaje si la fecha no está en la agenda
}

// Función principal
fun main(args: Array<String>) {
    // Crear un mapa mutable para almacenar las fechas y actividades
    val agenda: MutableMap<Fecha, String> = mutableMapOf()

    // Llamar a la función cargar para ingresar las actividades
    cargar(agenda)

    // Llamar a la función imprimir para mostrar todas las actividades registradas
    imprimir(agenda)

    // Llamar a la función consultaFecha para permitir al usuario consultar actividades por fecha
    consultaFecha(agenda)
}