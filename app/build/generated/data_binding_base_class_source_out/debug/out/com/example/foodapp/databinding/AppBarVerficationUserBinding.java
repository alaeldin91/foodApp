// Generated by view binder compiler. Do not edit!
package com.example.foodapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.foodapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AppBarVerficationUserBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final LinearLayout linearToolBar;

  @NonNull
  public final CoordinatorLayout root;

  @NonNull
  public final TextView textToolBar;

  @NonNull
  public final Toolbar toolbar;

  private AppBarVerficationUserBinding(@NonNull CoordinatorLayout rootView,
      @NonNull LinearLayout linearToolBar, @NonNull CoordinatorLayout root,
      @NonNull TextView textToolBar, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.linearToolBar = linearToolBar;
    this.root = root;
    this.textToolBar = textToolBar;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AppBarVerficationUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AppBarVerficationUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.app_bar_verfication_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AppBarVerficationUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.linearToolBar;
      LinearLayout linearToolBar = ViewBindings.findChildViewById(rootView, id);
      if (linearToolBar == null) {
        break missingId;
      }

      CoordinatorLayout root = (CoordinatorLayout) rootView;

      id = R.id.textToolBar;
      TextView textToolBar = ViewBindings.findChildViewById(rootView, id);
      if (textToolBar == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new AppBarVerficationUserBinding((CoordinatorLayout) rootView, linearToolBar, root,
          textToolBar, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
