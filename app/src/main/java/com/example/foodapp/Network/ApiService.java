package com.example.foodapp.Network;

import com.example.foodapp.model.CategoryList;
import com.example.foodapp.model.MealList;
import com.example.foodapp.model.RegisterModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("random.php")
    Observable<MealList> getRandomMeals();

    @GET("filter.php")
    Observable<MealList> getPopularItems(@Query("c") String category);

    @GET("categories.php")
    Observable<CategoryList> getCategory();


}
