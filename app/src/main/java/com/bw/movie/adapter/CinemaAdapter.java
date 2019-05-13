package com.bw.movie.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class CinemaAdapter extends FragmentPagerAdapter {
    private final List<Fragment> list;
    private final String[] titles;

    public CinemaAdapter(FragmentManager fm, List<Fragment> list, String[] titles) {
        super(fm);
        this.list = list ;
        this.titles = titles ;

    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
