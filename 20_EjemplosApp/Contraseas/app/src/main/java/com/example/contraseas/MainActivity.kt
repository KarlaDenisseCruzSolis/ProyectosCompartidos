package com.example.contraseas

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contraseas.ui.theme.ContraseñasTheme
import java.security.SecureRandom

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContraseñasTheme {
                PasswordGeneratorScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordGeneratorScreen() {
    var password by remember { mutableStateOf("") }
    var length by remember { mutableStateOf("12") }
    var includeNumbers by remember { mutableStateOf(true) }
    var includeLetters by remember { mutableStateOf(true) }
    var includeSymbols by remember { mutableStateOf(true) }
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { },
                label = { Text("Generated Password") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = length,
                onValueChange = { if (it.all { char -> char.isDigit() }) length = it },
                label = { Text("Password Length") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = includeNumbers, onCheckedChange = { includeNumbers = it })
                Text("Include Numbers")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = includeLetters, onCheckedChange = { includeLetters = it })
                Text("Include Letters")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = includeSymbols, onCheckedChange = { includeSymbols = it })
                Text("Include Symbols")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                password = generatePassword(
                    length.toIntOrNull() ?: 12,
                    includeNumbers,
                    includeLetters,
                    includeSymbols
                )
            }) {
                Text("Generate Password")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                copyToClipboard(context, password)
            }) {
                Text("Copy to Clipboard")
            }
        }
    }
}

fun generatePassword(length: Int, includeNumbers: Boolean, includeLetters: Boolean, includeSymbols: Boolean): String {
    val numbers = "0123456789"
    val letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val symbols = "!@#$%^&*()_-+=<>?"

    var allowedChars = ""
    if (includeNumbers) allowedChars += numbers
    if (includeLetters) allowedChars += letters
    if (includeSymbols) allowedChars += symbols

    if (allowedChars.isEmpty()) return ""

    return (1..length)
        .map { SecureRandom().nextInt(allowedChars.length) }
        .map { allowedChars[it] }
        .joinToString("")
}

fun copyToClipboard(context: Context, text: String) {
    val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clipData = ClipData.newPlainText("password", text)
    clipboardManager.setPrimaryClip(clipData)
    Toast.makeText(context, "Password copied to clipboard", Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun PasswordGeneratorScreenPreview() {
    ContraseñasTheme {
        PasswordGeneratorScreen()
    }
}