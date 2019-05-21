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
import com.bw.movie.adapter.EvaluateFragmentAdapter;
import com.bw.movie.bean.EvaluateFragmentBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CinemaEvaluateFragment extends Fragment implements ContractInterface.CinemaEvaluateFragment {

    private XRecyclerView xRecyclerView;
    List<EvaluateFragmentBean.ResultBean> resultBeans = new ArrayList<>();
    private EvaluateFragmentAdapter adapter;
    private ContractInterface.PresenterInterface presenterInterface;
    private int userId;
    private String sessionId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cinema_evaluate, null);
        xRecyclerView = view.findViewById(R.id.fragment_cinema_evaluate_XRecyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final int str = (int) getArguments().get("str");
        presenterInterface = new MyPresenter<>(this);

        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setPullRefreshEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new EvaluateFragmentAdapter(getActivity(),resultBeans);
        xRecyclerView.setAdapter(adapter);
        userId = LoginActivity.userId;
        sessionId = LoginActivity.sessionId;
        //Log.e("影院点赞ID","user："+LoginActivity.userId+"    sessionId："+LoginActivity.sessionId);

        presenterInterface.pToEvaluateFragment(str,1,10);



        adapter.setEvaluateClickLisener(new EvaluateFragmentAdapter.EvaluateClickLisener() {
            @Override
            public void getId(int commentUserId) {
                //Log.e("影院点赞ID",""+commentUserId+"user"+LoginActivity.userId+"sessionId"+LoginActivity.sessionId+"commentUserId"+commentUserId);
                presenterInterface.pToEvaluateFragmentGreat(userId,sessionId,commentUserId);
            }
        });

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenterInterface.pToEvaluateFragment(str,1,10);
            }

            int page = 1 ;
            @Override
            public void onLoadMore() {
                page ++ ;
                presenterInterface.pToEvaluateFragment(str,page,10);
            }
        });




    }

    @Override
    public void showEvaluateFragment(Object object) {
        xRecyclerView.loadMoreComplete();
        xRecyclerView.refreshComplete();
        List<EvaluateFragmentBean.ResultBean> resultB = (List<EvaluateFragmentBean.ResultBean>) object;
        resultBeans.addAll(resultB);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showEvaluateFragmentGreat(Object object) {
        Toast.makeText(getContext(),""+object,Toast.LENGTH_SHORT).show();
    }
}
