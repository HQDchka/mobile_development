package com.example.myapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    // Объявление переменных для элементов интерфейса
    private lateinit var inputField: EditText
    private lateinit var sendButton: Button
    private lateinit var openButton: Button

    /**
     * Метод onCreate вызывается при создании активности.
     * Происходит инициализация UI и обработка нажатий на кнопки.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Устанавливаем макет activity_main.xml как содержимое этой активности
        setContentView(R.layout.activity_main)

        // Инициализируем элементы интерфейса по их ID из XML
        inputField = findViewById(R.id.inputField)
        sendButton = findViewById(R.id.sendButton)
        openButton = findViewById(R.id.openButton)

        /**
         * Обработчик нажатия на кнопку "Отправить данные".
         * Проверяет, есть ли текст в поле ввода.
         * Если есть, создаёт Intent для перехода к SecondActivity и передаёт туда текст.
         */
        sendButton.setOnClickListener {
            val text = inputField.text.toString()

            // Пример ввода: пользователь ввёл "Мяу"
            if (text.isNotEmpty()) {
                // Создаём интент для запуска второй активности
                val intent = Intent(this, SecondActivity::class.java)
                // Передаём строку с ключом "DATA"
                intent.putExtra("DATA", text)
                // Запускаем SecondActivity
                startActivity(intent)
            }
        }

        /**
         * Обработчик нажатия на кнопку "Открыть без данных".
         * Просто открывает SecondActivity без передачи данных.
         */
        openButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}