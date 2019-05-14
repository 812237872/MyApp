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

import org.w3c.dom.Text;

import java.util.List;

public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.ViewHolder> {
    Context context;
    List<HotMove> list;

    public MyRecAdapter(Context context, List<HotMove> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_rec_hotmove, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String s = list.get(i).getImageUrl();
        Uri uri=Uri.parse(s);
        viewHolder.simpleDraweeView.setImageURI(uri);
        viewHolder.text_hotmove.setText(list.get(i).getName());
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
        TextView text_hotmove;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.Simple_hotmove);
            text_hotmove=itemView.findViewById(R.id.text_hotmove);
        }
    }
}
