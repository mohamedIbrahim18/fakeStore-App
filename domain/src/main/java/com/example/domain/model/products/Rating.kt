package com.example.domain.model.products

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Rating(
	val rate: Double? = null,
	val count: Int? = null
) : Parcelable