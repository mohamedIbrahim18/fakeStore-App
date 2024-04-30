package com.example.data.repository.singleProduct

import com.example.data.dataSourceContract.singleProduct.SingleProductDataSource
import com.example.domain.model.products.Products
import com.example.domain.repository.singleProduct.SingleProductRepository
import javax.inject.Inject

class SingleProductRepositoryImpl @Inject constructor(
    val dataSource: SingleProductDataSource
)  :SingleProductRepository{
    override suspend fun getSingleProduct(id: Int): Products {
       return dataSource.getSingleProduct(id)
    }
}