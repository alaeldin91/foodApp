package com.example.foodapp.ui.userAuthentication;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.foodapp.MainActivity;
import com.example.foodapp.model.ForgetPassword;
import com.example.foodapp.respository.UserAuthenticationRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class ForgetPasswordViewModel extends ViewModel {
    private final UserAuthenticationRepository userAuthenticationRepository;

    @Inject
    public ForgetPasswordViewModel(UserAuthenticationRepository userAuthenticationRepository) {
        this.userAuthenticationRepository = userAuthenticationRepository;
    }

    public void observerForgetPassword(String newPassword, String phoneNumber, Activity activity) {
        userAuthenticationRepository.
                forgetPassword(newPassword, phoneNumber)
                .subscribeOn(Schedulers.io()
                ).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ForgetPassword>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i("ala", d.toString());
                    }

                    @Override
                    public void onNext(@NonNull ForgetPassword forgetPassword) {
                        if (forgetPassword.getResponse().equals("ok")) {
                            Toast.makeText(activity, "message" + forgetPassword.getResponse(), Toast.LENGTH_SHORT).show();
                            activity.startActivity(new Intent(activity, MainActivity.class));
                        } else {
                            activity.startActivity(new Intent(activity, Register.class));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
