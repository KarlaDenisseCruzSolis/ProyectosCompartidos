package com.example.blocdenotes

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blocdenotes.ui.theme.BlocDeNotesTheme
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlocDeNotesTheme {
                MainScreen()
            }
        }
    }
}

data class Note(val text: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("notes", Context.MODE_PRIVATE)
    val gson = Gson()

    var noteText by remember { mutableStateOf("") }
    val notes = remember { mutableStateListOf<Note>() }

    // Load notes from SharedPreferences on start
    loadNotes(sharedPreferences, gson, notes)

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = noteText,
                onValueChange = { noteText = it },
                label = { Text("Escribe tu nota aquí") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (noteText.isNotBlank()) {
                        notes.add(Note(noteText))
                        noteText = ""
                        saveNotes(sharedPreferences, gson, notes)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar Nota")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("Notas Guardadas", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(notes) { note ->
                    Text(text = note.text, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

fun saveNotes(sharedPreferences: SharedPreferences, gson: Gson, notes: List<Note>) {
    val json = gson.toJson(notes)
    sharedPreferences.edit().putString("notes_list", json).apply()
}

fun loadNotes(sharedPreferences: SharedPreferences, gson: Gson, notes: MutableList<Note>) {
    val json = sharedPreferences.getString("notes_list", null)
    if (json != null) {
        val type = object : TypeToken<List<Note>>() {}.type
        val loadedNotes: List<Note> = gson.fromJson(json, type)
        notes.addAll(loadedNotes)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    BlocDeNotesTheme {
        MainScreen()
    }
}