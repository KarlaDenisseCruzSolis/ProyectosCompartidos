package com.example.ak_cap21_22_23_24

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File

class MyTest {

    @Test
    fun testCreateTemporaryFile(@TempDir tempDir: File) {
        // Crea un archivo temporal dentro del directorio temporal
        val tempFile = File(tempDir, "tempFile.txt")
        println("Archivo temporal creado: ${tempFile.absolutePath}")
    }

    @Test
    fun testCreateTemporaryFolder(@TempDir tempDir: File) {
        // Crea una carpeta temporal dentro del directorio temporal
        val tempFolder = File(tempDir, "tempFolder")
        println("Carpeta temporal creada: ${tempFolder.absolutePath}")
    }
}
