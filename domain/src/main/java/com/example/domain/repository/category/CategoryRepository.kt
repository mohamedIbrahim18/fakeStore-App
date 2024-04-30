package com.example.domain.repository.category


interface CategoryRepository {
suspend fun getAllCategories(): List<String>
}