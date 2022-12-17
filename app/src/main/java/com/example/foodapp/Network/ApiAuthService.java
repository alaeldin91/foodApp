package com.example.foodapp.Network;

import com.example.foodapp.model.ForgetPassword;
import com.example.foodapp.model.LoginModel;
import com.example.foodapp.model.RegisterModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiAuthService {
    @POST("Register.php")
    @FormUrlEncoded
    Observable<RegisterModel> register(@Field("firstName") String firstName,
                                       @Field("secondName") String secondName,
                                       @Field("phoneNumber") String email,
                                       @Field("email") String phoneNumber,
                                       @Field("password") String password);
    @POST("login.php")
    @FormUrlEncoded
    Observable<LoginModel> login(@Field("tel") String phoneNumber, @Field("password") String password);
    @POST("UpdatePassword.php")
    @FormUrlEncoded
    Observable<ForgetPassword> forgetPassword(@Field("password")String newPassword,@Field("phoneNumber")String phoneNumber);




}
