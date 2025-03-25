// Definimos una enumeración llamada WeekDay que representa los días de la semana.
enum class WeekDay {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
}

// Definimos una función que toma un día de la semana como argumento y ejecuta diferentes acciones según el día.
fun doOnWeekDay(day: WeekDay) {
    when (day) {
        WeekDay.Monday -> println("Work") // Si es lunes, imprime "Work"
        WeekDay.Tuesday -> println("Work hard") // Si es martes, imprime "Work hard"
        WeekDay.Wednesday -> println("Midweek tasks") // Si es miércoles, imprime "Midweek tasks"
        WeekDay.Thursday -> println("Almost Friday") // Si es jueves, imprime "Almost Friday"
        WeekDay.Friday -> println("Prepare for weekend") // Si es viernes, imprime "Prepare for weekend"
        else -> println("Party on weekend!") // Para cualquier otro caso (sábado o domingo), imprime "Party on weekend!"
    }
}

// Función principal donde se ejecuta el programa
fun main() {
    val today = WeekDay.Sunday // Se asigna el valor Sunday a la variable today
    doOnWeekDay(today) // Se llama a la función doOnWeekDay con el valor de today
}
