package com.bw.movie.util;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
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

    //推荐影院
    @GET("movieApi/cinema/v1/findRecommendCinemas")
    public Observable<ResponseBody>
            getRecommend(@Query("page")int page,@Query("count")int count,
                         @Header("userId")int userId,@Header("sessionId")String sessionId);

    @GET("")
    Observable<ResponseBody> getMove(@Header("userId") int userId,@Header("sessionId") String session,@Query("page") int page,@Query("count") int count);
}
