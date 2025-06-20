package com.example.lab13

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {

    private lateinit var fragmentLayout: View
    private var initialX = 0f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentLayout = view.findViewById(R.id.fragment_container)
        val button = view.findViewById<Button>(R.id.btnChangeColor)

        button.setOnClickListener {
            fragmentLayout.setBackgroundColor(
                ContextCompat.getColor(requireContext(), R.color.blue)
            )
        }

        button.setOnLongClickListener {
            fragmentLayout.setBackgroundColor(
                ContextCompat.getColor(requireContext(), R.color.purple)
            )
            true
        }

        fragmentLayout.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    initialX = event.x
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    val deltaX = event.x - initialX
                    if (Math.abs(deltaX) > 50) {
                        v.setBackgroundColor(Color.parseColor("#E91E63"))
                        true
                    } else {
                        false
                    }
                }
                else -> false
            }
        }
    }
}