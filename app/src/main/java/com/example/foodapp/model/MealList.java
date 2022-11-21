package com.example.foodapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MealList {
    @SerializedName("meals")
    @Expose
    private  ArrayList<MealItem> mealsList = null;

    public ArrayList<MealItem> getMealsList() {
        return mealsList;
    }


}
