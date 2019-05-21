package com.bw.movie.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.DetailsFragmentBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class CinemaDetailsFragment extends Fragment implements ContractInterface.CinemaDetailsFragment {

    private TextView Text_address;
    private TextView Text_phone;
    private SharedPreferences sp;
    private ContractInterface.PresenterInterface presenterInterface;
    private TextView viewById;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cinema_details, null);
        Text_address = view.findViewById(R.id.fragment_cinema_details_address);
        Text_phone = view.findViewById(R.id.fragment_cinema_details_phone);
        viewById = view.findViewById(R.id.fragment_cinema_details_hoo);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int str = (int) getArguments().get("str");
        //Log.e("你看看详情", "onActivityCreated: "+str );

        presenterInterface = new MyPresenter<>(this);

        /*sp = getActivity().getSharedPreferences("Name", Context.MODE_PRIVATE);
        String Sp_address = sp.getString("address", "");
        String Sp_phone = sp.getString("phone", "");
        String Sp_vehicleRoute = sp.getString("vehicleRoute", "");

        Log.e("AGE" ,"sp详情"+Sp_address+"sp电话"+Sp_phone);

        Text_address.setText(Sp_address);
        Text_phone.setText(Sp_phone);*/


        presenterInterface.pToDetailsFragment(str);


    }

    @Override
    public void showDetailsFragment(Object object) {

        Log.e("AGE" ,"数据"+object);
        DetailsFragmentBean.ResultBean resultBean  = (DetailsFragmentBean.ResultBean) object;
        String address = resultBean.getAddress();
        String phone = resultBean.getPhone();
        String vehicleRoute = resultBean.getVehicleRoute();
        Text_address.setText(address);
        Text_phone.setText(phone);
        viewById.setText(vehicleRoute);
    }
}
