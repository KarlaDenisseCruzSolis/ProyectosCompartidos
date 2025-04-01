//PROBLEMA PROPUESTO 180
/*Cargar por teclado y almacenar en una lista inmutable las alturas de 5 personas (valores Float)
Obtener el promedio de las mismas. Contar cuántas personas son más altas que el promedio y cuántas más bajas.*/
fun cargaaar(): Float {
    print("Ingrese la altura de la persona (Ej. 1.92):")
    val valor = readln().toFloat()
    return valor
}

fun main(args: Array<String>) {
    val lista1: List<Float> = List(5) {cargaaar()}
    val promedio = lista1.average()
    println("La altura promedio de las personas es $promedio")
    val altos = lista1.count { it > promedio}
    val bajos = lista1.count { it < promedio}
    println("La cantidad de personas más altas al promedio es: $altos")
    println("La cantidad de personas más bajas al promedio es: $bajos")
}
