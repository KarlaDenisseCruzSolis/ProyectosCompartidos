package com.example.ak_29_al_33

//Delegado a una clase sin aportarlo en el constructor público
interface Table<K, V, R> {
    fun get(key: K): V
    fun put(key: K, value: V): R
}

class MyTable private constructor(table: Table<Int, Int, Int>) : Table<Int, Int, Int> by table {
    companion object {
        fun create(): MyTable = MyTable(object : Table<Int, Int, Int> {
            override fun get(key: Int): Int = key * 2
            override fun put(key: Int, value: Int): Int = value + 1
        })
    }
}

fun main() {
    // Crear una instancia de MyTable utilizando el método create
    val myTable = MyTable.create()
    println(myTable.get(2)) // Imprime: 4
}
