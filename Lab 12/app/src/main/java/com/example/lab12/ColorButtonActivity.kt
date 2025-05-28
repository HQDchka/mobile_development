package com.example.lab12

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ColorButtonActivity : AppCompatActivity() {

    private val colors = listOf(
        Color.RED,
        Color.rgb(255, 165, 0),
        Color.YELLOW,
        Color.GREEN,
        Color.CYAN,
        Color.BLUE,
        Color.MAGENTA
    )

    private var colorIndex = 0
    private val handler = Handler(Looper.getMainLooper())
    private var isMoving = false

    private var dX = 0f
    private var dY = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_button)

        val button = findViewById<Button>(R.id.colorButton)
        button.setBackgroundColor(colors[colorIndex])

        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    Log.d("TouchEvent", "ACTION_DOWN")
                    colorIndex = (colorIndex + 1) % colors.size
                    v.setBackgroundColor(colors[colorIndex])
                    isMoving = false

                    dX = event.rawX - v.x
                    dY = event.rawY - v.y

                    true
                }

                MotionEvent.ACTION_MOVE -> {
                    Log.d("TouchEvent", "ACTION_MOVE")
                    isMoving = true
                    v.x = event.rawX - dX
                    v.y = event.rawY - dY

                    (v as Button).text = "Вы перетаскиваете кнопку"
                    cycleColors(v)

                    true
                }

                MotionEvent.ACTION_UP -> {
                    Log.d("TouchEvent", "ACTION_UP")
                    (v as Button).text = "Вы отпустили кнопку"
                    handler.removeCallbacksAndMessages(null)
                    true
                }

                else -> false
            }
        }
    }

    private fun cycleColors(button: Button) {
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (isMoving) {
                    colorIndex = (colorIndex + 1) % colors.size
                    button.setBackgroundColor(colors[colorIndex])
                    handler.postDelayed(this, 300)
                }
            }
        }, 300)
    }
}
