package com.example.data.api

import com.example.data.model.product.ProductsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface WebServices {
    @GET("products")
    suspend fun getAllProducts(): List<ProductsDTO>

    @GET("categories")
    suspend fun getAllCategories(): List<String>

    @GET("category/{category}")
    suspend fun getSpecificProductInCategory(
        @Path("category") category:String
    ) : List<ProductsDTO>

    @GET("{id}")
    suspend fun getSingleProduct(@Path("id") id:Int) :ProductsDTO
}