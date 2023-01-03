package com.example.foodapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodapp.model.MealByCategory;
import com.example.foodapp.model.TempTableProduct;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TempTableDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTableTemp(TempTableProduct tempTableProduct);

    @Query("SELECT * FROM tempTable")
    LiveData<List<TempTableProduct>> getTempMeal();
}
