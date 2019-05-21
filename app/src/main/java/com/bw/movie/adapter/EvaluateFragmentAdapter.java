package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.EvaluateFragmentBean;
import com.bw.movie.view.CinemaEvaluateFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EvaluateFragmentAdapter  extends RecyclerView.Adapter<EvaluateFragmentAdapter.holder> {

    private final Context context;
    private final List<EvaluateFragmentBean.ResultBean> resultBeans;
    EvaluateClickLisener evaluateClickLisener;

    public EvaluateFragmentAdapter(Context context, List<EvaluateFragmentBean.ResultBean> resultBeans) {
        this.context = context ;
        this.resultBeans = resultBeans ;
    }

    @NonNull
    @Override
    public EvaluateFragmentAdapter.holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cinema_evaluate_adapter, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final EvaluateFragmentAdapter.holder holder, final int i) {
        String titles = resultBeans.get(i).getCommentContent();
        String pic = resultBeans.get(i).getCommentHeadPic();
        long commentTime = resultBeans.get(i).getCommentTime();
        String name = resultBeans.get(i).getCommentUserName();
        int greatNum = resultBeans.get(i).getGreatNum();
        resultBeans.get(i).getIsGreat();


        Date date = new Date(commentTime);
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");

        if (resultBeans.get(i).getIsGreat() == 1){
            holder.checkBox.setChecked(true);
        }else {
            holder.checkBox.setChecked(true);
        }
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultBeans.get(i).getIsGreat() == 0){
                    holder.checkBox.setChecked(true);
                    resultBeans.get(i).setGreatNum(resultBeans.get(i).getGreatNum()+1);
                    holder.greatNum.setText(resultBeans.get(i).getGreatNum()+"");
                    evaluateClickLisener.getId(resultBeans.get(i).getCommentId());
                }else {
                    resultBeans.get(i).setIsGreat(1);
                    holder.checkBox.setChecked(true);
                    resultBeans.get(i).setGreatNum(resultBeans.get(i).getGreatNum());
                    holder.greatNum.setText(resultBeans.get(i).getGreatNum()+"");
                    evaluateClickLisener.getId(resultBeans.get(i).getCommentId());
                }
            }
        });


        holder.simpleDraweeView.setImageURI(pic);
        holder.name.setText(name);
        holder.titles.setText(titles);
        holder.commentTime.setText(format.format(date));
        holder.greatNum.setText(greatNum+"");

    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public void setEvaluateClickLisener(EvaluateClickLisener lisener){
        evaluateClickLisener = lisener ;
    }
    public interface EvaluateClickLisener{
        public void getId(int commentUserId);
    }

    public class holder extends RecyclerView.ViewHolder {

        SimpleDraweeView simpleDraweeView ;
        TextView name , titles , commentTime ,greatNum ;
        CheckBox checkBox ;
        public holder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.cinema_evaluate_adapter_SimpleDraweeView);
            name = itemView.findViewById(R.id.cinema_evaluate_adapter_name);
            titles = itemView.findViewById(R.id.cinema_evaluate_adapter_commentContent);
            commentTime = itemView.findViewById(R.id.cinema_evaluate_adapter_time);
            greatNum = itemView.findViewById(R.id.cinema_evaluate_adapter_zhan);
            checkBox = itemView.findViewById(R.id.cinema_evaluate_adapter_ck);
        }
    }
}
