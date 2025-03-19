fun Capitulo5(){
    println("Capitulo 5: Bucles \n")
    repeat(10) { i ->
        println("Esta linea será impresa 10 veces")
        println("Estamos en la  iteración numero ${i + 1}.")
    }
    val list = listOf("Hello", "World", "!")
    for(str in list) {
        print(str)
    }
    println("")
}