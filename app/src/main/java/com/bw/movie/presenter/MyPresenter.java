package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.cont.ContractInterface;
import com.bw.movie.model.MyModel;

public class MyPresenter<T> implements ContractInterface.PresenterInterface {
    T tt ;
    MyModel myModel ;

    public MyPresenter(T t){
        tt = t ;
        myModel = new MyModel();
    }

    @Override
    public void pToLogin(String phone, String pwd, String pwd2) {
        myModel.setMyLogin(new MyModel.MyLogin() {
            @Override
            public void Succeed(Object object) {
                    ContractInterface.LoginInterface loginInterface = (ContractInterface.LoginInterface) tt;
                    loginInterface.showLogin(object);
            }
            @Override
            public void error(Object object) {

            }
        });
        myModel.mToLogin(phone,pwd,pwd2);
    }

    @Override
    public void pToRegister(String nickName, int sex, String birthday, String phone, String email, String pwd, String pwd2) {
        myModel.setMyRegister(new MyModel.MyRegister() {
            @Override
            public void Succeed(Object object) {
                //Log.e("AGE" ,"错误2"+object);
                ContractInterface.RegisterInterface registerInterface = (ContractInterface.RegisterInterface) tt;
                registerInterface.showRegister(object);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToRegister(nickName,sex,birthday,phone,email,pwd,pwd2);
    }
    //推荐影院
    @Override
    public void pToRecommend(int userId, String sessionId, int page,int count) {


        myModel.mToRecommend(userId,sessionId,page,count);
    }

    @Override
    public void toHotMove() {
        myModel.setMyRegister(new MyModel.MyRegister() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.ShowInterface showInterface= (ContractInterface.ShowInterface) tt;
                showInterface.showHotMove(object);
            }
            @Override
            public void error(Object object) {

            }
        });
        myModel.getHotMove();
    }

    @Override
    public void onDestroy() {

    }

}
