package com.example.foodapp.respository;

import androidx.lifecycle.LiveData;

import com.example.foodapp.Network.ApiService;
import com.example.foodapp.db.CategoryItemDao;
import com.example.foodapp.model.CategoryItem;
import com.example.foodapp.model.CategoryList;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class CategoryRepository {
    private final ApiService apiService;
    private final CategoryItemDao categoryItemDao;

    @Inject
    public CategoryRepository(ApiService apiService, CategoryItemDao categoryItemDao) {
        this.apiService = apiService;
        this.categoryItemDao = categoryItemDao;
    }

    public Observable<CategoryList> getCategoryList() {
        return apiService.getCategory();
    }

    public void insertCategoryItem(CategoryItem categoryItem) {
        categoryItemDao.insertCategoryListItem(categoryItem);
    }

    public LiveData<List<CategoryItem>> getLocalCategoryList() {
        return categoryItemDao.getCategories();
    }


}
