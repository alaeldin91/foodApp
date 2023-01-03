package com.example.foodapp.di;

import android.app.Application;

import androidx.room.Room;

import com.example.foodapp.db.CategoryItemDao;
import com.example.foodapp.db.FoodDb;
import com.example.foodapp.db.MealByCategoryDao;
import com.example.foodapp.db.MealRandomItemDao;
import com.example.foodapp.db.TempTableDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataBaseModule {
    @Provides
    @Singleton
    public static FoodDb providePokemonDB(Application application) {
        return Room.databaseBuilder(application, FoodDb.class, "MealDb").fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    public static MealRandomItemDao provideFoodDbMale(FoodDb foodDb) {
        return foodDb.mealRandomItemDao();
    }

    @Provides
    @Singleton
    public static CategoryItemDao provideFoodDbCategory(FoodDb foodDb) {
        return foodDb.categoryItemDao();
    }

    @Provides
    @Singleton
    public static MealByCategoryDao provideMealByCategory(FoodDb foodDb) {
        return foodDb.mealByCategoryDao();
    }

    @Provides
    @Singleton
    public static TempTableDao provideTempTableDao(FoodDb foodDb) {
        return foodDb.tempTableDao();
    }
}
