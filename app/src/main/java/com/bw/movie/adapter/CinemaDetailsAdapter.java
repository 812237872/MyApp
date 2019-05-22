package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.view.CinemaDetailsActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CinemaDetailsAdapter extends RecyclerView.Adapter<CinemaDetailsAdapter.holder> {
    private final Context context;
    private final List<DetailsBean.ResultBean> list;
    Listener listener;
    public CinemaDetailsAdapter(Context context, List<DetailsBean.ResultBean> list) {
        this.context = context ;
        this.list = list ;
    }
    public void setListener(Listener listener){
        this.listener=listener;
    }

    public interface Listener{
        public void onClick(int i);
    }
    @NonNull
    @Override
    public CinemaDetailsAdapter.holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cinema_details_adapter, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, final int i) {
        String screeningHall = list.get(i).getScreeningHall();
        double price = list.get(i).getPrice();
        String beginTime = list.get(i).getBeginTime();
        String endTime = list.get(i).getEndTime();


        /*Date date = new Date(beginTime);
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");*/

        holder.name.setText(screeningHall);
        holder.price.setText("￥"+price);
        holder.time.setText(beginTime+"——"+endTime);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class holder extends RecyclerView.ViewHolder {
        TextView price , name ,time ;
        ImageView imageView ;
        public holder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.CinemaDetailsAdapter_time);
            price = itemView.findViewById(R.id.CinemaDetailsAdapter_price);
            name = itemView.findViewById(R.id.CinemaDetailsAdapter_name);
            imageView = itemView.findViewById(R.id.CinemaDetailsAdapter_imager);
        }
    }
}
