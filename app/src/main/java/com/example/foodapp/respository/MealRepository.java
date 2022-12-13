package com.example.foodapp.respository;

import androidx.lifecycle.LiveData;

import com.example.foodapp.Network.ApiService;
import com.example.foodapp.db.MealRandomItemDao;
import com.example.foodapp.model.MealItem;
import com.example.foodapp.model.MealList;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class MealRepository {
    private final ApiService apiService;
    private final MealRandomItemDao mealRandomItemDao;

    @Inject
    public MealRepository(MealRandomItemDao mealRandomItemDao, ApiService apiService) {
        this.mealRandomItemDao = mealRandomItemDao;
        this.apiService = apiService;
    }

    public Observable<MealList> getRandomMealListItemFirst() {
        return apiService.getRandomMeals();
    }

    public void insertRandomMealItem(MealItem mealItem) {
        mealRandomItemDao.insertRandomMealItem(mealItem);
    }

    public Observable<MealList> getPopularMealsItem(String category) {
        return apiService.getPopularItems(category);
    }
    public LiveData<List<MealItem>> getLocalPopularMealItem(){
        return mealRandomItemDao.getMeal();
    }
    public Observable<MealList> getDetailsMeals(String id){
        return  apiService.getDetailMeal(id);
    }


}
