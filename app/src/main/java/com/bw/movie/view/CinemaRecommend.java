package com.bw.movie.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.RecommendAdapter;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CinemaRecommend extends Fragment implements ContractInterface.CinemaRecommend {

    private XRecyclerView xRecyclerView;
    List<String> list = new ArrayList<>();
    private ContractInterface.PresenterInterface presenterInterface;

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

        RecommendAdapter adapter = new RecommendAdapter(getActivity());
        xRecyclerView.setAdapter(adapter);

        final String sessionId = LoginActivity.sessionId;
        final int userId = LoginActivity.userId;
        final int count = 10 ;

        presenterInterface = new MyPresenter<>(this);
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
    }

    @Override
    public void showRecommend(Object object) {

    }
}
