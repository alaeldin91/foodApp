package com.example.foodapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.foodapp.MainActivity;
import com.example.foodapp.R;
import com.example.foodapp.adapter.AdapterCategory;
import com.example.foodapp.adapter.AdapterPopularMeal;
import com.example.foodapp.databinding.FragmentHomeBinding;
import com.example.foodapp.helper.PreferencesHelper;
import com.example.foodapp.model.CategoryItem;
import com.example.foodapp.model.MealItem;
import com.example.foodapp.ui.DetailsMeals.ShowRandomMeals;
import com.example.foodapp.ui.product.MealActivity;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment implements AdapterCategory.OnItemClickCategory {

    ImageView randomListItemImageFirst;
    ArrayList<MealItem> mealItemPopularArrayList;
    ArrayList<CategoryItem> categoryItems;
    PreferencesHelper preferencesHelper;
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private AdapterPopularMeal adapterPopularMeal;
    private AdapterCategory adapterCategory;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        utilizeView();
        untilizeRecyclerPopularMealView();
        untilizeRecyclerCategoryView();
        observerRandomMealListItem();
        observerPopularMealListItem();
        observerGetCategory();
        observerPopularGeMealLocal();
        observerCategoriesLocal();
        homeViewModel.observerRandomMealListItem();
        homeViewModel.observerPopularMealListItem();
        homeViewModel.observerCategoryListItem();
        homeViewModel.getLocalPopularMeal();
        homeViewModel.getLocalCategories();
    }

    public void utilizeView() {
        randomListItemImageFirst = binding.imgRandomMeal;
    }

    private void observerRandomMealListItem() {
        homeViewModel.getRandomMealList().observe(getViewLifecycleOwner(), this::updateList);
    }

    private void onRandomClickListener(ArrayList<MealItem> mealItemArrayList) {
        binding.imgRandomMeal.setOnClickListener(view -> {
            preferencesHelper = new PreferencesHelper(getActivity());
            String idMeal = mealItemArrayList.get(1).getIdMeal();
            String mealNAME = mealItemArrayList.get(1).getStrMeal();
            String mealThumb = mealItemArrayList.get(1).getStrMealThumb();
            String categoryName = mealItemArrayList.get(1).getStrCategory();
            preferencesHelper.putString("idMeal", idMeal);
            preferencesHelper.putString("mealNAME", mealNAME);
            preferencesHelper.putString("mealThumb", mealThumb);
            preferencesHelper.putString("categoryName", categoryName);
            startActivity(new Intent(getActivity(), ShowRandomMeals.class));
        });

    }

    public void observerGetCategory() {
        homeViewModel.getCategoryItem().observe(getViewLifecycleOwner(), categoryItems -> {
            for (int i = 0; i < categoryItems.size(); i++) {
                CategoryItem categoryItem = categoryItems.get(i);
                homeViewModel.insertCategoryItem(categoryItem);
            }
            adapterCategory.updateList(categoryItems);
        });

    }

    public void observerPopularGeMealLocal() {
        homeViewModel.getMealPopularList("Seafood").observe(getViewLifecycleOwner(), mealItems -> {
            ArrayList<MealItem> mealItemArrayList = new ArrayList<>(mealItems);
            if (mealItemArrayList.size() > 0) {
                adapterPopularMeal.updateList(mealItemArrayList);
                Glide.with(this).load(mealItemArrayList.get(1).getStrMealThumb()).into(binding.imgRandomMeal);
                onRandomClickListener(mealItemArrayList);
            }
        });

    }

    public void observerCategoriesLocal() {
        homeViewModel.getLiveDataLocalCategories().observe(getViewLifecycleOwner(), categoryItems -> {
            ArrayList<CategoryItem> categoryItemArrayList = new ArrayList<>(categoryItems);
            if (categoryItemArrayList.size() > 0) {
                adapterCategory.updateList(categoryItemArrayList);
            }
        });
    }

    public void observerPopularMealListItem() {
        homeViewModel.getMealPopularListItem().observe(getViewLifecycleOwner(), mealItems -> {
            for (int i = 0; i < mealItems.size(); i++) {
                MealItem mealItem = mealItems.get(i);
                homeViewModel.insertRandomMealItem(mealItem);

            }
            adapterPopularMeal.updateList(mealItems);
        });

    }

    public void updateList(ArrayList<MealItem> updateListRandomMealItem) {
        this.mealItemPopularArrayList = updateListRandomMealItem;
    }

    private void untilizeRecyclerPopularMealView() {
        binding.recViewMealsPopular.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL
                , false));
        adapterPopularMeal = new AdapterPopularMeal(getContext()
                , mealItemPopularArrayList);
        binding.recViewMealsPopular.setAdapter(adapterPopularMeal);
    }

    public void untilizeRecyclerCategoryView() {
        binding.recyclerCatogries.setLayoutManager(new GridLayoutManager(getContext(),
                3, GridLayoutManager.VERTICAL, false));
        adapterCategory = new AdapterCategory(getContext(), categoryItems, this);
        binding.recyclerCatogries.setAdapter(adapterCategory);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClickCategory(View view, int position,ArrayList<CategoryItem>categoryItems) {
        Intent intent = new Intent(getActivity(),MealActivity.class);
        Log.i("ala",categoryItems.get(position).getStrCategory());
      startActivity(intent);

    }
}