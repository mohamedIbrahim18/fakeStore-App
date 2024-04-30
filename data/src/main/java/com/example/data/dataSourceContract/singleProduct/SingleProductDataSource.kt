package com.example.data.dataSourceContract.singleProduct

import com.example.domain.model.products.Products

interface SingleProductDataSource {
    suspend fun getSingleProduct(id:Int):Products
}