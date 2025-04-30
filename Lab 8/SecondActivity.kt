package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.displayText)

        // Получаем переданные данные из Intent
        val receivedData = intent.getStringExtra("DATA")

        /**
         * Проверяем, были ли получены данные:
         * - Если да, то выводим "Получено: $receivedData"
         * - Если нет, то пишем "Данные не переданы"
         *
         * Пример вывода 1 (если пользователь ввёл "Бомбардирро крокодилло"):
         *   Получено: Бомбардирро крокодилло
         *
         * Пример вывода 2 (если кнопка "Открыть без данных" была нажата):
         *   Данные не переданы
         */
        if (receivedData != null) {
            textView.text = "Получено: $receivedData"
        } else {
            textView.text = "Данные не переданы"
        }
    }
}