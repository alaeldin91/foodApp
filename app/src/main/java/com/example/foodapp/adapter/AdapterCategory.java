package com.example.foodapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.databinding.CategoryItemBinding;
import com.example.foodapp.model.CategoryItem;

import java.util.ArrayList;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.CategoryViewHolder> {
    private Context context;
    private ArrayList<CategoryItem> categoryItems;
    private CategoryItemBinding categoryItemBinding;
    public OnItemClickCategory onItemClickCategory;
    public AdapterCategory(Context context, ArrayList<CategoryItem> categoryItems,OnItemClickCategory onItemClickCategory) {
        this.context = context;
        this.categoryItems = categoryItems;
        this.onItemClickCategory= onItemClickCategory;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        categoryItemBinding = CategoryItemBinding.inflate(inflater, parent, false);
        return new CategoryViewHolder(categoryItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Glide.with(context).load(categoryItems.get(position)
                        .getStrCategoryThumb())
                .into(holder.categoryItemBinding.categoryImage);
        categoryItemBinding.categoryText.setText(categoryItems.get(position).getStrCategory());
    }

    @Override
    public int getItemCount() {
        return categoryItems == null ? 0 : categoryItems.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateList(ArrayList<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
        notifyDataSetChanged();
    }

    public interface OnItemClickCategory {
        public void onItemClickCategory(View view,int position);
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final CategoryItemBinding categoryItemBinding;

        public CategoryViewHolder(@NonNull CategoryItemBinding categoryItemBinding) {
            super(categoryItemBinding.getRoot());
            this.categoryItemBinding = categoryItemBinding;
            categoryItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickCategory.onItemClickCategory(view,getAdapterPosition());
                }
            });

        }
    }
}
