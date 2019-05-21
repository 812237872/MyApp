package com.bw.movie.cont;

import java.nio.channels.Pipe;

public interface ContractInterface {

    //登录页面
    public interface LoginInterface{
        public void showLogin(Object object);
    }
    //注册页面
    public interface RegisterInterface{
        public void showRegister(Object object);
    }
    //展示页面
    public interface ShowInterface{
        public void showHotMove(Object o);
        public void showMoving(Object o);
        public void showMoveCom(Object o);
        public interface LikeMoveInterface{
            public void showLikeMove(Object o);

        }
    }

    public interface MoveXiangInterface{
        public void showMove(Object o);
        public void showMoves(Object o);
        public void showMoveYin(Object o);
        public void showMoveZan(Object o);
        public void showMovePing(Object o);
    }
    public interface CinemaInterface{
        public void showCinema(Object o);
        public void showLikeCinema(Object o);

    }

    public interface PlayMoveInterface{
        public void showPlayMoveXiang(Object o);
        public void showMoveCinema(Object o);
    }

    public interface GouInterface{
        public void showDown(Object o);
        public void showPayMovie(Object o);
    }

    //推荐影院
    public interface CinemaRecommend{
        public void showRecommend(Object object);
    }


    //P层接口
    public interface PresenterInterface{
        //登录
        public void pToLogin(String phone , String pwd , String pwd2);
        //注册
        public void pToRegister(String nickName,int sex,String birthday,String phone,String email,String pwd,String pwd2);

        //推荐影院
        public void pToRecommend(int userId,String sessionId,int page,int count);
        public void toHotMove();
        public void toMoving();
        public void toMoveCom();
        public void toLikeMove(int id);
        public void toNoLikeMove(int id);
        public void toMoveXiang(int id);
        public void toMoveXiangs(int id);
        public void toMoveYing(int id);
        public void toMoveZan(int id);
        public void toMovePing(int id,String com);
        public void toCinema(int id);
        public void toLikeCinema(int id);
        public void toDisLikeCinema(int id);
        public void toMoveCinema(int cid,int id);
        public void toPlayMoveXiang(int id);
        public void toDownMovie(int sche,int amount,String sign);
        public void toPayMovie(int type,String order);
        public void onDestroy();
    }

}
