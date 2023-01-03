package com.example.foodapp.respository;

import androidx.lifecycle.LiveData;

import com.example.foodapp.db.TempTableDao;
import com.example.foodapp.model.TempTableProduct;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TempProductRepository {
    private final TempTableDao tempTableDao;
    @Inject
    public TempProductRepository(TempTableDao tempTableDao) {
        this.tempTableDao = tempTableDao;
    }
    public void insertTempTable(TempTableProduct tempTableProduct) {
        tempTableDao.insertTableTemp(tempTableProduct);
    }
       public LiveData<List<TempTableProduct>> getAllTempTable(){
          return   tempTableDao.getTempMeal();
        }


}
