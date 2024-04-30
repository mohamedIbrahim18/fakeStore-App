package com.example.data.repository

import com.example.data.repository.categroy.CategoryRepositoryImpl
import com.example.data.repository.product.ProductsRepositoryImpl
import com.example.data.repository.singleProduct.SingleProductRepositoryImpl
import com.example.data.repository.specificProducts.SpecificProductsRepositoryImpl
import com.example.domain.repository.category.CategoryRepository
import com.example.domain.repository.products.ProductsRepository
import com.example.domain.repository.singleProduct.SingleProductRepository
import com.example.domain.repository.specificProdcuts.SpecificProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {
    @Binds
    abstract fun bindProductsRepository(productsRepositoryImpl: ProductsRepositoryImpl)
            : ProductsRepository

    @Binds
    abstract fun bindCategoriesRepository(categoryRepositoryImpl: CategoryRepositoryImpl)
            : CategoryRepository

    @Binds
    abstract fun bindSpecificProductsForCategory(specificProductsRepositoryImpl: SpecificProductsRepositoryImpl): SpecificProductsRepository

    @Binds
    abstract fun bindSingleProduct(singleProductRepositoryImpl: SingleProductRepositoryImpl):
            SingleProductRepository
}