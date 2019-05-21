package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.hotmove.HotMove;
import com.bw.movie.view.fragment.ComMoveFragment;

import java.util.List;

public class MyMove3Adapter extends RecyclerView.Adapter<MyMove3Adapter.ViewHolder> {
    Context context;
    List<HotMove> list;
    Listener listener;
    ComMoveFragment comMoveFragment;
    public MyMove3Adapter(Context context, List<HotMove> list, ComMoveFragment comMoveFragment) {
        this.context = context;
        this.list = list;
        this.comMoveFragment=comMoveFragment;
    }
    public void setListener(Listener listener){
        this.listener=listener;
    }
    public interface Listener{
        public void onClick(int id,int followMovie);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_search_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Glide.with(context).load(list.get(i).getImageUrl()).into(viewHolder.move_img);
        viewHolder.move_name.setText(list.get(i).getName());
        viewHolder.move_jie.setText(list.get(i).getSummary());
        int movie = list.get(i).getFollowMovie();
        if(movie==1){
            viewHolder.checkBox.setChecked(true);
            viewHolder.checkBox.setBackgroundResource(R.mipmap.com_icon_collection_selected_hdpi);
        }else{
            viewHolder.checkBox.setChecked(false);
            viewHolder.checkBox.setBackgroundResource(R.mipmap.com_icon_collection_default_hdpi);
        }
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.checkBox.isChecked()){
                    comMoveFragment.init(list.get(i).getId());
//                    list.get(i).setFollowMovie(1);
                }else{
                    comMoveFragment.init1(list.get(i).getId());
//                    list.get(i).setFollowMovie(2);
                }
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(i).getId(),list.get(i).getFollowMovie());
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
        ImageView move_img;
        TextView move_name,move_jie;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            move_img=itemView.findViewById(R.id.move_img);
            move_name=itemView.findViewById(R.id.move_name);
            move_jie=itemView.findViewById(R.id.move_jie);
            checkBox=itemView.findViewById(R.id.check_collec);
        }
    }
}
