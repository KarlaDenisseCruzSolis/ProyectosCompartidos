package com.example.ejemplo9 // Define el paquete donde se encuentra el archivo

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText  // Declara la variable para el campo de texto donde se ingresa el correo electrónico
    private lateinit var validateButton: Button // Declara la variable para el botón que valida el correo electrónico
    private lateinit var resultTextView: TextView // Declara la variable para el TextView que mostrará el resultado de la validación

    override fun onCreate(savedInstanceState: Bundle?) { // Metodo llamado cuando la actividad es creada
        super.onCreate(savedInstanceState) // Llama al constructor de la clase base
        setContentView(R.layout.activity_main) // Establece el layout de la actividad

        // Inicializar vistas
        emailEditText = findViewById(R.id.emailEditText) // Inicializa el EditText para la entrada del correo electrónico
        validateButton = findViewById(R.id.validateButton)  // Inicializa el botón para validar el correo
        resultTextView = findViewById(R.id.resultTextView) // Inicializa el TextView donde se mostrará el resultado

        // Establecer el listener de clics para el botón
        validateButton.setOnClickListener { // Cuando el usuario hace clic en el botón de validar
            validateEmail() // Llama a la función para validar el correo electrónico
        }
    }

    private fun validateEmail() {
        val email = emailEditText.text.toString().trim() // Obtiene el texto del EditText y elimina los espacios en blanco al principio y al final

        if (email.isEmpty()) { // Si el campo de correo electrónico está vacío
            resultTextView.text = "Por favor ingresa una dirección de correo electrónico." // Muestra un mensaje pidiendo al usuario que ingrese un correo
        } else if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            resultTextView.text = "La dirección de correo electrónico es válida." // Muestra un mensaje indicando que el correo es válido
        } else {
            resultTextView.text = "La dirección de correo electrónico no es válida." // Muestra un mensaje indicando que el correo no es válido
        }
    }
}