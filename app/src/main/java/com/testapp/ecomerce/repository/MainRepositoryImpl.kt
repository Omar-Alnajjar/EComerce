package com.testapp.ecomerce.repository

import com.testapp.ecomerce.data.api.ApiHelper
import com.testapp.ecomerce.models.ProductsResponse
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiHelper: ApiHelper) : MainRepository {
    override suspend fun getProducts(): ProductsResponse {
        return apiHelper.getProducts()
    }
}