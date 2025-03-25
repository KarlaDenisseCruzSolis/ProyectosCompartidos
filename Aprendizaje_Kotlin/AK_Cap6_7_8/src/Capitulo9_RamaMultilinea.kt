
fun main() {
    // Definir la condición como un valor booleano
    val condition = true // Puedes cambiar esto a 'false' para probar otro caso

    // Funciones que se llaman dentro del 'when'
    fun doSomething() {
        println("Doing something!")
    }

    fun doSomeMore() {
        println("Doing some more!")
    }

    fun doSomethingElse() {
        println("Doing something else!")
    }

    // Usamos la sentencia 'when' con una rama que contiene múltiples instrucciones
    when {
        condition -> {
            doSomething()   // Realiza alguna acción si la condición es verdadera
            doSomeMore()    // Realiza más acciones si la condición es verdadera
        }
        else -> doSomethingElse()  // Si la condición no es verdadera, se ejecuta 'doSomethingElse()'
    }
}
