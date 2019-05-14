package com.bw.movie.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bw.movie.R ;
import com.bw.movie.adapter.CinemaFlowAdapter;
import com.bw.movie.bean.HotMove;
import com.bw.movie.bean.HotMoveBean;
import com.bw.movie.cont.ContractInterface;

import java.util.ArrayList;
import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

public class FilmFragment extends Fragment implements ContractInterface.ShowInterface {
    RecyclerCoverFlow recyclerCoverFlow;
    List<HotMove> list=new ArrayList<>();
    private CinemaFlowAdapter cinemaFlowAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film, null);
        //recyclerCoverFlow=view.findViewById(R.id.rcf_cinema_flow);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cinemaFlowAdapter = new CinemaFlowAdapter(getActivity(),list);

    }

    @Override
    public void showHotMove(Object o) {
        HotMoveBean hotMoveBean= (HotMoveBean) o;
        List<HotMove> result = hotMoveBean.getResult();
        list.addAll(result);
    }
}
