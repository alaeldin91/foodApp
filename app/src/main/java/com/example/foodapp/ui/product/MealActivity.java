package com.example.foodapp.ui.product;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
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

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

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
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClickListenerAdd(View view, int position, ArrayList<MealByCategory> mealByCategory) {
        if (countQuantity <= 0)  {
            Log.i("zero", "your are not data");
        } else {
            addMealsByCategoryTemp(view,position, mealByCategory);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClickListenerNegative(View view, int position, ArrayList<MealByCategory>
            mealByCategory, TextView text) {
        countQuantity--;
        text.setText(countQuantity + "");

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addMealsByCategoryTemp(View view,int position, ArrayList<MealByCategory> mealByCategory) {
        MealByCategory mealByCategoryModel = mealByCategory.get(position);
        int id = mealByCategoryModel.getId();
        String categoryName = intent.getStringExtra("categoryName");
        String name = mealByCategoryModel.getMealImage();
        double price = 30.0;
        double total = price * countQuantity;
       // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        String pattern = "MM/dd/yyyy";
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        String date =  simpleDateFormat.format(c.getTime());
        String imageProduct = mealByCategoryModel.getMealImage();
        TempTableProduct tempTableProduct = new TempTableProduct(id, categoryName, name, price,
                imageProduct, total, date, countQuantity);
        tempProductViewModel.insertTempAllMeals(tempTableProduct);
    }
}