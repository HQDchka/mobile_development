package com.example.lab13

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isSecondFragmentShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToggle = findViewById<Button>(R.id.btnToggleFragment)
        val btnSecondActivity = findViewById<Button>(R.id.btnSecondActivity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, FirstFragment())
                .commit()
        }

        btnToggle.setOnClickListener {
            val fragment = if (isSecondFragmentShown) FirstFragment() else SecondFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
            isSecondFragmentShown = !isSecondFragmentShown
        }

        btnSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}