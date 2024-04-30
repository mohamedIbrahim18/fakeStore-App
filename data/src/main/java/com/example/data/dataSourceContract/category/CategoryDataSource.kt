package com.example.data.dataSourceContract.category


interface CategoryDataSource  {
suspend fun getAllCategories() : List<String>
}