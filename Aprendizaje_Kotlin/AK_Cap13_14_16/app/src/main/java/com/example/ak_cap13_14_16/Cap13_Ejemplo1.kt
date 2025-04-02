package com.example.ak_cap13_14_16

data class Person(val name: String, val gender: Sex, val department: Department) {
    enum class Sex { MALE, FEMALE }
}

data class Employee(val salary: Int, val dept: Department)
data class Department(val name: String)
data class Student(val grade: Int)

fun main() {
    val people = listOf(
        Person("Alice", Person.Sex.FEMALE, Department("HR")),
        Person("Bob", Person.Sex.MALE, Department("IT"))
    )

    // 1. Acumular nombres en una lista
    val list = people.map { it.name }
    println(list)

    // 2. Convertir elementos en cadenas y concatenarlos, separados por comas
    val things = listOf(1, 2, "a", "b")
    val joined = things.joinToString()
    println(joined)

    // 3. Calcular la suma de los salarios de los empleados
    val employees = listOf(
        Employee(5000, Department("HR")),
        Employee(3000, Department("IT"))
    )
    val total = employees.sumBy { it.salary }
    println(total)

    // 4. Grupo de empleados por departamento
    val byDept = employees.groupBy { it.dept }
    println(byDept)

    // 5. Calcular la suma de los salarios por departamento
    val totalByDept = employees.groupBy { it.dept }.mapValues { it.value.sumBy { it.salary } }
    println(totalByDept)

    // 6. Partición de los estudiantes en pasar y fallando
    val students = listOf(Student(80), Student(60))
    val passingFailing = students.partition { it.grade >= 70 }
    println(passingFailing)

    // 7. Nombres de miembros masculinos
    val roster = listOf(
        Person("Alice", Person.Sex.FEMALE, Department("HR")),
        Person("Bob", Person.Sex.MALE, Department("IT"))
    )
    val namesOfMaleMembers = roster.filter { it.gender == Person.Sex.MALE }.map { it.name }
    println(namesOfMaleMembers)

    // 8. Grupo de nombres de miembros en la lista por género
    val namesByGender = roster.groupBy { it.gender }.mapValues { it.value.map { it.name } }
    println(namesByGender)

    // 9. Filtrar una lista a otra lista
    val items = listOf("apple", "orange", "banana")
    val filtered = items.filter { it.startsWith('o') }
    println(filtered)

    // 10. Encontrando la cadena más corta de una lista
    val items2 = listOf("apple", "orange", "banana")
    val shortest = items2.minBy { it.length }
    println(shortest)
}
