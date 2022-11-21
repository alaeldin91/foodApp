package com.example.foodapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.foodapp.model.MealItem;

@Database(entities = MealItem.class, version = 2, exportSchema = false)
public abstract class FoodDb extends RoomDatabase {
    public abstract MealRandomItemDao mealRandomItemDao();
}
