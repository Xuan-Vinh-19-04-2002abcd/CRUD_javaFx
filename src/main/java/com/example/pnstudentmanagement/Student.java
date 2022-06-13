package com.example.pnstudentmanagement;

public class Student {
    int id;
    public String name;
    public float scrore;

    Student(int id, String name, float score) {
        this.id = id;
        this.name = name;
        this.scrore = score;
    }

    Student( String name, float score) {
        this.name = name;
        this.scrore = score;
    }
}
