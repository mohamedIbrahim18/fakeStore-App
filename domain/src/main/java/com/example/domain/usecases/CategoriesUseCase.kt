package com.example.domain.usecases

import com.example.domain.repository.category.CategoryRepository
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(
    val repo: CategoryRepository
) {
    suspend fun getAllCategories(): List<String> {
        return repo.getAllCategories()
    }
}