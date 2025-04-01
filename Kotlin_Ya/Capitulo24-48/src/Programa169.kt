data class Alumnoo(val documento: Int, val nombre: String)
class Curso {
    val alumnos = arrayOf(Alumnoo(123456, "Marcos"),
        Alumnoo(666666, "Ana"),
        Alumnoo(777777, "Luis"))
    operator fun contains(documento: Int): Boolean {
        return alumnos.any {documento == it.documento}
    }
}
fun main(args: Array<String>) {
    val curso1 = Curso()
    if (123456 in curso1)
        println("El alumno Marcos está inscrito en el cuso")
    else
        println("El alumno Marcos no está inscrito en el cuso")
}