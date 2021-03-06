package com.bw.movie.view.fragment;

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
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.MyMove2Adapter;
import com.bw.movie.adapter.MyMoveAdapter;
import com.bw.movie.bean.hotmove.HotMove;
import com.bw.movie.bean.hotmove.HotMoveBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.activity.MoveXiangActivity;

import java.util.ArrayList;
import java.util.List;

public class MovingFragment extends Fragment implements ContractInterface.ShowInterface,ContractInterface.ShowInterface.LikeMoveInterface{

    RecyclerView recyclerView;
    List<HotMove> list=new ArrayList<>();
    ContractInterface.PresenterInterface presenterInterface;
    MyMove2Adapter myMoveAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.layout_moving, null);
        recyclerView=view.findViewById(R.id.moving_rec);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        myMoveAdapter = new MyMove2Adapter(getActivity(),list,this);
        recyclerView.setAdapter(myMoveAdapter);
        presenterInterface=new MyPresenter<>(this);
        toMoving();
        myMoveAdapter.setListener(new MyMove2Adapter.Listener() {
            @Override
            public void onClick(int id,int f) {
                Intent intent = new Intent(getActivity(), MoveXiangActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("f",f);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        toMoving();
    }

    public void toMoving(){
        presenterInterface.toMoving();
    }
    public void init(int id){
        presenterInterface.toLikeMove(id);
    }
    public void init1(int id){
        presenterInterface.toNoLikeMove(id);
    }
    @Override
    public void showHotMove(Object o) {

    }

    @Override
    public void showMoving(Object o) {
        list.clear();
        HotMoveBean hotMoveBean= (HotMoveBean) o;
        List<HotMove> result = hotMoveBean.getResult();
        list.addAll(result);
        myMoveAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoveCom(Object o) {

    }

    @Override
    public void showLikeMove(Object o) {
        toMoving();
        String s= (String) o;
        Toast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();
    }
}
