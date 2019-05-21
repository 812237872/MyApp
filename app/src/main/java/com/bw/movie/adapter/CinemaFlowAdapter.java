package com.bw.movie.adapter;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.hotmove.HotMove;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CinemaFlowAdapter extends RecyclerView.Adapter<CinemaFlowAdapter.ViewHolder> {

    Context context;
    List<HotMove> list;
    OnItemListener onItemListener;
    private View view;

    public CinemaFlowAdapter(Context context, List<HotMove> list) {
        this.context = context;
        this.list = list;
    }
    public void setOnItemListener(OnItemListener listener){
        onItemListener=listener;
    }
    public interface OnItemListener{
        public void onClick(int i);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = View.inflate(context, R.layout.layout_xuanma, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        String imageUrl = list.get(i).getImageUrl();
        Uri uri=Uri.parse(imageUrl);
        viewHolder.simpleDraweeView.setImageURI(uri);
        viewHolder.text_move.setText(list.get(i).getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemListener.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView text_move;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            simpleDraweeView=itemView.findViewById(R.id.sim);
            text_move=itemView.findViewById(R.id.text_move);
        }
    }
}
