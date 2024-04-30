package com.example.data.dataSoruce

import com.example.data.dataSoruce.category.CategoryRemoteDataSourceImpl
import com.example.data.dataSoruce.product.ProductsRemoteDataSourceImpl
import com.example.data.dataSoruce.singleProduct.SingleProductRemoteDataSourceImpl
import com.example.data.dataSoruce.specificProducts.SpecificProductsRemoteDataSourceImpl
import com.example.data.dataSourceContract.category.CategoryDataSource
import com.example.data.dataSourceContract.product.ProductsDataSource
import com.example.data.dataSourceContract.singleProduct.SingleProductDataSource
import com.example.data.dataSourceContract.specificProducts.SpecificProductsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)

abstract class di {
    @Binds
    abstract fun bindProductsRemoteDataSource(productsRemoteDataSourceImpl: ProductsRemoteDataSourceImpl):
            ProductsDataSource

    @Binds
    abstract fun bindCategoriesRemoteDataSource(categoryRemoteDataSourceImpl: CategoryRemoteDataSourceImpl)
            : CategoryDataSource

    @Binds
    abstract fun bindProductsForSpecificCategory(specificProductsRemoteDataSourceImpl: SpecificProductsRemoteDataSourceImpl)
            : SpecificProductsDataSource

    @Binds
    abstract fun bindSingleProduct(singleProductRemoteDataSourceImpl: SingleProductRemoteDataSourceImpl)
            : SingleProductDataSource
}