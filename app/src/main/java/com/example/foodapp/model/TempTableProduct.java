package com.example.foodapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tempTable")
public class TempTableProduct {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String categoryName;
    private String nameMeal;
    private double price;
    private String productImage;
    private double total;
    private String createdAt;
    private int quantity;

    public TempTableProduct(int id, String categoryName, String nameMeal, double price,
                            String productImage, double total, String createdAt, int quantity) {
        this.id = id;
        this.categoryName = categoryName;
        this.nameMeal = nameMeal;
        this.price = price;
        this.productImage = productImage;
        this.total = total;
        this.createdAt = createdAt;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getNameMeal() {
        return nameMeal;
    }

    public void setNameMeal(String nameMeal) {
        this.nameMeal = nameMeal;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
