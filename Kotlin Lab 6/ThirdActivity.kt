package com.example.kotlinlab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val textView: TextView = findViewById(R.id.textViewDisplay)
        val receivedText = intent.getStringExtra("EXTRA_TEXT")
        textView.text = receivedText
    }
}
