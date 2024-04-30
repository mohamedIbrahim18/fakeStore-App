package com.example.petfinde.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.products.Products
import com.example.domain.usecases.SingleProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SingleProductViewModel @Inject constructor(
    val singleProductUseCase: SingleProductUseCase
): ViewModel() {
    val singleProductLiveData = MutableLiveData<Products>()

    fun getSingleProduct(id:Int){
        viewModelScope.launch {
            try {
               val product = singleProductUseCase.getSingleProduct(id)
                singleProductLiveData.postValue(product)
            }catch (e:Exception){
                Log.e("livedata", e.message!!)
            }
        }

    }
}