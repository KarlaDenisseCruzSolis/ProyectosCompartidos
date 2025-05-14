fun main(args: Array<String>) {
    // Crear un conjunto mutable de enteros con algunos elementos iniciales
    val conjunto1: MutableSet<Int> = mutableSetOf(2, 7, 20, 150, 3)

    // Imprimir el listado completo del conjunto
    println("Listado completo del conjunto")
    for(elemento in conjunto1)  // Recorrer cada elemento del conjunto
        print("$elemento ")  // Imprimir el elemento
    println()  // Línea en blanco después del listado

    // Imprimir la cantidad de elementos en el conjunto
    println("Cantidad de elementos del conjunto: ${conjunto1.size}")

    // Agregar el número 500 al conjunto
    conjunto1.add(500)
    println("Listado completo del conjunto luego de agregar el 500")
    for(elemento in conjunto1)  // Recorrer y mostrar los elementos del conjunto actualizado
        print("$elemento ")  // Imprimir cada elemento
    println()  // Línea en blanco después del listado

    // Intentar agregar nuevamente el número 500 al conjunto
    conjunto1.add(500)
    println("Listado completo del conjunto luego de volver a agregar el 500")
    for(elemento in conjunto1)  // Recorrer y mostrar los elementos del conjunto actualizado
        print("$elemento ")  // Imprimir cada elemento
    println()  // Línea en blanco después del listado

    // Verificar si el número 500 está en el conjunto
    if (500 in conjunto1)
        println("El 500 está almacenado en el conjunto")  // Si está en el conjunto, imprimir mensaje
    else
        println("El 500 no está almacenado en el conjunto")  // Si no está, imprimir mensaje

    // Eliminar el número 500 del conjunto
    println("Eliminamos el elemento 500 del conjunto")
    conjunto1.remove(500)

    // Verificar nuevamente si el número 500 está en el conjunto después de eliminarlo
    if (500 in conjunto1)
        println("El 500 está almacenado en el conjunto")  // Si sigue presente, mostrar mensaje
    else
        println("El 500 no está almacenado en el conjunto")  // Si fue eliminado, mostrar mensaje

    // Contar la cantidad de elementos en el conjunto que son mayores o iguales a 10
    val cant = conjunto1.count { it >= 10 }
    println("Cantidad de elementos con valores superiores o igual a 10: $cant")
}