package com.example.lab14

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val tvNotice = view.findViewById<TextView>(R.id.tvNotice)
        val et1 = view.findViewById<EditText>(R.id.et1)
        val et2 = view.findViewById<EditText>(R.id.et2)
        val et3 = view.findViewById<EditText>(R.id.et3)
        val btnSend = view.findViewById<Button>(R.id.btnSendToSecondFragment)

        // Показ уведомления, если передано из MainActivity
        val notice = arguments?.getString("notice")
        if (!notice.isNullOrEmpty()) {
            tvNotice.text = notice
        }

        // Кнопка "Отправить на второй фрагмент"
        btnSend.setOnClickListener {
            val text1 = et1.text.toString().trim()
            val text2 = et2.text.toString().trim()
            val text3 = et3.text.toString().trim()

            if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty()) {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle()
                bundle.putString("data", "$text1; $text2; $text3")

                val secondFragment = SecondFragment()
                secondFragment.arguments = bundle

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, secondFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

        return view
    }
}
