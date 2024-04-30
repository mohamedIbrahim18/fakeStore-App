package com.example.data.repository.categroy

import com.example.data.dataSourceContract.category.CategoryDataSource
import com.example.domain.repository.category.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    val categoryDataSource: CategoryDataSource
): CategoryRepository {
    override suspend fun getAllCategories(): List<String> {
       return categoryDataSource.getAllCategories()
    }

}