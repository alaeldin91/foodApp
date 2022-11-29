package com.example.foodapp.ui.userAuthentication;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.foodapp.R;
import com.example.foodapp.UserAuthentication;
import com.example.foodapp.databinding.FragmentRegisterBinding;
import com.example.foodapp.helper.PreferencesHelper;
import com.google.android.material.button.MaterialButton;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class Register extends Fragment {
    PreferencesHelper preferencesHelper;
    private FragmentRegisterBinding binding;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SignUp();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
          return binding.getRoot();
    }

    private void SignUp() {
        binding.signup.setOnClickListener(view -> {
            convertEdtToString();

        });

    }

    private void validation(String firstName, String secondName,
                            String email, String password, String confirmPassword) {
        if (TextUtils.isEmpty(firstName)) {
            binding.firstNameEdt.setError(getString(R.string.enterFirstName));
            binding.firstNameEdt.requestFocus();
        } else if (TextUtils.isEmpty(secondName)) {
            binding.secondNameEdt.setError(getString(R.string.enterSecondName));
            binding.secondNameEdt.requestFocus();
        } else if (TextUtils.isEmpty(email)) {
            binding.emailEdt.setError(getString(R.string.enterEmail));
            binding.emailEdt.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            binding.passwordEdt.setError(getString(R.string.enterPassword));
            binding.passwordEdt.requestFocus();
        } else if (TextUtils.isEmpty(confirmPassword)) {
            binding.confirmPasswordEdt.setError(getString(R.string.enterConfirmPassword));
        } else if (!password.equals(confirmPassword)) {
            showErrorConfirmDialog();
            Toast.makeText(getContext(), "password is not confirm password", Toast.LENGTH_LONG).show();
        } else {
            preferencesHelper = new PreferencesHelper(getActivity());
            // sharedPreferences = this.getActivity().getSharedPreferences("authPreference", getContext().MODE_PRIVATE);
            preferencesHelper.putString("firstName", firstName);
            preferencesHelper.putString("firstName", firstName);
            preferencesHelper.putString("secondName", secondName);
            preferencesHelper.putString("email",email);
            preferencesHelper.putString("password", password);
            VerficationUserFragment verficationUserFragment = new VerficationUserFragment();
            ((UserAuthentication) getActivity()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameUser, verficationUserFragment).commit();


        }

    }

    private void showErrorConfirmDialog() {
        Dialog dialogErrorConfirm = new Dialog(getContext());
        dialogErrorConfirm.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogErrorConfirm.setContentView(R.layout.lay_custom_dialog);
        dialogErrorConfirm.setCancelable(true);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialogErrorConfirm.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        MaterialButton ok = dialogErrorConfirm.findViewById(R.id.btnok);
        dialogErrorConfirm.show();
        ok.setOnClickListener(view -> dialogErrorConfirm.dismiss());

    }

    private void convertEdtToString() {
        String firstName = binding.firstNameEdt.getText().toString();
        String secondName = binding.secondNameEdt.getText().toString();
        String email = binding.emailEdt.getText().toString();
        String password = binding.passwordEdt.getText().toString();
        String confirmPassword = binding.confirmPasswordEdt.getText().toString();
        validation(firstName, secondName, email, password, confirmPassword);
    }


}