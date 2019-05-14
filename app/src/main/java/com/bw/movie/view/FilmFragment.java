package com.bw.movie.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bw.movie.R ;
import com.bw.movie.adapter.CinemaFlowAdapter;
import com.bw.movie.adapter.MyRecAdapter;
import com.bw.movie.bean.hotmove.HotMove;
import com.bw.movie.bean.hotmove.HotMoveBean;
import com.bw.movie.cont.ContractInterface;

import java.util.ArrayList;
import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

public class FilmFragment extends Fragment implements ContractInterface.ShowInterface {
    RecyclerCoverFlow recyclerCoverFlow;
    List<HotMove> list=new ArrayList<>();
    List<HotMove> list_mg=new ArrayList<>();
    List<HotMove> list_com=new ArrayList<>();
    CinemaFlowAdapter cinemaFlowAdapter;
    RecyclerView rec_1;
    RecyclerView rec_2;
    RecyclerView rec_3;
    MyRecAdapter myRecAdapte_1;
    MyRecAdapter myRecAdapte_2;
    MyRecAdapter myRecAdapte_3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film, null);
        recyclerCoverFlow=view.findViewById(R.id.rcf_cinema_flow);
        rec_1=view.findViewById(R.id.rec_1);
        rec_3=view.findViewById(R.id.rec_3);
        rec_2=view.findViewById(R.id.rec_2);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cinemaFlowAdapter = new CinemaFlowAdapter(getActivity(),list);
        recyclerCoverFlow.setAdapter(cinemaFlowAdapter);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true);
        LinearLayoutManager manager2=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true);
        LinearLayoutManager manager3=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true);
        rec_1.setLayoutManager(manager);
        myRecAdapte_1 = new MyRecAdapter(getActivity(),list);
        rec_1.setAdapter(myRecAdapte_1);
        rec_2.setLayoutManager(manager2);
        myRecAdapte_2=new MyRecAdapter(getActivity(),list_mg);
        rec_2.setAdapter(myRecAdapte_2);
        rec_3.setLayoutManager(manager3);
        myRecAdapte_3=new MyRecAdapter(getActivity(),list_com);
        rec_3.setAdapter(myRecAdapte_3);
    }

    @Override
    public void showHotMove(Object o) {
        HotMoveBean hotMoveBean= (HotMoveBean) o;
        List<HotMove> result = hotMoveBean.getResult();
        list.addAll(result);
        cinemaFlowAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoving(Object o) {
        HotMoveBean hotMoveBean= (HotMoveBean) o;
        List<HotMove> result = hotMoveBean.getResult();
        list_mg.addAll(result);
        myRecAdapte_2.notifyDataSetChanged();
    }

    @Override
    public void showMoveCom(Object o) {
        HotMoveBean hotMoveBean= (HotMoveBean) o;
        List<HotMove> result = hotMoveBean.getResult();
        list_com.addAll(result);
        myRecAdapte_3.notifyDataSetChanged();
    }
}
