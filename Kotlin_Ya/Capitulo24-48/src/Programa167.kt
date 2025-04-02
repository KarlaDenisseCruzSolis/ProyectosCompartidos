class Dadoss (){
    val arreglo = IntArray(10)
    fun tirar() {
        for(i in arreglo.indices)
            arreglo[i] = ((Math.random() * 6) + 1).toInt()
    }
    operator fun invoke(nro: Int) = arreglo[nro]
}
fun main(args: Array<String>) {
    var dados = Dadoss()
    dados.tirar()
    println(dados(0))
    println(dados(1))
    for(i in 2..9)
        println(dados(i))
}