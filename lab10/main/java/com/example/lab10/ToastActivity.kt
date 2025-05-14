package com.example.lab10

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ToastActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        findViewById<Button>(R.id.button_simple_toast).setOnClickListener {
            Toast.makeText(this, "Это стандартный Toast!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.button_sound_toast).setOnClickListener {
            Toast.makeText(this, "Это Toast со звуком!", Toast.LENGTH_LONG).show()
            mediaPlayer = MediaPlayer.create(this, R.raw.sound)
            mediaPlayer.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) mediaPlayer.release()
    }
}
