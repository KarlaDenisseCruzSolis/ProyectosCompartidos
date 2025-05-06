package com.example.ak_29_al_33

// Reemplazo de métodos estáticos con 'object'
object CommonUtils {
    var anyname: String = "Hello"

    fun dispMsg(message: String) {
        println(message)
    }
}

// Singleton en Kotlin con 'object'
object SharedRegistry {
    fun register(key: String, thing: Any) {
        println("Registered $key: $thing")
    }
}

fun main() {
    // Usando CommonUtils como reemplazo de métodos estáticos
    println(CommonUtils.anyname) // Accede a la propiedad 'anyname'
    CommonUtils.dispMsg("like static call") // Llama al metodo 'dispMsg'

    // Usando SharedRegistry como un singleton
    SharedRegistry.register("a", "apple")
    SharedRegistry.register("b", "boy")
    SharedRegistry.register("c", "cat")
    SharedRegistry.register("d", "dog")
}
