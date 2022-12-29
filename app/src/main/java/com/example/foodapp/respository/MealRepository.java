package com.example.foodapp.respository;

import androidx.lifecycle.LiveData;

import com.example.foodapp.Network.ApiService;
import com.example.foodapp.db.MealByCategoryDao;
import com.example.foodapp.db.MealRandomItemDao;
import com.example.foodapp.model.MealByCategory;
import com.example.foodapp.model.MealItem;
import com.example.foodapp.model.MealList;
import com.example.foodapp.model.MealListByCategory;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class MealRepository {
    private final ApiService apiService;
    private final MealRandomItemDao mealRandomItemDao;
    private final MealByCategoryDao mealByCategoryDao;

    @Inject
    public MealRepository(MealRandomItemDao mealRandomItemDao, ApiService apiService, MealByCategoryDao mealByCategoryDao) {
        this.mealRandomItemDao = mealRandomItemDao;
        this.apiService = apiService;
        this.mealByCategoryDao = mealByCategoryDao;
    }

    public Observable<MealList> getRandomMealListItemFirst() {
        return apiService.getRandomMeals();
    }

    public void insertRandomMealItem(MealItem mealItem) {
        mealRandomItemDao.insertRandomMealItem(mealItem);
    }

    public void insertMealByCategory(MealByCategory mealByCategory) {
        mealByCategoryDao.insertMealByCategory(mealByCategory);

    }

    public Observable<MealList> getPopularMealsItem(String category) {
        return apiService.getPopularItems(category);
    }

    public LiveData<List<MealItem>> getLocalPopularMealItem() {
        return mealRandomItemDao.getMeal();
    }

    public Observable<MealList> getDetailsMeals(String id) {
        return apiService.getDetailMeal(id);
    }

    public Observable<MealListByCategory> getMealByCategory(String category) {
        return apiService.getMealItemByCategory(category);
    }

    public LiveData<List<MealByCategory>> getMealByCategoryLocal() {
        return mealByCategoryDao.getMealByCategories();
    }
}

