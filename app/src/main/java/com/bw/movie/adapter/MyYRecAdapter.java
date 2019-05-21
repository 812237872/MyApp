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
import com.bw.movie.bean.hotmove.MoveYing;
import com.bw.movie.view.activity.MoveXiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyYRecAdapter extends RecyclerView.Adapter<MyYRecAdapter.ViewHolder> {
    Context context;
    List<MoveYing> list;
    MoveXiangActivity moveXiangActivity;
    public MyYRecAdapter(Context context, List<MoveYing> list, MoveXiangActivity moveXiangActivity) {
        this.context = context;
        this.list = list;
        this.moveXiangActivity=moveXiangActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_yrec_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        String s = list.get(i).getCommentHeadPic();
        Uri uri=Uri.parse(s);
        viewHolder.sim_ying.setImageURI(uri);
        viewHolder.ping_name.setText(list.get(i).getCommentUserName());
        viewHolder.text_ping.setText(list.get(i).getCommentContent());
        String commentTime = list.get(i).getCommentTime()+"";
        String timedate = timedate(commentTime);
        viewHolder.ping_time.setText(timedate);
        viewHolder.zan_num.setText(list.get(i).getGreatNum()+"");
        viewHolder.ping_num.setText(list.get(i).getReplyNum()+"");
        int isGreat = list.get(i).getIsGreat();
        if(isGreat==1){
            viewHolder.img_zan.setChecked(true);
            viewHolder.img_zan.setBackgroundResource(R.mipmap.com_icon_praise_selected_hdpi);
        }
        viewHolder.img_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.img_zan.isChecked()){
                    moveXiangActivity.initZan(list.get(i).getCommentId());
                    viewHolder.img_zan.setBackgroundResource(R.mipmap.com_icon_praise_selected_hdpi);
                }
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
        SimpleDraweeView sim_ying;
        CheckBox img_zan,img_ping;
        TextView ping_name,text_ping,ping_time,ping_num,zan_num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sim_ying=itemView.findViewById(R.id.sim_ying);
            img_zan=itemView.findViewById(R.id.img_zan);
            img_ping=itemView.findViewById(R.id.img_ping);
            ping_name=itemView.findViewById(R.id.ping_name);
            text_ping=itemView.findViewById(R.id.text_ping);
            ping_time=itemView.findViewById(R.id.ping_time);
            ping_num=itemView.findViewById(R.id.ping_num);
            zan_num=itemView.findViewById(R.id.zan_num);
        }
    }
    public static String timedate(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
//        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(lcc));
        return times;
    }

}
