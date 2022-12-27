package com.example.foodapp.ui.product;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.adapter.AdapterMealByCategory;
import com.example.foodapp.databinding.ActivityMealBinding;
import com.example.foodapp.model.MealByCategory;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MealActivity extends AppCompatActivity {
    private ViewModelByCategory viewModelByCategory;
    private AdapterMealByCategory adapterMealByCategory;
     ArrayList<MealByCategory>mealByCategories;
     private ActivityMealBinding activityMealBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_meal);
        activityMealBinding = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(activityMealBinding.getRoot());
        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("categoryName");
        viewModelByCategory = new ViewModelProvider(this).get(ViewModelByCategory.class);
        viewModelByCategory.observerMealByCategory(categoryName);
        utilizeRecyclerMealByCategory();
        observeMealByCategory();

    }
    public void observeMealByCategory(){
        viewModelByCategory.getMealByCategoryMutableLiveData().observe(this, new Observer<ArrayList<MealByCategory>>() {
            @Override
            public void onChanged(ArrayList<MealByCategory> mealByCategories) {
          adapterMealByCategory.updateList(mealByCategories);
            }

        });
    }

    public void utilizeRecyclerMealByCategory() {
       activityMealBinding.recViewMeals.setLayoutManager(new
                GridLayoutManager(getApplicationContext(), 1, GridLayoutManager.VERTICAL, false));
       adapterMealByCategory = new AdapterMealByCategory(this,mealByCategories);
       activityMealBinding.recViewMeals.setAdapter(adapterMealByCategory);
    }


}