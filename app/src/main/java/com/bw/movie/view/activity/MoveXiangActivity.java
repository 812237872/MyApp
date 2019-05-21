package com.bw.movie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.MyListAdapter;
import com.bw.movie.adapter.MyRecycleStaggerAdapter;
import com.bw.movie.adapter.MyYRecAdapter;
import com.bw.movie.bean.hotmove.Move;
import com.bw.movie.bean.hotmove.MoveBean;
import com.bw.movie.bean.hotmove.MoveXiang;
import com.bw.movie.bean.hotmove.MoveXiangBean;
import com.bw.movie.bean.hotmove.MoveYing;
import com.bw.movie.bean.hotmove.MoveYingBean;
import com.bw.movie.bean.hotmove.VideoImg;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class MoveXiangActivity extends AppCompatActivity implements ContractInterface.MoveXiangInterface,ContractInterface.ShowInterface.LikeMoveInterface{
    TextView text_x,text_name,text_xiang,text_yu,text_ju,text_ying,text_gou;
    ImageView img_move,img_back;
    CheckBox check_collect;
    //详情popup
    ImageView img_xiang,img_xia;
    TextView text_type,text_director,text_time,text_address,text_jj;
    ListView listView;
    //预告popup
    ImageView img_yu;
    VideoView videoView1,videoView2,videoView3;
    //剧照popup
    ImageView img_ju;
    RecyclerView rec_ju;
    //影评poppup
    ImageView img_ying,img_write;
    RecyclerView rec_ying;
    RelativeLayout rl_comment;
    EditText comment_content;
    TextView hide_down;
    Button comment_send;
    ContractInterface.PresenterInterface presenterInterface;
    int f;
    int id;
    String s;
    List<String> s_list=new ArrayList<>();
    List<VideoImg> v_list=new ArrayList<>();
    List<String> i_list=new ArrayList<>();
    List<MoveYing> m_list=new ArrayList<>();
    MyListAdapter myListAdapter;
    PopupWindow xiang_popup;
    PopupWindow yu_popup;
    PopupWindow ju_popup;
    PopupWindow ying_popup;
    private MyRecycleStaggerAdapter myRecycleStaggerAdapter;
    private MyYRecAdapter myYRecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_xiang);
        text_x=findViewById(R.id.text_x);
        text_name=findViewById(R.id.text_name);
        text_xiang=findViewById(R.id.text_xiang);
        text_yu=findViewById(R.id.text_yu);
        text_ju=findViewById(R.id.text_ju);
        text_ying=findViewById(R.id.text_ying);
        text_gou=findViewById(R.id.text_gou);
        img_move=findViewById(R.id.img_move);
        img_back=findViewById(R.id.img_back);
        check_collect=findViewById(R.id.check_collect);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        f = intent.getIntExtra("f", 0);

        presenterInterface=new MyPresenter<>(this);
        presenterInterface.toMoveXiang(id);
        presenterInterface.toMoveXiangs(id);
        init();
        popup1();
        popup2();
        popup3();
        popup4();
        check_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_collect.isChecked()){
                    presenterInterface.toLikeMove(id);
                    f=1;
                }else{
                    presenterInterface.toNoLikeMove(id);
                    f=2;
                }
            }
        });
        text_gou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoveXiangActivity.this, CinemaActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",s);
                startActivity(intent);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void init(){
        if(f==1){
            check_collect.setChecked(true);
            check_collect.setBackgroundResource(R.mipmap.com_icon_collection_selected_hdpi);
        }else{
            check_collect.setChecked(false);
            check_collect.setBackgroundResource(R.mipmap.com_icon_collection_default_hdpi);
        }
    }
    public void popup1(){
        View view = View.inflate(MoveXiangActivity.this, R.layout.layout_xiang_popup, null);
        xiang_popup = new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,1500);
        xiang_popup.setContentView(view);
        img_xiang=view.findViewById(R.id.img_xiang);
        img_xia=view.findViewById(R.id.img_xia);
        text_type=view.findViewById(R.id.text_type);
        text_director=view.findViewById(R.id.text_director);
        text_time=view.findViewById(R.id.text_time);
        text_address=view.findViewById(R.id.text_address);
        text_jj=view.findViewById(R.id.text_jj);
        listView=view.findViewById(R.id.listview);
        myListAdapter = new MyListAdapter(MoveXiangActivity.this,s_list);
        listView.setAdapter(myListAdapter);
        xiang_popup.setFocusable(true);
        xiang_popup.setTouchable(true);
        text_xiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = View.inflate(MoveXiangActivity.this, R.layout.activity_move_xiang, null);
                xiang_popup.showAtLocation(view,Gravity.BOTTOM,0,0);
                text_x.setText(s);
            }
        });
        xiang_popup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                text_x.setText("电影详情");
            }
        });
        img_xia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xiang_popup.dismiss();
                text_x.setText("电影详情");
            }
        });
    }
    public void popup2(){
        View view = View.inflate(MoveXiangActivity.this, R.layout.layout_yu_popup, null);
        yu_popup = new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,1500);
        yu_popup.setContentView(view);
        xiang_popup.setFocusable(true);
        xiang_popup.setTouchable(true);
        img_yu=view.findViewById(R.id.img_yu);
        videoView1=view.findViewById(R.id.videoView1);
        videoView2=view.findViewById(R.id.videoView2);
        videoView3=view.findViewById(R.id.videoView3);
        img_yu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xiang_popup.dismiss();
            }
        });
        text_yu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(MoveXiangActivity.this, R.layout.activity_move_xiang, null);
                yu_popup.showAtLocation(view,Gravity.BOTTOM,0,0);
                videoView1.setVideoPath(v_list.get(0).getVideoUrl());
                videoView1.setMediaController(new MediaController(MoveXiangActivity.this));
                videoView1.requestFocus();
                videoView1.start();
                videoView2.setVideoPath(v_list.get(1).getVideoUrl());
                videoView2.setMediaController(new MediaController(MoveXiangActivity.this));
                videoView2.requestFocus();
                videoView2.start();
                videoView3.setVideoPath(v_list.get(2).getVideoUrl());
                videoView3.setMediaController(new MediaController(MoveXiangActivity.this));
                videoView3.requestFocus();
                videoView3.start();
            }
        });
        img_yu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yu_popup.dismiss();
            }
        });
    }
    public void popup3(){
        View view = View.inflate(MoveXiangActivity.this, R.layout.layout_ju_popup, null);
        img_ju=view.findViewById(R.id.img_ju);
        rec_ju=view.findViewById(R.id.rec_ju);
        ju_popup = new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,1500);
        ju_popup.setContentView(view);
        ju_popup.setFocusable(true);
        ju_popup.setTouchable(true);
        myRecycleStaggerAdapter = new MyRecycleStaggerAdapter(this,i_list);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rec_ju.setLayoutManager(manager);
        rec_ju.setAdapter(myRecycleStaggerAdapter);
        text_ju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(MoveXiangActivity.this, R.layout.activity_move_xiang, null);
                ju_popup.showAtLocation(view,Gravity.BOTTOM,0,0);
            }
        });
        img_ju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ju_popup.dismiss();
            }
        });
    }

    public void popup4(){
        queryMoveying();
        View view = View.inflate(MoveXiangActivity.this, R.layout.layout_ping_popup, null);
        img_ying=view.findViewById(R.id.img_ying);
        rec_ying=view.findViewById(R.id.rec_ying);
        rl_comment=view.findViewById(R.id.rl_comment);
        comment_content=view.findViewById(R.id.comment_content);
        hide_down=view.findViewById(R.id.hide_down);
        comment_send=view.findViewById(R.id.comment_send);
        img_write=view.findViewById(R.id.img_write);

        ying_popup = new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,1500);
        ying_popup.setContentView(view);
        ying_popup.setFocusable(true);
        ying_popup.setTouchable(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rec_ying.setLayoutManager(manager);
        myYRecAdapter = new MyYRecAdapter(this,m_list,this);
        rec_ying.setAdapter(myYRecAdapter);
        text_ying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(MoveXiangActivity.this, R.layout.activity_move_xiang, null);
                ying_popup.showAtLocation(view,Gravity.BOTTOM,0,0);
            }
        });
        img_ying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ying_popup.dismiss();
            }
        });
        img_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 弹出输入法
                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                // 显示评论框
                img_write.setVisibility(View.GONE);
                rl_comment.setVisibility(View.VISIBLE);
            }
        });
        hide_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 隐藏评论框
                img_write.setVisibility(View.VISIBLE);
                rl_comment.setVisibility(View.GONE);
                // 隐藏输入法，然后暂存当前输入框的内容，方便下次使用
                InputMethodManager im = (InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(comment_content.getWindowToken(), 0);
            }
        });
        comment_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comment_content.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "评论不能为空！", Toast.LENGTH_SHORT).show();
                } else {
                    // 生成评论数据
                    String s = comment_content.getText().toString();
                    presenterInterface.toMovePing(id,s);
                    // 发送完，清空输入框
                    comment_content.setText("");
                }
            }
        });
    }

    public void queryMoveying(){
        presenterInterface.toMoveYing(id);
    }
    public void initZan(int id){
        presenterInterface.toMoveZan(id);
    }

    @Override
    public void showMove(Object o) {
        MoveBean moveBean= (MoveBean) o;
        Move result = moveBean.getResult();
        text_name.setText(result.getName());
        s=result.getName();
        Glide.with(this).load(result.getImageUrl()).into(img_move);
    }

    @Override
    public void showMoves(Object o) {
        MoveXiangBean moveXiangBean= (MoveXiangBean) o;
        MoveXiang result = moveXiangBean.getResult();
        Glide.with(this).load(result.getImageUrl()).into(img_xiang);
        text_type.setText("类型："+result.getMovieTypes());
        text_director.setText("导演："+result.getDirector());
        text_time.setText("时长："+result.getDuration());
        text_address.setText("产地："+result.getPlaceOrigin());
        text_jj.setText(result.getSummary());
        String starring = result.getStarring();
        String[] split = starring.split(",");
        for (int i = 0; i <split.length ; i++) {
            s_list.add(split[i]);
        }
        myListAdapter.notifyDataSetChanged();
        v_list.addAll(result.getShortFilmList());
        i_list.addAll(result.getPosterList());
        myRecycleStaggerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoveYin(Object o) {
        m_list.clear();
        MoveYingBean moveYingBean= (MoveYingBean) o;
        List<MoveYing> result = moveYingBean.getResult();
        m_list.addAll(result);
        Log.e("tags",m_list.toString());
        myYRecAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoveZan(Object o) {
        String s= (String) o;
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        queryMoveying();
    }

    @Override
    public void showMovePing(Object o) {
        String s= (String) o;
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        queryMoveying();
    }

    @Override
    public void showLikeMove(Object o) {
        String s= (String) o;
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterInterface.onDestroy();
        presenterInterface=null;
    }
}
