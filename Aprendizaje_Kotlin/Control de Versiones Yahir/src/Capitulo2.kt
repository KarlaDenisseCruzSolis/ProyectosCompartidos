fun Capitulo2() {
    println("Capitulo 2: Tipo anulable \n") //Imprime el nombre de la actividad
    // Declaración de variables anulables (pueden contener un valor o ser null)
    val textField1: String? = "Hola, cambiando mensaje de Kotlin" // Variable con un valor de tipo String
    val textField2: String? = null           // Variable con un valor null

    // Ejemplo INCORRECTO: Llamar a toString() sobre un tipo anulable sin validación adecuada
    val incorrectText1 = textField1?.toString() ?: "" // Si textField1 es null, devuelve ""
    val incorrectText2 = textField2?.toString() ?: "" // Si textField2 es null, devuelve ""
    // Imprimir los resultados incorrectos
    println("Incorrecto (textField1): $incorrectText1") // Muestra el valor de textField1 convertido a String
    println("Incorrecto (textField2): $incorrectText2") // Muestra una cadena vacía en lugar de "null"

    // Ejemplo CORRECTO: También usa el operador Elvis (?:) para manejar valores null de manera segura
    val correctText1 = textField1?.toString() ?: "" // Devuelve el valor de textField1 o una cadena vacía si es null
    val correctText2 = textField2?.toString() ?: "" // Devuelve una cadena vacía en caso de null
    // Imprimir los resultados correctos
    println("Correcto (textField1): $correctText1") // Muestra el valor de textField1
    println("Correcto (textField2): $correctText2") // Muestra "" (cadena vacía) en lugar de "null"
    println("") // Línea en blanco para separar la salida
}