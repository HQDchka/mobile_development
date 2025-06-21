package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etAge, etColor;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etColor = findViewById(R.id.etColor);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnView = findViewById(R.id.btnView);
        Button btnRename = findViewById(R.id.btnRename);
        Button btnDelete = findViewById(R.id.btnDelete);

        dbHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(v -> {
            String name = etName.getText().toString();
            int age = Integer.parseInt(etAge.getText().toString());
            String color = etColor.getText().toString();

            if (!name.isEmpty()) {
                dbHelper.addCat(name, age, color);
                Toast.makeText(this, "Кошка добавлена", Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(v -> {
            Intent intent = new Intent(this, CatListActivity.class);
            startActivity(intent);
        });

        btnRename.setOnClickListener(v ->
                dbHelper.renameLastCat("Сахарок")
        );

        btnDelete.setOnClickListener(v -> {
            dbHelper.resetAndAddDefaultCats();
            Toast.makeText(this, "База очищена и заполнена стандартными данными", Toast.LENGTH_LONG).show();
        });
    }
}