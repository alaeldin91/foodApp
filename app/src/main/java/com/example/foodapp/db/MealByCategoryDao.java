package com.example.foodapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodapp.model.MealByCategory;

import java.util.List;
@Dao
public interface MealByCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMealByCategory(MealByCategory mealByCategory);
    @Query("SELECT * FROM mealByCategoryDb")
    LiveData<List<MealByCategory>> getMealByCategories();

}
