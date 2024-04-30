package com.example.data.model.product

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.domain.model.products.Rating
import com.google.gson.annotations.SerializedName

@Parcelize
data class RatingDTO(

	@field:SerializedName("rate")
	val rate: Double? = null,

	@field:SerializedName("count")
	val count: Int? = null
) : Parcelable {
	fun toDomainRating(): Rating {
		return Rating(
			rate=rate,
			count=count
		)
	}
}