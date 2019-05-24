package com.bw.movie.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MyMessageBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyMessageActivity extends AppCompatActivity implements ContractInterface.MyMessage {

    TextView info_name ,info_sex,info_birthday,info_phone,info_email;
    private SimpleDraweeView simpleDraweeView;
    private ImageView imageView;
    private ImageView my_user_reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message);

        imageView = findViewById(R.id.my_user_back);
        my_user_reset = findViewById(R.id.my_user_reset);
        simpleDraweeView = findViewById(R.id.info_head);
        info_name = findViewById(R.id.info_name);
        info_sex = findViewById(R.id.info_sex);
        info_birthday = findViewById(R.id.info_birthday);
        info_phone = findViewById(R.id.info_phone);
        info_email = findViewById(R.id.info_email);


        ContractInterface.PresenterInterface presenterInterface = new MyPresenter<>(this);
        presenterInterface.pToMyMessage(LoginActivity.userId,LoginActivity.sessionId);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        my_user_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyMessageActivity.this,ResetPasswords.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showMyMessage(Object object) {
        MyMessageBean myMessageBean = (MyMessageBean) object;
        String headPic = myMessageBean.getResult().getHeadPic();
        String nickName = myMessageBean.getResult().getNickName();
        int get_sex = myMessageBean.getResult().getSex();
        long birthday = myMessageBean.getResult().getBirthday();
        String get_phone = myMessageBean.getResult().getPhone();
        String get_email = myMessageBean.getResult().getEmail();
        //myMessageBean.getResult().get

        Date date = new Date(birthday);
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");

        simpleDraweeView.setImageURI(headPic);
        info_name .setText(nickName);
        info_sex.setText(get_sex+"");
        info_birthday.setText(format.format(date));
        info_phone.setText(get_phone);
        info_email.setText(get_email);
    }
}
