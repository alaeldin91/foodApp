package com.example.foodapp.ui.DetailsMeals;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.foodapp.databinding.ActivityShowRandomMealsBinding;
import com.example.foodapp.helper.PreferencesHelper;
import com.example.foodapp.model.MealItem;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ShowRandomMeals extends AppCompatActivity {
    ActivityShowRandomMealsBinding binding;
    String categoryName;
    private PreferencesHelper preferencesHelper;
    private DetailsMealsViewModel detailsMealsViewModel;
    private String mealName;
    private String mealThumb;
    private String uriImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowRandomMealsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferencesHelper = new PreferencesHelper(getApplicationContext());
        detailsMealsViewModel = new ViewModelProvider(ShowRandomMeals.this).get(DetailsMealsViewModel.class);
        String id = preferencesHelper.getString("idMeal");
        Log.i("ala", id + " ");
        detailsMealsViewModel.getDetailsMeals(id);
        observerGetDetails(id);
        getMealInformationFrom();
        setInformationViews();
        loadCase();
        observerLocalDetails();
        detailsMealsViewModel.getLocalDetailsMeals();
        binding.imageYouTube.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uriImage));
            startActivity(i);
        });
    }

    public void observerLocalDetails() {
        detailsMealsViewModel.getLiveLocalDetails().observe(this, new Observer<List<MealItem>>() {
            @Override
            public void onChanged(List<MealItem> mealItems) {
                binding.tvArea.setText(mealItems.get(0).getStrArea());
                binding.tvCategoryItem.setText(mealItems.get(0).getStrCategory());
                binding.instructor.setText(mealItems.get(0).getStrInstructions());
            }
        });
    }

    public void getMealInformationFrom() {
        mealName = preferencesHelper.getString("mealNAME");
        mealThumb = preferencesHelper.getString("mealThumb");
        categoryName = preferencesHelper.getString("categoryName");
    }

    private void setInformationViews() {
        Glide.with(getApplicationContext()).load(mealThumb).into(binding.image);
        binding.CollapsingToolbar.setTitle(mealName);
    }

    private void loadCase() {
        binding.btnFloat.setVisibility(View.INVISIBLE);
        binding.progress.setVisibility(View.VISIBLE);
        binding.instructor.setVisibility(View.INVISIBLE);
        binding.tvCategoryItem.setVisibility(View.INVISIBLE);
        binding.tvArea.setVisibility(View.INVISIBLE);
    }

    public void observerGetDetails(String idStr) {

        detailsMealsViewModel.getDetailsMutable(idStr).observe(this, mealItemArrayList -> {
            onResponse();
            ArrayList<MealItem> mealItemArrayList1 = new ArrayList<>(mealItemArrayList);
            binding.tvArea.setText(mealItemArrayList1.get(0).getStrArea());
            binding.tvCategoryItem.setText(mealItemArrayList1.get(0).getStrCategory());
            binding.instructor.setText(mealItemArrayList1.get(0).getStrInstructions());
            uriImage = mealItemArrayList1.get(0).getStrYoutube();
        });
    }

    public void onResponse() {
        binding.btnFloat.setVisibility(View.VISIBLE);
        binding.progress.setVisibility(View.INVISIBLE);
        binding.instructor.setVisibility(View.VISIBLE);
        binding.tvCategoryItem.setVisibility(View.VISIBLE);
        binding.tvArea.setVisibility(View.VISIBLE);
    }
}