package com.bw.movie.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.CinemaAdapter;

import java.util.ArrayList;
import java.util.List;

public class CinemaFragment extends Fragment {

    List<Fragment> list = new ArrayList<>();
    private String[] titles = {"推荐影院","附近影院"};
    private CinemaAdapter adapter;
    private RadioGroup radioGroup;
    private CinemaNearby cinemaNearby;
    private CinemaRecommend cinemaRecommend;
    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cinema, null);
        radioGroup = view.findViewById(R.id.cinema_RadioGroup);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cinemaNearby = new CinemaNearby();
        cinemaRecommend = new CinemaRecommend();

        manager = getFragmentManager();
        manager.beginTransaction()
                .add(R.id.cinema_FrameLayout ,cinemaRecommend)
                .add(R.id.cinema_FrameLayout ,cinemaNearby)
                .show(cinemaRecommend)
                .hide(cinemaNearby)
                .commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.cinema_Radio1:
                        transaction.show(cinemaRecommend)
                                .hide(cinemaNearby);
                        break;
                    case R.id.cinema_Radio2:
                        transaction.show(cinemaNearby)
                                .hide(cinemaRecommend);
                        break;
                }
                transaction.commit();
            }
        });


    }
}
