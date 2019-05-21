package com.bw.movie.model;
import android.net.Uri;
import android.util.Log;

import com.bw.movie.bean.hotmove.CinemaBean;
import com.bw.movie.bean.hotmove.DownBean;
import com.bw.movie.bean.hotmove.HotMoveBean;
import com.bw.movie.bean.hotmove.MoveBean;
import com.bw.movie.bean.hotmove.MoveCinemaBean;
import com.bw.movie.bean.hotmove.MoveXiangBean;
import com.bw.movie.bean.hotmove.MoveYingBean;
import com.bw.movie.bean.hotmove.PayBean;
import com.bw.movie.bean.user.LoginBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.util.Api;
import com.bw.movie.util.RetrofitUtil;
import com.bw.movie.util.UriCl;
import com.bw.movie.view.LoginActivity;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MyModel {

    MyLogin myLogin;
    MyMoveCom myMoveCom;
    MyRecommend myRecommend;
    MyRegister myRegister;
    LikeMove likeMove;
    MoveXiang moveXiang;
    MoveYings moveYings;
    private final RetrofitUtil util;
    private final Api api;

    public MyModel() {
        util = RetrofitUtil.getIntsetn();
        api = util.getRetrofit(Api.class);
    }

    public void mToLogin(String phone, String pwd, String pwd2) {
        api.getLogin(phone, pwd, pwd2)
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

    public void mToRegister(String nickName, int sex, String birthday, String phone, String email, String pwd, String pwd2) {
        api.getRegister(nickName, sex, birthday, phone, email, pwd, pwd2)
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
//    public void mToRecommend(int userId, String sessionId, int page, int count) {
//        api.getRecommend(page, count, userId, sessionId)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<ResponseBody>() {
//                    @Override
//                    public void call(ResponseBody responseBody) {
//                        try {
//                            String string = responseBody.string();
//                            //Log.e("AGE" ,"错误"+string);
//                            Gson gson = new Gson();
//                            RecommendBean recommendBean = gson.fromJson(string, RecommendBean.class);
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//    }
        public void getHotMove () {
            api.getMove(UriCl.hotMove, LoginActivity.userId, LoginActivity.sessionId, 1, 5)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<ResponseBody>() {
                        @Override
                        public void call(ResponseBody responseBody) {
                            try {
                                String s = responseBody.string();
                                Gson gson = new Gson();
                                HotMoveBean hotMoveBean = gson.fromJson(s, HotMoveBean.class);
                                myRegister.Succeed(hotMoveBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
        public void getMoving () {
            api.getMove(UriCl.moving, LoginActivity.userId, LoginActivity.sessionId, 1, 5)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<ResponseBody>() {
                        @Override
                        public void call(ResponseBody responseBody) {
                            try {
                                String s = responseBody.string();
                                Gson gson = new Gson();
                                HotMoveBean hotMoveBean = gson.fromJson(s, HotMoveBean.class);
                                myLogin.Succeed(hotMoveBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
        public void getMoveCom() {
            api.getMove(UriCl.moveCom, LoginActivity.userId, LoginActivity.sessionId, 1, 5)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<ResponseBody>() {
                        @Override
                        public void call(ResponseBody responseBody) {
                            try {
                                String s = responseBody.string();
                                Gson gson = new Gson();
                                HotMoveBean hotMoveBean = gson.fromJson(s, HotMoveBean.class);
                                myMoveCom.Succeed(hotMoveBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
        public void likeMove(int id){
            api.likeMove(UriCl.likemove,LoginActivity.userId,LoginActivity.sessionId,id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<ResponseBody>() {
                        @Override
                        public void call(ResponseBody responseBody) {
                            try {
                                String s = responseBody.string();
                                JSONObject jsonObject=new JSONObject(s);
                                String message = jsonObject.getString("message");
                                likeMove.Succeed(message);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
    public void disLikeMove(int id){
        api.likeMove(UriCl.dislikemove,LoginActivity.userId,LoginActivity.sessionId,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            JSONObject jsonObject=new JSONObject(s);
                            String message = jsonObject.getString("message");
                            likeMove.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void moveXiang(int id){
        api.likeMove(UriCl.movexiang,LoginActivity.userId,LoginActivity.sessionId,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson=new Gson();
                            MoveBean moveBean = gson.fromJson(s, MoveBean.class);
                            likeMove.Succeed(moveBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void moveXiangs(int id){
        api.likeMove(UriCl.movexiangs,LoginActivity.userId,LoginActivity.sessionId,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson=new Gson();
                            MoveXiangBean moveXiangBean = gson.fromJson(s, MoveXiangBean.class);
                            moveXiang.Succeed(moveXiangBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void moveYing(int id){
        api.moveYing(UriCl.moveying,LoginActivity.userId,LoginActivity.sessionId,1,10,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson=new Gson();
                            MoveYingBean moveYingBean = gson.fromJson(s, MoveYingBean.class);
                            moveYings.Succeed(moveYingBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void moveZan(int id){
        api.zanMove(UriCl.movezan,LoginActivity.userId,LoginActivity.sessionId,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            JSONObject jsonObject=new JSONObject(s);
                            String message = jsonObject.getString("message");
                            likeMove.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void addMovePing(int id,String com){
        api.addMovePing(UriCl.addmoveping,LoginActivity.userId,LoginActivity.sessionId,id,com)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            JSONObject jsonObject=new JSONObject(s);
                            String message = jsonObject.getString("message");
                            likeMove.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void getCinema(int id){
        api.likeMove(UriCl.cinema,LoginActivity.userId,LoginActivity.sessionId,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson=new Gson();
                            CinemaBean cinemaBean = gson.fromJson(s, CinemaBean.class);
                            likeMove.Succeed(cinemaBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void likeCinema(int id){
        api.likeCinema(UriCl.likecinema,LoginActivity.userId,LoginActivity.sessionId,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            JSONObject jsonObject=new JSONObject(s);
                            String message = jsonObject.getString("message");
                            likeMove.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void disLikeCinema(int id){
        api.likeCinema(UriCl.dislikecinema,LoginActivity.userId,LoginActivity.sessionId,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            JSONObject jsonObject=new JSONObject(s);
                            String message = jsonObject.getString("message");
                            likeMove.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void moveCinema(int cid,int id){
        api.moveCinema(UriCl.cinemamove,LoginActivity.userId,LoginActivity.sessionId,cid,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson=new Gson();
                            MoveCinemaBean moveCinemaBean = gson.fromJson(s, MoveCinemaBean.class);
                            likeMove.Succeed(moveCinemaBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void downMovie(int sche,int amount,String sign){
        api.downMovie(UriCl.downmove,LoginActivity.userId,LoginActivity.sessionId,sche,amount,sign)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson=new Gson();
                            DownBean downBean = gson.fromJson(s, DownBean.class);
                            likeMove.Succeed(downBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void payMovie(int type,String order){
        api.payPrice(UriCl.pay,LoginActivity.userId,LoginActivity.sessionId,type,order)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson=new Gson();
                            PayBean payBean = gson.fromJson(s, PayBean.class);
                            moveXiang.Succeed(payBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

        public void setMyRegister (MyRegister register){
            myRegister = register;
        }
        public interface MyRegister {
            public void Succeed(Object object);

            public void error(Object object);
        }

        public void setMyLogin (MyLogin login){
            myLogin = login;
        }
        public interface MyLogin {
            public void Succeed(Object object);

            public void error(Object object);
        }
        public void setMyMoveCom (MyMoveCom com){
            myMoveCom = com;
        }
        public interface MyMoveCom {
            public void Succeed(Object o);
        }

        // 推荐影院---杨明豪
        public void setMyRecommend(MyRecommend recommend){
            myRecommend = recommend;
        }
        public interface MyRecommend {
            public void Succeed(Object object);

            public void error(Object object);
        }
    public void setLikeMove(LikeMove move){
        likeMove = move;
    }
    public interface LikeMove {
        public void Succeed(Object object);
    }
    public void setMoveXiang (MoveXiang  move){
        moveXiang = move;
    }
    public interface MoveXiang {
        public void Succeed(Object object);
    }
    public void setMoveYings(MoveYings move){
        moveYings = move;
    }
    public interface MoveYings {
        public void Succeed(Object object);
    }
}