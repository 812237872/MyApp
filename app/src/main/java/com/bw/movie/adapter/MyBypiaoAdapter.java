package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MyByPiao;
import com.bw.movie.view.MyBypiao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyBypiaoAdapter extends RecyclerView.Adapter<MyBypiaoAdapter.holder> {
    private final Context context;
    private final List<MyByPiao.ResultBean> list;

    public MyBypiaoAdapter(Context context, List<MyByPiao.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyBypiaoAdapter.holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.bypiao_adapter, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBypiaoAdapter.holder holder, int i) {
        //电影名称、下单时间、订单号、影院名称、放映厅、开始时间、购票数量、影片价格
        String movieName = list.get(i).getMovieName();

        long createTime = list.get(i).getCreateTime();
        Date createTime1 = new Date(createTime);
        SimpleDateFormat createTime1_format = new java.text.SimpleDateFormat("yyyy-MM-dd");

        int status = list.get(i).getStatus();

        String orderId = list.get(i).getOrderId();
        String cinemaName = list.get(i).getCinemaName();
        String screeningHall = list.get(i).getScreeningHall();
        //开始时间
        String beginTime = list.get(i).getBeginTime();
        //结束时间
        String endTime = list.get(i).getEndTime();
        int amount = list.get(i).getAmount();
        double price = list.get(i).getPrice();


        holder.ByPiao_time.setText(createTime1_format.format(createTime1));
        holder.ByPiao_Mvname.setText(movieName);
        holder.ByPiao_orderId.setText(orderId);
        holder.ByPiao_cinemaName.setText(cinemaName);
        holder.ByPiao_screeningHall.setText(screeningHall);
        holder.ByPiao_beginTime.setText(beginTime+"");
        holder.ByPiao_amount.setText(amount+"");
        holder.ByPiao_price.setText(price+"");
        if(list.get(i).getStatus()==1){
            holder.ByPiao_status.setText("代付款");
        }else{
            holder.ByPiao_status.setText("已付款");
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class holder extends RecyclerView.ViewHolder {

        Button ByPiao_status ;
        TextView ByPiao_time,ByPiao_Mvname,ByPiao_orderId,ByPiao_cinemaName,ByPiao_screeningHall
                ,ByPiao_beginTime,ByPiao_amount,ByPiao_price;
        public holder(@NonNull View itemView) {
            super(itemView);
            ByPiao_time = itemView.findViewById(R.id.ByPiao_time);
            ByPiao_Mvname = itemView.findViewById(R.id.ByPiao_Mvname);
            ByPiao_orderId = itemView.findViewById(R.id.ByPiao_orderId);
            ByPiao_cinemaName = itemView.findViewById(R.id.ByPiao_cinemaName);
            ByPiao_screeningHall = itemView.findViewById(R.id.ByPiao_screeningHall);
            ByPiao_beginTime = itemView.findViewById(R.id.ByPiao_beginTime);
            ByPiao_amount = itemView.findViewById(R.id.ByPiao_amount);
            ByPiao_price = itemView.findViewById(R.id.ByPiao_price);
            ByPiao_status = itemView.findViewById(R.id.ByPiao_status);
        }
    }
}
