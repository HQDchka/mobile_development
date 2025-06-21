package com.example.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cats.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Кошечки";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Имя";
    public static final String COLUMN_AGE = "Возраст"; // произвольное поле
    public static final String COLUMN_COLOR = "Цвет"; // произвольное поле
    public static final String COLUMN_TIMESTAMP = "ВремяДобавления";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_AGE + " INTEGER, " +
                    COLUMN_COLOR + " TEXT, " +
                    COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addCat(String name, int age, String color) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);
        values.put(COLUMN_COLOR, color);
        return db.insert(TABLE_NAME, null, values);
    }

    public List<Cat> getAllCats() {
        List<Cat> cats = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                Cat cat = new Cat(
                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_AGE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_COLOR)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIMESTAMP))
                );
                cats.add(cat);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return cats;
    }

    public void renameLastCat(String newName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, newName);
        db.update(TABLE_NAME, values, COLUMN_ID + " = (SELECT MAX(" + COLUMN_ID + ") FROM " + TABLE_NAME + ")", null);
    }

    public void resetAndAddDefaultCats() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);

        addDefaultCats(db);
    }

    private void addDefaultCats(SQLiteDatabase db) {
        ContentValues values;

        String[][] defaultCats = {
                {"Мурка", "3", "Рыжий"},
                {"Барсик", "5", "Серый"},
                {"Люся", "2", "Чёрный"},
                {"Плюш", "4", "Белый"},
                {"Рыжик", "6", "Оранжевый"}
        };

        for (String[] data : defaultCats) {
            values = new ContentValues();
            values.put(COLUMN_NAME, data[0]);
            values.put(COLUMN_AGE, Integer.parseInt(data[1]));
            values.put(COLUMN_COLOR, data[2]);
            db.insert(TABLE_NAME, null, values);
        }
    }
}