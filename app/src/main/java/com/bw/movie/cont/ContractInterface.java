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
    }

}
