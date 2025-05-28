package com.example.lab12

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSwitch = findViewById<Button>(R.id.btnSwitch)
        val btnColor = findViewById<Button>(R.id.btnColor)

        btnSwitch.setOnClickListener {
            startActivity(Intent(this, SwitchActivity::class.java))
        }

        btnColor.setOnClickListener {
            startActivity(Intent(this, ColorButtonActivity::class.java))
        }
    }
}
