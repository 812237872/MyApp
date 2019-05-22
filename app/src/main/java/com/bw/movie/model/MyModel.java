package com.bw.movie.model;
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
import com.bw.movie.bean.DetailsFragmentBean;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.EvaluateFragmentBean;
import com.bw.movie.bean.FlowBean;
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

    MyLogin myLogin;
    MyMoveCom myMoveCom;
    MyRecommend myRecommend;
    MyRegister myRegister;
    LikeMove likeMove;
    MoveXiang moveXiang;
    MoveYings moveYings;

    //**推荐--附近   影院
    MyNearby myNearby;
    //关注
    MyAttention myAttention;
    MyNotAttention myNotAttention;
    //影院详情页
    MyDetails myDetails;
    //影院轮播图
    setMyFlow setMyFlow;
    //影院详情页详情
    setDetailsFragment setDetailsFragment;
    setEvaluateFragment setEvaluateFragment;
    setEvaluateFragmentGreat setEvaluateFragmentGreat;

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

    //推荐影院
    public void mToRecommend(int userId, String sessionId, int page, int count) {
        api.getRecommend(userId, sessionId,page, count)
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

    public void getHotMove() {
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

    public void getMoving() {
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

    public void likeMove(int id) {
        api.likeMove(UriCl.likemove, LoginActivity.userId, LoginActivity.sessionId, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            JSONObject jsonObject = new JSONObject(s);
                            String message = jsonObject.getString("message");
                            likeMove.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void disLikeMove(int id) {
        api.likeMove(UriCl.dislikemove, LoginActivity.userId, LoginActivity.sessionId, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            JSONObject jsonObject = new JSONObject(s);
                            String message = jsonObject.getString("message");
                            likeMove.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        }

    //附近影院
    public void mToNearby ( int userId, String sessionId,int page, int count){
        api.getNearby(page, count, userId, sessionId)
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
    public void mToAttention ( int userId, int sessionId, String cinemaId){
        api.getAttention(userId, sessionId, cinemaId)
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
    public void mToNotAttention ( int userId, int sessionId, String cinemaId){
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
    public void mToDetails ( int cinemaId, int movieId){
        api.getDetails(cinemaId, movieId)
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
    //影院详情萝卜图
    public void mToFlow ( int cinemaId){
        api.getFlow(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"错误+i"+string);
                            Gson gsond = new Gson();
                            FlowBean flowBean = gsond.fromJson(string, FlowBean.class);
                            setMyFlow.Succeed(flowBean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //影院详情页详情
    public void mToDetailsFragment ( int cinemaId){
        api.getDetailsFragment(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"详情"+string);
                            Gson gson = new Gson();
                            DetailsFragmentBean detailsFragmentBean = gson.fromJson(string, DetailsFragmentBean.class);
                            setDetailsFragment.Succeed(detailsFragmentBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
    }
    //影院详情页评论
    public void mToEvaluateFragment ( int cinemaId, int page, int count){
        api.getEvaluateFragment(cinemaId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"评论"+string);
                            Gson gson = new Gson();
                            EvaluateFragmentBean evaluateFragmentBean = gson.fromJson(string, EvaluateFragmentBean.class);
                            setEvaluateFragment.Succeed(evaluateFragmentBean);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    //影院详情页评论点赞
    public void mToEvaluateFragmenGreat ( int userId, String sessionId,int commentId){
        Log.e("a123", "mToEvaluateFragmenGreat: " + userId + "-----" + sessionId + "-----" + commentId);
        api.getgetEvaluateFragmentGreat(commentId, userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //Log.e("AGE" ,"额详情"+string);
                            JSONObject jsonObject = new JSONObject(string);
                            String message = jsonObject.getString("message");
                            Log.e("a123", "call: " + message.toString());
                            setEvaluateFragmentGreat.Succeed(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    public void moveXiang ( int id) {
        api.likeMove(UriCl.movexiang, LoginActivity.userId, LoginActivity.sessionId, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson = new Gson();
                            MoveBean moveBean = gson.fromJson(s, MoveBean.class);
                            likeMove.Succeed(moveBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    public void moveXiangs ( int id){
        api.likeMove(UriCl.movexiangs, LoginActivity.userId, LoginActivity.sessionId, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String s = responseBody.string();
                            Gson gson = new Gson();
                            MoveXiangBean moveXiangBean = gson.fromJson(s, MoveXiangBean.class);
                            moveXiang.Succeed(moveXiangBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void moveYing ( int id){
                api.moveYing(UriCl.moveying, LoginActivity.userId, LoginActivity.sessionId, 1, 10, id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<ResponseBody>() {
                            @Override
                            public void call(ResponseBody responseBody) {
                                try {
                                    String s = responseBody.string();
                                    Gson gson = new Gson();
                                    MoveYingBean moveYingBean = gson.fromJson(s, MoveYingBean.class);
                                    moveYings.Succeed(moveYingBean);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }

    public void moveZan ( int id){
                api.zanMove(UriCl.movezan, LoginActivity.userId, LoginActivity.sessionId, id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<ResponseBody>() {
                            @Override
                            public void call(ResponseBody responseBody) {
                                try {
                                    String s = responseBody.string();
                                    JSONObject jsonObject = new JSONObject(s);
                                    String message = jsonObject.getString("message");
                                    likeMove.Succeed(message);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }


    public void addMovePing ( int id, String com){
                api.addMovePing(UriCl.addmoveping, LoginActivity.userId, LoginActivity.sessionId, id, com)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<ResponseBody>() {
                            @Override
                            public void call(ResponseBody responseBody) {
                                try {
                                    String s = responseBody.string();
                                    JSONObject jsonObject = new JSONObject(s);
                                    String message = jsonObject.getString("message");
                                    likeMove.Succeed(message);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }

    public void getCinema ( int id){
                api.likeMove(UriCl.cinema, LoginActivity.userId, LoginActivity.sessionId, id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<ResponseBody>() {
                            @Override
                            public void call(ResponseBody responseBody) {
                                try {
                                    String s = responseBody.string();
                                    Gson gson = new Gson();
                                    CinemaBean cinemaBean = gson.fromJson(s, CinemaBean.class);
                                    likeMove.Succeed(cinemaBean);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }


     public void likeCinema ( int id){
                api.likeCinema(UriCl.likecinema, LoginActivity.userId, LoginActivity.sessionId, id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<ResponseBody>() {
                            @Override
                            public void call(ResponseBody responseBody) {
                                try {
                                    String s = responseBody.string();
                                    JSONObject jsonObject = new JSONObject(s);
                                    String message = jsonObject.getString("message");
                                    likeMove.Succeed(message);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }

    public void disLikeCinema ( int id){
                api.likeCinema(UriCl.dislikecinema, LoginActivity.userId, LoginActivity.sessionId, id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<ResponseBody>() {
                            @Override
                            public void call(ResponseBody responseBody) {
                                try {
                                    String s = responseBody.string();
                                    JSONObject jsonObject = new JSONObject(s);
                                    String message = jsonObject.getString("message");
                                    likeMove.Succeed(message);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }

    public void moveCinema ( int cid, int id){
            api.moveCinema(UriCl.cinemamove, LoginActivity.userId, LoginActivity.sessionId, cid, id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<ResponseBody>() {
                        @Override
                        public void call(ResponseBody responseBody) {
                            try {
                                String s = responseBody.string();
                                Gson gson = new Gson();
                                MoveCinemaBean moveCinemaBean = gson.fromJson(s, MoveCinemaBean.class);
                                likeMove.Succeed(moveCinemaBean);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }


    public void downMovie ( int sche, int amount, String sign){
            api.downMovie(UriCl.downmove, LoginActivity.userId, LoginActivity.sessionId, sche, amount, sign)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<ResponseBody>() {
                        @Override
                        public void call(ResponseBody responseBody) {
                            try {
                                String s = responseBody.string();
                                Gson gson = new Gson();
                                DownBean downBean = gson.fromJson(s, DownBean.class);
                                likeMove.Succeed(downBean);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }

    public void payMovie ( int type, String order){
            api.payPrice(UriCl.pay, LoginActivity.userId, LoginActivity.sessionId, type, order)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<ResponseBody>() {
                        @Override
                        public void call(ResponseBody responseBody) {
                            try {
                                String s = responseBody.string();
                                Gson gson = new Gson();
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
        public void setMyRecommend (MyRecommend recommend){
            myRecommend = recommend;
        }
        public interface MyRecommend {
            public void Succeed(Object object);

            public void error(Object object);
        }
        public void setLikeMove (LikeMove move){
            likeMove = move;
        }
        public interface LikeMove {
            public void Succeed(Object object);
        }
        public void setMoveXiang (MoveXiang move){
            moveXiang = move;
        }
        public interface MoveXiang {
            public void Succeed(Object object);
        }
        public void setMoveYings (MoveYings move){
            moveYings = move;
        }
        public interface MoveYings {
            public void Succeed(Object object);
        }
        // 附近影院---杨明豪
        public void setMyNearby (MyNearby nearby){
            myNearby = nearby;
        }
        public interface MyNearby {
            public void Succeed(Object object);

            public void error(Object object);
        }

        //影院关注
        public void setMyAttention (MyAttention attention){
            myAttention = attention;
        }
        public interface MyAttention {
            public void Succeed(Object object);

            public void error(Object object);
        }

        //影院不关注
        public void setMyNotAttention (MyNotAttention attention){
            myNotAttention = attention;
        }
        public interface MyNotAttention {
            public void Succeed(Object object);

            public void error(Object object);
        }

        //影院详情页
        public void setMyDetails (MyDetails details){
            myDetails = details;
        }
        public interface MyDetails {
            public void Succeed(Object object);

            public void error(Object object);
        }

        //影院轮播
        public void setSetMyFlow (setMyFlow flow){
            setMyFlow = flow;
        }
        public interface setMyFlow {
            public void Succeed(Object object);

            public void error(Object object);
        }

        //影院详情页详情
        public void setSetDetailsFragment (setDetailsFragment fragment){
            setDetailsFragment = fragment;
        }
        public interface setDetailsFragment {
            public void Succeed(Object object);

            public void error(Object object);
        }
        //影院详情页评论
        public void setSetEvaluateFragment (setEvaluateFragment fragment){
            setEvaluateFragment = fragment;
        }
        public interface setEvaluateFragment {
            public void Succeed(Object object);

            public void error(Object object);
        }
        //影院详情页评论点赞
        public void setSetEvaluateFragmentGreat (setEvaluateFragmentGreat great){
            setEvaluateFragmentGreat = great;
        }
        public interface setEvaluateFragmentGreat {
            public void Succeed(Object object);

            public void error(Object object);
        }

    }
