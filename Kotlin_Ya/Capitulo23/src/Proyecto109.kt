// Definición de la clase Persona
class Persona {
    // Atributo 'nombre' de tipo String, inicializado como una cadena vacía
    var nombre: String = ""

    // Atributo 'edad' de tipo Int, inicializado en 0
    var edad: Int = 0

    // Metodo para inicializar los valores de la persona
    fun inicializar(nombre: String, edad: Int) {
        // Asigna los valores recibidos a los atributos de la clase usando 'this'
        this.nombre = nombre
        this.edad = edad
    }

    // Metodo para imprimir los datos de la persona
    fun imprimir() {
        // Imprime el nombre y la edad de la persona
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    // Metodo para verificar si la persona es mayor de edad
    fun esMayorEdad() {
        if (edad >= 18)
            println("Es mayor de edad $nombre")  // Si la edad es 18 o más, es mayor de edad
        else
            println("No es mayor de edad $nombre")  // Si no, es menor de edad
    }
}

// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {

    // Declaración de una variable de tipo Persona
    val persona1: Persona

    // Creación de un objeto de la clase Persona
    persona1 = Persona()

    // Se inicializan los datos de persona1 con nombre "Juan" y edad 12
    persona1.inicializar("Juan", 12)

    // Se imprimen los datos de persona1
    persona1.imprimir()

    // Se verifica si persona1 es mayor de edad
    persona1.esMayorEdad()

    // Declaración de otra variable de tipo Persona
    val persona2: Persona

    // Creación de otro objeto de la clase Persona
    persona2 = Persona()

    // Se inicializan los datos de persona2 con nombre "Ana" y edad 50
    persona2.inicializar("Ana", 50)

    // Se imprimen los datos de persona2
    persona2.imprimir()

    // Se verifica si persona2 es mayor de edad
    persona2.esMayorEdad()
}
