package com.example.lab3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CatListActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_list);

        ListView listView = findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(this);

        List<Cat> cats = dbHelper.getAllCats();
        ArrayAdapter<Cat> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cats);
        listView.setAdapter(adapter);
    }
}