package com.example.domain.usecases

import com.example.domain.model.products.Products
import com.example.domain.repository.products.ProductsRepository
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    val repository: ProductsRepository
) {
    suspend fun getAllProducts():List<Products?>?{
        return repository.getAllProducts()
    }

}