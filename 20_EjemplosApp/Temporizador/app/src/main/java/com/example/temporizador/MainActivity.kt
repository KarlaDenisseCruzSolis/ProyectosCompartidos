package com.example.temporizador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.temporizador.ui.theme.TemporizadorTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TemporizadorTheme {
                MainScreen()
            }
        }
    }
}

enum class TimerState {
    RUNNING, PAUSED, STOPPED
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var timerState by remember { mutableStateOf(TimerState.STOPPED) }
    var timeElapsed by remember { mutableIntStateOf(0) }
    var isCountdownMode by remember { mutableStateOf(false) }
    var countdownTime by remember { mutableIntStateOf(0) }
    var countdownInput by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(timerState) {
        if (timerState == TimerState.RUNNING) {
            coroutineScope.launch {
                while (timerState == TimerState.RUNNING) {
                    delay(1000)
                    if (isCountdownMode) {
                        if (countdownTime > 0) {
                            countdownTime--
                        } else {
                            timerState = TimerState.STOPPED
                        }
                    } else {
                        timeElapsed++
                    }
                }
            }
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = formatTime(if (isCountdownMode) countdownTime else timeElapsed),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))

            if (isCountdownMode) {
                OutlinedTextField(
                    value = countdownInput,
                    onValueChange = {
                        countdownInput = it
                        countdownTime = it.toIntOrNull() ?: 0
                    },
                    label = { Text("Tiempo (segundos)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        when (timerState) {
                            TimerState.STOPPED -> {
                                if (isCountdownMode && countdownTime == 0) {
                                    countdownTime = countdownInput.toIntOrNull() ?: 0
                                }
                                timerState = TimerState.RUNNING
                            }

                            TimerState.RUNNING -> timerState = TimerState.PAUSED
                            TimerState.PAUSED -> timerState = TimerState.RUNNING
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        when (timerState) {
                            TimerState.STOPPED -> "Iniciar"
                            TimerState.RUNNING -> "Pausar"
                            TimerState.PAUSED -> "Reanudar"
                        }
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = {
                        timerState = TimerState.STOPPED
                        timeElapsed = 0
                        if (isCountdownMode) {
                            countdownTime = countdownInput.toIntOrNull() ?: 0
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Reiniciar")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Cuenta Regresiva")
                Switch(
                    checked = isCountdownMode,
                    onCheckedChange = {
                        isCountdownMode = it
                        timeElapsed = 0
                        countdownTime = countdownInput.toIntOrNull() ?: 0
                    }
                )
            }
        }
    }
}

fun formatTime(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val secs = seconds % 60
    return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, secs)
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    TemporizadorTheme {
        MainScreen()
    }
}