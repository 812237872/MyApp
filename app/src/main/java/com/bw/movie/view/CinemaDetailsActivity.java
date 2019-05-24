package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.acitivity.BaseActivity;
import com.bw.movie.adapter.CinemaDetailsAdapter;
import com.bw.movie.adapter.RecyclerCoverFlowAdapter;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.FlowBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.activity.GouActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

public class CinemaDetailsActivity extends BaseActivity implements ContractInterface.CinemaDetails {

    TextView Text_name , Text_address ;
    SimpleDraweeView imageView ;
    List<DetailsBean.ResultBean> list = new ArrayList<>();
    private RecyclerView xRecyclerView;
    private CinemaDetailsAdapter adapter;
    private RecyclerCoverFlow recyclerCoverFlow;
    List<Integer> Pic_list = new ArrayList<>();
    List<FlowBean.ResultBean> Flow_list = new ArrayList<>();
    private RecyclerCoverFlowAdapter flowAdapter;
    private ContractInterface.PresenterInterface presenterInterface;
    private RadioGroup radioGroup;
    private CinemaDetailsFragment cinemaDetailsFragment;
    private CinemaEvaluateFragment cinemaEvaluateFragment;
    private RelativeLayout relativeLayout;
    private String name;
    private String address;
    public String movename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinema_details);

        xRecyclerView = findViewById(R.id.cinema_details_XRecyclerView);
        recyclerCoverFlow = findViewById(R.id.cinema_details_RecyclerCoverFlow);
        radioGroup = findViewById(R.id.cinema_details_RadioGroup);
        RelativeLayout relativeLayout = findViewById(R.id.cinema_details_RelativeLayout);
        final RelativeLayout relativeLayout1 = findViewById(R.id.shape_cinema_RelativeLayout);
        ImageView view = findViewById(R.id.cinema_details_return);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageView imageViews = findViewById(R.id.cinema_details_ImageView);

        imageViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout1.setVisibility(View.GONE);
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout1.setVisibility(View.VISIBLE);
            }
        });

        cinemaDetailsFragment = new CinemaDetailsFragment();
        cinemaEvaluateFragment = new CinemaEvaluateFragment();

        final FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.cinema_details_FrameLayout,cinemaDetailsFragment)
                .add(R.id.cinema_details_FrameLayout,cinemaEvaluateFragment)
                .show(cinemaDetailsFragment)
                .hide(cinemaEvaluateFragment)
                .commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.cinema_details_Radio1 :
                            transaction.show(cinemaDetailsFragment)
                                    .hide(cinemaEvaluateFragment);
                        break;
                    case R.id.cinema_details_Radio2 :
                            transaction.show(cinemaEvaluateFragment)
                                    .hide(cinemaDetailsFragment);
                        break;
                }
                transaction.commit();
            }
        });


        Text_name = findViewById(R.id.cinema_details_name);
        Text_address = findViewById(R.id.cinema_details_dress);
        imageView = findViewById(R.id.cinema_details_logo);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        xRecyclerView.setLayoutManager(layoutManager);

        flowAdapter = new RecyclerCoverFlowAdapter(this,Flow_list);
        recyclerCoverFlow.setAdapter(flowAdapter);

        adapter = new CinemaDetailsAdapter(this,list);
        xRecyclerView.setAdapter(adapter);

        adapter.setListener(new CinemaDetailsAdapter.Listener() {
            @Override
            public void onClick(int i) {
                Intent intent = new Intent(CinemaDetailsActivity.this, GouActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("address",address);
                intent.putExtra("pid",list.get(i).getId());
                intent.putExtra("beginTime",list.get(i).getBeginTime());
                intent.putExtra("endTime",list.get(i).getEndTime());
                intent.putExtra("screeningHall",list.get(i).getScreeningHall());
                intent.putExtra("price",list.get(i).getPrice());
                intent.putExtra("movename",movename);
                startActivity(intent);

            }
        });

        Intent intent = getIntent();
        final int cinemaId = intent.getIntExtra("cinemaId",0);
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");
        String logo = intent.getStringExtra("logo");

        Bundle bundle = new Bundle();
        bundle.putInt("str",cinemaId);
        cinemaDetailsFragment.setArguments(bundle);
        cinemaEvaluateFragment.setArguments(bundle);


        Text_name.setText(name);
        Text_address.setText(address);
        imageView.setImageURI(logo);


        //Log.e("TAG","ID数据"+cinemaId);

        presenterInterface = new MyPresenter<>(this);
        presenterInterface.pToFlow(cinemaId);
        //Log.e("错误+数据","影院id"+cinemaId);
        flowAdapter.setOnItemFlowClick(new RecyclerCoverFlowAdapter.OnItemFlowClick() {
            @Override
            public void onItemClick(int position,String name) {
                presenterInterface.pToDetails(position,cinemaId);
                //Log.e("错误+数据","id"+position+"影院id"+cinemaId);
                movename=name;
                list.clear();

            }
        });




    }

    @Override
    public void showDetails(Object object) {
        List<DetailsBean.ResultBean> resultBeans = (List<DetailsBean.ResultBean>) object;
        list.addAll(resultBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFlow(Object object) {
        FlowBean flowBean = (FlowBean) object;
        List<FlowBean.ResultBean> resultBeans = flowBean.getResult();
        if (resultBeans == null){

        }else {
            Flow_list.addAll(resultBeans);
        }
        flowAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterInterface.onDestroy();
        presenterInterface=null;
    }
}
