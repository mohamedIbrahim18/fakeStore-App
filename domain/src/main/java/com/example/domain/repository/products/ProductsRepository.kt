package com.example.domain.repository.products

import com.example.domain.model.products.Products

interface ProductsRepository {
    suspend fun getAllProducts() : List<Products?>?
}