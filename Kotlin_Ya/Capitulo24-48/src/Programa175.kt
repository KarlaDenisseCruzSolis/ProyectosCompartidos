fun main(args: Array<String>) {
    // Crea una lista mutable de edades
    val edades: MutableList<Int> = mutableListOf(23, 67, 12, 35, 12)

    // Imprime la lista original de edades
    println("Lista de edades")
    println(edades)

    // Modifica el primer elemento de la lista
    edades[0] = 60
    println("Lista completa después de modificar la primer edad")
    println(edades)

    // Imprime el primer elemento de la lista
    println("Primera edad almacenada en la lista")
    println(edades[0])

    // Calcula e imprime el promedio de edades
    println("Promedio de edades")
    println(edades.average())

    // Agrega una edad al final de la lista
    println("Agregamos una edad al final de la lista:")
    edades.add(50)
    println("Lista de edades")
    println(edades)

    // Agrega una edad al principio de la lista
    println("Agregamos una edad al principio de la lista:")
    edades.add(0, 17)
    println("Lista de edades")
    println(edades)

    // Elimina el primer elemento de la lista
    println("Eliminamos la primer edad de la lista:")
    edades.removeAt(0)
    println("Lista de edades")
    println(edades)

    // Cuenta cuántas personas son mayores de edad (mayores o iguales a 18)
    print("Cantidad de personas mayores de edad:")
    val cant = edades.count { it >= 18 }
    println(cant)

    // Elimina todas las edades que sean iguales a 12
    edades.removeAll { it == 12 }
    println("Lista de edades después de borrar las que tienen 12 años")
    println(edades)

    // Limpia completamente la lista
    edades.clear()
    println("Lista de edades luego de borrar la lista en forma completa")
    println(edades)

    // Verifica si la lista está vacía
    if (edades.isEmpty())
        println("No hay edades almacenadas en la lista")
}