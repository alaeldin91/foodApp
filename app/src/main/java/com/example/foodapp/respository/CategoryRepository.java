package com.example.foodapp.respository;

import com.example.foodapp.Network.ApiService;
import com.example.foodapp.model.CategoryList;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class CategoryRepository {
    private final ApiService apiService;

    @Inject
    public CategoryRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<CategoryList> getCategoryList() {
        return apiService.getCategory();
    }


}
