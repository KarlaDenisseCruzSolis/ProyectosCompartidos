// Archivo: Capitulo3.kt

// Definimos una anotación simple
annotation class Strippable

// Definimos una anotación con meta-anotaciones
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy

// Definimos una enumeración para usar en una anotación
enum class Importance { LOW, MEDIUM, HIGH }

// Definimos una anotación con un parámetro de tipo enum
annotation class StrippableWithLevel(val importance: Importance)

// Definimos una anotación repetible
@Repeatable
annotation class Tag(val name: String)

// Usamos las anotaciones en una clase
@Fancy
@StrippableWithLevel(Importance.HIGH)
@Tag("Experimental")
@Tag("Beta")
class MyClass {
    @Fancy
    fun myFunction(@Fancy param: String) {
        println("Funcion ejecutada con param: $param")
    }
}

// Función para ejecutar el código de este archivo
fun Capitulo3() {
    println("Capitulo 3: Anotaciones \n")
    val obj = MyClass()
    obj.myFunction("Hola")
    println("")
}