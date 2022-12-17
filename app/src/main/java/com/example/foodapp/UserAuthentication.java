package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.foodapp.Network.ApiAuthService;
import com.example.foodapp.databinding.ActivityUserAuthnicationBinding;
import com.example.foodapp.helper.PreferencesHelper;
import com.example.foodapp.respository.UserAuthenticationRepository;
import com.example.foodapp.ui.userAuthentication.LoginFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserAuthentication extends AppCompatActivity {
    ActivityUserAuthnicationBinding binding;
     private PreferencesHelper preferencesHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserAuthnicationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferencesHelper  = new PreferencesHelper(this);
        String phoneNumber = preferencesHelper.getString("phoneNumber");
        String password = preferencesHelper.getString("password");
        Log.i("ala2",password+" "+phoneNumber);
        if ((phoneNumber.equals(""))&& (password.equals(""))){
            LoginFragment loginFragment = new LoginFragment();
            setCurrentFragment(loginFragment);

        }
        else{
            startActivity(new Intent(UserAuthentication.this,MainActivity.class));
        }
    }
    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameUser, fragment).commit();
    }
}