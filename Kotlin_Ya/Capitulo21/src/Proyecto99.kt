// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {

    // Declaración e inicialización de un arreglo de tipo Float con 5 elementos
    val alturas = FloatArray(5)

    // Variable para almacenar la suma de todas las alturas ingresadas
    var suma = 0f

    // Bucle para ingresar las alturas y calcular la suma total
    for(i in 0..alturas.size-1) {
        // Solicita al usuario ingresar una altura
        print("Ingrese la altura:")

        // Lee el valor ingresado, lo convierte a Float y lo almacena en el arreglo
        alturas[i] = readLine()!!.toFloat()

        // Acumula la altura ingresada en la variable 'suma'
        suma += alturas[i]
    }

    // Calcula el promedio dividiendo la suma total entre la cantidad de elementos en el arreglo
    val promedio = suma / alturas.size

    // Imprime la altura promedio calculada
    println("Altura promedio: $promedio")

    // Variables para contar cuántas alturas están por encima o por debajo del promedio
    var altos = 0
    var bajos = 0

    // Bucle para comparar cada altura con el promedio
    for(i in 0..alturas.size-1)
    // Si la altura es mayor al promedio, incrementa el contador de personas altas
        if (alturas[i] > promedio)
            altos++
        // Si la altura es menor o igual al promedio, incrementa el contador de personas bajas
        else
            bajos++

    // Imprime la cantidad de personas con altura mayor al promedio
    println("Cantidad de personas más altas que el promedio: $altos")

    // Imprime la cantidad de personas con altura menor o igual al promedio
    println("Cantidad de personas más bajas que el promedio: $bajos")
}
