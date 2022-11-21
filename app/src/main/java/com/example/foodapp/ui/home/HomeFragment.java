package com.example.foodapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.foodapp.adapter.AdapterCategory;
import com.example.foodapp.adapter.AdapterPopularMeal;
import com.example.foodapp.databinding.FragmentHomeBinding;
import com.example.foodapp.model.CategoryItem;
import com.example.foodapp.model.MealItem;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    ImageView randomListItemImageFirst;
    ArrayList<MealItem> mealItemPopularArrayList;
    ArrayList<CategoryItem> categoryItems;
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
        observerPublicMealListItem();
        observerGetCategory();
        observerPopularGeMealLocal();
        homeViewModel.observerRandomMealListItem();
        homeViewModel.observerPopularMealListItem();
        homeViewModel.observerCategoryListItem();
        homeViewModel.getLocalPopularMeal();

    }

    public void utilizeView() {
        randomListItemImageFirst = binding.imgRandomMeal;
    }

    private void observerRandomMealListItem() {
        homeViewModel.getRandomMealList().observe(getViewLifecycleOwner(), this::updateList);
    }
    public void observerGetCategory(){
        homeViewModel.getCategoryItem().observe(getViewLifecycleOwner(), new Observer<ArrayList<CategoryItem>>() {
            @Override
            public void onChanged(ArrayList<CategoryItem> categoryItems) {
                 adapterCategory.updateList(categoryItems);
            }
        });

    }
    public void observerPopularGeMealLocal() {
        homeViewModel.getMealPopularList("Seafood").observe(getViewLifecycleOwner(), mealItems -> {
            ArrayList<MealItem> mealItemArrayList = new ArrayList<>(mealItems);
            Glide.with(this).load(mealItemArrayList.get(0).getStrMealThumb()).into(binding.imgRandomMeal);
            adapterPopularMeal.updateList(mealItemArrayList);
        });

    }

    public void observerPublicMealListItem() {
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
    public void untilizeRecyclerCategoryView(){
        binding.recyclerCatogries.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,false));
        adapterCategory = new AdapterCategory(getContext(),categoryItems);
        binding.recyclerCatogries.setAdapter(adapterCategory);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}