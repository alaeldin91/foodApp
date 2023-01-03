package com.example.foodapp.ui.product;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.foodapp.adapter.AdapterMealByCategory;
import com.example.foodapp.databinding.ActivityMealBinding;
import com.example.foodapp.model.MealByCategory;
import com.example.foodapp.model.TempTableProduct;
import com.example.foodapp.ui.temp.TempProductViewModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MealActivity extends AppCompatActivity implements AdapterMealByCategory.MealByCategoryInterface {
    ArrayList<MealByCategory> mealByCategories;
    int countQuantity = 0;
    TempProductViewModel tempProductViewModel;
    Intent intent;
    private ViewModelByCategory viewModelByCategory;
    private AdapterMealByCategory adapterMealByCategory;
    private ActivityMealBinding activityMealBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMealBinding = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(activityMealBinding.getRoot());
        intent = getIntent();
        String categoryName = intent.getStringExtra("categoryName");
        activityMealBinding.txtTitle.setText(categoryName);
        viewModelByCategory = new ViewModelProvider(this).get(ViewModelByCategory.class);
        tempProductViewModel = new ViewModelProvider(this).get(TempProductViewModel.class);
        viewModelByCategory.observerMealByCategory(categoryName);
        utilizeRecyclerMealByCategory();
        observeMealByCategory();
        viewModelByCategory.getLocalMealByCategory();
        observeGetLocalMealByCategory();
    }

    public void observeMealByCategory() {
        viewModelByCategory.getMealByCategoryMutableLiveData().observe(this, mealByCategories -> {
            adapterMealByCategory.updateList(mealByCategories);
            for (int i = 0; i < mealByCategories.size(); i++) {
                MealByCategory mealByCategory = mealByCategories.get(i);
                viewModelByCategory.insertMealByCategory(mealByCategory);

            }
        });
    }

    public void utilizeRecyclerMealByCategory() {
        activityMealBinding.recViewMeals.setLayoutManager(new
                GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false));
        adapterMealByCategory = new AdapterMealByCategory(this, mealByCategories, this);
        activityMealBinding.recViewMeals.setAdapter(adapterMealByCategory);
    }

    public void observeGetLocalMealByCategory() {
        viewModelByCategory.getMealByCategoryLocal().observe(this, mealByCategories -> {
            ArrayList<MealByCategory> mealByCategory = new ArrayList<>(mealByCategories);
            if (mealByCategory.size() > 0) {
                adapterMealByCategory.updateList(mealByCategory);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClickListenerPositive(View view, int position, ArrayList<MealByCategory>
            mealByCategory, TextView text) {
        countQuantity++;
        text.setText(countQuantity + "");
        calacuteQuantityPositive(view,position,mealByCategory,text,countQuantity);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void calacuteQuantityPositive(View view, int position,
                                          ArrayList<MealByCategory> mealByCategory, TextView textView, int quantity) {
        countQuantity++;
        textView.setText(countQuantity);
        MealByCategory mealByCategoryModel = mealByCategory.get(position);
        int id = mealByCategoryModel.getId();
        String categoryName = intent.getStringExtra("categoryName");
        String name = mealByCategoryModel.getMealImage();
        double price = 30.0;
        double total = price * quantity;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        String imageProduct = mealByCategoryModel.getMealImage();
        TempTableProduct tempTableProduct = new TempTableProduct(id, categoryName, name, price,
                imageProduct, total, date, quantity);
        tempProductViewModel.insertTempAllMeals(tempTableProduct);
       // Log.i("meal", mealByCategoryModel.getMealName());

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClickListenerNegative(View view, int position, ArrayList<MealByCategory>
            mealByCategory, TextView text) {
        countQuantity--;
        text.setText(countQuantity + "");
    }
}