interface Puntoo {
    fun imprimir()
}
class PuntoPlano(val x: Int, val y: Int): Puntoo {
    override fun imprimir() {
        println("Punto en el plano: ($x,$y)")
    }
}
class PuntoEspacio(val x: Int, val y: Int, val z: Int): Puntoo {
    override fun imprimir() {
        println("Punto en el espacio: ($x,$y,$z)")
    }
}
fun main(parametro: Array<String>) {
    val puntoPlano1 = PuntoPlano(10, 4)
    puntoPlano1.imprimir()
    val puntoEspacio1 = PuntoEspacio(20, 50, 60)
    puntoEspacio1.imprimir()
}
