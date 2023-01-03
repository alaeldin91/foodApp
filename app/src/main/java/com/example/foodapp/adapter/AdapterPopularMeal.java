package com.example.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.databinding.PopularItemBinding;
import com.example.foodapp.model.MealItem;

import java.util.ArrayList;

public class AdapterPopularMeal extends RecyclerView.Adapter<AdapterPopularMeal.PopularMealHolder> {
    private final Context context;
    private ArrayList<MealItem> popularMealItem;
    private PopularItemBinding popularItemBinding;

    public AdapterPopularMeal(Context context, ArrayList<MealItem> popularMealItem) {
        this.context = context;
        this.popularMealItem = popularMealItem;
    }

    @NonNull
    @Override
    public PopularMealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        popularItemBinding = PopularItemBinding.inflate(inflater, parent, false);
        return new PopularMealHolder(popularItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMealHolder holder, int position) {
        Glide.with(context).load(popularMealItem.get(position).getStrMealThumb())
                .into(holder.popularItemBinding.imgPopularMealItem);
    }

    @Override
    public int getItemCount() {
        return popularMealItem == null ? 0 : popularMealItem.size();
    }

    public void updateList(ArrayList<MealItem> popularMealItem) {
        this.popularMealItem = popularMealItem;
        notifyDataSetChanged();
    }


    public class PopularMealHolder extends RecyclerView.ViewHolder {
        private final PopularItemBinding popularItemBinding;

        public PopularMealHolder(@NonNull PopularItemBinding popularItemBinding) {
            super(popularItemBinding.getRoot());

            this.popularItemBinding = popularItemBinding;

        }
    }

}
