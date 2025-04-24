package com.example.ak_cap25_al_28

// Definición de la clase User para el ejemplo
data class User(val name: String, val age: Int)

fun main() {
    val MINIMUM_AGE = 18
    val users = listOf(
        User("Alice", 25),
        User("Bob", 17),
        User("Charlie", 30)
    )

    // 1. Lambda como parámetro para filtrar la función
    val allowedUsers = users.filter { it.age > MINIMUM_AGE }
    println("Allowed users (filter as parameter): $allowedUsers")

    // 2. Lambda pasada como una variable
    val isOfAllowedAge = { user: User -> user.age > MINIMUM_AGE }
    val allowedUsersWithLambda = users.filter(isOfAllowedAge)
    println("Allowed users (lambda passed as variable): $allowedUsersWithLambda")

    // 3. Lambda para benchmarking una función llamada (usando objeto anónimo)
    val time = object {
        fun realtime(body: () -> Unit): Long {
            val start = System.currentTimeMillis()  // Cambio aquí
            try {
                body()
            } finally {
                val end = System.currentTimeMillis()  // Cambio aquí
                return end - start
            }
        }
    }.realtime {
        // Colocar el código que se quiera medir
        println("This is a long-running code...")
        Thread.sleep(1000)  // Simulación de código que tarda 1 segundo
    }

    println("Executed the code in $time ms")
}
