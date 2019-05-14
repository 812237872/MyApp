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


    //P层接口
    public interface PresenterInterface{
        public void pToLogin(String phone , String pwd , String pwd2);
        public void pToRegister(String nickName,int sex,String birthday,String phone,String email,String pwd,String pwd2);
        public void toHotMove();
        public void onDestroy();
    }

}
