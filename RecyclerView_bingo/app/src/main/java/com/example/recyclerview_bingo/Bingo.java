package com.example.recyclerview_bingo;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Bingo {
    public List<Tirage> tirages;
    private int tirage;
    private List<Integer> numbers;

    private static final int max = 75;
    private static final char[] letter = new char[]{'B','I','N','G','O'};
    private static final String TAG = "BINGO";

    public Bingo() {
        this.tirage = 0;
        this.tirages = new ArrayList<>();
        this.numbers = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            this.numbers.add(i);
        }
    }
    
    public void getNewNum(){
        Random random = new Random();
        int index = random.nextInt(this.numbers.size());
        Log.i(TAG, "random index: " + index);

        Integer elem = this.numbers.get(index);
        Log.i(TAG, "random elem: " + elem);

        char col = Bingo.letter[(elem -1)/ 15];
        Log.i(TAG, "col: " + col);

        Tirage t = new Tirage( ++tirage, col, elem );
        tirages.add( t );
        Log.i(TAG, "tirage: " + t);

        this.numbers.remove(elem);
        Log.i(TAG, "number: " + this.numbers);
        Log.i(TAG, "====================================");

    }
    
    private void buildBingo(){
    }
    
}
