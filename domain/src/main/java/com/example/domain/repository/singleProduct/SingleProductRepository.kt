package com.example.domain.repository.singleProduct

import com.example.domain.model.products.Products

interface SingleProductRepository {
    suspend fun getSingleProduct(id:Int):Products
}