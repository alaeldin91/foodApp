package com.example.foodapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.foodapp.model.CategoryItem;
import com.example.foodapp.model.MealByCategory;
import com.example.foodapp.model.MealItem;

@Database(entities ={ MealItem.class, CategoryItem.class, MealByCategory.class}, version = 4, exportSchema = false)
public abstract class FoodDb extends RoomDatabase {
    public abstract MealRandomItemDao mealRandomItemDao();
    public abstract  CategoryItemDao categoryItemDao();
    public abstract MealByCategoryDao mealByCategoryDao();
}
