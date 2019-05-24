package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.RecommendAdapter;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.CinemaPresenter;
import com.bw.movie.presenter.MyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CinemaRecommend extends Fragment implements ContractInterface.CinemaRecommend {

    private XRecyclerView xRecyclerView;
    List<RecommendBean.ResultBean> list = new ArrayList<>();
    private ContractInterface.PresenterInterface presenterInterface;
    private ContractInterface.CinemaInterface cinemaInterface ;
    private RecommendAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cinema_recommend, null);
        xRecyclerView = view.findViewById(R.id.Recommend_XRecyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setPullRefreshEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecommendAdapter(getActivity(),list);
        xRecyclerView.setAdapter(adapter);

        final String sessionId = LoginActivity.sessionId;
        final int userId = LoginActivity.userId;
        final int count = 10 ;

        presenterInterface = new MyPresenter<>(this);
        //关注
        cinemaInterface = new CinemaPresenter<>(this);
        presenterInterface.pToRecommend(userId,sessionId,1,count);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenterInterface.pToRecommend(userId,sessionId,1,count);
            }
            int i = 1;
            @Override
            public void onLoadMore() {
                i++;
                presenterInterface.pToRecommend(userId,sessionId,i,count);
            }
        });

        adapter.setOnItemClickListener(new RecommendAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, boolean ck) {
                if (ck){
                    cinemaInterface.pToRAttention(position,userId,sessionId);
                }else {
                    cinemaInterface.pToRNotAttention(position,userId,sessionId);
                }
            }
        });
        adapter.setOnItemLinearClickListener(new RecommendAdapter.OnItemLinearClickListener() {
            @Override
            public void onItemClick(int position, String name, String address,String logo) {
                //Toast.makeText(getActivity(),"点击",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),CinemaDetailsActivity.class);
                intent.putExtra("cinemaId",position);
                intent.putExtra("name",name);
                intent.putExtra("address",address);
                intent.putExtra("logo",logo);
                startActivity(intent);
            }

        });



    }

    @Override
    public void showRecommend(Object object) {
        xRecyclerView.loadMoreComplete();
        xRecyclerView.refreshComplete();
        List<RecommendBean.ResultBean> resultBeans = (List<RecommendBean.ResultBean>) object;
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterInterface.onDestroy();
        presenterInterface=null;
    }
}
