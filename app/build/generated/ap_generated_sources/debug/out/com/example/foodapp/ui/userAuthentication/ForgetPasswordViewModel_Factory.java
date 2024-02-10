// Generated by Dagger (https://dagger.dev).
package com.example.foodapp.ui.userAuthentication;

import com.example.foodapp.respository.UserAuthenticationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ForgetPasswordViewModel_Factory implements Factory<ForgetPasswordViewModel> {
  private final Provider<UserAuthenticationRepository> userAuthenticationRepositoryProvider;

  public ForgetPasswordViewModel_Factory(
      Provider<UserAuthenticationRepository> userAuthenticationRepositoryProvider) {
    this.userAuthenticationRepositoryProvider = userAuthenticationRepositoryProvider;
  }

  @Override
  public ForgetPasswordViewModel get() {
    return newInstance(userAuthenticationRepositoryProvider.get());
  }

  public static ForgetPasswordViewModel_Factory create(
      Provider<UserAuthenticationRepository> userAuthenticationRepositoryProvider) {
    return new ForgetPasswordViewModel_Factory(userAuthenticationRepositoryProvider);
  }

  public static ForgetPasswordViewModel newInstance(
      UserAuthenticationRepository userAuthenticationRepository) {
    return new ForgetPasswordViewModel(userAuthenticationRepository);
  }
}