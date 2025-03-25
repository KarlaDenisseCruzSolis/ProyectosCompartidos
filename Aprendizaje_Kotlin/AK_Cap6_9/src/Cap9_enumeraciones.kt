
// Se define una enumeración llamada Day con los días de la semana
enum class Day {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
}

fun doOnDay(day: Day) {
    // Se usa when para ejecutar diferentes acciones dependiendo del día
    when (day) {
        Day.Sunday -> println("Relax and enjoy!") // Si es domingo, imprime este mensaje
        Day.Monday, Day.Tuesday -> println("Time to work!") // Si es lunes o martes, imprime esto
        Day.Wednesday -> println("Halfway through the week!") // Si es miércoles, imprime esto
        Day.Thursday -> println("Almost there!") // Si es jueves, imprime esto
        Day.Friday -> println("Weekend is coming!") // Si es viernes, imprime esto
        Day.Saturday -> println("Enjoy your weekend!") // Si es sábado, imprime esto
    }
}

fun main() {
    val today = Day.Wednesday // Se define una variable con el día actual

    doOnDay(today) // Se llama a la función pasando el día de hoy
}
