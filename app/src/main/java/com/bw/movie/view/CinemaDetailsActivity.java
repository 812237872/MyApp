package com.bw.movie.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import java.util.List;

public class CinemaDetailsActivity extends AppCompatActivity implements ContractInterface.CinemaDetails {

    TextView Text_name , Text_address ;
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinema_details);

        Text_name = findViewById(R.id.cinema_details_name);
        Text_address = findViewById(R.id.cinema_details_dress);
        imageView = findViewById(R.id.cinema_details_logo);



        Intent intent = getIntent();
        int cinemaId = intent.getIntExtra("cinemaId",0);
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String logo = intent.getStringExtra("logo");

        Text_name.setText(name);
        Text_address.setText(address);
        imageView.setBackground();


        Log.e("TAG","ID数据"+cinemaId);

        ContractInterface.PresenterInterface presenterInterface = new MyPresenter<>(this);
        presenterInterface.pToDetails(cinemaId);

    }

    @Override
    public void showDetails(Object object) {
        List<DetailsBean.ResultBean> resultBeans = (List<DetailsBean.ResultBean>) object;

    }
}
