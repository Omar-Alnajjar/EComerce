package com.testapp.ecomerce.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testapp.ecomerce.models.Product
import com.testapp.ecomerce.repository.MainRepository
import com.testapp.ecomerce.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    val productsViewState = SingleLiveData<ProductsViewState>()

    var doneButtonEnabledObservable: ObservableField<Boolean> = ObservableField(false)
    var loadingObservable: ObservableField<Boolean> = ObservableField(false)
    var errorObservable: ObservableField<Boolean> = ObservableField(false)
    var emptyObservable: ObservableField<Boolean> = ObservableField(false)
    var sortObservable: ObservableField<Boolean> = ObservableField(false)

    private val selectedProducts = mutableListOf<Product>()

    private val products: MutableList<Product> = mutableListOf()


    init {
        getProducts()
    }

    private fun getProducts(searchText: String? = null, searchType: String? = null) {
        resetPreviousActions()
        val exceptionHandler = CoroutineExceptionHandler { _, _ ->
            errorObservable.set(true)
            loadingObservable.set(false)
        }
        viewModelScope.launch(exceptionHandler) {
            delay(SEARCH_START_DELAY_TIME)

            errorObservable.set(false)
            loadingObservable.set(true)

            val newProducts =
                mainRepository.getProducts().results

            updateProducts(newProducts)

            productsViewState.value =
                ProductsViewState.ProductsResponseData(products)
            loadingObservable.set(false)
        }
    }

    private fun resetPreviousActions() {
        selectedProducts.clear()
        doneButtonEnabledObservable.set(false)
        sortObservable.set(false)
    }

    private fun updateProducts(newProducts: List<Product>?) {
        products.clear()

        if (newProducts.isNullOrEmpty()) {
            emptyObservable.set(true)
        } else {
            emptyObservable.set(false)
        }

        newProducts?.let {
            products.addAll(it)
        }
    }

    fun tryAgainGetProducts() {
        getProducts()
    }

    fun getItemsCount() = products.size

    fun getItemAt(position: Int): Product? {
        return products.getOrNull(position)
    }


    companion object {
        const val SEARCH_START_DELAY_TIME = 700L
    }
}