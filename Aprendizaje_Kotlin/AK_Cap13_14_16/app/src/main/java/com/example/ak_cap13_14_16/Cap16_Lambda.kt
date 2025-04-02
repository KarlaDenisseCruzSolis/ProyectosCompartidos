package com.example.ak_cap13_14_16

//Funciones Lambda

/*---------lambda con un solo argumento-------------
val greet = { name: String ->
    "Hello, $name!"  // Devuelve un saludo con el nombre
}

fun main() {
    println(greet("John"))  // Output: Hello, John!
}*/


/*----------lambda con múltiples argumentos-----------
val concatenate = { first: String, second: String ->
    "$first $second"  // Concatena dos cadenas
}

fun main() {
    println(concatenate("Hello", "World"))  // Output: Hello World
}*/


/*----------lambda usando it (único argumento)-----------
val double = { number: Int ->
    number * 2
}

fun main() {
    println(double(5))  // Output: 10
}*/


//----------Uso de it en una lista-----------
val numbers = listOf(1, 2, 3, 4)
val doubledNumbers = numbers.map { it * 2 }

fun main() {
    println(doubledNumbers)  // Output: [2, 4, 6, 8]
}
