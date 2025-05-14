//PROBLEMA PROPUESTO 189
/*Definir un MutableSet y almacenar 6 valores aleatorios comprendidos entre 1 y 50. El objeto de tipo MutableSet representa
un cartón de lotería. Comenzar a generar valores aleatorios (comprendidos entre 1 y 5) todos distintos y detenerse cuando
salgan todos los que contiene el cartón de lotería. Mostrar cuantos números tuvieron que sortearse hasta que se completó el cartón.*/

fun generarCarton(carton: MutableSet<Int>) {
    // Continuar generando números aleatorios entre 1 y 50 hasta que se tengan 6 números únicos en el cartón
    do {
        // Generar un valor aleatorio entre 1 y 50
        val valor = ((Math.random() * 50) + 1).toInt()
        // Agregar el valor al cartón si no está ya presente
        carton.add(valor)
    } while (carton.size != 6)  // El bucle continúa hasta que el cartón tenga 6 valores únicos
}

fun generarBolillero(bolillero: MutableSet<Int>) {
    // Generar un conjunto de 50 valores únicos entre 1 y 50 para el bolillero
    do {
        // Generar un valor aleatorio entre 1 y 50
        val valor = ((Math.random() * 50) + 1).toInt()
        // Agregar el valor al bolillero si no está ya presente
        bolillero.add(valor)
    } while (bolillero.size != 50)  // El bucle continúa hasta que el bolillero tenga 50 números únicos
}

fun verificarTriunfo(carton: MutableSet<Int>, bolillero: MutableSet<Int>) {
    var aciertos = 0  // Contador de aciertos
    var cantBolillas = 0  // Contador de bolillas sorteadas
    var intentos = 0  // Contador de intentos (bolillas sorteadas hasta que el cartón gana)

    // Recorrer las bolillas del bolillero
    for (bolilla in bolillero) {
        cantBolillas++  // Incrementar el contador de bolillas sorteadas
        // Verificar si la bolilla está en el cartón
        if (bolilla in carton) {
            aciertos++  // Incrementar el contador de aciertos
            // Si se han acertado las 6 bolillas, registrar los intentos y salir del bucle
            if (aciertos == 6) {
                intentos = cantBolillas
                break
            }
        }
    }
    // Imprimir cuántas bolillas fueron necesarias para completar el cartón
    println("Se sacaron $intentos bolillas hasta que el cartón ganó.")
}

fun main(args: Array<String>) {
    // Crear un MutableSet para el cartón de lotería
    val carton: MutableSet<Int> = mutableSetOf()
    // Generar un cartón con 6 números aleatorios
    generarCarton(carton)
    println("Carton de lotería generado")
    println(carton)  // Imprimir el cartón generado

    // Crear un MutableSet para el bolillero
    val bolillero: MutableSet<Int> = mutableSetOf()
    // Generar el bolillero con 50 números aleatorios
    generarBolillero(bolillero)
    println("Numeros del bolillero")
    println(bolillero)  // Imprimir los números del bolillero

    // Verificar cuántos intentos fueron necesarios para completar el cartón
    verificarTriunfo(carton, bolillero)
}