fun Capitulo2() {
    println("Capitulo 2: Advertencias \n")
    // Simulación de un campo de texto que puede ser null
    val textField1: String? = "Hola, Kotlin" // Campo con texto
    val textField2: String? = null           // Campo nulo

    // Ejemplo INCORRECTO: Llamar a toString() directamente sobre un tipo anulable
    val incorrectText1 = textField1?.toString() ?: ""
    val incorrectText2 = textField2?.toString() ?: ""

    println("Incorrecto (textField1): $incorrectText1") // "Hola, Kotlin"
    println("Incorrecto (textField2): $incorrectText2") // "null" ❌

    // Ejemplo CORRECTO: Usar toString() solo si el valor no es null
    val correctText1 = textField1?.toString() ?: ""
    val correctText2 = textField2?.toString() ?: ""

    println("Correcto (textField1): $correctText1") // "Hola, Kotlin"
    println("Correcto (textField2): $correctText2") // "" ✅ (Cadena vacía)
    println("")
}