package com.example.numerology;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int id;
    private int number;
    private char letter;
    @SerializedName("desc")
    private String text;

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }

    public String getText() {
        return text;
    }
}
