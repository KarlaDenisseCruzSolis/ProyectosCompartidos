// Enum que define varios países sudamericanos y sus cantidades de habitantes
enum class Paises (val habitantes: Int) {
    BRASIL (202450649), // Brasil con 202,450,649 habitantes
    COLOMBIA (50364000), // Colombia con 50,364,000 habitantes
    PERU (31151643), // Perú con 31,151,643 habitantes
    VENEZUELA (31028337), // Venezuela con 31,028,337 habitantes
    CHILE (18261884), // Chile con 18,261,884 habitantes
    ECUADOR (16298217), // Ecuador con 16,298,217 habitantes
    BOLIVIA (10888000), // Bolivia con 10,888,000 habitantes
    PARAGUAY (6460000), // Paraguay con 6,460,000 habitantes
    URUGUAY (3372000) // Uruguay con 3,372,000 habitantes
}

fun main(parametro: Array<String>) {
    // Creación de variables de tipo Paises y asignación de valores específicos
    val pais1 = Paises.BRASIL
    println(pais1) // Imprime la constante Brasil
    println(pais1.habitantes) // Imprime la cantidad de habitantes de Brasil

    val pais2 = Paises.COLOMBIA
    println(pais2) // Imprime la constante Colombia
    println(pais2.habitantes) // Imprime la cantidad de habitantes de Colombia

    val pais3 = Paises.PERU
    println(pais3) // Imprime la constante Perú
    println(pais3.habitantes) // Imprime la cantidad de habitantes de Perú

    val pais4 = Paises.VENEZUELA
    println(pais4) // Imprime la constante Venezuela
    println(pais4.habitantes) // Imprime la cantidad de habitantes de Venezuela

    val pais5 = Paises.CHILE
    println(pais5) // Imprime la constante Chile
    println(pais5.habitantes) // Imprime la cantidad de habitantes de Chile

    val pais6 = Paises.ECUADOR
    println(pais6) // Imprime la constante Ecuador
    println(pais6.habitantes) // Imprime la cantidad de habitantes de Ecuador

    val pais7 = Paises.BOLIVIA
    println(pais7) // Imprime la constante Bolivia
    println(pais7.habitantes) // Imprime la cantidad de habitantes de Bolivia

    val pais8 = Paises.PARAGUAY
    println(pais8) // Imprime la constante Paraguay
    println(pais8.habitantes) // Imprime la cantidad de habitantes de Paraguay

    val pais9 = Paises.URUGUAY
    println(pais9) // Imprime la constante Uruguay
    println(pais9.habitantes) // Imprime la cantidad de habitantes de Uruguay
}