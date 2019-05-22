package com.bw.movie.util;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;
import rx.Observer;

public interface Api {
    @FormUrlEncoded
    @POST("movieApi/user/v1/login")
    public Observable<ResponseBody> getLogin(@Field("phone") String phone , @Field("pwd") String pwd, @Field("pwd2") String pwd2);

    @FormUrlEncoded
    @POST("movieApi/user/v1/registerUser")
    public Observable<ResponseBody>
    getRegister(@Field("nickName") String nickName , @Field("sex") int sex,
                @Field("birthday") String birthday , @Field("phone") String phone,
                @Field("email") String email , @Field("pwd") String pwd, @Field("pwd2") String pwd2);

    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<ResponseBody>getRecommend(@Header("userId") int userid,@Header("sessionId") String sessionid,@Query("page") int page,@Query("count") int count);

    @GET
    Observable<ResponseBody> getMove(@Url String url, @Header("userId") int userId, @Header("sessionId") String session, @Query("page") int page, @Query("count") int count);


    @GET
    Observable<ResponseBody> likeMove(@Url String url, @Header("userId") int userId, @Header("sessionId") String session,@Query("movieId") int id);
    @GET
    Observable<ResponseBody> likeCinema(@Url String url, @Header("userId") int userId, @Header("sessionId") String session,@Query("cinemaId") int id);

    @GET
    Observable<ResponseBody> moveCinema(@Url String url, @Header("userId") int userId, @Header("sessionId") String session,@Query("cinemasId") int cid,@Query("movieId") int id);
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> zanMove(@Url String url, @Header("userId") int userId, @Header("sessionId") String session,@Field("commentId") int id);
    @GET
    Observable<ResponseBody> moveYing(@Url String url, @Header("userId") int userId, @Header("sessionId") String session, @Query("page") int page, @Query("count") int count,@Query("movieId") int id);
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> addMovePing(@Url String url, @Header("userId") int userId, @Header("sessionId") String session,@Field("movieId") int id,@Field("commentContent") String com);
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> downMovie(@Url String url, @Header("userId") int userid,@Header("sessionId") String session,@Field("scheduleId") int scheduleId,@Field("amount") int amount,@Field("sign") String sign);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> payPrice(@Url String url, @Header("userId") int userid,@Header("sessionId") String session,@Field("payType") int type,@Field("orderId") String orderId);
    //附近影院
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    public Observable<ResponseBody>
    getNearby(@Query("page")int page,@Query("count")int count,
                 @Header("userId")int userId,@Header("sessionId")String sessionId);

    //影院的详情页
    @GET("movieApi/movie/v1/findMovieScheduleList")
    public Observable<ResponseBody>
    getDetails(@Query("cinemasId")int cinemasId,@Query("movieId")int movieId);

    //关注
    @GET("movieApi/cinema/v1/verify/followCinema")
    public Observable<ResponseBody>
    getAttention(@Query("cinemaId")int cinemaId ,@Header("userId")int userId,@Header("sessionId")String sessionId);
    //    //不关注
    @GET("movieApi/cinema/v1/verify/cancelFollowCinema")
    public Observable<ResponseBody>
    getNotAttention(@Query("cinemaId")int cinemaId ,@Header("userId")int userId,@Header("sessionId")String sessionId);

    //详情页面轮播图
    @GET("movieApi/movie/v1/findMovieListByCinemaId")
    public Observable<ResponseBody>
    getFlow(@Query("cinemaId")int cinemaId);

    //相亲页面详情
    @GET("movieApi/cinema/v1/findCinemaInfo")
    public Observable<ResponseBody>
    getDetailsFragment(@Query("cinemaId")int cinemaId);
    //详情页面评论
    @GET("movieApi/cinema/v1/findAllCinemaComment")
    public Observable<ResponseBody>
    getEvaluateFragment(@Query("cinemaId")int cinemaId,@Query("page")int page,@Query("count")int count);
    //详情页面评论点赞

    @FormUrlEncoded
    @POST("movieApi/cinema/v1/verify/cinemaCommentGreat")
    public Observable<ResponseBody>
    getgetEvaluateFragmentGreat(@Field("commentId") int commentId ,@Header("userId")int userId,@Header("sessionId")String sessionId);


}
