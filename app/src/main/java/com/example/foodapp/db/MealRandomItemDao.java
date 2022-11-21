package com.example.foodapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.foodapp.model.MealItem;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MealRandomItemDao {
    @Insert
    void insertRandomMealItem(MealItem mealItem);
    @Query("SELECT * FROM MealDb")
    LiveData<List<MealItem>> getMeal();


}
