package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.NearbyBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.model.MyModel;

import java.util.List;

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

        myModel.setMyRecommend(new MyModel.MyRecommend() {
            @Override
            public void Succeed(Object object) {
                RecommendBean recommendBean = (RecommendBean) object;
                List<RecommendBean.ResultBean> result = recommendBean.getResult();
                ContractInterface.CinemaRecommend cinemaRecommend = (ContractInterface.CinemaRecommend) tt;
                cinemaRecommend.showRecommend(result);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToRecommend(userId,sessionId,page,count);
    }
    //附近影院
    @Override
    public void pToNearby(int userId, String sessionId, int page, int count) {
        myModel.setMyNearby(new MyModel.MyNearby() {
            @Override
            public void Succeed(Object object) {
                NearbyBean nearbyBean = (NearbyBean) object;
                List<NearbyBean.ResultBean> result = nearbyBean.getResult();
                ContractInterface.CinemaNearby cinemaNearby = (ContractInterface.CinemaNearby) tt;
                cinemaNearby.showNearby(result);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToNearby(userId,sessionId,page,count);
    }

    //影院详情页
    @Override
    public void pToDetails(int cinemaId) {
        myModel.setMyDetails(new MyModel.MyDetails() {
            @Override
            public void Succeed(Object object) {
                DetailsBean detailsBean = (DetailsBean) object;
                List<DetailsBean.ResultBean> result = detailsBean.getResult();
                ContractInterface.CinemaDetails cinemaDetails = (ContractInterface.CinemaDetails) tt;
                cinemaDetails.showDetails(result);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToDetails(cinemaId);
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
