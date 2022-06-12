package com.testapp.ecomerce.models

data class ProductsResponse(
    val pagination: Pagination,
    val results: List<Product>
)