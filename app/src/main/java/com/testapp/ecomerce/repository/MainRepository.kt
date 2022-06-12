package com.testapp.ecomerce.repository

import com.testapp.ecomerce.models.ProductsResponse


interface MainRepository{
    suspend fun getProducts(): ProductsResponse
}