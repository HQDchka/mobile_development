package com.example.lab14

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val et = findViewById<EditText>(R.id.etInput)
        findViewById<Button>(R.id.btnToThird).setOnClickListener {
            val text = et.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, ThirdActivity::class.java).apply {
                    putExtra("text", text)
                })
            }
        }
    }
}
