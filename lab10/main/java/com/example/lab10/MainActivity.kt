package com.example.lab10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_toast).setOnClickListener {
            startActivity(Intent(this, ToastActivity::class.java))
        }

        findViewById<Button>(R.id.button_popup).setOnClickListener {
            startActivity(Intent(this, PopupActivity::class.java))
        }
    }
}
