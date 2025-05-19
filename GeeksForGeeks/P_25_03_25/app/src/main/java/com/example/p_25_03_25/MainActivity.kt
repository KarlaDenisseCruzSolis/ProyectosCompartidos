package com.example.p_25_03_25

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity // Importar AppCompatActivity

class MainActivity : AppCompatActivity() { // Extiende AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear un FrameLayout programáticamente
        val frameLayout = FrameLayout(this)
        frameLayout.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )

        // Lista de colores que se utilizarán para los Views
        val colors = listOf(
            "#F44336", "#E91E63", "#9C27B0", "#3F51B5", "#2196F3",
            "#03A9F4", "#00BCD4", "#009688", "#4CAF50"
        )

        // Lista de ubicaciones (gravedad) para los Views
        val gravities = listOf(
            Gravity.TOP or Gravity.START, Gravity.TOP or Gravity.CENTER_HORIZONTAL, Gravity.TOP or Gravity.END,
            Gravity.CENTER_VERTICAL or Gravity.START, Gravity.CENTER,
            Gravity.CENTER_VERTICAL or Gravity.END, Gravity.BOTTOM or Gravity.START,
            Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, Gravity.BOTTOM or Gravity.END
        )

        // Crear y agregar los Views al FrameLayout
        for (i in colors.indices) {
            val view = View(this)
            val params = FrameLayout.LayoutParams(125.dpToPx(), 125.dpToPx())
            params.gravity = gravities[i]
            view.layoutParams = params
            view.setBackgroundColor(Color.parseColor(colors[i])) // Establecer el color de fondo
            frameLayout.addView(view) // Añadir el View al FrameLayout
        }

        // Establecer el FrameLayout como la vista principal
        setContentView(frameLayout)
    }

    // Función de extensión para convertir dp a px
    fun Int.dpToPx(): Int {
        val density = resources.displayMetrics.density
        return (this * density).toInt()
    }
}
