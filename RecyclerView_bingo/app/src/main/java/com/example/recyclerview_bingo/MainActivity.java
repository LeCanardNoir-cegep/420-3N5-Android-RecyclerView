package com.example.recyclerview_bingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.recyclerview_bingo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public List<Tirage> tirages;
    public BingoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initRecyclerView();
        feedRecyclerView();
        changeRecyclerViewData();
    }

    private void feedRecyclerView() {
        this.adapter.mTirages.addAll(Arrays.asList(
                new Tirage(1, 'B', 2),
                new Tirage(2, 'O', 75),
                new Tirage(3, 'N', 32),
                new Tirage(4, 'B', 13)
        ));
        adapter.notifyDataSetChanged();
    }

    private void changeRecyclerViewData() {
        this.adapter.mTirages.addAll(Arrays.asList(
                new Tirage(5, 'B', 5),
                new Tirage(6, 'O', 72),
                new Tirage(7, 'N', 30),
                new Tirage(8, 'B', 10)
        ));
        adapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        GridLayoutManager lm = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(lm);

        // specify an adapter (see also next example)
        this.adapter = new BingoAdapter();
        recyclerView.setAdapter(this.adapter);
    }

}