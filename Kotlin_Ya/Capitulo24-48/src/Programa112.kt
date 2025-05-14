//ORIGINAL
class Persona2 constructor(nombre: String, edad: Int) { // Definición de la clase 'Persona2' con un constructor que recibe dos parámetros: 'nombre' y 'edad'.
    var nombre: String = nombre // Inicializa la propiedad 'nombre' con el valor recibido del constructor.
    var edad: Int = edad // Inicializa la propiedad 'edad' con el valor recibido del constructor.
    fun imprimir() { // Definición de la función 'imprimir', que no recibe parámetros.
        println("Nombre: $nombre y tiene una edad de $edad") // Imprime el nombre y la edad de la persona.
    }
    fun esMayorEdad() { // Definición de la función 'esMayorEdad', que no recibe parámetros.
        if (edad >= 18) // Verifica si la persona es mayor o igual a 18 años.
            println("Es mayor de edad $nombre") // Si la persona es mayor de edad, imprime el mensaje.
        else
            println("No es mayor de edad $nombre") // Si la persona no es mayor de edad, imprime el mensaje.
    }
}
fun main(parametro: Array<String>) { // Función principal 'main', que recibe un parámetro 'parametro' de tipo Array de String.
    val persona1 = Persona2("Juan", 12) // Crea un objeto de tipo 'Persona2' con nombre "Juan" y edad 12.
    persona1.imprimir() // Llama a la función 'imprimir' del objeto persona1 para mostrar su información.
    persona1.esMayorEdad() // Llama a la función 'esMayorEdad' del objeto persona1 para verificar si es mayor de edad.
}

//ACOTACION 1
/*class Persona2 (var nombre: String, var edad: Int) { // Versión más compacta de la clase 'Persona2' utilizando propiedades directamente en el constructor.
    fun imprimir() { // Definición de la función 'imprimir', que no recibe parámetros.
        println("Nombre: $nombre y tiene una edad de $edad") // Imprime el nombre y la edad de la persona.
    }
    fun esMayorEdad() { // Definición de la función 'esMayorEdad', que no recibe parámetros.
        if (edad >= 18) // Verifica si la persona es mayor o igual a 18 años.
            println("Es mayor de edad $nombre") // Si la persona es mayor de edad, imprime el mensaje.
        else
            println("No es mayor de edad $nombre") // Si la persona no es mayor de edad, imprime el mensaje.
    }
}
fun main(parametro: Array<String>) { // Función principal 'main', que recibe un parámetro 'parametro' de tipo Array de String.
    val persona1 = Persona2("Juan", 12) // Crea un objeto de tipo 'Persona2' con nombre "Juan" y edad 12.
    persona1.imprimir() // Llama a la función 'imprimir' del objeto persona1 para mostrar su información.
    persona1.esMayorEdad() // Llama a la función 'esMayorEdad' del objeto persona1 para verificar si es mayor de edad.
}*/

//ACOTACION 2
/*class Persona2 (var nombre: String, var edad: Int) { // La clase 'Persona2' ahora incluye una validación para la edad en el bloque 'init'.
    init { // Bloque 'init' que se ejecuta cuando se crea una instancia de la clase.
        if (edad < 0) // Verifica si la edad es menor que 0.
            edad = 0 // Si la edad es negativa, la establece a 0.
    }
    fun imprimir() { // Definición de la función 'imprimir', que no recibe parámetros.
        println("Nombre: $nombre y tiene una edad de $edad") // Imprime el nombre y la edad de la persona, con la validación aplicada.
    }
    fun esMayorEdad() { // Definición de la función 'esMayorEdad', que no recibe parámetros.
        if (edad >= 18) // Verifica si la persona es mayor o igual a 18 años.
            println("Es mayor de edad $nombre") // Si la persona es mayor de edad, imprime el mensaje.
        else
            println("No es mayor de edad $nombre") // Si la persona no es mayor de edad, imprime el mensaje.
    }
}
fun main(parametro: Array<String>) { // Función principal 'main', que recibe un parámetro 'parametro' de tipo Array de String.
    val persona1 = Persona2("Juan", -12) // Crea un objeto de tipo 'Persona2' con nombre "Juan" y una edad negativa (-12), que será corregida por el bloque 'init'.
    persona1.imprimir() // Llama a la función 'imprimir' del objeto persona1 para mostrar su información.
    persona1.esMayorEdad() // Llama a la función 'esMayorEdad' del objeto persona1 para verificar si es mayor de edad.
}*/