//PROBLEMA PROPUESTO 172
/*Confeccionar una función que reciba una serie de edades y nos retorne la cantidad que son mayores o iguales a 18
(como mínimo se envía un entero a la función)*/
fun cantidadMayores(vararg edades: Int) = edades.count {it >= 18}

fun main(args: Array<String>) = println(cantidadMayores(3, 65, 32, 23, 2, 98, 23, 45, 15))
