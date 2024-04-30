package com.example.data.repository.specificProducts

import com.example.data.dataSourceContract.specificProducts.SpecificProductsDataSource
import com.example.domain.model.products.Products
import com.example.domain.repository.specificProdcuts.SpecificProductsRepository
import javax.inject.Inject

class SpecificProductsRepositoryImpl @Inject constructor(
   val specificProductsDataSource: SpecificProductsDataSource
) :SpecificProductsRepository {
    override suspend fun getSpecificProducts(category:String): List<Products> {
        return specificProductsDataSource.getSpecificProducts(category)
    }
}