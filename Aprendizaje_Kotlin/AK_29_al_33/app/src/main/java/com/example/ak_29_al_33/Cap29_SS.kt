package com.example.ak_29_al_33

//Serializable y serialVersionUID en Kotlin

import java.io.*

// Clase serializable con serialVersionUID
class MySpecialCase : Serializable {
    companion object {
        // Esta es la forma más concisa y correcta de definir serialVersionUID
        private const val serialVersionUID: Long = 123L
    }

    // Atributos de la clase (por ejemplo)
    var name: String = "Example"

    override fun toString(): String {
        return "MySpecialCase(name='$name')"
    }
}

fun main() {
    // Crear una instancia de MySpecialCase
    val myObject = MySpecialCase()

    // Serializar el objeto a un archivo
    val fileOut = ObjectOutputStream(FileOutputStream("mySpecialCase.ser"))
    fileOut.writeObject(myObject)
    fileOut.close()

    println("Objeto serializado: $myObject")

    // Deserializar el objeto desde el archivo
    val fileIn = ObjectInputStream(FileInputStream("mySpecialCase.ser"))
    val deserializedObject = fileIn.readObject() as MySpecialCase
    fileIn.close()

    println("Objeto deserializado: $deserializedObject")
}

