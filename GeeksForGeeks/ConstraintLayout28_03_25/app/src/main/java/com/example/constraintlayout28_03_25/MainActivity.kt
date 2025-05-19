package com.example.constraintlayout28_03_25

//activity_main**********************************
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos del layout
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Asegurar que el botón está visible y funcional
        btnLogin.isEnabled = true
        btnLogin.invalidate()

        // Evento de clic en el botón
        btnLogin.setOnClickListener {
            println("Botón presionado") // Para verificar en Logcat
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                runOnUiThread {
                    Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            } else {
                runOnUiThread {
                    Toast.makeText(this, "Login exitoso!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


//activity_main2**********************************
/*import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Referencias a los botones de activity_main2.xml
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)

        // Evento de clic en btn1
        btn1.setOnClickListener {
            // Lógica cuando se presiona btn1
            Toast.makeText(this, "Botón 1 presionado", Toast.LENGTH_SHORT).show()
        }

        // Evento de clic en btn2
        btn2.setOnClickListener {
            // Lógica cuando se presiona btn2
            Toast.makeText(this, "Botón 2 presionado", Toast.LENGTH_SHORT).show()
        }

        // Evento de clic en btn3
        btn3.setOnClickListener {
            // Lógica cuando se presiona btn3
            Toast.makeText(this, "Botón 3 presionado", Toast.LENGTH_SHORT).show()
        }
    }
}*/


//activity_main3**********************************
/*import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }
}*/


//activity_main4**********************************
/*import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

    }
}*/


//activity_main_primero**********************************

/*import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_primero)
    }
}*/



