// Generated by view binder compiler. Do not edit!
package com.example.foodapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.foodapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ConstraintLayout conTextField;

  @NonNull
  public final Button forgetPassword;

  @NonNull
  public final ImageView imageLogin;

  @NonNull
  public final Button login;

  @NonNull
  public final TextInputEditText passwordEdt;

  @NonNull
  public final TextInputEditText phoneNumberEdt;

  @NonNull
  public final TextInputLayout phoneNumberLayout;

  @NonNull
  public final Button signup;

  private FragmentLoginBinding(@NonNull LinearLayout rootView,
      @NonNull ConstraintLayout conTextField, @NonNull Button forgetPassword,
      @NonNull ImageView imageLogin, @NonNull Button login, @NonNull TextInputEditText passwordEdt,
      @NonNull TextInputEditText phoneNumberEdt, @NonNull TextInputLayout phoneNumberLayout,
      @NonNull Button signup) {
    this.rootView = rootView;
    this.conTextField = conTextField;
    this.forgetPassword = forgetPassword;
    this.imageLogin = imageLogin;
    this.login = login;
    this.passwordEdt = passwordEdt;
    this.phoneNumberEdt = phoneNumberEdt;
    this.phoneNumberLayout = phoneNumberLayout;
    this.signup = signup;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.conTextField;
      ConstraintLayout conTextField = ViewBindings.findChildViewById(rootView, id);
      if (conTextField == null) {
        break missingId;
      }

      id = R.id.forgetPassword;
      Button forgetPassword = ViewBindings.findChildViewById(rootView, id);
      if (forgetPassword == null) {
        break missingId;
      }

      id = R.id.imageLogin;
      ImageView imageLogin = ViewBindings.findChildViewById(rootView, id);
      if (imageLogin == null) {
        break missingId;
      }

      id = R.id.login;
      Button login = ViewBindings.findChildViewById(rootView, id);
      if (login == null) {
        break missingId;
      }

      id = R.id.passwordEdt;
      TextInputEditText passwordEdt = ViewBindings.findChildViewById(rootView, id);
      if (passwordEdt == null) {
        break missingId;
      }

      id = R.id.phoneNumberEdt;
      TextInputEditText phoneNumberEdt = ViewBindings.findChildViewById(rootView, id);
      if (phoneNumberEdt == null) {
        break missingId;
      }

      id = R.id.phoneNumberLayout;
      TextInputLayout phoneNumberLayout = ViewBindings.findChildViewById(rootView, id);
      if (phoneNumberLayout == null) {
        break missingId;
      }

      id = R.id.signup;
      Button signup = ViewBindings.findChildViewById(rootView, id);
      if (signup == null) {
        break missingId;
      }

      return new FragmentLoginBinding((LinearLayout) rootView, conTextField, forgetPassword,
          imageLogin, login, passwordEdt, phoneNumberEdt, phoneNumberLayout, signup);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}