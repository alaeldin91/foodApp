package com.example.foodapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "mealByCategoryDb")
public class MealByCategory {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("idMeal")
    @Expose
    private String mealId;
    @SerializedName("strMeal")
    @Expose
    private String mealName;
    @SerializedName("strMealThumb")
    @Expose
    private String mealImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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