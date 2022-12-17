package com.example.foodapp.ui.userAuthentication;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodapp.R;
import com.example.foodapp.databinding.FragmentVerficationForgetPasswordBinding;
import com.example.foodapp.helper.PreferencesHelper;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Collections;
import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class VerficationForgetPasswordFragment extends Fragment {
    private static final int RC_SIGN_IN = 123;
    FragmentVerficationForgetPasswordBinding verficationForgetPasswordBinding;
    private FirebaseAuth firebaseAuth;
    private View root;
    private ForgetPasswordViewModel forgetPasswordViewModel;
    private PreferencesHelper preferencesHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        verficationForgetPasswordBinding = FragmentVerficationForgetPasswordBinding.
                inflate(inflater, container, false);
        return verficationForgetPasswordBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        verficationForgetPasswordBinding.textToolBar.setText(getString(R.string.verficationUser));
        root = verficationForgetPasswordBinding.root;
        preferencesHelper = new PreferencesHelper(getActivity());
        forgetPasswordViewModel = new ViewModelProvider(this).get(ForgetPasswordViewModel.class);
        ConfigurationFireBaseAuth();
    }

    private void ConfigurationFireBaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance();
        changePassword();
    }

    private void changePassword() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders
                (Collections.singletonList(new AuthUI.IdpConfig.PhoneBuilder().build())).build(), RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            handleForgetResponse(resultCode, data);
        }
    }

    private void handleForgetResponse(int resultCode, Intent data) {
        IdpResponse idpResponse = IdpResponse.fromResultIntent(data);
        if (resultCode == RESULT_OK) {
            goHome();
        } else {
            if (idpResponse == null) {
                showSnackBar(R.string.login_cancelled);
            }
            assert idpResponse != null;
            if (Objects.requireNonNull(idpResponse.getError()).getErrorCode() == ErrorCodes.NO_NETWORK) {
                showSnackBar(R.string.no_Internet);
            }
            if (idpResponse.getError().getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                showSnackBar(R.string.un_known_Error);
            }
        }
        showSnackBar(R.string.un_known_Error);

    }


    private void goHome() {
        saveForgetPassword();
    }

    private void saveForgetPassword() {
        String phoneNumber = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getPhoneNumber();
        preferencesHelper.putString("phoneNumber", phoneNumber);
        String newPassword = preferencesHelper.getString("password");

        forgetPasswordViewModel.observerForgetPassword(phoneNumber, newPassword, getActivity());

    }

    private void showSnackBar(int errorMessage) {
        Snackbar.make(root, errorMessage, Snackbar.LENGTH_LONG).show();
    }
}