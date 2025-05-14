// Clase base 'Persona6' con propiedades 'nombre' y 'edad', y un método 'imprimir' que muestra esos valores
open class Persona6(val nombre: String, val edad: Int) {
    // Metodo que imprime el nombre y la edad de la persona
    open fun imprimir() {
        println("Nombre: $nombre")
        println("Edad: $edad")
    }
}

// Clase 'Empleado4' que hereda de 'Persona6' y agrega la propiedad 'sueldo', con un método adicional 'pagaImpuestoss'
class Empleado4(nombre: String, edad: Int, val sueldo: Double): Persona6(nombre, edad) {
    // Sobrescribe el metodo 'imprimir' para incluir el sueldo además de los datos de la persona
    override fun imprimir() {
        super.imprimir()  // Llama al metodo 'imprimir' de la clase base 'Persona6'
        println("Sueldo: $sueldo")  // Imprime el sueldo del empleado
    }

    // Metodo que determina si el empleado paga impuestos según su sueldo
    fun pagaImpuestoss() {
        if (sueldo > 3000)  // Si el sueldo es mayor a 3000, el empleado paga impuestos
            println("El empleado $nombre paga impuestos")
        else  // Si el sueldo es menor o igual a 3000, el empleado no paga impuestos
            println("El empleado $nombre no paga impuestos")
    }
}

fun main(parametro: Array<String>) {
    // Creación de un objeto 'Persona6' con nombre "Jose" y edad 22
    val persona1 = Persona6("Jose", 22)
    println("Datos de la persona")
    persona1.imprimir()  // Llama al metodo 'imprimir' de 'Persona6'

    // Creación de un objeto 'Empleado4' con nombre "Ana", edad 30 y sueldo 5000.0
    val empleado1 = Empleado4("Ana", 30, 5000.0)
    println("Datos del empleado")
    empleado1.imprimir()  // Llama al metodo 'imprimir' de 'Empleado4', que sobrescribe el de 'Persona6'
    empleado1.pagaImpuestoss()  // Llama al metodo 'pagaImpuestoss' para determinar si paga impuestos
}