package com.bw.movie.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.NearbyAdapter;
import com.bw.movie.bean.NearbyBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.CinemaPresenter;
import com.bw.movie.presenter.MyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CinemaNearby extends Fragment implements ContractInterface.CinemaNearby{

    private XRecyclerView xRecyclerView;
    private ContractInterface.PresenterInterface presenterInterface;
    private ContractInterface.CinemaInterface cinemaInterface ;
    List<NearbyBean.ResultBean> list = new ArrayList<>();
    private NearbyAdapter adapter;
    private String sessionId;
    private int userId;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cinema_nearby, null);
        xRecyclerView = view.findViewById(R.id.Nearby_XRecyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sessionId = LoginActivity.sessionId;
        userId = LoginActivity.userId;

        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setPullRefreshEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new NearbyAdapter(getActivity(),list);
        xRecyclerView.setAdapter(adapter);


        final int count = 10 ;

        presenterInterface = new MyPresenter<>(this);
        //关注
        cinemaInterface = new CinemaPresenter<>(this);
        presenterInterface.pToNearby(userId, sessionId,1,count);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenterInterface.pToRecommend(userId, sessionId,1,count);
            }
            int i = 1;
            @Override
            public void onLoadMore() {
                i++;
                presenterInterface.pToRecommend(userId, sessionId,i,count);
            }
        });


        adapter.setOnItemNearbyClickListener(new NearbyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, boolean ck,int i) {
                if (ck){
                    cinemaInterface.pToAttention(position,userId,sessionId);
                }else {
                    cinemaInterface.pToNotAttention(position,userId,sessionId);
                }
            }
        });


        appss();

    }

    private void appss() {

    }

    @Override
    public void showNearby(Object object) {
        xRecyclerView.loadMoreComplete();
        xRecyclerView.refreshComplete();
        List<NearbyBean.ResultBean> resultBeans = (List<NearbyBean.ResultBean>) object;
        list.addAll(resultBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showAttention(Object object) {
        Toast.makeText(getActivity(),"关注："+object,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showNotAttention(Object object) {
        Toast.makeText(getActivity(),"不关注："+object,Toast.LENGTH_SHORT).show();
    }
}
