// Generated by view binder compiler. Do not edit!
package com.example.foodapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

public final class FragmentForgetPasswordBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button changePassword;

  @NonNull
  public final TextInputEditText confirmPasswordEdt;

  @NonNull
  public final ImageView imageLogin;

  @NonNull
  public final TextInputLayout newPasswordLayout;

  @NonNull
  public final TextInputEditText passwordEdt;

  private FragmentForgetPasswordBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button changePassword, @NonNull TextInputEditText confirmPasswordEdt,
      @NonNull ImageView imageLogin, @NonNull TextInputLayout newPasswordLayout,
      @NonNull TextInputEditText passwordEdt) {
    this.rootView = rootView;
    this.changePassword = changePassword;
    this.confirmPasswordEdt = confirmPasswordEdt;
    this.imageLogin = imageLogin;
    this.newPasswordLayout = newPasswordLayout;
    this.passwordEdt = passwordEdt;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentForgetPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentForgetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_forget_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentForgetPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.changePassword;
      Button changePassword = ViewBindings.findChildViewById(rootView, id);
      if (changePassword == null) {
        break missingId;
      }

      id = R.id.confirm_passwordEdt;
      TextInputEditText confirmPasswordEdt = ViewBindings.findChildViewById(rootView, id);
      if (confirmPasswordEdt == null) {
        break missingId;
      }

      id = R.id.imageLogin;
      ImageView imageLogin = ViewBindings.findChildViewById(rootView, id);
      if (imageLogin == null) {
        break missingId;
      }

      id = R.id.newPasswordLayout;
      TextInputLayout newPasswordLayout = ViewBindings.findChildViewById(rootView, id);
      if (newPasswordLayout == null) {
        break missingId;
      }

      id = R.id.passwordEdt;
      TextInputEditText passwordEdt = ViewBindings.findChildViewById(rootView, id);
      if (passwordEdt == null) {
        break missingId;
      }

      return new FragmentForgetPasswordBinding((ConstraintLayout) rootView, changePassword,
          confirmPasswordEdt, imageLogin, newPasswordLayout, passwordEdt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
