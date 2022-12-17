package com.example.foodapp.ui.userAuthentication;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.foodapp.MainActivity;
import com.example.foodapp.UserAuthentication;
import com.example.foodapp.model.RegisterModel;
import com.example.foodapp.respository.UserAuthenticationRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class RegisterViewModel extends ViewModel {
    private final UserAuthenticationRepository userAuthenticationRepository;

    @Inject
    public RegisterViewModel(UserAuthenticationRepository userAuthenticationRepository) {
        this.userAuthenticationRepository = userAuthenticationRepository;
    }

    public void observerRegister(String firstName,
                                 String secondName,
                                 String phoneNumber,
                                 String email,
                                 String password,
                                 Activity activity) {
        userAuthenticationRepository.register(firstName, secondName, phoneNumber, email, password)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterModel>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i("ala", d.toString());

                    }

                    @Override
                    public void onNext(@NonNull RegisterModel registerModel) {

                        if (registerModel.getResponse().equals("ok")) {
                            activity.startActivity(new Intent(activity, MainActivity.class));
                        } else {
                            activity.startActivity(new Intent(activity, UserAuthentication.class));
                            Toast.makeText(activity, "the User is exist", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("ala", "USERNAME DON'T EXIST" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {


                    }
                });
    }

}
