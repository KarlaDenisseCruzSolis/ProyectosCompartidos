fun main(parametro: Array<String>) {
    // Creación de un objeto anónimo que contiene un arreglo y métodos para manipularlo
    val dados = object {
        val arreglo = IntArray(5) // Arreglo de 5 elementos enteros

        // Metodo para generar valores aleatorios entre 1 y 6 en el arreglo
        fun generar() {
            for(i in arreglo.indices) // Recorre los índices del arreglo
                arreglo[i] = ((Math.random() * 6) + 1).toInt() // Asigna un valor aleatorio entre 1 y 6
        }

        // Metodo para imprimir todos los elementos del arreglo
        fun imprimir() {
            for(elemento in arreglo) // Recorre todos los elementos del arreglo
                print("$elemento - ") // Imprime el valor de cada elemento seguido de un guion
            println() // Salto de línea después de imprimir el arreglo
        }

        // Metodo para encontrar el mayor valor en el arreglo
        fun mayor(): Int {
            var may = arreglo[0] // Inicializa la variable 'may' con el primer valor del arreglo
            for(i in arreglo.indices) // Recorre los índices del arreglo
                if (arreglo[i] > may) // Si el valor actual es mayor que 'may'
                    may = arreglo[i] // Actualiza 'may' con el nuevo valor mayor
            return may // Devuelve el mayor valor encontrado
        }
    }

    dados.generar() // Llama al metodo 'generar' para llenar el arreglo con valores aleatorios
    dados.imprimir() // Llama al metodo 'imprimir' para mostrar los valores del arreglo
    print("Mayor valor:") // Imprime el texto "Mayor valor:"
    println(dados.mayor()) // Llama al metodo 'mayor' para obtener e imprimir el mayor valor del arreglo
}