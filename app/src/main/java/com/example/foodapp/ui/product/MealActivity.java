package com.example.foodapp.ui.product;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.foodapp.adapter.AdapterMealByCategory;
import com.example.foodapp.databinding.ActivityMealBinding;
import com.example.foodapp.model.MealByCategory;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MealActivity extends AppCompatActivity {
    ArrayList<MealByCategory> mealByCategories;
    private ViewModelByCategory viewModelByCategory;
    private AdapterMealByCategory adapterMealByCategory;
    private ActivityMealBinding activityMealBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMealBinding = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(activityMealBinding.getRoot());
        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("categoryName");
        viewModelByCategory = new ViewModelProvider(this).get(ViewModelByCategory.class);
        viewModelByCategory.observerMealByCategory(categoryName);
        utilizeRecyclerMealByCategory();
        observeMealByCategory();
        viewModelByCategory.getLocalMealByCategory();
        observeGetLocalMealByCategory();
    }

    public void observeMealByCategory() {
        viewModelByCategory.getMealByCategoryMutableLiveData().observe(this, new Observer<ArrayList<MealByCategory>>() {
            @Override
            public void onChanged(ArrayList<MealByCategory> mealByCategories) {
                adapterMealByCategory.updateList(mealByCategories);
                for (int i = 0; i < mealByCategories.size(); i++) {
                    MealByCategory mealByCategory = mealByCategories.get(i);
                    viewModelByCategory.insertMealByCategory(mealByCategory);

                }
            }

        });
    }

    public void utilizeRecyclerMealByCategory() {
        activityMealBinding.recViewMeals.setLayoutManager(new
                GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false));
        adapterMealByCategory = new AdapterMealByCategory(this, mealByCategories);
        activityMealBinding.recViewMeals.setAdapter(adapterMealByCategory);
    }

    public void observeGetLocalMealByCategory() {
        viewModelByCategory.getMealByCategoryLocal().observe(this, new Observer<List<MealByCategory>>() {
            @Override
            public void onChanged(List<MealByCategory> mealByCategories) {
                ArrayList<MealByCategory> mealByCategory = new ArrayList<>(mealByCategories);
                if (mealByCategory.size() > 0) {
                    adapterMealByCategory.updateList(mealByCategory);
                }
            }
        });
    }


}