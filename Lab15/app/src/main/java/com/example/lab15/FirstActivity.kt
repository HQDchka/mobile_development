package com.example.lab15

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonLog = findViewById<Button>(R.id.button_log)

        buttonToast.setOnClickListener {
            Toast.makeText(this, "This is a toast", Toast.LENGTH_SHORT).show()
        }

        buttonLog.setOnClickListener {
            Log.d("FirstActivity", "Log pressed")
        }
    }
}