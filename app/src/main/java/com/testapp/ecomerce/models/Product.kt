package com.testapp.ecomerce.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("image_ids")
    val imageIds: List<String>? = null,
    @SerializedName("image_urls")
    val imageUrls: List<String>? = null,
    @SerializedName("image_urls_thumbnails")
    val imageUrlsThumbnails: List<String>? = null,
    val name: String? = null,
    val price: String? = null,
    val uid: String? = null
)