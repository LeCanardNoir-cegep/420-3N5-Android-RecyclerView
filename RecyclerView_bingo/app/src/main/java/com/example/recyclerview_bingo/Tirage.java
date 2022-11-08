package com.example.recyclerview_bingo;

import androidx.annotation.NonNull;

public class Tirage {
    public int id;
    public char col;
    public int num;

    public Tirage(int id, char col, int num) {
        this.id = id;
        this.col = col;
        this.num = num;
    }

    @NonNull
    @Override
    public String toString() {
        return "id: " + id + ", col: " + col + ", num: " + num;
    }
}
