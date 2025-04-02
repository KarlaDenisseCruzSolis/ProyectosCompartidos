fun IntArray.imprimir() {
    print("[")
    for(elemento in this) {
        print("$elemento ")
    }
    println("]");
}
fun main(args: Array<String>) {
    val arreglo1= IntArray(10, {it})
    arreglo1.imprimir()
}