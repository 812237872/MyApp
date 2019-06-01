package com.bw.movie.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bw.movie.R;
import com.bw.movie.adapter.MyBypiaoAdapter;
import com.bw.movie.bean.MyByPiao;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyBypiao extends AppCompatActivity implements ContractInterface.MyBypiao {


    private RadioButton record_film,record_cinema;
    private ImageView record_finish ;
    private XRecyclerView record_recyclerView;
    private ContractInterface.PresenterInterface presenterInterface;
    List<MyByPiao.ResultBean> list = new ArrayList<>();
    private MyBypiaoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bypiao);
        record_film = findViewById(R.id.record_film);
        record_cinema = findViewById(R.id.record_cinema);
        record_recyclerView = findViewById(R.id.record_RecyclerView);
        record_finish = findViewById(R.id.record_finish);

        presenterInterface = new MyPresenter<>(this);

        record_recyclerView.setLoadingMoreEnabled(true);
        record_recyclerView.setPullRefreshEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        record_recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyBypiaoAdapter(this,list);
        record_recyclerView.setAdapter(adapter);

        presenterInterface.pToMyBypiao(LoginActivity.userId,LoginActivity.sessionId,1,10,1);

        record_film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                presenterInterface.pToMyBypiao(LoginActivity.userId,LoginActivity.sessionId,1,10,1);
            }
        });

        record_cinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                presenterInterface.pToMyBypiao(LoginActivity.userId,LoginActivity.sessionId,1,10,2);
            }
        });

        record_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void MyBypiao(Object object) {
        record_recyclerView.loadMoreComplete();
        record_recyclerView.refreshComplete();
        List<MyByPiao.ResultBean> resultBeans = (List<MyByPiao.ResultBean>) object;
        list.addAll(resultBeans);
        adapter.notifyDataSetChanged();
    }
}
