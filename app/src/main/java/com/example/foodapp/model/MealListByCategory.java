package com.example.foodapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MealListByCategory {
    @SerializedName("meals")
    @Expose
    private ArrayList<MealByCategory> mealByCategoryList;

    public ArrayList<MealByCategory> getMealByCategoryList() {
        return mealByCategoryList;
    }

    public void setMealByCategoryList(ArrayList<MealByCategory> mealByCategoryList) {
        this.mealByCategoryList = mealByCategoryList;
    }
}
