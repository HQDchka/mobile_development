package com.example.lab15

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonActivity1 = findViewById<Button>(R.id.button_activity_1)
        val buttonActivity2 = findViewById<Button>(R.id.button_activity_2)
        val buttonPlaySound = findViewById<Button>(R.id.button_play_sound)

        buttonActivity1.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        buttonActivity2.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        buttonPlaySound.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(this, R.raw.sound)
            mediaPlayer.start()
        }
    }
}