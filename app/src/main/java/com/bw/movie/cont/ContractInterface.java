package com.bw.movie.cont;

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
    }


    //推荐影院
    public interface CinemaRecommend{
        public void showRecommend(Object object);
        public void showAttention(Object object);
        public void showNotAttention(Object object);
    }

    //附近影院
    public interface CinemaNearby{
        public void showNearby(Object object);
        public void showAttention(Object object);
        public void showNotAttention(Object object);
    }

    //影院详情页面
    public interface CinemaDetails{
        public void showDetails(Object object);
    }


    //P层接口
    public interface PresenterInterface{
        //登录
        public void pToLogin(String phone , String pwd , String pwd2);
        //注册
        public void pToRegister(String nickName,int sex,String birthday,String phone,String email,String pwd,String pwd2);
        //推荐影院
        public void pToRecommend(int userId,String sessionId,int page,int count);
        //附近影院
        public void pToNearby(int userId,String sessionId,int page,int count);
        //影院详情页面
        public void pToDetails(int cinemaId);

        public void toHotMove();
        public void onDestroy();
    }

    //影院内部的接口调用
    public interface CinemaInterface{
        //关注
        public void pToAttention(int id,int userId,String sessionId);
        //不关注
        public void pToNotAttention(int id,int userId,String sessionId);

        //关注
        public void pToRAttention(int id,int userId,String sessionId);
        //不关注
        public void pToRNotAttention(int id,int userId,String sessionId);
    }

}
