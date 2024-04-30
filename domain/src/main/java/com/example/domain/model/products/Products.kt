package com.example.domain.model.products

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Products(
    val image: String? = null,
    val price: Double? = null,
    val rating: Rating? = null,
    val description: String? = null,
    val id: Int? = null,
    val title: String? = null,
    val category: String? = null
) : Parcelable