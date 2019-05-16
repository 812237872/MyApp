package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.cont.ContractInterface;
import com.bw.movie.model.MyModel;

public class CinemaPresenter<T> implements ContractInterface.CinemaInterface {

    T tt ;
    MyModel myModel ;

    public CinemaPresenter(T t){
        tt = t ;
        myModel = new MyModel();
    }

    @Override
    public void pToAttention(int id, int userId, String sessionId) {
        myModel.setMyAttention(new MyModel.MyAttention() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.CinemaNearby cinemaNearby = (ContractInterface.CinemaNearby) tt;
                cinemaNearby.showAttention(object);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToAttention(id,userId,sessionId);
    }

    @Override
    public void pToNotAttention(int id, int userId, String sessionId) {
        myModel.setMyNotAttention(new MyModel.MyNotAttention() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.CinemaNearby cinemaNearby = (ContractInterface.CinemaNearby) tt;
                cinemaNearby.showNotAttention(object);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToNotAttention(id, userId, sessionId);
    }

    @Override
    public void pToRAttention(int id, int userId, String sessionId) {
        myModel.setMyAttention(new MyModel.MyAttention() {
            @Override
            public void Succeed(Object object) {
                Log.e("不关注", "Succeed: "+object);
                ContractInterface.CinemaRecommend cinemaNearby = (ContractInterface.CinemaRecommend) tt;
                cinemaNearby.showAttention(object);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToAttention(id,userId,sessionId);
    }

    @Override
    public void pToRNotAttention(int id, int userId, String sessionId) {
        myModel.setMyNotAttention(new MyModel.MyNotAttention() {
            @Override
            public void Succeed(Object object) {
                Log.e("不关注", "Succeed: "+object);
                ContractInterface.CinemaRecommend cinemaNearby = (ContractInterface.CinemaRecommend) tt;
                cinemaNearby.showAttention(object);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToNotAttention(id, userId, sessionId);
    }
}
