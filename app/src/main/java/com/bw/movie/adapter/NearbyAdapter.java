package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.NearbyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.holder> {
    private final Context context;
    private final List<NearbyBean.ResultBean> list;

    OnItemClickListener  mOnItemClickListener ;
    private int id;

    public NearbyAdapter(Context context, List<NearbyBean.ResultBean> list) {
        this.context = context ;
        this.list = list ;
    }

    @NonNull
    @Override
    public NearbyAdapter.holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_nearby, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NearbyAdapter.holder holder, final int i) {
        final int id = list.get(i).getId();
        String name = list.get(i).getName();
        String address = list.get(i).getAddress();
        int distance = list.get(i).getDistance();
        String logo = list.get(i).getLogo();

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
                    mOnItemClickListener.onItemClick(id, checked,i);
                }
            });

            /*holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemLinearClickListener.onItemClick(id);
                }
            });*/

        }else {
            holder.imageView.setChecked(false);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                private boolean checked;
                @Override
                public void onClick(View v) {
                    checked = holder.imageView.isChecked();
                    mOnItemClickListener.onItemClick(id, checked,i);
                }
            });

            /*holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemLinearClickListener.onItemClick(id);
                }
            });*/

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemNearbyClickListener(OnItemClickListener clickListener){
        mOnItemClickListener    = clickListener ;
    }
    public interface OnItemClickListener {
        void onItemClick(int position,boolean ck,int i);
    }


    public class holder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView ;
        TextView name , address ,distance ;
        CheckBox imageView ;

        public holder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.Nearby_SimpleDraweeView);
            name = itemView.findViewById(R.id.Nearby_name);
            address = itemView.findViewById(R.id.Nearby_address);
            distance = itemView.findViewById(R.id.Nearby_distance);
            imageView = itemView.findViewById(R.id.Nearby_CheckBox);
        }
    }
}