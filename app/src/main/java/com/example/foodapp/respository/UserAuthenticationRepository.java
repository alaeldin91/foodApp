package com.example.foodapp.respository;

import com.example.foodapp.Network.ApiAuthService;
import com.example.foodapp.model.ForgetPassword;
import com.example.foodapp.model.LoginModel;
import com.example.foodapp.model.RegisterModel;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class UserAuthenticationRepository {
    private final ApiAuthService apiService;

    @Inject
    public UserAuthenticationRepository(ApiAuthService apiService) {
        this.apiService = apiService;
    }

    public Observable<RegisterModel> register(String firstName, String secondName, String
            phoneNumber, String email, String password) {
        return apiService.register(firstName, secondName, phoneNumber, email, password);
    }

    public Observable<LoginModel> login(String phoneNumber, String password) {
        return apiService.login(phoneNumber, password);
    }

    public Observable<ForgetPassword> forgetPassword(String newPassword, String phoneNumber) {
        return apiService.forgetPassword(newPassword, phoneNumber);
    }
}
