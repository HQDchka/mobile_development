package com.example.kotlinlab6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstButton: Button = findViewById(R.id.buttonFirst)
        val secondButton: Button = findViewById(R.id.buttonSecond)

        firstButton.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        secondButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
