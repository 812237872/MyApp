package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bw.movie.R ;
import com.bw.movie.adapter.CinemaFlowAdapter;
import com.bw.movie.adapter.MyRecAdapter;
import com.bw.movie.bean.hotmove.HotMove;
import com.bw.movie.bean.hotmove.HotMoveBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.activity.SreachActivity;

import java.util.ArrayList;
import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

public class FilmFragment extends Fragment implements ContractInterface.ShowInterface ,ContractInterface.ShowInterface.LikeMoveInterface{
    RecyclerCoverFlow recyclerCoverFlow;
    List<HotMove> list=new ArrayList<>();
    List<HotMove> list_mg=new ArrayList<>();
    List<HotMove> list_com=new ArrayList<>();
    CinemaFlowAdapter cinemaFlowAdapter;
    RecyclerView rec_1;
    RecyclerView rec_2;
    RecyclerView rec_3;
    MyRecAdapter myRecAdapter_1;
    MyRecAdapter myRecAdapter_2;
    MyRecAdapter myRecAdapter_3;
    ContractInterface.PresenterInterface presenterInterface;
    ImageView img_next1,img_next2,img_next3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film, null);
        recyclerCoverFlow=view.findViewById(R.id.rcf_cinema_flow);
        rec_1=view.findViewById(R.id.rec_1);
        rec_3=view.findViewById(R.id.rec_3);
        rec_2=view.findViewById(R.id.rec_2);
        img_next1=view.findViewById(R.id.img_next1);
        img_next2=view.findViewById(R.id.img_next2);
        img_next3=view.findViewById(R.id.img_next3);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenterInterface=new MyPresenter<>(this);
        cinemaFlowAdapter = new CinemaFlowAdapter(getActivity(),list);
        recyclerCoverFlow.setAdapter(cinemaFlowAdapter);
        cinemaFlowAdapter.setOnItemListener(new CinemaFlowAdapter.OnItemListener() {
            @Override
            public void onClick(int i) {
                Intent intent = new Intent(getActivity(), SreachActivity.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager manager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager manager2=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager manager3=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        rec_1.setLayoutManager(manager);
        myRecAdapter_1 = new MyRecAdapter(getActivity(),list);
        rec_1.setAdapter(myRecAdapter_1);
        rec_2.setLayoutManager(manager2);
        myRecAdapter_2=new MyRecAdapter(getActivity(),list_mg);
        rec_2.setAdapter(myRecAdapter_2);
        rec_3.setLayoutManager(manager3);
        myRecAdapter_3=new MyRecAdapter(getActivity(),list_com);
        rec_3.setAdapter(myRecAdapter_3);
        init();
        myRecAdapter_1.setListener(new MyRecAdapter.ListenerInterface() {
            @Override
            public void onClick(int i) {
                Intent intent = new Intent(getActivity(), SreachActivity.class);
                startActivity(intent);
            }
        });
        myRecAdapter_2.setListener(new MyRecAdapter.ListenerInterface() {
            @Override
            public void onClick(int i) {
                Intent intent = new Intent(getActivity(), SreachActivity.class);
                startActivity(intent);
            }
        });
        myRecAdapter_3.setListener(new MyRecAdapter.ListenerInterface() {
            @Override
            public void onClick(int i) {
                Intent intent = new Intent(getActivity(), SreachActivity.class);
                startActivity(intent);
            }
        });
        img_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SreachActivity.class);
                startActivity(intent);
            }
        });
        img_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SreachActivity.class);
                startActivity(intent);
            }
        });
        img_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SreachActivity.class);
                startActivity(intent);
            }
        });
    }


    public void init(){
        presenterInterface.toHotMove();
        presenterInterface.toMoving();
        presenterInterface.toMoveCom();
    }
    @Override
    public void showHotMove(Object o) {
        HotMoveBean hotMoveBean= (HotMoveBean) o;
        List<HotMove> result = hotMoveBean.getResult();
        if(result!=null){
            list.addAll(result);
        }

        //让轮播图显示中间的图片
        recyclerCoverFlow.smoothScrollToPosition(list.size()/2);
        cinemaFlowAdapter.notifyDataSetChanged();
        myRecAdapter_1.notifyDataSetChanged();
    }

    @Override
    public void showMoving(Object o) {
        HotMoveBean hotMoveBean= (HotMoveBean) o;
        List<HotMove> result = hotMoveBean.getResult();
        if(result!=null){
            list_mg.addAll(result);
        }

        myRecAdapter_2.notifyDataSetChanged();
    }

    @Override
    public void showMoveCom(Object o) {
        HotMoveBean hotMoveBean= (HotMoveBean) o;
        List<HotMove> result = hotMoveBean.getResult();
        if(result!=null){
        list_com.addAll(result);
        }

        myRecAdapter_3.notifyDataSetChanged();
    }

    @Override
    public void showLikeMove(Object o) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterInterface.onDestroy();
        presenterInterface=null;
    }
}
