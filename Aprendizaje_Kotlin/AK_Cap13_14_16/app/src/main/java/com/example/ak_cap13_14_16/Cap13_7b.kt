package com.example.ak_cap13_14_16

//7b: recopilación con SummarizingInt

data class SummaryStatisticsInt(var count: Int = 0,
                                var sum: Int = 0,
                                var min: Int = Int.MAX_VALUE,
                                var max: Int = Int.MIN_VALUE,
                                var avg: Double = 0.0) {
    fun accumulate(newInt: Int): SummaryStatisticsInt {
        count++
        sum += newInt
        min = min.coerceAtMost(newInt)
        max = max.coerceAtLeast(newInt)
        avg = sum.toDouble() / count
        return this
    }
}

data class Persona4(val name: String, val age: Int)

fun main() {
    val persons = listOf(
        Persona4("Tod", 5),
        Persona4("Max", 33),
        Persona4("Frank", 13),
        Persona4("Peter", 80),
        Persona4("Pamela", 18)
    )

    val stats = persons.fold(SummaryStatisticsInt()) { stats, person ->
        stats.accumulate(person.age)
    }

    println(stats)
    // Output: SummaryStatisticsInt(count=5, sum=149, min=5, max=80, avg=29.8)
}