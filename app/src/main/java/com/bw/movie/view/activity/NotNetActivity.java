package com.bw.movie.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bw.movie.R;

public class NotNetActivity extends AppCompatActivity {

    public static NotNetActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_net);
        Toast.makeText(this,"请检查网络连接",Toast.LENGTH_LONG).show();
        instance=this;


    }
    
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        finish();
//        return super.onTouchEvent(event);
//    }
}
