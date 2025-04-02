//PROBLEMA PROPUESTO PROGRAMA 191
package entradateclado

fun retornarInt(mensaje: String): Int {
    print(mensaje)
    return readln().toInt()
}

fun retornarDouble(mensaje: String): Double {
    print(mensaje)
    return readln().toDouble()
}

fun retornarFloat(mensaje: String): Float {
    print(mensaje)
    return readln().toFloat()
}