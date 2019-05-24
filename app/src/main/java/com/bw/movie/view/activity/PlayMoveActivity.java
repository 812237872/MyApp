package com.bw.movie.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.acitivity.BaseActivity;
import com.bw.movie.adapter.MyPRecAdapter;
import com.bw.movie.bean.hotmove.MoveCinema;
import com.bw.movie.bean.hotmove.MoveCinemaBean;
import com.bw.movie.bean.hotmove.MoveXiang;
import com.bw.movie.bean.hotmove.MoveXiangBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class PlayMoveActivity extends BaseActivity implements ContractInterface.PlayMoveInterface {

    private int id;
    private int cid;
    private String address;
    private String name;
    TextView play_name,play_address,text_movename,text_movetype,text_moved,text_movetime,text_moveadd;
    ImageView img_play,img_playmove,img_back;
    RecyclerView rec_play;
    List<MoveCinema> list=new ArrayList<>();
    ContractInterface.PresenterInterface presenterInterface;
    MyPRecAdapter myPRecAdapter;
    String movename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_move);
        play_name=findViewById(R.id.play_name);
        play_address=findViewById(R.id.play_address);
        text_movename=findViewById(R.id.text_movename);
        text_movetype=findViewById(R.id.text_movetype);
        text_moved=findViewById(R.id.text_moved);
        text_movetime=findViewById(R.id.text_movetime);
        text_moveadd=findViewById(R.id.text_moveadd);
        img_play=findViewById(R.id.img_play);
        img_playmove=findViewById(R.id.img_playmove);
        img_back=findViewById(R.id.img_back);
        rec_play=findViewById(R.id.rec_play);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        cid = intent.getIntExtra("cid", 0);
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");
        play_name.setText(name);
        play_address.setText(address);
        presenterInterface=new MyPresenter<>(this);
        presenterInterface.toPlayMoveXiang(id);
        presenterInterface.toMoveCinema(cid,id);

        rec_play.setLayoutManager(new LinearLayoutManager(this));
        myPRecAdapter = new MyPRecAdapter(this,list);
        rec_play.setAdapter(myPRecAdapter);

        myPRecAdapter.setListener(new MyPRecAdapter.ListenerInterface() {
            @Override
            public void onClick(int pid,int i) {
                Intent intent = new Intent(PlayMoveActivity.this, GouActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("address",address);
                intent.putExtra("pid",pid);
                intent.putExtra("movename",movename);
                String beginTime = list.get(i).getBeginTime();
                intent.putExtra("beginTime",beginTime);
                String endTime = list.get(i).getEndTime();
                intent.putExtra("endTime",endTime);
                String screeningHall = list.get(i).getScreeningHall();
                intent.putExtra("screeningHall",screeningHall);
                double   price = list.get(i).getPrice();
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showPlayMoveXiang(Object o) {
        MoveXiangBean moveXiangBean= (MoveXiangBean) o;
        MoveXiang result = moveXiangBean.getResult();
        Glide.with(this).load(result.getImageUrl()).into(img_playmove);
        text_movename.setText(result.getName());
        text_movetype.setText("类型："+result.getMovieTypes());
        text_moved.setText("导演："+result.getDirector());
        text_movetime.setText("时长："+result.getDuration());
        text_moveadd.setText("产地："+result.getPlaceOrigin());
        movename = result.getName();
    }

    @Override
    public void showMoveCinema(Object o) {
        MoveCinemaBean moveCinemaBean= (MoveCinemaBean) o;
        List<MoveCinema> result = moveCinemaBean.getResult();
        list.addAll(result);
        myPRecAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterInterface.onDestroy();
        presenterInterface=null;
    }
}
