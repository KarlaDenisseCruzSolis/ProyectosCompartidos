
import kotlinx.coroutines.* // Necesario para GlobalScope, launch, delay y Dispatchers

fun main(args: Array<String>) {
    // Inicia una nueva corrutina en el contexto predeterminado (usando Dispatchers.Default en lugar de CommonPool)
    GlobalScope.launch(Dispatchers.Default) {
        // Pausa la ejecución de la corrutina durante 1 segundo (sin bloquear el hilo principal)
        delay(1000L)

        // Se imprime "World!" después de la pausa de 1 segundo
        println("World!")
    }

    // Se imprime "Hello," inmediatamente en el hilo principal, mientras la corrutina está esperando
    println("Hello,")

    // Bloquea el hilo principal durante 2 segundos para evitar que el programa termine antes de que la corrutina finalice
    Thread.sleep(2000L)
}
