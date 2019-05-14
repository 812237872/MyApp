package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.util.Api;
import com.bw.movie.util.RetrofitUtil;
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
    MyRecommend myRecommend ;
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
    ///推荐影院
    public void mToRecommend(int userId, String sessionId, int page,int count){
        api.getRecommend(page,count,userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"错误"+string);
                            Gson gson = new Gson();
                            RecommendBean recommendBean = gson.fromJson(string,RecommendBean.class);
                            
                        } catch (Exception e) {
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

    // 推荐影院---杨明豪
    public void setMyRecommend(MyRecommend recommend){
        myRecommend = recommend;
    }
    public interface MyRecommend{
        public void Succeed(Object object);
        public void error(Object object);
    }

}
