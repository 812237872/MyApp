package com.bw.movie.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class MyFeedBack extends AppCompatActivity implements ContractInterface.MyFeedBack {

    private EditText editText;
    private Button button;
    private ImageView back;
    private ContractInterface.PresenterInterface presenterInterface;
    private RelativeLayout cuo,dui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_feed_back);
        back = findViewById(R.id.my_feed_back);
        button = findViewById(R.id.my_feed_but);
        editText = findViewById(R.id.my_feed_edit);
        presenterInterface = new MyPresenter<>(this);
        cuo = findViewById(R.id.RelativeLayout_cuo);
        dui = findViewById(R.id.RelativeLayout_dui);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                if (s.equals("")){
                    Toast.makeText(MyFeedBack.this,"您输入的内容不可为空，请重新输入。",Toast.LENGTH_SHORT).show();
                }else {
                    presenterInterface.pToMyFeedBack(LoginActivity.userId,LoginActivity.sessionId,s);
                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void showMyFeedBack(Object object) {
        Toast.makeText(this,object+"",Toast.LENGTH_SHORT).show();
        if (object.equals("反馈成功")){
            cuo.setVisibility(View.GONE);
            dui.setVisibility(View.VISIBLE);
        }
    }
}
