package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.holder> {
    private final Context context;
    private final List<RecommendBean.ResultBean> list;

    OnItemClickListener mOnItemClickListener ;
    OnItemLinearClickListener onItemLinearClickListener ;

    public RecommendAdapter(Context context, List<RecommendBean.ResultBean> list) {
        this.context = context ;
        this.list = list ;
    }

    @NonNull
    @Override
    public RecommendAdapter.holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_recommend, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecommendAdapter.holder holder, final int i) {
        final int id = list.get(i).getId();
        final String name = list.get(i).getName();
        final String address = list.get(i).getAddress();
        int distance = list.get(i).getDistance();
        final String logo = list.get(i).getLogo();


        holder.simpleDraweeView.setImageURI(logo);
        holder.name.setText(name);
        holder.address.setText(address);
        holder.distance.setText(distance+"");

        if (list.get(i).getFollowCinema()==1){
            holder.imageView.setChecked(true);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                private boolean checked;
                @Override
                public void onClick(View v) {
                    checked = holder.imageView.isChecked();
                    mOnItemClickListener.onItemClick(id, checked);
                }
            });

            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemLinearClickListener.onItemClick(id,name,address,logo);
                }
            });

        }else {
            holder.imageView.setChecked(false);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                private boolean checked;
                @Override
                public void onClick(View v) {
                    checked = holder.imageView.isChecked();
                    mOnItemClickListener.onItemClick(id, checked);
                }
            });

            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemLinearClickListener.onItemClick(id,name,address,logo);
                }
            });

        }





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //接口回调
    public void setOnItemClickListener(OnItemClickListener clickListener){
        mOnItemClickListener    = clickListener ;
    }
    public interface OnItemClickListener {
        void onItemClick(int position,boolean ck);
    }

    public void setOnItemLinearClickListener(OnItemLinearClickListener listener){
        onItemLinearClickListener = listener ;
    }
    public interface OnItemLinearClickListener {
        void onItemClick(int position,String name , String address,String logo);
    }





    public class holder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView ;
        TextView name , address ,distance ;
        CheckBox imageView ;
        LinearLayout linearLayout;

        public holder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.RecommendAdapter_SimpleDraweeView);
            name = itemView.findViewById(R.id.RecommendAdapter_name);
            address = itemView.findViewById(R.id.RecommendAdapter_address);
            distance = itemView.findViewById(R.id.RecommendAdapter_distance);
            imageView = itemView.findViewById(R.id.RecommendAdapter_CheckBox);
            linearLayout = itemView.findViewById(R.id.RecommendAdapter_LinearLayout);
        }
    }
}
