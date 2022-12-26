package com.example.foodapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealByCategory {
    @SerializedName("strMeal")
    @Expose
    private String mealName;
    @SerializedName("strMealThumb")
    @Expose
    private String mealImage;
    @SerializedName("idMeal")
    @Expose
    private String mealId;

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealImage() {
        return mealImage;
    }

    public void setMealImage(String mealImage) {
        this.mealImage = mealImage;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }
}