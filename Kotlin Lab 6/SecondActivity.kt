package com.example.kotlinlab6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val editText: EditText = findViewById(R.id.editTextInput)
        val button: Button = findViewById(R.id.buttonThird)

        button.setOnClickListener {
            val text = editText.text.toString()
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("EXTRA_TEXT", text)
            startActivity(intent)
        }
    }
}