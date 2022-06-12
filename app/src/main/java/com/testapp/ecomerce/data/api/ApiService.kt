package com.testapp.ecomerce.data.api

import com.testapp.ecomerce.models.ProductsResponse
import retrofit2.http.GET

interface ApiService{

    @GET("default/dynamodb-writer")
    suspend fun getProducts(): ProductsResponse
}