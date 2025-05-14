class Cliente(var nombre: String, var monto: Float) { // Definición de la clase Cliente con propiedades 'nombre' y 'monto'.
    fun depositar(monto: Float) { // Metodo 'depositar' que aumenta el monto en la cuenta del cliente.
        this.monto += monto // Suma el monto depositado al saldo actual del cliente.
    }
    fun extraer(monto: Float) { // Metodo 'extraer' que reduce el monto de la cuenta del cliente.
        this.monto -= monto // Resta el monto extraído del saldo actual del cliente.
    }
    fun imprimir() { // Metodo 'imprimir' que muestra el nombre y el saldo actual del cliente.
        println("$nombre tiene depositado la suma de $monto") // Imprime el nombre del cliente y el monto que tiene depositado.
    }
}

class Banco { // Definición de la clase Banco que maneja varios clientes.
    val cliente1: Cliente = Cliente("Juan", 0f) // Creación de un cliente 'Juan' con saldo inicial de 0.
    var cliente2: Cliente = Cliente("Ana", 0f) // Creación de un cliente 'Ana' con saldo inicial de 0.
    var cliente3: Cliente = Cliente("Luis", 0f) // Creación de un cliente 'Luis' con saldo inicial de 0.

    fun operar() { // Metodo 'operar' que realiza operaciones bancarias con los clientes.
        cliente1.depositar(100f) // Realiza un depósito de 100 en la cuenta de 'Juan'.
        cliente2.depositar(150f) // Realiza un depósito de 150 en la cuenta de 'Ana'.
        cliente3.depositar(200f) // Realiza un depósito de 200 en la cuenta de 'Luis'.
        cliente3.extraer(150f) // Realiza una extracción de 150 de la cuenta de 'Luis'.
    }

    fun depositosTotales() { // Metodo 'depositosTotales' que calcula y muestra el total de los depósitos del banco.
        val total = cliente1.monto + cliente2.monto + cliente3.monto // Suma los saldos de los tres clientes para obtener el total.
        println("El total de dinero del banco es: $total") // Imprime el total de dinero en el banco.
        cliente1.imprimir() // Llama al metodo 'imprimir' de la clase Cliente para mostrar los detalles de 'Juan'.
        cliente2.imprimir() // Llama al metodo 'imprimir' de la clase Cliente para mostrar los detalles de 'Ana'.
        cliente3.imprimir() // Llama al metodo 'imprimir' de la clase Cliente para mostrar los detalles de 'Luis'.
    }
}

fun main(parametro: Array<String>) { // Función principal 'main' que ejecuta el programa.
    val banco1 = Banco() // Crea un objeto 'banco1' de la clase Banco.
    banco1.operar() // Llama al metodo 'operar' de 'banco1' para realizar las operaciones con los clientes.
    banco1.depositosTotales() // Llama al metodo 'depositosTotales' de 'banco1' para mostrar el total de los depósitos y los saldos de los clientes.
}