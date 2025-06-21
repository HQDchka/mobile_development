package com.example.lab3;

public class Cat {
    private int id;
    private String name;
    private int age;
    private String color;
    private String timestamp;

    public Cat(int id, String name, int age, String color, String timestamp) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.color = color;
        this.timestamp = timestamp;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getColor() { return color; }
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Имя: " + name + "\n" +
                "Возраст: " + age + "\n" +
                "Цвет: " + color + "\n" +
                "Дата: " + timestamp;
    }
}