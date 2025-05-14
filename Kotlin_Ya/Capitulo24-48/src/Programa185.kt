data class Materia(val nombre: String, val nota: Int) // Definir la clase Materia con las propiedades nombre y nota

fun cargar(alumnos: MutableMap<Int, MutableList<Materia>>) {
    // Solicitar al usuario la cantidad de alumnos que se van a cargar
    print("Cuantos alumnos cargará ?:")
    val cant = readLine()!!.toInt() // Leer la cantidad de alumnos a cargar

    for(i in 1..cant) { // Bucle para cargar los alumnos
        // Solicitar el DNI del alumno
        print("Ingrese dni:")
        val dni = readLine()!!.toInt() // Leer el DNI del alumno

        val listaMaterias = mutableListOf<Materia>() // Crear una lista mutable para almacenar las materias del alumno

        do {
            // Solicitar el nombre de la materia
            print("Ingrese materia del alumno:")
            val nombre = readLine()!! // Leer el nombre de la materia
            // Solicitar la nota de la materia
            print("Ingrese nota:")
            val nota = readLine()!!.toInt() // Leer la nota de la materia

            // Agregar la materia a la lista de materias del alumno
            listaMaterias.add(Materia(nombre, nota))

            // Preguntar si se desea agregar otra materia
            print("Ingrese otra nota (si/no):")
            val opcion = readLine()!! // Leer la opción para agregar otra materia
        } while (opcion == "si") // Continuar si la respuesta es "si"

        // Almacenar la lista de materias del alumno en el mapa con su DNI como clave
        alumnos[dni] = listaMaterias
    }
}

fun imprimir(alumnos: MutableMap<Int, MutableList<Materia>>) {
    // Imprimir los datos de todos los alumnos
    for((dni, listaMaterias) in alumnos) { // Recorrer el mapa de alumnos
        println("Dni del alumno: $dni") // Imprimir el DNI del alumno

        // Imprimir las materias y notas del alumno
        for(materia in listaMaterias) {
            println("Materia: ${materia.nombre}") // Imprimir el nombre de la materia
            println("Nota: ${materia.nota}") // Imprimir la nota de la materia
        }
        println() // Línea en blanco para separar los registros de alumnos
    }
}

fun consultaPorDni(alumnos: MutableMap<Int, MutableList<Materia>>) {
    // Consultar las materias y notas de un alumno por su DNI
    print("Ingrese el dni del alumno a consultar:")
    val dni = readLine()!!.toInt() // Leer el DNI del alumno a consultar

    if (dni in alumnos) { // Verificar si el DNI existe en el mapa de alumnos
        println("Cursa las siguientes materias") // Imprimir mensaje de inicio de consulta
        val lista = alumnos[dni] // Obtener la lista de materias del alumno

        if (lista != null) // Verificar si la lista no es nula
        // Imprimir las materias y las notas del alumno
            for ((nombre, nota) in lista) {
                println("Nombre de materia: $nombre") // Imprimir el nombre de la materia
                println("Nota: $nota") // Imprimir la nota de la materia
            }
    }
}

fun main(args: Array<String>) {
    // Crear un mapa mutable de alumnos donde la clave es el DNI y el valor es una lista de materias
    val alumnos: MutableMap<Int, MutableList<Materia>> = mutableMapOf()

    // Llamar a la función cargar para ingresar los datos de los alumnos
    cargar(alumnos)

    // Llamar a la función imprimir para mostrar los datos de todos los alumnos
    imprimir(alumnos)

    // Llamar a la función consultaPorDni para consultar los datos de un alumno específico por su DNI
    consultaPorDni(alumnos)
}