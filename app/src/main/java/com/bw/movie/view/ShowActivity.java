package com.bw.movie.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.acitivity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends BaseActivity {

    private FilmFragment filmFragment;
    private CinemaFragment cinemaFragment;
    private MyFragment myFragment;
    private RadioGroup radioGroup;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        radioGroup = findViewById(R.id.Ashow_RadioGroup);

        filmFragment = new FilmFragment();
        cinemaFragment = new CinemaFragment();
        myFragment = new MyFragment();

        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.Ashow_ViewPager,filmFragment)
                .add(R.id.Ashow_ViewPager,cinemaFragment)
                .add(R.id.Ashow_ViewPager,myFragment)
                .show(filmFragment)
                .hide(cinemaFragment)
                .hide(myFragment)
                .commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.Ashow_Radio1 :
                        transaction.show(filmFragment)
                                .hide(cinemaFragment)
                                .hide(myFragment);
                        break;
                    case R.id.Ashow_Radio2 :
                        transaction.show(cinemaFragment)
                                .hide(filmFragment)
                                .hide(myFragment);
                        break;
                    case R.id.Ashow_Radio3 :
                        transaction.show(myFragment)
                                .hide(cinemaFragment)
                                .hide(filmFragment);
                        break;
                }
                transaction.commit();
            }
        });
    }

}
