fun main(parametro: Array<String>) {
    val valor1: Int //Definimos e inicializamos dos variables Int inmutables (utilizamos la palabra clave val)
    val valor2: Int
    valor1 = 100
    valor2 = 400
    var resultado: Int //Definimos una tercer variable mutable también de tipo Int
    resultado = valor1 + valor2 //Primero en la variable resultado almacenamos la suma de los contenidos de las variables valor1 y valor2
    println("La suma de $valor1 + $valor2 es $resultado") //Para mostrar por la Consola el contenido de la variable $resultado utilizamos la función println y dentro del String que muestra donde queremos que aparezca el contenido de la variable le antecedimos el caracter $
    resultado = valor1 * valor2 //Como la variable resultado es mutable podemos ahora almacenar el producto de las dos primeras variables
    println("El producto de $valor1 * $valor2 es $resultado")
}