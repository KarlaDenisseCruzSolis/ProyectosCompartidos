
fun main() {
    // Definimos las condiciones
    val condition1 = true  // Por ejemplo, esta condición es verdadera
    val condition2 = false  // Esta condición es falsa

    // Usamos la condición en una expresión 'if'
    val str = if (condition1) {
        "Condition1 met!"  // Si 'condition1' es verdadera, asignamos "Condition1 met!" a 'str'.
    } else if (condition2) {
        "Condition2 met!"  // Si 'condition1' es falsa pero 'condition2' es verdadera, asignamos "Condition2 met!" a 'str'.
    } else {
        "Conditions not met!"  // Si ambas condiciones son falsas, asignamos "Conditions not met!" a 'str'.
    }

    // Imprime el valor de 'str'
    println(str)
}
