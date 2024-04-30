package com.example.data.dataSoruce.product

import com.example.data.api.WebServices
import com.example.data.dataSourceContract.product.ProductsDataSource
import com.example.domain.model.products.Products
import javax.inject.Inject
import javax.inject.Named

class ProductsRemoteDataSourceImpl @Inject constructor(
    @Named("webServiceProducts")
    val webServices : WebServices
) : ProductsDataSource {
    override suspend fun getAllProducts(): List<Products?>? {
       return webServices.getAllProducts().map {
           it.toProducts()
       }
    }
}