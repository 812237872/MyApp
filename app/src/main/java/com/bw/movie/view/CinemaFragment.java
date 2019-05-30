package com.bw.movie.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.movie.R;
import com.bw.movie.adapter.CinemaAdapter;
import com.bw.movie.bean.CinemaSousuoBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CinemaFragment extends Fragment implements ContractInterface.CinemaFragment {

    List<Fragment> list = new ArrayList<>();
    private String[] titles = {"推荐影院","附近影院"};
    private CinemaAdapter adapter;
    private RadioGroup radioGroup;
    private CinemaNearby cinemaNearby;
    private CinemaRecommend cinemaRecommend;
    private FragmentManager manager;
    public static String city;
    public static double latitude ;
    public static double longitude ;


    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    //定位成功回调信息，设置相关消息
                    aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    latitude = aMapLocation.getLatitude();//获取纬度
                    longitude = aMapLocation.getLongitude();//获取经度
                    aMapLocation.getAccuracy();//获取精度信息
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    //textView.setText(aMapLocation.getCity());
                    Date date = new Date(aMapLocation.getTime());
                    df.format(date);//定位时间
                    city = aMapLocation.getCity();
                    MyViews.init(city);
                    Log.e("AGE","获取经度："+aMapLocation.getLongitude()+"获取伟度："+aMapLocation.getLatitude()+"地名："+aMapLocation.getCity().toString());
                    locations.setText(aMapLocation.getCity());
                    locations.setTextColor(Color.BLACK);

                    //Log.e("AGE","获取经度："+aMapLocation.getLongitude()+"获取伟度："+aMapLocation.getLatitude()+"地名："+aMapLocation.getCity().toString());
                } else {
                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                    /*Log.e("AmapError", "location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                    Log.e("AGE","获取经度："+aMapLocation.getLongitude()+"获取伟度："+aMapLocation.getLatitude());*/
                }
            }
        }
    };
    private MyViews myViews;
    private TextView locations,sousuo;
    private EditText edit_sousuo;
    private ContractInterface.PresenterInterface presenterInterface;
    private int id;
    private String logo;
    private String address;
    private String name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cinema, null);
        radioGroup = view.findViewById(R.id.cinema_RadioGroup);
        myViews = view.findViewById(R.id.cinema_MyViews);
        locations = myViews.findViewById(R.id.locations);
        edit_sousuo = myViews.findViewById(R.id.search_edname);
        sousuo = myViews.findViewById(R.id.search_textName);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cinemaNearby = new CinemaNearby();
        cinemaRecommend = new CinemaRecommend();

        presenterInterface = new MyPresenter<>(this);

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

            //初始化定位
            mLocationClient = new AMapLocationClient(getContext());
            //设置定位回调监听
            mLocationClient.setLocationListener(mLocationListener);

            AMapLocationClientOption option = new AMapLocationClientOption();
            //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
            option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
            option.setInterval(60000);
            mLocationClient.setLocationOption(option);

            int selfPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
            if (selfPermission != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.BLUETOOTH},
                        100);
            }else {
                mLocationClient.startLocation();
            }


            sousuo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = edit_sousuo.getText().toString();
                    if (s.equals("")){
                        Toast.makeText(getContext(),"搜索内容不可为空",Toast.LENGTH_SHORT).show();
                    }else {
                        presenterInterface.pToSousuo(LoginActivity.userId,LoginActivity.sessionId ,1,10,s);
                    }
                }
            });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100){
            if (permissions[0].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                mLocationClient.startLocation();
            }
        }
    }

    @Override
    public void showSousuo(Object object) {
        CinemaSousuoBean cinemaSousuoBean = (CinemaSousuoBean) object;
        List<CinemaSousuoBean.ResultBean> list = new ArrayList<>();
        list.addAll(cinemaSousuoBean.getResult());
        for (int i = 0; i <list.size() ; i++) {
            id = list.get(i).getId();
            logo = list.get(i).getLogo();
            address = list.get(i).getAddress();
            name = list.get(i).getName();
        }


        Intent intent = new Intent(getContext(),CinemaDetailsActivity.class);
        intent.putExtra("cinemaId",id);
        intent.putExtra("name",name);
        intent.putExtra("address",address);
        intent.putExtra("logo",logo);
        startActivity(intent);
    }
}
