package com.example.foodapp.ui.home;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.foodapp.model.CategoryItem;
import com.example.foodapp.model.MealItem;
import com.example.foodapp.respository.CategoryRepository;
import com.example.foodapp.respository.MealRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.schedulers.Schedulers;


@HiltViewModel
public class HomeViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<MealItem>> mealRandomListItem = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<MealItem>> mealPopularListItem = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<CategoryItem>> categoryItem = new MutableLiveData<>();
    private final MealRepository mealRepository;
    private final CategoryRepository categoryRepository;
    private LiveData<List<MealItem>> mealItemPopular;
    private LiveData<List<CategoryItem>> categoryLocalItem;

    @Inject
    public HomeViewModel(MealRepository mealRepository, CategoryRepository categoryRepository) {
        this.mealRepository = mealRepository;
        this.categoryRepository = categoryRepository;
        this.mealItemPopular = mealRepository.getLocalPopularMealItem();
        this.categoryLocalItem = categoryRepository.getLocalCategoryList();
    }

    public MutableLiveData<ArrayList<CategoryItem>> getCategoryItem() {
        return categoryItem;
    }

    public MutableLiveData<ArrayList<MealItem>> getRandomMealList() {
        return mealRandomListItem;
    }

    public MutableLiveData<ArrayList<MealItem>> getMealPopularListItem() {
        return mealPopularListItem;
    }

    public LiveData<List<MealItem>> getMealPopularList(String popular) {
        return mealItemPopular;
    }
    public void insertCategoryItem(CategoryItem categoryItem){
        categoryRepository.insertCategoryItem(categoryItem);
    }

    public void insertRandomMealItem(MealItem mealItem) {

        mealRepository.insertRandomMealItem(mealItem);
    }
    public LiveData<List<CategoryItem>> getLiveDataLocalCategories(){
        return categoryLocalItem;
    }

    public void observerCategoryListItem() {
        categoryRepository.getCategoryList().subscribeOn(Schedulers.io()).map(categoryList -> {
            ArrayList<CategoryItem> categoryItem = categoryList.getCategories();
            return categoryItem;
        }).observeOn(Schedulers.io()).subscribe(result->categoryItem.postValue(result),
                error->Log.i("error",error.getMessage()));
    }

    public void observerRandomMealListItem() {
        mealRepository.getRandomMealListItemFirst().subscribeOn(Schedulers.io()).map(mealRandomList -> {
            ArrayList<MealItem> listItemMeal = mealRandomList.getMealsList();
            return listItemMeal;
        }).observeOn(Schedulers.io()).subscribe(result -> mealRandomListItem.postValue(result),
                error -> Log.i("error", error.getMessage()));

    }

    public void observerPopularMealListItem() {
        mealRepository.getPopularMealsItem("Seafood")
                .subscribeOn(Schedulers.io()).map(mealList -> {
            ArrayList<MealItem> listPopularItem = mealList.getMealsList();
            return listPopularItem;
        }).observeOn(Schedulers.io()).subscribe(result -> mealPopularListItem.postValue(result)
                , error -> Log.i("ala", error.getMessage()));
    }

    public void getLocalPopularMeal() {
        this.mealItemPopular = mealRepository.getLocalPopularMealItem();

    }
    public void getLocalCategories(){
        this.categoryLocalItem = categoryRepository.getLocalCategoryList();
    }


}