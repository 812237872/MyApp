package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.holder> {
    private final Context context;

    public RecommendAdapter(Context context) {
        this.context = context ;
        
    }

    @NonNull
    @Override
    public RecommendAdapter.holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_recommend, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendAdapter.holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class holder extends RecyclerView.ViewHolder {

        public holder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
