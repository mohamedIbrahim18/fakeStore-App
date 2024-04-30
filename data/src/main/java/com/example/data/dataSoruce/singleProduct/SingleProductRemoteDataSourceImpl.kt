package com.example.data.dataSoruce.singleProduct

import com.example.data.api.WebServices
import com.example.data.dataSourceContract.singleProduct.SingleProductDataSource
import com.example.domain.model.products.Products
import javax.inject.Inject
import javax.inject.Named

class SingleProductRemoteDataSourceImpl @Inject constructor(
    @Named("webServicesForSingleProduct")
    val webServices: WebServices
) : SingleProductDataSource {
    override suspend fun getSingleProduct(id: Int): Products {
        return webServices.getSingleProduct(id).toProducts()
    }

}