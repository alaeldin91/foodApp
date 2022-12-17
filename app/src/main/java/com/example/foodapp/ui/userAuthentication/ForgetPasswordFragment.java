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
import com.example.foodapp.databinding.FragmentForgetPasswordBinding;
import com.example.foodapp.helper.PreferencesHelper;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ForgetPasswordFragment extends Fragment {
    PreferencesHelper preferencesHelper;
    private FragmentForgetPasswordBinding fragmentForgetPasswordBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentForgetPasswordBinding = FragmentForgetPasswordBinding.inflate(getLayoutInflater());
        return fragmentForgetPasswordBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        forgetPassword();
    }

    private void forgetPassword() {
        fragmentForgetPasswordBinding.changePassword.setOnClickListener(view -> EdtToStringForgetPassword());
    }

    private void validation(String newPassword, String confirmPassword) {


        if (TextUtils.isEmpty(newPassword)) {
            fragmentForgetPasswordBinding.passwordEdt.setError(getString(R.string.newPasswordQuestion));
            fragmentForgetPasswordBinding.passwordEdt.requestFocus();
        } else if (TextUtils.isEmpty(confirmPassword)) {
            fragmentForgetPasswordBinding.confirmPasswordEdt.setError(getString(R.string.confirmPasswordQuestion));
            fragmentForgetPasswordBinding.confirmPasswordEdt.requestFocus();
        } else if (!newPassword.equals(confirmPassword)) {
            showErrorPasswordDialog();
            Toast.makeText(getContext(), "password is not confirm password", Toast.LENGTH_LONG).show();
        } else {
            preferencesHelper = new PreferencesHelper(getActivity());
            preferencesHelper.putString("password", newPassword);
            VerficationForgetPasswordFragment verficationForgetPasswordFragment = new VerficationForgetPasswordFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameUser, verficationForgetPasswordFragment).commit();
        }
    }

    private void EdtToStringForgetPassword() {
        String newPassword = Objects.requireNonNull(fragmentForgetPasswordBinding.passwordEdt.getText()).toString();
        String confirmPassword = Objects.requireNonNull(fragmentForgetPasswordBinding.confirmPasswordEdt.getText()).toString();
        validation(newPassword, confirmPassword);

    }

    private void showErrorPasswordDialog() {
        Dialog dialogErrorConfirmPassword = new Dialog(getContext());
        dialogErrorConfirmPassword.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogErrorConfirmPassword.setContentView(R.layout.lay_custom_dialog);
        dialogErrorConfirmPassword.setCancelable(true);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialogErrorConfirmPassword.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        MaterialButton ok = dialogErrorConfirmPassword.findViewById(R.id.btnok);
        dialogErrorConfirmPassword.show();
        ok.setOnClickListener(view -> dialogErrorConfirmPassword.dismiss());
    }
}