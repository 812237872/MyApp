package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.MyFragmentVipBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment implements ContractInterface.MyFragmentVip {

    private String sessionId;
    private int userId;
    private SimpleDraweeView touxiang;
    private TextView mine_name;
    private Button qiandao;
    private ContractInterface.PresenterInterface presenterInterface;
    private ImageView myinfo,back_login,mine_like,mine_yijian,mine_bypiao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, null);
        touxiang = view.findViewById(R.id.mine_head);
        mine_name = view.findViewById(R.id.mine_name);
        qiandao = view.findViewById(R.id.qiandao);
        //我的信息
        myinfo = view.findViewById(R.id.mine_myinfo);
        //退出登录
        back_login = view.findViewById(R.id.back_login);
        //我的关注
        mine_like = view.findViewById(R.id.mine_like);
        //意见反馈
        mine_yijian = view.findViewById(R.id.mine_yijian);
        //购票记录
        mine_bypiao = view.findViewById(R.id.mine_bypiao);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        sessionId = LoginActivity.sessionId;
        userId = LoginActivity.userId;
        presenterInterface = new MyPresenter<>(this);


        presenterInterface.pToMyFragmentVip(userId,sessionId);

        //签到
        qiandao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterInterface.pToMyFragmentSignl(userId,sessionId);
            }
        });
        //我的信息
        myinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MyMessageActivity.class);
                startActivity(intent);
            }
        });
        //退出登录
        back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        //意见反馈
        mine_yijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext() , MyFeedBack.class);
                startActivity(intent);
            }
        });
        //我们的关注
        mine_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext() , MyAttention.class);
                startActivity(intent);
            }
        });
        //购票记录
        mine_bypiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext() , MyBypiao.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void showMyVip(Object object) {
        MyFragmentVipBean myFragmentVipBean = (MyFragmentVipBean) object;
        String get_pic = myFragmentVipBean.getResult().getHeadPic();
        String get_name = myFragmentVipBean.getResult().getNickName();
        mine_name.setText(get_name);
        touxiang.setImageURI(get_pic);
    }

    @Override
    public void showSignl(Object object) {
        Toast.makeText(getContext(),object+"",Toast.LENGTH_SHORT).show();
    }

}
