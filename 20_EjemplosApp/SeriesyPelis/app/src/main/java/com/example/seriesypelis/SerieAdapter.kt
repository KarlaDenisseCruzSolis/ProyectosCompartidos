package com.example.seriesypelis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class SerieAdapter(
    private val series: List<Serie>,
    private val onItemClick: (Serie) -> Unit
) : RecyclerView.Adapter<SerieAdapter.SerieViewHolder>() {

    class SerieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val cardView: CardView = view.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_serie, parent, false)
        return SerieViewHolder(view)
    }

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {
        val serie = series[position]
        holder.tvNombre.text = if (serie.visto) "✅ ${serie.nombre}" else serie.nombre
        holder.cardView.setOnClickListener { onItemClick(serie) }
    }

    override fun getItemCount(): Int = series.size
}
