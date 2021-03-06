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
    public interface WxLoginInterface{
        public void showWxLogin(Object o);
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
    public interface CinemasInterface{
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
        public void showFlow(Object object);
    }
    //影院详情页详情
    public interface CinemaDetailsFragment{
        public void showDetailsFragment(Object object);
    }
    //影院详情页评论
    public interface CinemaEvaluateFragment{
        public void showEvaluateFragment(Object object);

        public void showEvaluateFragmentGreat(Object object);
    }
    //我的页面会员信息
    public interface MyFragmentVip{
        public void showMyVip(Object object);
        //我的页面签到
        public void showSignl(Object object);
    }

    //我的页面个人信息
    public interface MyMessage{
        public void showMyMessage(Object object);
    }
    //我的页面个人信息修改密码
    public interface ResetPasswords{
        public void showMyPasswords(Object object);
    }
    //我的页面意见反馈
    public interface MyFeedBack{
        public void showMyFeedBack(Object object);
    }
    public interface CinemaFragment{
        public void showSousuo(Object object);
    }

    // 我 的页面购票记录
    public interface MyBypiao{
        public void MyBypiao(Object object);
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
        public void pToNearby(String longitude,String latitude ,int userId,String sessionId,int page,int count);
        //影院详情页面
        public void pToDetails(int cinemaId,int movield);
        //影院搜索
        public void pToSousuo(int userId,String sessionId,int  page, int count ,String cinemaName);
        //影院轮播图
        public void pToFlow(int cinemaId);
        //详情页面详情
        public void pToDetailsFragment(int cinemaId);
        //详情页面评论
        public void pToEvaluateFragment(int cinemaId,int page ,int count);
        //详情页面评论点赞
        public void pToEvaluateFragmentGreat(int userId,String sessionId,int commentId);
        //我的页面会员信息
        public void pToMyFragmentVip(int userId,String sessionId);
        //我的页面签到
        public void pToMyFragmentSignl(int userId,String sessionId);
        //我的页面个人信息
        public void pToMyMessage(int userId,String sessionId);
        //我的页面个人信息修改密码
        public void pToResetPasswords(int userId,String sessionId,String oldPwd,String newPwd,String newPwd2);
        //我的页面意见反馈
        public void pToMyFeedBack(int userId,String sessionId,String content);
        //我的页面购票记录
        public void pToMyBypiao(int userId,String sessionId,int page ,int count,int status);


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
        public void toWxLogin(String code);
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
