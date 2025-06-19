package com.example.lab14

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var isFirstFragmentVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(FirstFragment())

        val btnToggle = findViewById<Button>(R.id.btnToggleFragment)
        val btnSecondActivity = findViewById<Button>(R.id.btnGoToSecondActivity)

        btnToggle.setOnClickListener {
            if (isFirstFragmentVisible) {
                showFragment(SecondFragment(), "Совершен переход из первого фрагмента")
            } else {
                showFragment(FirstFragment(), "Совершен переход из второго фрагмента")
            }
            isFirstFragmentVisible = !isFirstFragmentVisible
        }


        btnSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showFragment(fragment: Fragment, message: String = "") {
        if (fragment is FirstFragment) {
            val bundle = Bundle()
            bundle.putString("notice", message)
            fragment.arguments = bundle
        } else if (fragment is SecondFragment) {
            val bundle = Bundle()
            bundle.putString("data", message)
            fragment.arguments = bundle
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
