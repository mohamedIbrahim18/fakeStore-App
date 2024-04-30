package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.products.Products
import com.example.domain.usecases.CategoriesUseCase
import com.example.domain.usecases.ProductsUseCase
import com.example.domain.usecases.SpecificProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val productsUseCase: ProductsUseCase,
    val categoriesUseCase: CategoriesUseCase,
    val specificProductsUseCase: SpecificProductsUseCase
) : ViewModel() {
    val productsLiveData = MutableLiveData<List<Products?>?>()
    val categoriesLiveData = MutableLiveData<List<String>>()
    val specificProductsLiveData = MutableLiveData<List<Products?>?>()
    fun getAllProducts() {
        viewModelScope.launch {
            try {
                val listOfProducts = productsUseCase.getAllProducts()
                productsLiveData.postValue(listOfProducts)
            } catch (e: Exception) {
                Log.e("livedata", e.message!!)
            }

        }
    }

    fun getAllCategories() {
        viewModelScope.launch {
            try {
                val listOfCategories = categoriesUseCase.getAllCategories()
                categoriesLiveData.postValue(listOfCategories)
            } catch (e: Exception) {
                Log.e("livedata", e.message!!)
            }

        }
    }


    fun getSpecificProducts(category:String) {
        viewModelScope.launch {
            try {
                val listOfProducts = specificProductsUseCase.getSpecificProductsForCategory(category)
                specificProductsLiveData.postValue(listOfProducts)
            } catch (e: Exception) {
                Log.e("livedata", e.message!!)
            }

        }
    }
}