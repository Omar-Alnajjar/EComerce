package com.testapp.ecomerce.data.api

import com.testapp.ecomerce.models.ProductsResponse

interface ApiHelper {
    suspend fun getProducts(): ProductsResponse
}