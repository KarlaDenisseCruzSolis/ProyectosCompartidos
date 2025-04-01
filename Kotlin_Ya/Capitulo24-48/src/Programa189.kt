//PROBLEMA PROPUESTO 189
/*Definir un MutableSet y almacenar 6 valores aleatorios comprendidos entre 1 y 50. El objeto de tipo MutableSet representa
un cartón de lotería. Comenzar a generar valores aleatorios (comprendidos entre 1 y 5) todos distintos y detenerse cuando
salgan todos los que contiene el cartón de lotería. Mostrar cuantos números tuvieron que sortearse hasta que se completó el cartón.*/
fun generarCarton(carton: MutableSet<Int>) {
    do {
        val valor = ((Math.random() * 50) + 1).toInt()
        carton.add(valor)
    } while (carton.size!=6)
}

fun generarBolillero(bolillero: MutableSet<Int>) {
    do {
        val valor = ((Math.random() * 50) + 1).toInt()
        bolillero.add(valor)
    } while (bolillero.size!=50)
}

fun verificarTriunfo(carton: MutableSet<Int>, bolillero: MutableSet<Int>) {
    var aciertos = 0
    var cantBolillas = 0
    var intentos = 0
    for(bolilla in bolillero) {
        cantBolillas++
        if (bolilla in carton) {
            aciertos++
            if (aciertos == 6) {
                intentos = cantBolillas
                break
            }
        }
    }
    println("Se sacaron $intentos bolillas hasta que el cartón ganó.")
}

fun main(args: Array<String>) {
    val carton: MutableSet<Int> = mutableSetOf()
    generarCarton(carton)
    println("Carton de lotería generado")
    println(carton)
    val bolillero: MutableSet<Int> = mutableSetOf()
    generarBolillero(bolillero)
    println("Numeros del bolillero")
    println(bolillero)
    verificarTriunfo(carton, bolillero)
}