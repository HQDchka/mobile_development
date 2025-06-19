package com.example.lab14

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val tv = view.findViewById<TextView>(R.id.tvReceived)
        val data = arguments?.getString("data") ?: "Нет данных"
        tv.text = data

        return view
    }
}
