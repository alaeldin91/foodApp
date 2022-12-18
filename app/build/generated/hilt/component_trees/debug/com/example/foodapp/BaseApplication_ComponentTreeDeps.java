package com.example.foodapp;

import dagger.hilt.internal.aggregatedroot.codegen._com_example_foodapp_BaseApplication;
import dagger.hilt.internal.componenttreedeps.ComponentTreeDeps;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_components_ActivityComponent;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_components_ActivityRetainedComponent;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_components_FragmentComponent;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_components_ServiceComponent;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_components_ViewComponent;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_components_ViewModelComponent;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_components_ViewWithFragmentComponent;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_internal_builders_ActivityComponentBuilder;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_internal_builders_ActivityRetainedComponentBuilder;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_internal_builders_FragmentComponentBuilder;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_internal_builders_ServiceComponentBuilder;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_internal_builders_ViewComponentBuilder;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_internal_builders_ViewModelComponentBuilder;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_internal_builders_ViewWithFragmentComponentBuilder;
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_components_SingletonComponent;
import hilt_aggregated_deps._com_example_foodapp_BaseApplication_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_MainActivity_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_UserAuthentication_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_di_DataBaseModule;
import hilt_aggregated_deps._com_example_foodapp_di_NetworkModule;
import hilt_aggregated_deps._com_example_foodapp_ui_DetailsMeals_DetailsMealsViewModel_HiltModules_BindsModule;
import hilt_aggregated_deps._com_example_foodapp_ui_DetailsMeals_DetailsMealsViewModel_HiltModules_KeyModule;
import hilt_aggregated_deps._com_example_foodapp_ui_DetailsMeals_ShowRandomMeals_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_ui_home_HomeFragment_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_ui_home_HomeViewModel_HiltModules_BindsModule;
import hilt_aggregated_deps._com_example_foodapp_ui_home_HomeViewModel_HiltModules_KeyModule;
import hilt_aggregated_deps._com_example_foodapp_ui_product_MealActivity_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_ForgetPasswordFragment_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_ForgetPasswordViewModel_HiltModules_BindsModule;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_ForgetPasswordViewModel_HiltModules_KeyModule;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_LoginFragment_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_LoginViewModel_HiltModules_BindsModule;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_LoginViewModel_HiltModules_KeyModule;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_RegisterViewModel_HiltModules_BindsModule;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_RegisterViewModel_HiltModules_KeyModule;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_Register_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_VerficationForgetPasswordFragment_GeneratedInjector;
import hilt_aggregated_deps._com_example_foodapp_ui_userAuthentication_VerficationUserFragment_GeneratedInjector;
import hilt_aggregated_deps._dagger_hilt_android_flags_FragmentGetContextFix_FragmentGetContextFixEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_flags_HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_DefaultViewModelFactories_ActivityEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_DefaultViewModelFactories_FragmentEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_HiltViewModelFactory_ViewModelFactoriesEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_HiltWrapper_DefaultViewModelFactories_ActivityModule;
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_HiltWrapper_HiltViewModelFactory_ViewModelModule;
import hilt_aggregated_deps._dagger_hilt_android_internal_managers_ActivityComponentManager_ActivityComponentBuilderEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_managers_FragmentComponentManager_FragmentComponentBuilderEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_managers_HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_managers_HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_managers_HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import hilt_aggregated_deps._dagger_hilt_android_internal_managers_ServiceComponentManager_ServiceComponentBuilderEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_managers_ViewComponentManager_ViewComponentBuilderEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_managers_ViewComponentManager_ViewWithFragmentComponentBuilderEntryPoint;
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_ApplicationContextModule;
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_HiltWrapper_ActivityModule;

@ComponentTreeDeps(
    rootDeps = _com_example_foodapp_BaseApplication.class,
    defineComponentDeps = {
        _dagger_hilt_android_components_ActivityComponent.class,
        _dagger_hilt_android_components_ActivityRetainedComponent.class,
        _dagger_hilt_android_components_FragmentComponent.class,
        _dagger_hilt_android_components_ServiceComponent.class,
        _dagger_hilt_android_components_ViewComponent.class,
        _dagger_hilt_android_components_ViewModelComponent.class,
        _dagger_hilt_android_components_ViewWithFragmentComponent.class,
        _dagger_hilt_android_internal_builders_ActivityComponentBuilder.class,
        _dagger_hilt_android_internal_builders_ActivityRetainedComponentBuilder.class,
        _dagger_hilt_android_internal_builders_FragmentComponentBuilder.class,
        _dagger_hilt_android_internal_builders_ServiceComponentBuilder.class,
        _dagger_hilt_android_internal_builders_ViewComponentBuilder.class,
        _dagger_hilt_android_internal_builders_ViewModelComponentBuilder.class,
        _dagger_hilt_android_internal_builders_ViewWithFragmentComponentBuilder.class,
        _dagger_hilt_components_SingletonComponent.class
    },
    aggregatedDeps = {
        _com_example_foodapp_BaseApplication_GeneratedInjector.class,
        _com_example_foodapp_MainActivity_GeneratedInjector.class,
        _com_example_foodapp_UserAuthentication_GeneratedInjector.class,
        _com_example_foodapp_di_DataBaseModule.class,
        _com_example_foodapp_di_NetworkModule.class,
        _com_example_foodapp_ui_DetailsMeals_DetailsMealsViewModel_HiltModules_BindsModule.class,
        _com_example_foodapp_ui_DetailsMeals_DetailsMealsViewModel_HiltModules_KeyModule.class,
        _com_example_foodapp_ui_DetailsMeals_ShowRandomMeals_GeneratedInjector.class,
        _com_example_foodapp_ui_home_HomeFragment_GeneratedInjector.class,
        _com_example_foodapp_ui_home_HomeViewModel_HiltModules_BindsModule.class,
        _com_example_foodapp_ui_home_HomeViewModel_HiltModules_KeyModule.class,
        _com_example_foodapp_ui_product_MealActivity_GeneratedInjector.class,
        _com_example_foodapp_ui_userAuthentication_ForgetPasswordFragment_GeneratedInjector.class,
        _com_example_foodapp_ui_userAuthentication_ForgetPasswordViewModel_HiltModules_BindsModule.class,
        _com_example_foodapp_ui_userAuthentication_ForgetPasswordViewModel_HiltModules_KeyModule.class,
        _com_example_foodapp_ui_userAuthentication_LoginFragment_GeneratedInjector.class,
        _com_example_foodapp_ui_userAuthentication_LoginViewModel_HiltModules_BindsModule.class,
        _com_example_foodapp_ui_userAuthentication_LoginViewModel_HiltModules_KeyModule.class,
        _com_example_foodapp_ui_userAuthentication_RegisterViewModel_HiltModules_BindsModule.class,
        _com_example_foodapp_ui_userAuthentication_RegisterViewModel_HiltModules_KeyModule.class,
        _com_example_foodapp_ui_userAuthentication_Register_GeneratedInjector.class,
        _com_example_foodapp_ui_userAuthentication_VerficationForgetPasswordFragment_GeneratedInjector.class,
        _com_example_foodapp_ui_userAuthentication_VerficationUserFragment_GeneratedInjector.class,
        _dagger_hilt_android_flags_FragmentGetContextFix_FragmentGetContextFixEntryPoint.class,
        _dagger_hilt_android_flags_HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class,
        _dagger_hilt_android_internal_lifecycle_DefaultViewModelFactories_ActivityEntryPoint.class,
        _dagger_hilt_android_internal_lifecycle_DefaultViewModelFactories_FragmentEntryPoint.class,
        _dagger_hilt_android_internal_lifecycle_HiltViewModelFactory_ViewModelFactoriesEntryPoint.class,
        _dagger_hilt_android_internal_lifecycle_HiltWrapper_DefaultViewModelFactories_ActivityModule.class,
        _dagger_hilt_android_internal_lifecycle_HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint.class,
        _dagger_hilt_android_internal_lifecycle_HiltWrapper_HiltViewModelFactory_ViewModelModule.class,
        _dagger_hilt_android_internal_managers_ActivityComponentManager_ActivityComponentBuilderEntryPoint.class,
        _dagger_hilt_android_internal_managers_FragmentComponentManager_FragmentComponentBuilderEntryPoint.class,
        _dagger_hilt_android_internal_managers_HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint.class,
        _dagger_hilt_android_internal_managers_HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint.class,
        _dagger_hilt_android_internal_managers_HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
        _dagger_hilt_android_internal_managers_ServiceComponentManager_ServiceComponentBuilderEntryPoint.class,
        _dagger_hilt_android_internal_managers_ViewComponentManager_ViewComponentBuilderEntryPoint.class,
        _dagger_hilt_android_internal_managers_ViewComponentManager_ViewWithFragmentComponentBuilderEntryPoint.class,
        _dagger_hilt_android_internal_modules_ApplicationContextModule.class,
        _dagger_hilt_android_internal_modules_HiltWrapper_ActivityModule.class
    }
)
public final class BaseApplication_ComponentTreeDeps {
}
