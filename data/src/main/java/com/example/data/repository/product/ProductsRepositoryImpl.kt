package com.example.data.repository.product

import com.example.data.dataSourceContract.product.ProductsDataSource
import com.example.domain.model.products.Products
import com.example.domain.repository.products.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
   val productsDataSource: ProductsDataSource
): ProductsRepository {
    override suspend fun getAllProducts(): List<Products?>? {
       return productsDataSource.getAllProducts()
    }
}