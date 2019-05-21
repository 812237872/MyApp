package com.bw.movie.presenter;

import android.content.Context;
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


//        myModel.mToRecommend(userId,sessionId,page,count);
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
