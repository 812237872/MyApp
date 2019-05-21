package com.bw.movie.presenter;

import android.content.Context;
import android.util.Log;

import com.bw.movie.bean.DetailsFragmentBean;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.EvaluateFragmentBean;
import com.bw.movie.bean.FlowBean;
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

<<<<<<< HEAD

//        myModel.mToRecommend(userId,sessionId,page,count);
=======
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
>>>>>>> 5bbf552e935f45a8024245a9b5d53291c4f2af38
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
    public void pToDetails(int cinemaId,int movield) {
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
        myModel.mToDetails(cinemaId,movield);
    }

    @Override
    public void pToFlow(int cinemaId) {
        myModel.setSetMyFlow(new MyModel.setMyFlow() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.CinemaDetails cinemaDetails = (ContractInterface.CinemaDetails) tt;
                cinemaDetails.showFlow(object);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToFlow(cinemaId);
    }

    //影院详情页详情
    @Override
    public void pToDetailsFragment(int cinemaId) {
        myModel.setSetDetailsFragment(new MyModel.setDetailsFragment() {
            @Override
            public void Succeed(Object object) {
                DetailsFragmentBean detailsFragmentBean = (DetailsFragmentBean) object;
                DetailsFragmentBean.ResultBean result = detailsFragmentBean.getResult();
                //Log.e("AGE" ,"p详情"+result);
                ContractInterface.CinemaDetailsFragment cinemaDetailsFragment = (ContractInterface.CinemaDetailsFragment) tt;
                cinemaDetailsFragment.showDetailsFragment(result);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToDetailsFragment(cinemaId);
    }
    //电影详情页评价
    @Override
    public void pToEvaluateFragment(int cinemaId, int page, int count) {
        myModel.setSetEvaluateFragment(new MyModel.setEvaluateFragment() {
            @Override
            public void Succeed(Object object) {
                EvaluateFragmentBean evaluateFragmentBean = (EvaluateFragmentBean) object;
                List<EvaluateFragmentBean.ResultBean> result = evaluateFragmentBean.getResult();
                ContractInterface.CinemaEvaluateFragment cinemaEvaluateFragment = (ContractInterface.CinemaEvaluateFragment) tt;
                cinemaEvaluateFragment.showEvaluateFragment(result);


            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToEvaluateFragment(cinemaId, page, count);
    }
    //详情页面评论点赞
    @Override
    public void pToEvaluateFragmentGreat(int userId, String sessionId, int commentId) {
        myModel.setSetEvaluateFragmentGreat(new MyModel.setEvaluateFragmentGreat() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.CinemaEvaluateFragment cinemaEvaluateFragment = (ContractInterface.CinemaEvaluateFragment) tt;
                cinemaEvaluateFragment.showEvaluateFragmentGreat(object);
            }
            @Override
            public void error(Object object) {
            }
        });
        myModel.mToEvaluateFragmenGreat(userId, sessionId, commentId);
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
    public void toMoving() {
        myModel.setMyLogin(new MyModel.MyLogin() {
            @Override
            public void Succeed(Object o) {
                ContractInterface.ShowInterface showInterface= (ContractInterface.ShowInterface) tt;
                showInterface.showMoving(o);
            }
            @Override
            public void error(Object object) {

            }
        });
        myModel.getMoving();
    }

    @Override
    public void toMoveCom() {
        myModel.setMyMoveCom(new MyModel.MyMoveCom() {
            @Override
            public void Succeed(Object o) {
                ContractInterface.ShowInterface showInterface= (ContractInterface.ShowInterface) tt;
                showInterface.showMoveCom(o);
            }
        });
        myModel.getMoveCom();
    }

    @Override
    public void toLikeMove(int id) {
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.ShowInterface.LikeMoveInterface likeMoveInterface= (ContractInterface.ShowInterface.LikeMoveInterface) tt;
                likeMoveInterface.showLikeMove(object);
            }
        });
        myModel.likeMove(id);
    }

    @Override
    public void toNoLikeMove(int id) {
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.ShowInterface.LikeMoveInterface likeMoveInterface= (ContractInterface.ShowInterface.LikeMoveInterface) tt;
                likeMoveInterface.showLikeMove(object);
            }
        });
        myModel.disLikeMove(id);
    }

    @Override
    public void toMoveXiang(int id) {
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.MoveXiangInterface moveXiangInterface= (ContractInterface.MoveXiangInterface) tt;
                moveXiangInterface.showMove(object);
            }
        });
        myModel.moveXiang(id);
    }

    @Override
    public void toMoveXiangs(int id) {
        myModel.setMoveXiang(new MyModel.MoveXiang() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.MoveXiangInterface moveXiangInterface= (ContractInterface.MoveXiangInterface) tt;
                moveXiangInterface.showMoves(object);
            }
        });
        myModel.moveXiangs(id);
    }

    @Override
    public void toMoveYing(int id) {
        myModel.setMoveYings(new MyModel.MoveYings() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.MoveXiangInterface moveXiangInterface= (ContractInterface.MoveXiangInterface) tt;
                moveXiangInterface.showMoveYin(object);
            }
        });
        myModel.moveYing(id);
    }

    @Override
    public void toMoveZan(int id) {
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.MoveXiangInterface moveXiangInterface= (ContractInterface.MoveXiangInterface) tt;
                moveXiangInterface.showMoveZan(object);
            }
        });
        myModel.moveZan(id);
    }

    @Override
    public void toMovePing(int id, String com) {
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.MoveXiangInterface moveXiangInterface= (ContractInterface.MoveXiangInterface) tt;
                moveXiangInterface.showMovePing(object);
            }
        });
        myModel.addMovePing(id,com);
    }
    public void toCinema(int id){
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.CinemaInterface cinemaInterface= (ContractInterface.CinemaInterface) tt;
                cinemaInterface.showCinema(object);
            }
        });
        myModel.getCinema(id);
    }

    @Override
    public void toLikeCinema(int id) {
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.CinemaInterface cinemaInterface= (ContractInterface.CinemaInterface) tt;
                cinemaInterface.showLikeCinema(object);
            }
        });
        myModel.likeCinema(id);
    }

    @Override
    public void toDisLikeCinema(int id) {
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.CinemaInterface cinemaInterface= (ContractInterface.CinemaInterface) tt;
                cinemaInterface.showLikeCinema(object);
            }
        });
        myModel.disLikeCinema(id);
    }

    @Override
    public void toMoveCinema(int cid, int id) {
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.PlayMoveInterface playMoveInterface= (ContractInterface.PlayMoveInterface) tt;
                playMoveInterface.showMoveCinema(object);
            }
        });
        myModel.moveCinema(cid,id);
    }

    @Override
    public void toPlayMoveXiang(int id) {
        myModel.setMoveXiang(new MyModel.MoveXiang() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.PlayMoveInterface playMoveInterface= (ContractInterface.PlayMoveInterface) tt;
                playMoveInterface.showPlayMoveXiang(object);
            }
        });
        myModel.moveXiangs(id);
    }

    @Override
    public void toDownMovie(int sche, int amount, String sign) {
        myModel.setLikeMove(new MyModel.LikeMove() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.GouInterface gouInterface= (ContractInterface.GouInterface) tt;
                gouInterface.showDown(object);
            }
        });
        myModel.downMovie(sche,amount,sign);
    }

    @Override
    public void toPayMovie(int type, String order) {
        myModel.setMoveXiang(new MyModel.MoveXiang() {
            @Override
            public void Succeed(Object object) {
                ContractInterface.GouInterface gouInterface= (ContractInterface.GouInterface) tt;
                gouInterface.showPayMovie(object);
            }
        });
        myModel.payMovie(type,order);
    }


    @Override
    public void onDestroy() {
        if(tt!=null){
            tt=null;
        }
    }

}
