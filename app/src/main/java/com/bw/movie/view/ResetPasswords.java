package com.bw.movie.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.util.EncryptUtil;

public class ResetPasswords extends AppCompatActivity implements ContractInterface.ResetPasswords {

    EditText edit_old,edit_news1,edit_news2 ;
    Button button ;
    private String news11;
    private String news21;
    private String old1;
    private ContractInterface.PresenterInterface presenterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_passwords);

        edit_news1 = findViewById(R.id.ResetPasswords_news1);
        edit_news2 = findViewById(R.id.ResetPasswords_news2);
        edit_old = findViewById(R.id.ResetPasswords_old);
        button = findViewById(R.id.ResetPasswords_but);



        presenterInterface = new MyPresenter<>(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_news1Text = edit_news1.getText().toString();
                String edit_news2Text = edit_news2.getText().toString();
                String edit_oldText = edit_old.getText().toString();

                //加密
                news11 = EncryptUtil.encrypt(edit_news1Text);
                news21 = EncryptUtil.encrypt(edit_news2Text);
                old1 = EncryptUtil.encrypt(edit_oldText);
                presenterInterface.pToResetPasswords(LoginActivity.userId,LoginActivity.sessionId,old1,news11,news21);
            }
        });




    }

    @Override
    public void showMyPasswords(Object object) {
        Toast.makeText(this,object+"",Toast.LENGTH_SHORT).show();
        if (object.equals("密码修改成功")){
            Intent intent = new Intent(ResetPasswords.this,LoginActivity.class);
            startActivity(intent);
        }

    }
}
