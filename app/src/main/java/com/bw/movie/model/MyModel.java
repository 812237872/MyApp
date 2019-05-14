package com.bw.movie.model;

import com.bw.movie.bean.hotmove.HotMoveBean;
import com.bw.movie.bean.user.LoginBean;
import com.bw.movie.util.Api;
import com.bw.movie.util.RetrofitUtil;
import com.bw.movie.util.UriCl;
import com.bw.movie.view.LoginActivity;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MyModel {

    MyLogin myLogin ;
    MyRegister myRegister ;
    MyMoveCom myMoveCom;
    private final RetrofitUtil util;
    private final Api api;

    public MyModel(){
        util = RetrofitUtil.getIntsetn();
        api = util.getRetrofit(Api.class);
    }
    public void mToLogin(String phone , String pwd , String pwd2){
        api.getLogin(phone,pwd,pwd2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Gson gson = new Gson();
                            LoginBean loginBean = gson.fromJson(string, LoginBean.class);
                            myLogin.Succeed(loginBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void mToRegister(String nickName,int sex,String birthday,String phone,String email,String pwd,String pwd2){
        api.getRegister(nickName,sex,birthday,phone,email,pwd,pwd2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"错误"+string);
                            JSONObject object = new JSONObject(string);
                            String message = object.getString("message");
                            myRegister.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void getHotMove(){
        api.getMove(UriCl.hotMove,LoginActivity.userId,LoginActivity.sessionId,1,5)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    String s = responseBody.string();
                    Gson gson=new Gson();
                    HotMoveBean hotMoveBean = gson.fromJson(s, HotMoveBean.class);
                    myRegister.Succeed(hotMoveBean);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void getMoving(){
        api.getMove(UriCl.moving,LoginActivity.userId,LoginActivity.sessionId,1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson=new Gson();
                            HotMoveBean hotMoveBean = gson.fromJson(s, HotMoveBean.class);
                            myLogin.Succeed(hotMoveBean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void getMoveCom(){
        api.getMove(UriCl.moveCom,LoginActivity.userId,LoginActivity.sessionId,1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson=new Gson();
                            HotMoveBean hotMoveBean = gson.fromJson(s, HotMoveBean.class);
                            myMoveCom.Succeed(hotMoveBean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void setMyRegister(MyRegister register){
        myRegister = register ;
    }
    public interface MyRegister{
        public void Succeed(Object object);
        public void error(Object object);
    }

    public void setMyLogin(MyLogin login){
        myLogin = login ;
    }
    public interface MyLogin{
        public void Succeed(Object object);
        public void error(Object object);
    }
    public void setMyMoveCom(MyMoveCom com){
        myMoveCom = com ;
    }
    public interface MyMoveCom{
        public void Succeed(Object o);
    }
}
