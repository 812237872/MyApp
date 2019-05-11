package com.bw.movie.util;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
    @FormUrlEncoded
    @POST("login")
    public Observable<ResponseBody> getLogin(@Field("phone") String phone , @Field("pwd") String pwd, @Field("pwd2") String pwd2);
    @FormUrlEncoded
    @POST("registerUser")
    public Observable<ResponseBody>
    getRegister(@Field("nickName") String nickName , @Field("sex") int sex,
                @Field("birthday") String birthday , @Field("phone") String phone,
                @Field("email") String email , @Field("pwd") String pwd, @Field("pwd2") String pwd2);

}
