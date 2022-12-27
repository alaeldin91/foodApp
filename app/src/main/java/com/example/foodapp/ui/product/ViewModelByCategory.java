package com.example.foodapp.ui.product;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodapp.model.MealByCategory;
import com.example.foodapp.respository.MealRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class ViewModelByCategory extends ViewModel {
    private final MutableLiveData<ArrayList<MealByCategory>> mealByCategory = new MutableLiveData<>();
    private final MealRepository mealRepository;

    @Inject
    public ViewModelByCategory(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void observerMealByCategory(String categoryName) {
        mealRepository.getMealByCategory(categoryName).subscribeOn(Schedulers.io()).map(mealListByCategory -> {
            ArrayList<MealByCategory> mealByCategories = mealListByCategory.getMealByCategoryList();
            Log.i("musa",mealByCategories+"");
            return mealByCategories;
        }).observeOn(Schedulers.io()).subscribe(result -> mealByCategory.postValue(result), error ->
                Log.i("error", error.getMessage()));
    }
    public MutableLiveData<ArrayList<MealByCategory>> getMealByCategoryMutableLiveData(){
        return mealByCategory;
    }
}
