package com.example.data.dataSoruce.specificProducts

import com.example.data.api.WebServices
import com.example.data.dataSourceContract.specificProducts.SpecificProductsDataSource
import com.example.data.model.product.ProductsDTO
import com.example.domain.model.products.Products
import javax.inject.Inject
import javax.inject.Named


class SpecificProductsRemoteDataSourceImpl @Inject constructor(
    @Named("webServicesForSpecificProducts") val webServices: WebServices
) : SpecificProductsDataSource {
    override suspend fun getSpecificProducts(category: String): List<Products> {
        val list = webServices.getSpecificProductInCategory(category).map {
            it.toProducts()
        }
        return list
    }


}