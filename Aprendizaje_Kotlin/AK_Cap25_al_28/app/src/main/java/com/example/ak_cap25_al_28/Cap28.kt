package com.example.ak_cap25_al_28

// Clase para usar modificadores de visibilidad
open class VisibilityExample {
    // Public: accesible desde cualquier lugar
    public val publicName = "Avijit"

    // Privado: solo accesible dentro de la clase
    private val privateName = "Avijit"

    // Protegido: accesible desde la clase y sus subclases
    protected val protectedName = "Avijit"

    // Interno: accesible dentro del mismo módulo
    internal val internalName = "Avijit"

    // Función para mostrar los valores
    fun showProperties() {
        println("Public Name: $publicName")
        println("Private Name: $privateName")
        println("Protected Name: $protectedName")
        println("Internal Name: $internalName")
    }
}

// Subclase que accede a la propiedad protegida
class SubVisibilityExample : VisibilityExample() {
    fun showProtected() {
        // Accede a la propiedad protegida desde la subclase
        println("Protected Name from Subclass: $protectedName")
    }
}

fun main() {
    // Creando un objeto de VisibilityExample
    val example = VisibilityExample()

    // Accediendo a las propiedades públicas e internas
    println("Public Name from main: ${example.publicName}")
    println("Internal Name from main: ${example.internalName}")

    // Llamando a la función que muestra todas las propiedades
    example.showProperties()

    // Las siguientes líneas generan errores porque las propiedades son privadas o protegidas:
    // println("Private Name from main: ${example.privateName}")  // Error: 'privateName' is private
    // println("Protected Name from main: ${example.protectedName}")  // Error: 'protectedName' is protected

    // Creando un objeto de la subclase para acceder a la propiedad protegida
    val subExample = SubVisibilityExample()
    subExample.showProtected()  // Accede a la propiedad protegida desde la subclase
}
