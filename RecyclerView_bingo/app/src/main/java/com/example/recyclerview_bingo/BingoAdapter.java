package com.example.recyclerview_bingo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BingoAdapter extends RecyclerView.Adapter<BingoAdapter.MyViewHolder> {
    private static final String TAG = "BingoAdapter";
    public List<Tirage> mTirages;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvId;
        public TextView tvNum;
        public TextView tvCol;
        public MyViewHolder(LinearLayout v){
            super(v);
            tvId = v.findViewById(R.id.id);
            tvNum = v.findViewById(R.id.num);
            tvCol = v.findViewById(R.id.col);
        }
    }

    public BingoAdapter(){
        mTirages = new ArrayList<>();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create view
        LinearLayout v =(LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item, viewGroup, false);
        Log.i(TAG, "onCreateViewHolder Call");
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Tirage currentTirage = mTirages.get(position);
        holder.tvId.setText(currentTirage.id);
        holder.tvNum.setText(currentTirage.num);
        holder.tvCol.setText(currentTirage.col);
        Log.i(TAG, "onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return mTirages.size();
    }
}
