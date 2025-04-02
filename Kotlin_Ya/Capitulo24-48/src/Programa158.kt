fun String.mitadPrimera(): String {
    return this.substring(0..this.length/2-1)
}
fun String.segundaMitad(): String{
    return this.substring(this.length/2..this.length-1)
}
fun main(args: Array<String>) {
    val cadena1 = "Viento"
    println(cadena1.mitadPrimera())
    println(cadena1.segundaMitad())
}