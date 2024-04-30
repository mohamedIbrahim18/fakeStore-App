package com.example.domain.usecases

import com.example.domain.model.products.Products
import com.example.domain.repository.specificProdcuts.SpecificProductsRepository
import javax.inject.Inject

class SpecificProductsUseCase @Inject constructor(
    val repo: SpecificProductsRepository
) {

    suspend fun getSpecificProductsForCategory(category: String): List<Products> {
        return repo.getSpecificProducts(category)
    }
}