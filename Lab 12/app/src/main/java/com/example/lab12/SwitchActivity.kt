package com.example.lab12

import android.graphics.Color
import android.os.Bundle
import android.widget.Switch
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SwitchActivity : AppCompatActivity() {
    private lateinit var layout: LinearLayout
    private lateinit var redSwitch: Switch
    private lateinit var greenSwitch: Switch
    private lateinit var blueSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch)

        layout = findViewById(R.id.mainLayout)
        redSwitch = findViewById(R.id.switchRed)
        greenSwitch = findViewById(R.id.switchGreen)
        blueSwitch = findViewById(R.id.switchBlue)

        val listener = {
            val r = if (redSwitch.isChecked) 255 else 0
            val g = if (greenSwitch.isChecked) 255 else 0
            val b = if (blueSwitch.isChecked) 255 else 0
            layout.setBackgroundColor(Color.rgb(r, g, b))
        }

        redSwitch.setOnCheckedChangeListener { _, _ -> listener() }
        greenSwitch.setOnCheckedChangeListener { _, _ -> listener() }
        blueSwitch.setOnCheckedChangeListener { _, _ -> listener() }
    }
}
