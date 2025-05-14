//PROBLEMA PROPUESTO 180
/*Cargar por teclado y almacenar en una lista inmutable las alturas de 5 personas (valores Float)
Obtener el promedio de las mismas. Contar cuántas personas son más altas que el promedio y cuántas más bajas.*/

// Función para cargar la altura de una persona desde el teclado
fun cargaaar(): Float {
    print("Ingrese la altura de la persona (Ej. 1.92):")
    // Leer la altura como un valor de tipo Float
    val valor = readln().toFloat()
    return valor
}

fun main(args: Array<String>) {
    // Crear una lista inmutable de 5 elementos, cargados con las alturas de 5 personas
    val lista1: List<Float> = List(5) {cargaaar()}

    // Calcular el promedio de las alturas de las personas
    val promedio = lista1.average()
    println("La altura promedio de las personas es $promedio")

    // Contar cuántas personas son más altas que el promedio
    val altos = lista1.count { it > promedio}

    // Contar cuántas personas son más bajas que el promedio
    val bajos = lista1.count { it < promedio}

    // Mostrar la cantidad de personas más altas que el promedio
    println("La cantidad de personas más altas al promedio es: $altos")

    // Mostrar la cantidad de personas más bajas que el promedio
    println("La cantidad de personas más bajas al promedio es: $bajos")
}