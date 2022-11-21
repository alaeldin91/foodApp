package com.example.foodapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    @SerializedName("categories")
    @Expose
    private ArrayList<CategoryItem> categories = null;

    public ArrayList<CategoryItem> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryItem> categories) {
        this.categories = categories;
    }

}
