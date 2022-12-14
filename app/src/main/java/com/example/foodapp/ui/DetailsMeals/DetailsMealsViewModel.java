package com.example.foodapp.ui.DetailsMeals;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodapp.model.MealItem;
import com.example.foodapp.model.MealList;
import com.example.foodapp.respository.MealRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class DetailsMealsViewModel extends ViewModel {
    final MealRepository mealRepository;
    MutableLiveData<ArrayList<MealItem>> mealItemMutableLiveData = new MutableLiveData<>();

    @Inject
    public DetailsMealsViewModel(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void getDetailsMeals(String id) {
        mealRepository.getDetailsMeals(id).subscribeOn(Schedulers.io()).map(new Function<MealList, ArrayList<MealItem>>() {
            @Override
            public ArrayList<MealItem> apply(MealList mealList) throws Throwable {
                ArrayList<MealItem> mealItemArrayList = mealList.getMealsList();
                return mealItemArrayList;
            }
        }).observeOn(Schedulers.io()).subscribe(result -> mealItemMutableLiveData.postValue(result),
                error -> Log.i("haji", error.getMessage()));
    }

    public MutableLiveData<ArrayList<MealItem>> getDetailsMutable(String id) {
        return mealItemMutableLiveData;
    }

}
