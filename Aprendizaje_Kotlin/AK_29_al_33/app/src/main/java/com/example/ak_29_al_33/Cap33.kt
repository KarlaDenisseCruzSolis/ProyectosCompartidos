package com.example.ak_29_al_33

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView
    val mAdapter: RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById(R.id.recycler_view)

        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getList(), object : OnClick {
            override fun onClickListener(position: Int) {
                Toast.makeText(applicationContext, "Clicked on item: $position", Toast.LENGTH_SHORT).show()
            }
        })
        mRecyclerView.adapter = mAdapter
    }

    private fun getList(): ArrayList<String> {
        var list: ArrayList<String> = ArrayList()
        for (i in 1..10) { // equivalent of 1 <= i && i <= 10
            list.add("$i")
        }
        return list
    }
}

interface OnClick {
    fun onClickListener(position: Int)
}
