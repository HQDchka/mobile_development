package com.example.lab15

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonChangeColor = findViewById<Button>(R.id.button_change_color)

        buttonChangeColor.setOnClickListener {
            val originalColor = buttonChangeColor.backgroundTintList
            buttonChangeColor.backgroundTintList = ColorStateList.valueOf(Color.RED)
            Handler(Looper.getMainLooper()).postDelayed({
                buttonChangeColor.backgroundTintList = originalColor
            }, 3000)
        }
    }
}