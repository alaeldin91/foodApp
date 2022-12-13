package com.example.foodapp.ui.userAuthentication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodapp.MainActivity;
import com.example.foodapp.R;
import com.example.foodapp.UserAuthentication;
import com.example.foodapp.databinding.FragmentLoginBinding;
import com.example.foodapp.helper.PreferencesHelper;
import com.example.foodapp.model.LoginModel;
import com.example.foodapp.respository.UserAuthenticationRepository;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@AndroidEntryPoint
public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;
    private PreferencesHelper preferencesHelper;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eventRegister();
        eventForgetPassword();
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        login();
    }

    private void eventRegister() {
        binding.signup.setOnClickListener(view -> {
            Register register = new Register();
            ((UserAuthentication) getActivity()).getSupportFragmentManager()
                    .beginTransaction().replace(R.id.frameUser, register).commit();
        });
    }

    private void eventForgetPassword() {
        binding.forgetPassword.setOnClickListener(view -> {
            ForgetPasswordFragment forgetPasswordFragment = new ForgetPasswordFragment();
            ((UserAuthentication) getActivity()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameUser, forgetPasswordFragment).commit();
        });
    }

    public void login() {
        binding.login.setOnClickListener(view -> {
            String phoneNumber = binding.phoneNumberEdt.getText().toString();
            String password = binding.passwordEdt.getText().toString();
            preferencesHelper = new PreferencesHelper(getContext());
            preferencesHelper.putString("phoneNumber",phoneNumber);
            preferencesHelper.putString("password",password);
            loginViewModel.observerLogin(phoneNumber, password,
                    getActivity(),binding.phoneNumberEdt,binding.passwordEdt);

        });

    }

}