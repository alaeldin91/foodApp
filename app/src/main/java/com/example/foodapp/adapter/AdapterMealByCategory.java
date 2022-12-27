package com.example.foodapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.databinding.CategoryMealListItemBinding;
import com.example.foodapp.model.MealByCategory;

import java.util.ArrayList;

public class AdapterMealByCategory extends RecyclerView.Adapter<AdapterMealByCategory.ViewHolderMealByCategory> {
    private Context context;
     ArrayList<MealByCategory> mealByCategories;
     CategoryMealListItemBinding categoryMealListItemBinding;

    public AdapterMealByCategory(Context context,
                                 ArrayList<MealByCategory> mealByCategories) {
        this.context = context;
        this.mealByCategories = mealByCategories;
    }

    @NonNull
    @Override
    public AdapterMealByCategory.ViewHolderMealByCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        categoryMealListItemBinding = CategoryMealListItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolderMealByCategory(categoryMealListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMealByCategory.ViewHolderMealByCategory holder, int position) {
        Glide.with(context).load(mealByCategories.get(position).getMealImage()).
                into(holder.categoryMealListItemBinding.categoryImageMeal);
        holder.categoryMealListItemBinding.txtMealCategory.
                setText(mealByCategories.get(position).getMealName());
    }

    @Override
    public int getItemCount() {
        return mealByCategories == null ? 0 : mealByCategories.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateList(ArrayList<MealByCategory> mealByCategories) {
        this.mealByCategories = mealByCategories;
        notifyDataSetChanged();

    }

    public  class ViewHolderMealByCategory extends RecyclerView.ViewHolder {
        private final CategoryMealListItemBinding categoryMealListItemBinding;
        public ViewHolderMealByCategory(@NonNull CategoryMealListItemBinding categoryMealListItemBinding) {
            super(categoryMealListItemBinding.getRoot());
            this.categoryMealListItemBinding = categoryMealListItemBinding;
        }
    }
}