package com.example.ak_29_al_33

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var mItems: ArrayList<String> = ArrayList()
    lateinit var mClick: OnClick

    // Inicialización del adaptador
    fun RecyclerAdapter(item: ArrayList<String>, mClick: OnClick) {
        this.mItems = item
        this.mClick = mClick
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mItems[position]
        holder.bind(item, mClick, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.main_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: TextView = view.findViewById(R.id.card)

        fun bind(str: String, mClick: OnClick, position: Int) {
            card.text = str
            card.setOnClickListener {
                mClick.onClickListener(position)
            }
        }
    }
}
