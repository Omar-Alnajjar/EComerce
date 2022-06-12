package com.testapp.ecomerce.ui.main

import com.testapp.ecomerce.models.Product

sealed class ProductsViewState {
    data class ProductsResponseData(val products: List<Product>?) : ProductsViewState()
}