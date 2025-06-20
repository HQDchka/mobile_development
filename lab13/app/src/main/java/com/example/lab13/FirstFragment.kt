package com.example.lab13

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class FirstFragment : Fragment() {

    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private val images = IntArray(3)
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image1 = view.findViewById(R.id.image1)
        image2 = view.findViewById(R.id.image2)
        image3 = view.findViewById(R.id.image3)

        images[0] = R.drawable.image1
        images[1] = R.drawable.image2
        images[2] = R.drawable.image3

        image1.setImageResource(images[0])
        image2.setImageResource(images[1])
        image3.setImageResource(images[2])

        val btnShift = view.findViewById<Button>(R.id.btnShift)
        btnShift.setOnClickListener {
            shiftImages()
            playSound()
        }
    }

    private fun shiftImages() {
        val temp = images[0]
        images[0] = images[1]
        images[1] = images[2]
        images[2] = temp

        image1.setImageResource(images[0])
        image2.setImageResource(images[1])
        image3.setImageResource(images[2])
    }

    private fun playSound() {
        mediaPlayer = if (mediaPlayer == null) {
            MediaPlayer.create(requireContext(), R.raw.sound)
        } else {
            mediaPlayer!!.seekTo(0)
            mediaPlayer
        }
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }
}