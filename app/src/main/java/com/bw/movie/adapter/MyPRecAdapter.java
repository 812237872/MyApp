package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.hotmove.MoveCinema;

import java.util.List;

public class MyPRecAdapter extends RecyclerView.Adapter<MyPRecAdapter.ViewHolder> {
    Context context;
    List<MoveCinema> list;
    ListenerInterface listenerInterface;
    public MyPRecAdapter(Context context, List<MoveCinema> list) {
        this.context = context;
        this.list = list;
    }
    public void setListener(ListenerInterface listener){
        listenerInterface=listener;
    }
    public interface ListenerInterface{
        public void onClick(int pid,int i);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_prec_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.prec_name.setText(list.get(i).getScreeningHall());
        viewHolder.prec_begin.setText(list.get(i).getBeginTime());
        viewHolder.prec_end.setText(list.get(i).getEndTime());
        viewHolder.rec_price.setText(list.get(i).getPrice()+"");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerInterface.onClick(list.get(i).getId(),i);
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
        TextView prec_name,prec_begin,prec_end,rec_price;
        ImageView img_next;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prec_name=itemView.findViewById(R.id.prec_name);
            prec_begin=itemView.findViewById(R.id.prec_begin);
            prec_end=itemView.findViewById(R.id.prec_end);
            rec_price=itemView.findViewById(R.id.rec_price);
            img_next=itemView.findViewById(R.id.img_next);
        }
    }
}
