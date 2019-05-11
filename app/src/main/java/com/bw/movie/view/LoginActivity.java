package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.util.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ContractInterface.LoginInterface {

    @BindView(R.id.phone_id)
    EditText edit_phone;
    @BindView(R.id.pwd_id)
    EditText edit_pwd;
    @BindView(R.id.jzpwd_id)
    CheckBox check;
    @BindView(R.id.quickly_id)
    TextView quicklyId;
    @BindView(R.id.btn_login)
    Button btn_Login;
    @BindView(R.id.wxLogin)
    ImageView imager;
    private ContractInterface.PresenterInterface presenterInterface;
    private SharedPreferences sp;

    private boolean b = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenterInterface = new MyPresenter<>(this);
        PassWord();



        sp = getSharedPreferences("info",MODE_PRIVATE);
        boolean flag = sp.getBoolean("flag", false);
        if (flag){
            String phone = sp.getString("phone", "");
            String pwd = sp.getString("pwd", "");
            check.setChecked(flag);
            edit_phone.setText(phone);
            edit_pwd.setText(pwd);
        }else {
            edit_phone.setText("");
            edit_pwd.setText("");
            check.setChecked(false);
        }

        quicklyId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = edit_phone.getText().toString();
                String pwd = edit_pwd.getText().toString();
                SharedPreferences.Editor edit = sp.edit();

                if(check.isChecked()){
                    edit.putString("phone",phone);
                    edit.putString("pwd",pwd);
                    edit.putBoolean("flag",true);
                    edit.commit();
                }else {
                    edit.clear();
                }
                edit.apply();

                String encrypt = EncryptUtil.encrypt(pwd);
                presenterInterface.pToLogin(phone,encrypt,encrypt);
            }
        });



    }

    @Override
    public void showLogin(Object object) {
        LoginBean loginBean = (LoginBean) object;
        if (loginBean.getMessage().equals("登陆成功")){
            Toast.makeText(LoginActivity.this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,ShowActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(LoginActivity.this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    //设置密码的显示和隐藏
    private void PassWord() {
        edit_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (b){
                    edit_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    b = false ;
                }else {
                    edit_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    b = true ;
                }
            }
        });
    }
}
