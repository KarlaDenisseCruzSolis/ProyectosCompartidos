package com.example.ak_34_al_38

// Alias de tipo para una función que valida un String
typealias StringValidator = (String) -> Boolean

// Alias de tipo para una función que reduce dos tipos a un tercer tipo
typealias Reductor<T, U, V> = (T, U) -> V

// Tipos genéricos utilizando Pair y List
typealias Parents = Pair<Person, Person>
typealias Accounts = List<Account>

fun main() {
    // Ejemplo de StringValidator
    val isNotEmpty: StringValidator = { str -> str.isNotEmpty() }
    println(isNotEmpty("Hello"))  // Imprime true

    // Ejemplo de Reductor
    val sum: Reductor<Int, Int, Int> = { a, b -> a + b }
    println(sum(5, 3))  // Imprime 8

    // Tipos genéricos
    val parents: Parents = Pair(Person("John"), Person("Jane"))
    println("Parents: ${parents.first.name} and ${parents.second.name}")  // Imprime los nombres de los padres

    val accounts: Accounts = listOf(Account(1, "Account 1"), Account(2, "Account 2"))
    accounts.forEach { println("Account ID: ${it.id}, Name: ${it.name}") }
}

// Clases de ejemplo para los tipos genéricos
data class Person(val name: String)
data class Account(val id: Int, val name: String)
