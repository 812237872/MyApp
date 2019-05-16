package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.HotMoveBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.NearbyBean;
import com.bw.movie.bean.RecommendBean;
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

    //**推荐--附近   影院
    MyNearby myNearby;
    MyRecommend myRecommend ;
    //关注
    MyAttention myAttention ;
    MyNotAttention myNotAttention;
//影院详情页
    MyDetails myDetails;

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
    public void mToRecommend(int userId, String sessionId, int page,int count) {
        api.getRecommend(page, count, userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"错误"+string);
                            Gson gson = new Gson();
                            RecommendBean recommendBean = gson.fromJson(string, RecommendBean.class);
                            myRecommend.Succeed(recommendBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //附近影院
    public void mToNearby(int userId, String sessionId, int page,int count){
        api.getNearby(page,count,userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"错误"+string);
                            Gson gson = new Gson();
                            NearbyBean nearbyBean = gson.fromJson(string, NearbyBean.class);
                            myNearby.Succeed(nearbyBean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //影院关注
    public void mToAttention(int userId, int sessionId, String cinemaId){
        api.getAttention(userId, sessionId,cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"错误"+string);
                            JSONObject jsonObject = new JSONObject(string);
                            String message = jsonObject.getString("message");
                            myAttention.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    ///不关注
    public void mToNotAttention(int userId, int sessionId, String cinemaId){
        api.getNotAttention(userId, sessionId, cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"错误"+string);
                            JSONObject jsonObject = new JSONObject(string);
                            String message = jsonObject.getString("message");
                            myNotAttention.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //影院详情页
    public void mToDetails(int cinemaId){
        api.getDetails(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"错误"+string);
                            Gson gson = new Gson();
                            DetailsBean detailsBean = gson.fromJson(string, DetailsBean.class);
                            myDetails.Succeed(detailsBean);
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

    // 附近影院---杨明豪
    public void setMyNearby(MyNearby nearby){
        myNearby = nearby;
    }
    public interface MyNearby{
        public void Succeed(Object object);
        public void error(Object object);
    }

    //影院关注
    public void setMyAttention(MyAttention attention){
        myAttention = attention;
    }
    public interface MyAttention{
        public void Succeed(Object object);
        public void error(Object object);
    }

    //影院不关注
    public void setMyNotAttention(MyNotAttention attention){
        myNotAttention = attention ;
    }
    public interface MyNotAttention{
        public void Succeed(Object object);
        public void error(Object object);
    }

    //影院详情页
    public void setMyDetails(MyDetails details){
        myDetails = details ;
    }
    public interface MyDetails{
        public void Succeed(Object object);
        public void error(Object object);
    }
}
