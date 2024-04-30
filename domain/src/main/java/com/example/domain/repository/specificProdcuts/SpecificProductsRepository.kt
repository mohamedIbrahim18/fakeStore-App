package com.example.domain.repository.specificProdcuts

import com.example.domain.model.products.Products

interface SpecificProductsRepository {
    suspend fun getSpecificProducts(category:String) : List<Products>
}