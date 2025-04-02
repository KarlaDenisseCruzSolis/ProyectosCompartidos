//PROBLEMA PROPUESTO 133
/*Definir un enum class almacenando como constante los nombres de varios países sudamericanos y como propiedad
para cada país la cantidad de habitantes que tiene. Definir una variable de este tipo e imprimir la constante
y la cantidad de habitantes de dicha variable.*/
enum class Paises (val habitantes: Int) {
    BRASIL (202450649),
    COLOMBIA (50364000),
    PERU (31151643),
    VENEZUELA (31028337),
    CHILE (18261884),
    ECUADOR (16298217),
    BOLIVIA (10888000),
    PARAGUAY (6460000),
    URUGUAY (3372000)
}

fun main(parametro: Array<String>) {
    val pais1 = Paises.BRASIL
    println(pais1)
    println(pais1.habitantes)
    val pais2 = Paises.COLOMBIA
    println(pais2)
    println(pais2.habitantes)
    val pais3 = Paises.PERU
    println(pais3)
    println(pais3.habitantes)
    val pais4 = Paises.VENEZUELA
    println(pais4)
    println(pais4.habitantes)
    val pais5 = Paises.CHILE
    println(pais5)
    println(pais5.habitantes)
    val pais6 = Paises.ECUADOR
    println(pais6)
    println(pais6.habitantes)
    val pais7 = Paises.BOLIVIA
    println(pais7)
    println(pais7.habitantes)
    val pais8 = Paises.PARAGUAY
    println(pais8)
    println(pais8.habitantes)
    val pais9 = Paises.URUGUAY
    println(pais9)
    println(pais9.habitantes)
}
