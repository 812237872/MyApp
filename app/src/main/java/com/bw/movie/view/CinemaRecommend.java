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
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CinemaRecommend extends Fragment {

    private XRecyclerView xRecyclerView;
    List<String> list = new ArrayList<>();

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

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }
            @Override
            public void onLoadMore() {

            }
        });
    }
}
