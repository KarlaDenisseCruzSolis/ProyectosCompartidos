import java.util.* // Importa la clase 'Locale' para manejar la conversión de texto a mayúsculas en diferentes locales.

class Persona3 { // Clase 'Persona3' que define las propiedades 'nombre' y 'edad' con sus respectivos setters y getters personalizados.
    var nombre: String = "" // Propiedad 'nombre' de tipo String, inicializada vacía.
        set(valor) { // Setter personalizado para la propiedad 'nombre'.
            field = valor.uppercase(Locale.getDefault()) // Asigna el valor convertido a mayúsculas al campo de respaldo.
        }
        get() { // Getter personalizado para la propiedad 'nombre'.
            return "(" + field + ")" // Devuelve el valor del 'nombre' con paréntesis alrededor.
        }

    var edad: Int = 0 // Propiedad 'edad' de tipo Int, inicializada en 0.
        set(valor) { // Setter personalizado para la propiedad 'edad'.
            if (valor >= 0) // Si el valor es mayor o igual a 0,
                field = valor // Asigna el valor a la propiedad 'edad'.
            else
                field = 0 // Si el valor es negativo, asigna 0.
        }
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el programa.
    val persona1 = Persona3() // Crea un objeto 'persona1' de la clase 'Persona3'.
    persona1.nombre = "juan" // Asigna el valor "juan" a la propiedad 'nombre', que se convertirá a "JUAN".
    persona1.edad = 23 // Asigna el valor 23 a la propiedad 'edad'.
    println(persona1.nombre) // Se imprime: (JUAN), ya que el getter devuelve el nombre con paréntesis.
    println(persona1.edad) // Se imprime: 23, ya que la propiedad 'edad' fue asignada correctamente.
    persona1.edad = -50 // Intenta asignar un valor negativo a 'edad', pero el setter asignará 0.
    println(persona1.edad) // Se imprime: 0, ya que el valor negativo fue corregido por el setter.
}