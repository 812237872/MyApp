package com.bw.movie.view.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.acitivity.BaseActivity;
import com.bw.movie.adapter.MovePageAdapter;
import com.bw.movie.view.fragment.ComMoveFragment;
import com.bw.movie.view.fragment.HotMoveFragment;
import com.bw.movie.view.fragment.MovingFragment;

import java.util.ArrayList;
import java.util.List;

public class SreachActivity extends BaseActivity {

    RadioGroup rp;
    ViewPager vp;
    RadioButton rb1,rb2,rb3;
    ImageView move_back;
    List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sreach);
        rp=findViewById(R.id.move_rp);
        vp=findViewById(R.id.move_page);
        rb1=findViewById(R.id.move_rb1);
        rb2=findViewById(R.id.move_rb2);
        rb3=findViewById(R.id.move_rb3);
        move_back=findViewById(R.id.move_back);

        list.add(new HotMoveFragment());
        list.add(new MovingFragment());
        list.add(new ComMoveFragment());
        MovePageAdapter movePageAdapter=new MovePageAdapter(getSupportFragmentManager(),list);
        vp.setAdapter(movePageAdapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }
            @Override
            public void onPageSelected(int i) {
                rp.check(rp.getChildAt(i).getId());
            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        move_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.move_rb1 :
                        vp.setCurrentItem(0,false);
                        rb1.setTextColor(Color.WHITE);
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        break;
                    case R.id.move_rb2 :
                        vp.setCurrentItem(1,false);
                        rb1.setTextColor(Color.BLACK);
                        rb2.setTextColor(Color.WHITE);
                        rb3.setTextColor(Color.BLACK);
                        break;
                    case R.id.move_rb3 :
                        vp.setCurrentItem(2,false);
                        rb1.setTextColor(Color.BLACK);
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.WHITE);
                        break;
                        default:
                            break;
                }
            }
        });
    }
}
