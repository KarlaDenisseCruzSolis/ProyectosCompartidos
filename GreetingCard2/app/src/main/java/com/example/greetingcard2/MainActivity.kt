package com.example.greetingcard2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard2.ui.theme.GreetingCard2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCard2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Karla Cruz")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Cyan) {
        Text(text = "Hi, $name! Modificando Karla.", modifier = Modifier.padding(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingCard2Theme {
        Greeting("Karla y Yahir")
    }
}
