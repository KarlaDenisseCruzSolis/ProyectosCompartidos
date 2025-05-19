package com.example.listv_java_03_04_25

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var l: ListView
    var tutorials: Array<String> = arrayOf(
        "Algorithms",
        "Data Structures",
        "Languages",
        "Interview Corner",
        "GATE",
        "ISRO CS",
        "UGC NET CS",
        "CS Subjects",
        "Web Technologies"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        l = findViewById(R.id.list)

        var arr: ArrayAdapter<String> = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,tutorials)

        l.setAdapter(arr)
    }
}
