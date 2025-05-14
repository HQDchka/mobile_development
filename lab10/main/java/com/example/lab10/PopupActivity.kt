package com.example.lab10

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView;



class PopupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        findViewById<Button>(R.id.button_simple_popup).setOnClickListener { showSimplePopup(it) }
        findViewById<Button>(R.id.button_action_popup).setOnClickListener { showActionPopup(it) }
        findViewById<Button>(R.id.button_custom_popup).setOnClickListener { showCustomPopup(it) }
    }

    private fun showSimplePopup(anchor: View) {
        val popupView = TextView(this).apply {
            text = "Это простой Popup!"
            setPadding(20, 20, 20, 20)
            setBackgroundColor(Color.LTGRAY)
        }
        val popup = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        popup.showAsDropDown(anchor)
        Handler(Looper.getMainLooper()).postDelayed({ popup.dismiss() }, 2000)
    }

    private fun showActionPopup(anchor: View) {
        val popupView = layoutInflater.inflate(R.layout.popup_action, null)
        val popup = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)

        popupView.findViewById<Button>(R.id.btn_yes).setOnClickListener {
            Log.d("Popup", "Вы нажали Да")
            popup.dismiss()
        }

        popupView.findViewById<Button>(R.id.btn_no).setOnClickListener {
            Log.d("Popup", "Вы нажали Нет")
            popup.dismiss()
        }

        popup.showAsDropDown(anchor)
    }

    private fun showCustomPopup(anchor: View) {
        val popupView = layoutInflater.inflate(R.layout.popup_custom, null)
        val popup = PopupWindow(popupView, 800, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        popup.setBackgroundDrawable(ColorDrawable())
        popup.isOutsideTouchable = true

        val imageView = popupView.findViewById<ImageView>(R.id.image_view)
        imageView.setImageResource(R.drawable.image)

        popupView.findViewById<Button>(R.id.btn_close).setOnClickListener {
            popup.dismiss()
        }

        popup.showAtLocation(anchor, Gravity.CENTER, 0, 0)
    }

}
