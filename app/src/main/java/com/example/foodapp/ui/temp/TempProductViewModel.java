package com.example.foodapp.ui.temp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodapp.model.TempTableProduct;
import com.example.foodapp.respository.TempProductRepository;

import java.util.List;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TempProductViewModel extends ViewModel {
    private final TempProductRepository tempProductRepository;
    private LiveData<List<TempTableProduct>> tempAllMeals;

    @Inject
    public TempProductViewModel(TempProductRepository tempProductRepository) {
        this.tempProductRepository = tempProductRepository;
    }

    public LiveData<List<TempTableProduct>> getTempAllMeals() {
        return tempAllMeals;
    }

    public void getLocalTempAllMeals() {
        this.tempAllMeals = tempProductRepository.getAllTempTable();
    }

    public void insertTempAllMeals(TempTableProduct tempTableProduct) {
        this.insertTempAllMeals(tempTableProduct);
    }

}
