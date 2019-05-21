package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.MyMoveAdapter;
import com.bw.movie.bean.hotmove.HotMove;
import com.bw.movie.bean.hotmove.HotMoveBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.activity.MoveXiangActivity;

import java.util.ArrayList;
import java.util.List;

public class HotMoveFragment extends Fragment implements ContractInterface.ShowInterface,ContractInterface.ShowInterface.LikeMoveInterface {

    RecyclerView recyclerView;
    List<HotMove> list=new ArrayList<>();
    MyMoveAdapter myMoveAdapter;
    ContractInterface.PresenterInterface presenterInterface;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.layout_hotmove, null);
        recyclerView=view.findViewById(R.id.hot_move_rec);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        myMoveAdapter = new MyMoveAdapter(getActivity(),list,this);
        recyclerView.setAdapter(myMoveAdapter);
        presenterInterface=new MyPresenter<>(this);
        initMove();
        myMoveAdapter.setListener(new MyMoveAdapter.Listener() {
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
        initMove();
    }

    public void initMove(){
        presenterInterface.toHotMove();
    }
    public void init(int id){
        presenterInterface.toLikeMove(id);
    }
    public void init1(int id){
        presenterInterface.toNoLikeMove(id);
    }
    @Override
    public void showHotMove(Object o) {
        list.clear();
        HotMoveBean hotMoveBean= (HotMoveBean) o;
        List<HotMove> result = hotMoveBean.getResult();
        list.addAll(result);
        Log.e("tag",list.toString());
        myMoveAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoving(Object o) {

    }

    @Override
    public void showMoveCom(Object o) {

    }

    @Override
    public void showLikeMove(Object o) {
        initMove();
        String s= (String) o;
        Toast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();

    }
}
