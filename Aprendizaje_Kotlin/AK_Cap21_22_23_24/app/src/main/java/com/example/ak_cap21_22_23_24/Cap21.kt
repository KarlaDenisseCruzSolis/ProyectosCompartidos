package com.example.ak_cap21_22_23_24

fun main() {
    println("== Elementos de cuerda ==")
    elementosDeCuerda()

    println("\n== Cuerdas escapadas ==")
    cuerdasEscapadas()

    println("\n== Cuerdas sin formato ==")
    cuerdasSinFormato()

    println("\n== Plantillas de cuerda ==")
    plantillasDeCuerda()

    println("\n== Igualdad de cuerdas ==")
    igualdadDeCuerdas()
}

fun elementosDeCuerda() {
    val cuerda = "Hello, World!"
    println("cuerda[1] = ${cuerda[1]}") // Imprime: e

    for (c in cuerda) {
        println("Letra: $c")
    }
}

fun cuerdasEscapadas() {
    val saludo = "Hola, mundo!\nEsta es una nueva linea."
    println(saludo)

    val escapes = "Tabulacion:\tHecho\nRetroceso:\bFin\nComillas dobles: \"Texto entre comillas\"\nDolar escapado: \$precio"
    println(escapes)

    val unicode = "Simbolo Unicode: \u263A" // ☺
    println(unicode)
}

fun cuerdasSinFormato() {
    val texto = """
        for (c in "foo")
            print(c)
    """
    println(texto)

    val frase = """
        |Dimelo y lo olvidare.
        |Ensename y lo recordare.
        |Involucrame y aprendere.
        |(Benjamin Franklin)
    """.trimMargin()
    println(frase)

    val margenPersonalizado = """
        >Ejemplo con otro delimitador
        >usando trimMargin(">")
    """.trimMargin(">")
    println(margenPersonalizado)
}

fun plantillasDeCuerda() {
    val i = 10
    val plantillaSimple = "i = $i"
    println(plantillaSimple)

    val s = "abc"
    val plantillaCompleja = "$s.length es ${s.length}"
    println(plantillaCompleja)

    val dolarEscapado = "\$cuerda"
    println("Con escape de dolar: $dolarEscapado")

    val precio = """
        ${'$'}9.99
    """
    println("Precio literal sin escape: ${precio.trim()}")
}

fun igualdadDeCuerdas() {
    val cuerda1 = "Hello, World!"
    val cuerda2 = "Hello," + " World!"
    println("cuerda1 == cuerda2: ${cuerda1 == cuerda2}") // true

    val c1 = """
        |Hello, World!
    """.trimMargin()

    val c2 = """
        #Hello, World!
    """.trimMargin("#")

    val c3 = c1

    println("c1 == c2: ${c1 == c2}")   // true
    println("c1 === c2: ${c1 === c2}") // false
    println("c1 === c3: ${c1 === c3}") // true
}
