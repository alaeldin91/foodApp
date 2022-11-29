package com.example.foodapp.ui.userAuthentication;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.ViewModel;
import com.example.foodapp.MainActivity;
import com.example.foodapp.UserAuthentication;
import com.example.foodapp.model.LoginModel;
import com.example.foodapp.respository.UserAuthenticationRepository;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class LoginViewModel extends ViewModel {
    private final UserAuthenticationRepository userAuthenticationRepository;
    @Inject
    public LoginViewModel(UserAuthenticationRepository userAuthenticationRepository) {
        this.userAuthenticationRepository = userAuthenticationRepository;
    }

    public void observerLogin(String phoneNumber, String password,Activity activity) {
        userAuthenticationRepository.login(phoneNumber, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<LoginModel>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i("ala", d.toString());
                    }

                    @Override
                    public void onNext(@NonNull LoginModel loginModel) {
                      if (loginModel.getResponse().equals("ok")){
                          activity.startActivity(new Intent(activity, MainActivity.class));
                      }
                       else {
                          activity.startActivity(new Intent(activity, UserAuthentication.class));
                      }


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
