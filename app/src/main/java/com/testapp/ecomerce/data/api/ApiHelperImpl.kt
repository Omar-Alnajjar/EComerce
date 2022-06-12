package com.testapp.ecomerce.data.api

import com.testapp.ecomerce.models.ProductsResponse
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getProducts(): ProductsResponse = apiService.getProducts()
}