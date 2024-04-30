package com.example.data.dataSoruce.category

import com.example.data.api.WebServices
import com.example.data.dataSourceContract.category.CategoryDataSource
import javax.inject.Inject
import javax.inject.Named

class CategoryRemoteDataSourceImpl @Inject constructor(
    @Named("webServicesCategories")
    val webServices: WebServices
) : CategoryDataSource {
    override suspend fun getAllCategories(): List<String> {
        val response = webServices.getAllCategories()
        return response
    }
}