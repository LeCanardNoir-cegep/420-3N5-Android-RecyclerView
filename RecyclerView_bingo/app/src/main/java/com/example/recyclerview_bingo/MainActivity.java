package com.example.recyclerview_bingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.recyclerview_bingo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public BingoAdapter adapter;
    public Bingo bingo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        this.bingo = new Bingo();

        initRecyclerView();
        feedRecyclerView();
    }

    private void feedRecyclerView() {
        for (int i = 0; i < 75; i++) {
            this.bingo.getNewNum();
        }
        this.adapter.mTirages = this.bingo.tirages;
        adapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        // specify an adapter (see also next example)
        this.adapter = new BingoAdapter();
        recyclerView.setAdapter(this.adapter);
    }

}