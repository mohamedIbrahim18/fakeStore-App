package com.example.data.dataSourceContract.product

import com.example.domain.model.products.Products

interface ProductsDataSource {
    suspend fun getAllProducts() : List<Products?>?
}