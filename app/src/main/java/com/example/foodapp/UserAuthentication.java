package com.example.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.foodapp.Network.ApiAuthService;
import com.example.foodapp.databinding.ActivityUserAuthnicationBinding;
import com.example.foodapp.respository.UserAuthenticationRepository;
import com.example.foodapp.ui.userAuthentication.LoginFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserAuthentication extends AppCompatActivity {
    ActivityUserAuthnicationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserAuthnicationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LoginFragment loginFragment = new LoginFragment();
        setCurrentFragment(loginFragment);
    }
    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameUser, fragment).commit();
    }
}