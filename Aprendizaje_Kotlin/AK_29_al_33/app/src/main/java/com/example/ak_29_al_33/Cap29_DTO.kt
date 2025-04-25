package com.example.ak_29_al_33

// Creación de DTO (POJOs / POCOs)
data class User(var firstname: String = "Joe", var lastname: String = "Bloggs", var age: Int = 20)

fun main() {
    // Crear un objeto de User
    val user = User()
    println(user) // Imprime: User(firstname=Joe, lastname=Bloggs, age=20)

    // Crear una copia con un cambio en 'firstname'
    val user2 = user.copy(firstname = "Alice")
    println(user2) // Imprime: User(firstname=Alice, lastname=Bloggs, age=20)
}
