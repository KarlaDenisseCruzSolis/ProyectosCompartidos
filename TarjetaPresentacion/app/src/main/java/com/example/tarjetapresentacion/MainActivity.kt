package com.example.tarjetapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaPresentacionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Sección superior: imagen + nombre + cargo
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Logotipo de Android",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "Yahir Osvaldo Valero Hernandez",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
        Text(
            text = "Ingeniero en Sistemas",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Sección inferior: info contacto
        ContactInfo(icon = R.drawable.ic_phone, info = "+52 833 338 1815")
        ContactInfo(icon = R.drawable.ic_email, info = "L21070330@cdmadero.tecnm.mx")
        ContactInfo(icon = R.drawable.ic_location, info = "Ciudad Madero, México")
    }
}

@Composable
fun ContactInfo(icon: Int, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = info)
    }
}
