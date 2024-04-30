package com.example.domain.usecases

import com.example.domain.model.products.Products
import com.example.domain.repository.singleProduct.SingleProductRepository
import javax.inject.Inject

class SingleProductUseCase @Inject constructor(
    val repo : SingleProductRepository
) {
    suspend fun getSingleProduct(id:Int) : Products{
        return repo.getSingleProduct(id)
    }
}