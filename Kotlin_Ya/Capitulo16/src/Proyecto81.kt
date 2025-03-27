
// Definimos una función llamada 'largo' que recibe un parámetro de tipo String
// y devuelve la cantidad de caracteres que tiene dicho String.
fun largo(nombre: String): Int {
    return nombre.length  // Utilizamos la propiedad 'length' de String para obtener la cantidad de caracteres.
}

fun main(parametro: Array<String>) {
    // Solicitar al usuario que ingrese el primer nombre.
    print("Ingrese un nombre:")
    val nombre1 = readLine()!!  // Leemos la entrada del usuario y la almacenamos en la variable 'nombre1'

    // Solicitar al usuario que ingrese el segundo nombre.
    print("Ingrese otro nombre:")
    val nombre2 = readLine()!!  // Leemos la entrada del usuario y la almacenamos en la variable 'nombre2'

    // Comparamos la longitud de ambos nombres usando la función 'largo'
    if (largo(nombre1) == largo(nombre2))  // Si los nombres tienen la misma cantidad de caracteres
        print("Los nombres: $nombre1 y $nombre2 tienen la misma cantidad de caracteres")
    else  // Si no tienen la misma cantidad de caracteres
        if (largo(nombre1) > largo(nombre2))  // Si 'nombre1' tiene más caracteres que 'nombre2'
            print("$nombre1 es más largo")  // Imprimimos que 'nombre1' es más largo
        else  // Si 'nombre2' tiene más caracteres que 'nombre1'
            print("$nombre2 es más largo")  // Imprimimos que 'nombre2' es más largo
}
