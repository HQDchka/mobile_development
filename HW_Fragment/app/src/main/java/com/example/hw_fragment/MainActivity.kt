package com.example.hw_fragment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isSwapped = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container1, FirstFragment())
            .replace(R.id.fragment_container2, SecondFragment())
            .commit()

        val btnSwap = findViewById<Button>(R.id.btn_swap)
        btnSwap.setOnClickListener {
            swapFragments()
        }
    }

    private fun swapFragments() {
        val transaction = supportFragmentManager.beginTransaction()

        if (!isSwapped) {
            transaction.replace(R.id.fragment_container1, SecondFragment())
            transaction.replace(R.id.fragment_container2, FirstFragment())
        } else {
            transaction.replace(R.id.fragment_container1, FirstFragment())
            transaction.replace(R.id.fragment_container2, SecondFragment())
        }
        transaction.commit()
        isSwapped = !isSwapped
    }
}
