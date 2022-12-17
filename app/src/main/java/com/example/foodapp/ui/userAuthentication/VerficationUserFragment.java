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

import com.example.foodapp.MainActivity;
import com.example.foodapp.R;
import com.example.foodapp.databinding.FragmentVerficationUserBinding;
import com.example.foodapp.helper.PreferencesHelper;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class VerficationUserFragment extends Fragment {
    private static final int RC_SIGN_IN = 123;
    FragmentVerficationUserBinding binding;
    private FirebaseAuth firebaseAuth;
    private View root;
    private RegisterViewModel registerViewModel;
    private PreferencesHelper preferencesHelper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVerficationUserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.appBarVerfication.textToolBar
                .setText(getString(R.string.verficationUser));
        root = binding.appBarVerfication.root;
        preferencesHelper = new PreferencesHelper(getActivity());
        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        ConfigurationFireBaseAuth();
    }

    private void ConfigurationFireBaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance();
        boolean isUserSignIn = firebaseAuth.getCurrentUser() != null;
        if (!isUserSignIn) {
            signIn();
        } else {
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }

    private void signIn() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(Arrays.asList(
                new AuthUI.IdpConfig.PhoneBuilder().build()
        )).build(), RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            handleSignInResponse(resultCode, data);
        }


    }

    private void handleSignInResponse(int resultCode, Intent data) {
        IdpResponse idpResponse = IdpResponse.fromResultIntent(data);
        if (resultCode == RESULT_OK) {
            goHomeScreen();
        } else {
            if (idpResponse == null) {
                showSnackBar(R.string.login_cancelled);
            }
            if (idpResponse.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                showSnackBar(R.string.no_Internet);
            }
            if (idpResponse.getError().getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                showSnackBar(R.string.un_known_Error);
            }
        }
        showSnackBar(R.string.un_known_SignIn);

    }

    private void showSnackBar(int errorMessage) {
        Snackbar.make(root, errorMessage, Snackbar.LENGTH_LONG).show();
    }

    private void goHomeScreen() {
        saveInformationUserData();
    }

    private void saveInformationUserData() {
        String phoneNumber = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getPhoneNumber();
        preferencesHelper.putString("phoneNumber", phoneNumber);
        String firstName = preferencesHelper.getString("firstName");
        String secondName = preferencesHelper.getString("secondName");
        String email = preferencesHelper.getString("email");
        String password = preferencesHelper.getString("password");
        registerViewModel.observerRegister(firstName, secondName, phoneNumber, email, password, getActivity());
    }

}