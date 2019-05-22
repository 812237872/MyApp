package com.bw.movie.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.MyCRecAdapter;
import com.bw.movie.bean.hotmove.Cinema;
import com.bw.movie.bean.hotmove.CinemaBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class CinemaActivity extends AppCompatActivity implements ContractInterface.CinemasInterface {

    private int id;
    private String name;
    TextView movie_name;
    RecyclerView rec_cine;
    ImageView cine_back;
    List<Cinema> list=new ArrayList<>();
    private MyCRecAdapter myCRecAdapter;
    ContractInterface.PresenterInterface presenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);
        movie_name=findViewById(R.id.movie_name);
        rec_cine=findViewById(R.id.rec_cine);
        cine_back=findViewById(R.id.cine_back);

        presenterInterface=new MyPresenter<>(this);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        name = intent.getStringExtra("name");

        movie_name.setText(name);
        rec_cine.setLayoutManager(new LinearLayoutManager(this));
        myCRecAdapter = new MyCRecAdapter(this,list,this);
        rec_cine.setAdapter(myCRecAdapter);
        init();
        cine_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        myCRecAdapter.setListener(new MyCRecAdapter.ListenerInterface() {
            @Override
            public void onClick(int cid,String name,String address) {
                Intent intent = new Intent(CinemaActivity.this, PlayMoveActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("cid",cid);
                intent.putExtra("name",name);
                intent.putExtra("address",address);
                startActivity(intent);
            }
        });
    }

    public void init(){
     presenterInterface.toCinema(id);
    }
    public void likeCinema(int id){
        presenterInterface.toLikeCinema(id);
    }
    public void disLikeCinema(int id){
        presenterInterface.toDisLikeCinema(id);
    }
    @Override
    public void showCinema(Object o) {
        list.clear();
        CinemaBean cinemaBean= (CinemaBean) o;
        List<Cinema> result = cinemaBean.getResult();
        list.addAll(result);
        myCRecAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLikeCinema(Object o) {
        String s= (String) o;
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        init();
    }
}
