package com.example.data.dataSourceContract.specificProducts

import com.example.data.model.product.ProductsDTO
import com.example.domain.model.products.Products

interface SpecificProductsDataSource {

    suspend fun getSpecificProducts(category:String) : List<Products>
}