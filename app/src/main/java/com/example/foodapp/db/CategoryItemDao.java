package com.example.foodapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.foodapp.model.CategoryItem;

import java.util.List;

@Dao
public interface CategoryItemDao {
    @Insert()
    void insertCategoryListItem(CategoryItem categoryItem);

    @Query("SELECT * FROM categoryDb")
    LiveData<List<CategoryItem>> getCategories();

}
