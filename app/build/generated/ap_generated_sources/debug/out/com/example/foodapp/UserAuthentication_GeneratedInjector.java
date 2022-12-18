package com.example.foodapp;

import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = UserAuthentication.class
)
@GeneratedEntryPoint
@InstallIn(ActivityComponent.class)
public interface UserAuthentication_GeneratedInjector {
  void injectUserAuthentication(UserAuthentication userAuthentication);
}
