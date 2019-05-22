package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.FlowBean;
import com.bw.movie.view.CinemaDetailsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RecyclerCoverFlowAdapter extends RecyclerView.Adapter<RecyclerCoverFlowAdapter.holder> {

    private final Context context;
    private final List<FlowBean.ResultBean> flow_list;
    OnItemFlowClick onItemFlowClick ;
    private int id;

    public RecyclerCoverFlowAdapter(Context context, List<FlowBean.ResultBean> flow_list) {
        this.context = context ;
        this.flow_list = flow_list ;
    }

    @NonNull
    @Override
    public RecyclerCoverFlowAdapter.holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_recycler_coverflow, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerCoverFlowAdapter.holder holder, final int i) {

        holder.simpleDraweeView.setImageURI(flow_list.get(i).getImageUrl());
        holder.name.setText(flow_list.get(i).getName());

        holder.simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = flow_list.get(i).getId();
                String name=flow_list.get(i).getName();
                onItemFlowClick.onItemClick(id,name);
            }
        });

    }

    @Override
    public int getItemCount() {
        return flow_list.size();
    }


    public void setOnItemFlowClick(OnItemFlowClick click){
        onItemFlowClick = click ;
    }
    public interface OnItemFlowClick{
        void onItemClick(int position,String name);
    }

    public class holder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView ;
        TextView name , time ;
        public holder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.RecyclerCoverFlowAdapter_SimpleDraweeView);
            name = itemView.findViewById(R.id.RecyclerCoverFlowAdapter_name);
        }
    }
}
