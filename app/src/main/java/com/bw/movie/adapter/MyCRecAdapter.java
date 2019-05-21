package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.hotmove.Cinema;
import com.bw.movie.view.activity.CinemaActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyCRecAdapter extends RecyclerView.Adapter<MyCRecAdapter.ViewHolder> {
    Context context;
    List<Cinema> list;
    CinemaActivity cinemaActivity;
    ListenerInterface listenerInterface;
    public MyCRecAdapter(Context context, List<Cinema> list, CinemaActivity cinemaActivity) {
        this.context = context;
        this.list = list;
        this.cinemaActivity=cinemaActivity;
    }

    public void setListener(ListenerInterface listener){
        listenerInterface=listener;
    }
    public interface ListenerInterface{
        public void onClick(int id,String name,String address);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_crec_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        String s = list.get(i).getLogo();
        Uri uri= Uri.parse(s);
        viewHolder.simpleDraweeView.setImageURI(uri);
        viewHolder.name_cine.setText(list.get(i).getName());
        viewHolder.text_cine.setText(list.get(i).getAddress());
        final int cinema = list.get(i).getFollowCinema();
        if(cinema==1) {
            viewHolder.img_xin.setChecked(true);
            viewHolder.img_xin.setBackgroundResource(R.mipmap.com_icon_collection_selected_hdpi);
        }else{
            viewHolder.img_xin.setChecked(false);
            viewHolder.img_xin.setBackgroundResource(R.mipmap.com_icon_collection_default_hdpi);
        }
        viewHolder.img_xin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.img_xin.isChecked()){
                    cinemaActivity.likeCinema(list.get(i).getId());
                    viewHolder.img_xin.setBackgroundResource(R.mipmap.com_icon_collection_selected_hdpi);
                }else{
                    cinemaActivity.disLikeCinema(list.get(i).getId());
                    viewHolder.img_xin.setBackgroundResource(R.mipmap.com_icon_collection_default_hdpi);
                }
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerInterface.onClick(list.get(i).getId(),list.get(i).getName(),list.get(i).getAddress());
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
        TextView name_cine,text_cine,cine_ju;
        CheckBox img_xin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.sim_cine);
            name_cine=itemView.findViewById(R.id.name_cine);
            text_cine=itemView.findViewById(R.id.text_cine);
            cine_ju=itemView.findViewById(R.id.cine_ju);
            img_xin=itemView.findViewById(R.id.img_xin);
        }
    }
}
