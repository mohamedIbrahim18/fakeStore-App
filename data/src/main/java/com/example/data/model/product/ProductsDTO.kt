package com.example.data.model.product

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.domain.model.products.Products
import com.google.gson.annotations.SerializedName

@Parcelize
data class ProductsDTO(

    @field:SerializedName("image")
	val image: String? = null,

    @field:SerializedName("price")
	val price: Double? = null,

    @field:SerializedName("rating")
	val rating: RatingDTO? = null,

    @field:SerializedName("description")
	val description: String? = null,

    @field:SerializedName("id")
	val id: Int? = null,

    @field:SerializedName("title")
	val title: String? = null,

    @field:SerializedName("category")
	val category: String? = null
) : Parcelable{
	fun toProducts(): Products {
		return Products(
			image = image,
			price =  price,
			rating = rating?.toDomainRating(), // Convert ProductsDTO Rating to Products Rating
			description = description,
			id =id,
			title =title,
			category = category
		)
	}
}