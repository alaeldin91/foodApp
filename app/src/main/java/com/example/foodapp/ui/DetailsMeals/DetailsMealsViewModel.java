package com.example.foodapp.ui.DetailsMeals;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodapp.model.MealItem;
import com.example.foodapp.model.MealList;
import com.example.foodapp.respository.MealRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class DetailsMealsViewModel extends ViewModel {
    final MealRepository mealRepository;
    MutableLiveData<ArrayList<MealItem>> mealItemMutableLiveData = new MutableLiveData<>();
    private LiveData<List<MealItem>> mealItemPopular;

    @Inject
    public DetailsMealsViewModel(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
        this.mealItemPopular = mealRepository.getLocalPopularMealItem();
    }

    public void getDetailsMeals(String id) {
        mealRepository.getDetailsMeals(id).subscribeOn(Schedulers.io()).map(new Function<MealList, ArrayList<MealItem>>() {
            @Override
            public ArrayList<MealItem> apply(MealList mealList) throws Throwable {
                ArrayList<MealItem> mealItemArrayList = mealList.getMealsList();
                return mealItemArrayList;
            }
        }).observeOn(Schedulers.io()).subscribe(result -> mealItemMutableLiveData.postValue(result),
                error -> Log.i("hajji", error.getMessage()));
    }

    public MutableLiveData<ArrayList<MealItem>> getDetailsMutable(String id) {
        return mealItemMutableLiveData;
    }

    public LiveData<List<MealItem>> getLiveLocalDetails() {
        return mealItemPopular;
    }

    public void getLocalDetailsMeals() {
        this.mealItemPopular = mealRepository.getLocalPopularMealItem();
    }
}
